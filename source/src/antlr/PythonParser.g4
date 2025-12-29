parser grammar PythonParser;

options {tokenVocab = PythonLexer;}
// TODO: [ revent return outside function ]
application
    : NEWLINE? statements EOF
    ;

statements
    : statement+
    ;

statement
    : simple_stmt
    | compound_stmt
    ;

simple_stmt
    : small_stmt (SEMI small_stmt)* NEWLINE
    ;

small_stmt
    : assignment
    | augmented_assignment
    | expr
    | return_stmt
    | raise_stmt
    | import_stmt
    | global_stmt
    | break_stmt    //BREAK
    | pass_stmt     //PASS
    | continue_stmt //CONTINUE
    ;

compound_stmt
    : if_stmt
    | for_stmt
    | while_stmt
    | with_stmt
    | try_stmt
    | func_def
    | class_def
    ;


assignment
    : (target_list EQUAL)+ expr     #Regular_Assignment
    // 👆 Attention: this allows: ``` a = b = c = 1,2,3,4,5 ``` which is wrong, So later in semantic checks we have to reject that case
    | typed_assignment              #Typed_Assignment
    ;

augmented_assignment
    : target augmented_assignment_operator expr
    ;
augmented_assignment_operator
    : PLUSEQUAL
    | MINEQUAL
    | STAREQUAL
    | SLASHEQUAL
    | PERCENTEQUAL
    | CIRCUMFLEXEQUAL // xor
    | DOUBLESTAREQUAL // power
    ;

target
    : target_atom target_postfix*
    ;

target_atom
    : identifier
    | LPAR target_list RPAR // must solve the semantic error for this later
    | LSQB target_list RSQB
    ;

target_postfix
    : attribute_ref     #Target_Postfix_Attribute_Ref
    | subscription      #Target_Postfix_Subscription
    ;

target_list
    : target (COMMA target)* COMMA?
    ;

typed_assignment
    : identifier COLON identifier (EQUAL expr)?
    ;


expr
    : tuple_expr
    ;

tuple_expr // Important Note for AST: in AST we must handle "(a)" as an atom not a tuple_expr
    : conditional_expr COMMA conditional_expr (COMMA conditional_expr)* COMMA?
    | conditional_expr COMMA
    | conditional_expr
    // Python takes ``` 1, ``` as a tuple and ``` (1) ``` as number and ``` (1,) ``` as a tuple !!!!
    // Note: We don't have to define another rule option for parenthese because in "atom -> LPAR expr RPAR" the inner expr will be conditional_expr, conditional_expr ....etc
    ;

conditional_expr
    : or_expr                                           #Or_Expr
    | or_expr IF or_expr ELSE conditional_expr          #Or_Expr_Short_If   // short if statement
    ;

or_expr
    : and_expr (OR and_expr)*
    ;

and_expr
    : not_expr (AND not_expr)*
    ;

not_expr
    : NOT not_expr
    | comparison
    ;

comparison
    : arithmetic_expr (comparision_operator arithmetic_expr)* // it is '*' not '+' to support a < b < c != d
    ;

arithmetic_expr
    : xor_expr
    ;

xor_expr
    : addition_expr (CIRCUMFLEX addition_expr)*
    ;

addition_expr
    : multiplication_expr ((PLUS | MINUS) multiplication_expr)*
    ;

multiplication_expr
    : unary_expr ((STAR | SLASH | PERCENT) unary_expr)*
    ;

unary_expr
    : unary_op* power_expr
    ;

power_expr
    : primary (DOUBLESTAR power_expr)?
    ;

primary
    : atom postfix*
    ;
unary_op
    : PLUS
    | MINUS
    ;
postfix
    : call
    | attribute_ref
    | subscription
    ;
call
    : LPAR arguments_list? RPAR
    ;
subscription
    : LSQB expr RSQB
    ;
attribute_ref
    : DOT identifier
    ;

atom
    : identifier            #Atom_Identifier
    | literal               #Atom_Literal
    | enclosure             #Atom_Enclosure
    | LPAR expr RPAR        #Atom_Expr
    ;

literal
    : number            #Literal_Number
    | strings           #Literal_String
    | BOOLEAN           #Literal_Bool_None
    | NONE              #Literal_Bool_None
    ;
strings
    : STRING
    | F_STRING
    ;

enclosure
    : dict_literal
    | set_literal
    | list_literal
    ;

list_literal
    : LSQB expr? RSQB // [1,2,3,4,5,6] , [1+2, a>b<t==6] that is allowed in python
    ;

dict_literal
    : LBRACE RBRACE
    | LBRACE dict_items RBRACE
    ;

dict_items
    : dict_item (COMMA dict_item)* COMMA?
    ;

dict_item
    : expr COLON expr // yep this is allowed in python: ``` {1+1: k>l} ``` !!
    ;

set_literal
    : LBRACE set_items RBRACE
    ;

