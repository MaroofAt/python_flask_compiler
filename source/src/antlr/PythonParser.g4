parser grammar PythonParser;

options {tokenVocab = PythonLexer;}

application
    : statements EOF
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
    | return_stmt
    | raise_stmt
//    | import_stmt
    | global_stmt
    | break_stmt    //BREAK
    | pass_stmt     //PASS
    | continue_stmt //CONTINUE
    ;

compound_stmt
    : if_stmt
    | for_stmt
    | while_stmt
//    | try_stmt
    | func_def
    | class_def
    ;


assignment
    :(target_list EQUAL)+ expr // Attention: this allows: ``` a = b = c = 1,2,3,4,5 ``` which is wrong, So later in semantic checks we have to reject that case
    | typed_assignment
//    | unpaking_tuples_assignment
//    | chained_assignement
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
    : attribute_ref
    | subscription
    ;

target_list
    : target (COMMA target)* COMMA?
    ;

typed_assignment
    : identifier COLON data_type (EQUAL expr)?
    ;

//unpaking_tuples_assignment
//    : target_list EQUAL expr COMMA expr_list?
//    ;
//
//chained_assignement
//    : target (EQUAL target)+ EQUAL conditional_expr
//    ;


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
    : or_expr
    | or_expr IF or_expr ELSE conditional_expr // short if statement
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
    :addition_expr
    ;

addition_expr
    : multiplication_expr ((PLUS | MINUS) multiplication_expr)*
    ;

multiplication_expr
    : primary ((STAR | SLASH | PERCENT) primary)*
    ;

primary
    : unary_op* atom postfix*
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
    : LPAR argument_list? RPAR
    ;
subscription
    : LSQB expr RSQB
    ;
attribute_ref
    : DOT identifier
    ;

atom
    : identifier
    | literal
    | enclosure
    | LPAR expr RPAR
    ;

literal
    : number
    | strings
    | BOOLEAN
    | NONE
    ;
strings
    : STRING
    | F_STRING
    ;

enclosure
    : list_literal
    | set_literal
    | dict_literal
    ;

list_literal
    : LSQB expr_list? RSQB // [1,2,3,4,5,6] , [1+2, a>b<t==6] that is allowed in python
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


argument_list
    : expr_list
    ;

expr_list
    : expr (COMMA expr)* (COMMA)?
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

// TODO Add the x += 1 and others later
// TODO Really Add decorators later ---------------- 👇
// TODO Add *args and **kwargs handling later 👇
func_def
    : decorators? DEF NAME LPAR (parameters_list?) RPAR
        (RARROW (data_type| NONE | identifier /* class identifier */ ))?
        COLON suite
    ;

parameters_list
    : non_default_parameter
        (COMMA non_default_parameter)*
        (COMMA default_parameter)* COMMA?
    | default_parameter
        (COMMA default_parameter)* COMMA?
    ;

default_parameter
    : non_default_parameter EQUAL expr
    ;

non_default_parameter
    : identifier (COLON data_type)?
    ;

decorators
    : decorator+
    ;
decorator
    : AT identifier NEWLINE
    ;

class_def
    : decorators? CLASS identifier inheritance? COLON suite
    ;
inheritance
    : LPAR identifier (COMMA identifier)* COMMA? RPAR
    ;

suite
    : simple_stmt
    | NEWLINE INDENT statements DEDENT
    ;

// Tiny Simple Statements
return_stmt
    : RETURN expr_list?
    ;
raise_stmt
    : RAISE (expr (FROM expr)?)?
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

data_type
    : KEYWORD_INT
    | KEYWORD_FLOAT
    | KEYWORD_CHAR
    | KEYWORD_STRING
    | KEYWORD_BOOL
    ;

identifier
    : NAME
    ;


