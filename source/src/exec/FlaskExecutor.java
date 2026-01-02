package exec;

import antlr.PythonLexer;
import antlr.PythonParser;
import classes.python.Application;
import org.antlr.v4.runtime.CharStream;
import static org.antlr.v4.runtime.CharStreams.fromFileName;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitors.PythonBaseVisitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Array;
import java.util.ArrayList;

public class FlaskExecutor {
    private String folder_path;

    public FlaskExecutor(String folder_path) {
        this.folder_path = folder_path;
    }

    public String getFolder_path() {
        return folder_path;
    }
    public void setFolder_path(String folder_path) {
        this.folder_path = folder_path;
    }

    public void compile() throws Exception {
        if(this.folder_path == null){
            throw new Exception("FlaskExecutor: compile: folder_path is null !!!");
        }
        File app_py = new File(folder_path + "\\app.py");
        if(!app_py.exists()){
            throw new Exception("FlaskExecutor: compile: app.py doesn't exists (it is a crucial file !) !!!!");
        }
        if(!compile_py(app_py)) {
            throw new Exception("FlaskExecutor: compile: error while compiling app.py");
        }
    }
    public boolean compile_py(File py_file){
        try {
            ArrayList<String> imported_files = look_for_imports_py(py_file);
            for(String file_path: imported_files){
                File file = new File(this.folder_path+ "\\" + file_path);
                if(file.exists()) compile_py(file);
            }
            String source = py_file.toString();
            CharStream input = fromFileName(source);
            PythonLexer lexer = new PythonLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            PythonParser parser = new PythonParser(tokens);
            ParseTree parseTree = parser.application();
            Application application = (Application) new PythonBaseVisitor().visit(parseTree);
            ArrayList<String> html_files = look_for_html_render(py_file);
            for(String file_path: html_files){
                File file = new File(this.folder_path+ "\\templates\\" +file_path);
                if(file.exists()) compile_jinja(file);
            }
            System.out.println("\n" +py_file.toString() + ":\n");
            System.out.println(application);
            return true;
        }catch (IOException ioe){
            ioe.printStackTrace();
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<String> look_for_imports_py(File py_file){
        try (BufferedReader br = new BufferedReader(new FileReader(py_file.toString()))) {
            String line;
            ArrayList<String> imported_files = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                line = line.trim();
                int from_i = line.indexOf("from");
                if(from_i == -1){
                    int import_i = line.indexOf("import");
                    if(import_i == -1){
                        throw new Exception("FlaskExecutor: look_for_imports_py: The Example Provided is wrong !!");
                    }
                    line = line.substring(import_i+5).trim();
                    String[] imports = line.split(",");
                    for(String s: imports){
                        imported_files.add(s.trim());
                    }
                }else{
                    line = line.substring(from_i+3).trim();
                    int import_i = line.indexOf("import");
                    if(import_i == -1){
                        throw new Exception("FlaskExecutor: look_for_imports_py: The Example Provided is wrong !!");
                    }
                    line = line.substring(0, import_i).trim();
                    imported_files.add(line);
                }
            }
            return imported_files;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<String> look_for_html_render(File py_file){
        try (BufferedReader br = new BufferedReader(new FileReader(py_file.toString()))) {
            String line;
            ArrayList<String> html_files = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                line = line.trim();
                int render_template_i = line.indexOf("render_template");
                if(render_template_i != -1){
                    int stop_i = line.indexOf(",");
                    if(stop_i == -1){
                        stop_i = line.indexOf(")");
                        if(stop_i == -1){
                            throw new Exception("FlaskExecutor: look_for_html_render: The Example Provided is wrong !!");
                        }
                    }
                    line = line.substring(render_template_i+15 , stop_i).trim();
                    html_files.add(line);
                }

            }
            return html_files;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean compile_jinja(File html_file){
        try {
            String source = html_file.toString();
            CharStream input = fromFileName(source);
            PythonLexer lexer = new PythonLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            //TODO: Murshed's code in here 👇
//            PythonParser parser = new PythonParser(tokens);
//            ParseTree parseTree = parser.application();
//            Application application = (Application) new PythonBaseVisitor().visit(parseTree);
//            System.out.println("\n" +html_file.toString() + ":\n");
//            System.out.println(application);
            return true;
        }catch (IOException ioe){
            ioe.printStackTrace();
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