set_items
    : expr (COMMA expr)* COMMA?
    ;


arguments_list
    : expr
        (COMMA expr)*
        (COMMA identifier_equal_expr_argument)*
        (COMMA args_argument)*
        (COMMA kwargs_argument)* COMMA?

    | identifier_equal_expr_argument
        (COMMA identifier_equal_expr_argument)*
        (COMMA args_argument)*
        (COMMA kwargs_argument)* COMMA?

    | args_argument
        (COMMA args_argument)*
        (COMMA kwargs_argument)* COMMA?

    | kwargs_argument
        (COMMA kwargs_argument)* COMMA?
    ;

args_argument
    : STAR expr
    ;

kwargs_argument
    : DOUBLESTAR expr
    ;

identifier_equal_expr_argument
    : identifier EQUAL expr
    ;



if_stmt
    : IF expr COLON suite
        (ELIF expr COLON suite)*
        (ELSE COLON suite)?
    ;

comparision_operator
    : LESS // <
    | GREATER // >
    | EQEQUAL // ==
    | NOTEQUAL // !=
    | LESSEQUAL // <=
    | GREATEREQUAL // >=
    | IS NOT?
    | NOT? IN
    ;

for_stmt
    : FOR target_list IN expr COLON suite
    ;

while_stmt
    : WHILE expr COLON suite
    ;



func_def
    : decorators? DEF NAME LPAR (parameters_list?) RPAR
        (RARROW (NONE | identifier))?
        COLON suite
    ;

parameters_list
    : non_default_parameter
        (COMMA non_default_parameter)*
        (COMMA default_parameter)*
        (COMMA args_kwargs_parameters_list)? COMMA?

    | default_parameter
        (COMMA default_parameter)*
        (COMMA args_kwargs_parameters_list)? COMMA?

    | args_kwargs_parameters_list
    ;

args_kwargs_parameters_list
    : args_parameter
        (COMMA kwargs_parameter)?                           #Args_Kwargs_Parameters_List_Full
    | kwargs_parameter                                      #Args_Kwargs_Parameters_List_Kwargs
    ;

args_parameter
    : STAR non_default_parameter
    ;

kwargs_parameter
    : DOUBLESTAR non_default_parameter
    ;

default_parameter
    : non_default_parameter EQUAL expr
    ;

non_default_parameter
    : identifier (COLON identifier)?
    ;

decorators
    : decorator+
    ;
decorator
    : AT decorator_expression NEWLINE
    ;
decorator_expression
    : dotted_name
    | dotted_name call
    ;
dotted_name
    : identifier (DOT identifier)*
    ;

class_def
    : decorators? CLASS identifier inheritance? COLON suite
    ;
inheritance
    : LPAR identifier (COMMA identifier)* COMMA? RPAR
    ;

try_stmt
    : TRY COLON suite
        except_clause+
        NEWLINE? else_clause?
        NEWLINE? finally_clause?                        #Try_Stmt

    | TRY COLON suite
        NEWLINE FINALLY COLON suite                     #Try_Finally_Stmt
    ;

else_clause
    : ELSE COLON suite
    ;

finally_clause
    : FINALLY COLON suite
    ;

except_clause
    : EXCEPT except_expression (AS identifier)? COLON suite
    ;

except_expression
    : exception_type
    | LPAR exception_type (COMMA exception_type)+ COMMA? RPAR
    ;

exception_type
    : identifier (DOT identifier)*
    ;


with_stmt
    : WITH with_item (COMMA with_item)* COLON suite
    ;

with_item
    : expr (AS target)?
    ;

suite
    : simple_stmt
    | NEWLINE INDENT statements DEDENT
    ;


// Small Simple Statments

import_stmt
    : IMPORT import_targets                             #Import_Stmt
    | FROM import_from_target IMPORT import_targets     #Import_From_Stmt
    ;

import_targets
    : import_target (COMMA import_target)* COMMA?
    ;

import_target
    : identifier (AS identifier)?                       #Import_Target
    | identifier (DOT identifier)+ (AS identifier)?     #Import_Target
    | STAR                                              #Import_Star
    ;

import_from_target
    : identifier (DOT identifier)*
    | (DOT | ELLIPSIS)+
    | (DOT | ELLIPSIS)+ identifier (DOT identifier)*
    ;

// Tiny Simple Statements
return_stmt
    : RETURN expr?
    ;

raise_stmt
    : RAISE raise_expression?
    ;

raise_expression
    : exception_instance (FROM exception_instance)?
    ;

exception_instance
    : exception_type
    | exception_type LPAR arguments_list? RPAR
    ;

global_stmt
    : GLOBAL identifier (COMMA identifier)* COMMA?
    ;
break_stmt
    : BREAK
    ;
pass_stmt
    : PASS
    ;
continue_stmt
    : CONTINUE
    ;


number
    : INT
    | FLOAT
    ;

identifier
    : NAME
    ;


