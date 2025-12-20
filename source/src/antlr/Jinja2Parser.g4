//parser grammar Jinja2Parser;
//
//options {tokenVocab = Jinja2Lexer;}
//
//// ========================================
//// ROOT/TOP-LEVEL RULES
//// ========================================
//template: (text | statement | expression | comment)* EOF;
//
//text: (TEXT_CONTENT | ANY_TEXT)+;
//
//comment: JINJA2_COMMENT_OPEN JINJA2_COMMENT_TEXT* JINJA2_COMMENT_CLOSE;
//
//// ========================================
//// EXPRESSIONS
//// ========================================
//expression: JINJA2_EXPRESSION_OPEN expr JINJA2_EXPRESSION_CLOSE;
//
//expr: test;
//
//test: or_test (JINJA2_IS JINJA2_NAME test_arg?)?;
//
//test_arg: JINJA2_EXPR_LPAREN arg_list? JINJA2_EXPR_RPAREN;
//
//or_test: and_test ((JINJA2_OR | JINJA2_EXPR_OR) and_test)*;
//and_test: not_test ((JINJA2_AND | JINJA2_EXPR_AND) not_test)*;
//not_test: JINJA2_NOT not_test | comparison;
//
//comparison:
//    arith_expr
//    (comp_op arith_expr)*;
//
//comp_op:
//    JINJA2_EQEQUAL
//    | JINJA2_NOTEQUAL
//    | JINJA2_LESS
//    | JINJA2_GREATER
//    | JINJA2_LESSEQUAL
//    | JINJA2_GREATEREQUAL
//    | JINJA2_EXPR_EQEQUAL
//    | JINJA2_EXPR_NOTEQUAL
//    | JINJA2_EXPR_LESS
//    | JINJA2_EXPR_GREATER
//    | JINJA2_EXPR_LESSEQUAL
//    | JINJA2_EXPR_GREATEREQUAL;
//
//arith_expr:
//    term (add_op term)*;
//
//add_op:
//    JINJA2_PLUS
//    | JINJA2_MINUS
//    | JINJA2_EXPR_MINUS
//    | JINJA2_EXPR_PLUS;
//
//term:
//    factor (mul_op factor)*;
//
//mul_op:
//    JINJA2_STAR
//    | JINJA2_SLASH
//    | JINJA2_PERCENT;
//
//factor:
//    (JINJA2_PLUS | JINJA2_MINUS) factor
//    | power;
//
//power: primary (JINJA2_STAR JINJA2_STAR factor)?;
//
//primary:
//    atom
//    | primary trailer;
//
//atom:
//    JINJA2_NAME
//    | JINJA2_NUMBER
//    | JINJA2_STRING
//    | JINJA2_TRUE
//    | JINJA2_FALSE
//    | JINJA2_NONE
//    | JINJA2_EXPR_NAME
//    | JINJA2_EXPR_NUMBER
//    | JINJA2_EXPR_LPAREN (expr | testlist_comp)? JINJA2_EXPR_RPAREN
//    | JINJA2_EXPR_LBRACK list_display? JINJA2_EXPR_RBRACK
//    | JINJA2_EXPR_LBRACE dict_display? JINJA2_EXPR_RBRACE;
//
//trailer:
//    JINJA2_EXPR_DOT JINJA2_EXPR_NAME
//    | JINJA2_DOT JINJA2_NAME
//    | JINJA2_EXPR_LPAREN arg_list? JINJA2_EXPR_RPAREN
//    | JINJA2_EXPR_LBRACK subscript JINJA2_EXPR_RBRACK;
//
//subscript: test | slice_op;
//slice_op: test? JINJA2_EXPR_COLON test? (JINJA2_EXPR_COLON test?)?;
//
//list_display: list_items;
//list_items: (expr | star_expr) (JINJA2_EXPR_COMMA (expr | star_expr))* JINJA2_EXPR_COMMA?;
//
//dict_display:
//    JINJA2_EXPR_LBRACE
//    (key_datum (JINJA2_EXPR_COMMA key_datum)* JINJA2_EXPR_COMMA?)?
//    JINJA2_EXPR_RBRACE;
//
//key_datum: expr JINJA2_EXPR_COLON expr;
//
//star_expr: JINJA2_STAR expr;
//
//testlist_comp: (test | star_expr) (comp_for | (JINJA2_EXPR_COMMA (test | star_expr))* JINJA2_EXPR_COMMA?);
//
//// ========================================
//// FILTERS
//// ========================================
//filter_chain: expr (JINJA2_PIPE filter)*;
//filter: JINJA2_NAME filter_args?;
//filter_args: JINJA2_EXPR_LPAREN arg_list? JINJA2_EXPR_RPAREN;
//
//// ========================================
//// STATEMENTS
//// ========================================
//statement: JINJA2_STATEMENT_OPEN stmt JINJA2_STATEMENT_CLOSE;
//
//stmt:
//    if_stmt
//    | for_stmt
//    | block_stmt
//    | extends_stmt
//    | include_stmt
//    | set_stmt
////    | macro_stmt
////    | call_stmt
//    | filter_stmt
//    | with_stmt
//    | raw_stmt
//    | autoescape_stmt
//    | import_stmt
//    | from_import_stmt
//    | expr_stmt;
//
//// ========================================
//// IF STATEMENT
//// ========================================
//if_stmt:
//    JINJA2_IF test if_body
//    (JINJA2_ELIF test if_body)*
//    (JINJA2_ELSE body)?;
//
//if_body: body;
//
//body: (statement | text | expression | comment)*;
//
//// ========================================
//// FOR LOOP
//// ========================================
//for_stmt:
//    JINJA2_FOR expr_list JINJA2_IN expr if_clauses?
//    JINJA2_COLON for_body
//    (JINJA2_ELSE JINJA2_COLON else_body)?
//    JINJA2_ENDFOR;
//
//for_body: body;
//else_body: body;
//
//expr_list: expr (JINJA2_COMMA expr)* JINJA2_COMMA?;
//if_clauses: JINJA2_IF test (JINJA2_AND test)*;
//
//// ========================================
//// BLOCKS AND TEMPLATE INHERITANCE
//// ========================================
//block_stmt: JINJA2_BLOCK JINJA2_NAME body JINJA2_ENDBLOCK;
//extends_stmt: JINJA2_EXTENDS STRING;
//include_stmt: JINJA2_INCLUDE STRING (JINJA2_WITH JINJA2_NAME JINJA2_EQUAL expr)? (JINJA2_COMMA JINJA2_NAME JINJA2_EQUAL expr)*;
//import_stmt: JINJA2_IMPORT STRING JINJA2_AS JINJA2_NAME;
//from_import_stmt: JINJA2_FROM STRING JINJA2_IMPORT JINJA2_NAME (JINJA2_COMMA JINJA2_NAME)* JINJA2_AS JINJA2_NAME?;
//
//// ========================================
//// VARIABLES AND MACROS
//// ========================================
//set_stmt: JINJA2_SET JINJA2_NAME JINJA2_EQUAL expr;
////macro_stmt: JINJA2_MACRO JINJA2_NAME JINJA2_EXPR_LPAREN macro_args? JINJA2_EXPR_RPAREN JINJA2_COLON body JINJA2_ENDMACRO;
//macro_args: JINJA2_NAME (JINJA2_COMMA JINJA2_NAME)* JINJA2_COMMA?;
//
////call_stmt:
////    JINJA2_CALL expr JINJA2_EXPR_LPAREN call_args? JINJA2_EXPR_RPAREN
////    JINJA2_COLON call_body JINJA2_ENDCALL;
//
//call_args: arg (JINJA2_COMMA arg)* JINJA2_COMMA?;
//call_body: body;
//
//arg: expr | JINJA2_NAME JINJA2_EQUAL expr;
//
//// ========================================
//// OTHER STATEMENTS
//// ========================================
//filter_stmt: JINJA2_FILTER JINJA2_NAME filter_args? JINJA2_COLON body JINJA2_ENDFILTER;
//with_stmt: JINJA2_WITH (with_target JINJA2_COMMA?)+ JINJA2_COLON body JINJA2_ENDWITH;
//with_target: JINJA2_NAME JINJA2_EQUAL expr;
//
//raw_stmt: RAW_START raw_content RAW_END;
//raw_content: RAW_TEXT+;
//
//autoescape_stmt: JINJA2_AUTOESCAPE (JINJA2_TRUE | JINJA2_FALSE) JINJA2_COLON body JINJA2_ENDAUTOESCAPE;
//
//expr_stmt: expr;
//
//// ========================================
//// UTILITY RULES
//// ========================================
//arg_list: argument (JINJA2_COMMA argument)* JINJA2_COMMA?;
//argument: expr | JINJA2_NAME JINJA2_EQUAL expr;
//
//comp_for: JINJA2_FOR expr_list JINJA2_IN or_test comp_iter?;
//comp_iter: comp_for | comp_if;
//comp_if: JINJA2_IF test comp_iter?;
//
//// ========================================
//// LEXER UPDATES NEEDED
//// ========================================
///*
//You need to add these tokens to your lexer:
//
//// Text content between Jinja2 tags
//TEXT_CONTENT: ~[{%{#]+; // Any text except Jinja2 delimiters
//
//// HTML/XML tags (optional, for better HTML support)
//HTML_TAG_OPEN: '<' [a-zA-Z][a-zA-Z0-9-]*;
//HTML_TAG_CLOSE: '</' [a-zA-Z][a-zA-Z0-9-]* '>';
//HTML_SELF_CLOSE: '<' [a-zA-Z][a-zA-Z0-9-]* '/>';
//HTML_ATTRIBUTE: [a-zA-Z_-]+ '=' ('"' ~["]* '"' | '\'' ~[']* '\'');
//
//// Raw blocks
//RAW_START: '{%' [ \t\r\n]* 'raw' [ \t\r\n]* '%}';
//RAW_END: '{%' [ \t\r\n]* 'endraw' [ \t\r\n]* '%}';
//RAW_TEXT: ~[{%]+ | '{' ~[%] | '{%' ~[%];
//
//// Autoescape blocks
//AUTOESCAPE: '{%' [ \t\r\n]* 'autoescape' [ \t\r\n]*;
//ENDAUTOESCAPE: '{%' [ \t\r\n]* 'endautoescape' [ \t\r\n]* '%}';
//
//// Any character that doesn't match other tokens
//ANY_TEXT: .;
//*/

parser grammar Jinja2Parser;

options {tokenVocab = Jinja2Lexer;}

// ========================================
// ROOT RULES
// ========================================
template: (text | statement | expression | comment | raw_stmt)* EOF;

text: (TEXT_CONTENT | ANY_TEXT)+;

comment: JINJA2_COMMENT_OPEN JINJA2_COMMENT_TEXT* JINJA2_COMMENT_CLOSE;

// ========================================
// EXPRESSIONS
// ========================================
expression: JINJA2_EXPRESSION_OPEN expr JINJA2_EXPRESSION_CLOSE;

expr: test  ;

test: or_test (JINJA2_EXPR_IS name test_arg?)?;

name: JINJA2_EXPR_NAME | JINJA2_NAME;

test_arg: JINJA2_EXPR_LPAREN arg_list? JINJA2_EXPR_RPAREN;

or_test: and_test (JINJA2_EXPR_OR and_test)*;
and_test: not_test (JINJA2_EXPR_AND not_test)*;
not_test: JINJA2_EXPR_NOT not_test | comparison;

comparison: arith_expr (comp_op arith_expr)*;

comp_op:
    JINJA2_EXPR_EQEQUAL
    | JINJA2_EXPR_NOTEQUAL
    | JINJA2_EXPR_LESS
    | JINJA2_EXPR_GREATER
    | JINJA2_EXPR_LESSEQUAL
    | JINJA2_EXPR_GREATEREQUAL;

arith_expr: term (add_op term)*;

add_op: JINJA2_EXPR_PLUS | JINJA2_EXPR_MINUS;

term: factor (mul_op factor)*;

mul_op: JINJA2_EXPR_STAR | JINJA2_EXPR_SLASH | JINJA2_EXPR_PERCENT;

factor: (JINJA2_EXPR_PLUS | JINJA2_EXPR_MINUS) factor | power;

power: primary (JINJA2_EXPR_STAR JINJA2_EXPR_STAR factor)?;

primary: atom (trailer)*;

atom:
    name
    | JINJA2_EXPR_NUMBER
    | JINJA2_EXPR_STRING
    | JINJA2_EXPR_TRUE
    | JINJA2_EXPR_FALSE
    | JINJA2_EXPR_NONE
    | JINJA2_EXPR_LPAREN expr JINJA2_EXPR_RPAREN
    | JINJA2_EXPR_LBRACK list_display? JINJA2_EXPR_RBRACK
    | JINJA2_EXPR_LBRACE dict_display? JINJA2_EXPR_RBRACE
    | JINJA2_EXPR_PIPE filter_args; // TODO another ckeck3

trailer:
    JINJA2_EXPR_DOT name
    | JINJA2_EXPR_LPAREN arg_list? JINJA2_EXPR_RPAREN
    | JINJA2_EXPR_LBRACK subscript JINJA2_EXPR_RBRACK
    | JINJA2_EXPR_PIPE filter_args; // TODO another ckeck3

subscript: test | slice_op;
slice_op: test? JINJA2_EXPR_COLON test? (JINJA2_EXPR_COLON test?)?;

list_display: list_items;
list_items: (expr | star_expr) (JINJA2_EXPR_COMMA (expr | star_expr))* JINJA2_EXPR_COMMA?;

dict_display:
    JINJA2_EXPR_LBRACE
    (key_datum (JINJA2_EXPR_COMMA key_datum)* JINJA2_EXPR_COMMA?)?
    JINJA2_EXPR_RBRACE;

key_datum: expr JINJA2_EXPR_COLON expr;

star_expr: JINJA2_EXPR_STAR expr;

testlist_comp: (test | star_expr) (comp_for | (JINJA2_EXPR_COMMA (test | star_expr))* JINJA2_EXPR_COMMA?);

// ========================================
// FILTERS
// ========================================
//filter_chain: expr (JINJA2_EXPR_PIPE filter)*;
//filter: name filter_args?;
filter_args: /*JINJA2_EXPR_LPAREN*/ arg_list? /*JINJA2_EXPR_RPAREN*/;

// ========================================
// STATEMENTS (simplified for now)
// ========================================
statement: JINJA2_STATEMENT_OPEN stmt JINJA2_STATEMENT_CLOSE;

stmt: if_stmt
    | for_stmt
    | set_stmt
    | expr_stmt2
    | extends_stmt
    | block_stmt
    | with_stmt
    | include_stmt
    | import_stmt
    | from_import_stmt
    | filter_stmt
    | autoescape_stmt;

// IF statement
if_stmt: JINJA2_IF test_stmt JINJA2_STATEMENT_CLOSE body
    (JINJA2_STATEMENT_OPEN JINJA2_ELIF test_stmt JINJA2_STATEMENT_CLOSE body)*
    (JINJA2_STATEMENT_OPEN JINJA2_ELSE JINJA2_STATEMENT_CLOSE body)?
    JINJA2_STATEMENT_OPEN JINJA2_ENDIF;

test_stmt: or_test_stmt (JINJA2_IS name test_arg_stmt?)?;

test_arg_stmt: JINJA2_LPAREN arg_list? JINJA2_RPAREN;

arg_list_stmt: argument_stmt (JINJA2_COMMA argument_stmt)* JINJA2_COMMA?;

argument_stmt: expr_stmt2 | name JINJA2_EQUAL expr_stmt2;

or_test_stmt: and_test_stmt (JINJA2_OR and_test_stmt)*;

and_test_stmt: not_test_stmt (JINJA2_AND not_test_stmt)*;

not_test_stmt: JINJA2_NOT not_test_stmt | comparison_stmt;

comparison_stmt: arith_stmt (comp_op_stmt arith_stmt)*;

comp_op_stmt:
    JINJA2_EQEQUAL
    | JINJA2_NOTEQUAL
    | JINJA2_LESS
    | JINJA2_GREATER
    | JINJA2_LESSEQUAL
    | JINJA2_GREATEREQUAL;


arith_stmt: term_stmt (add_op_stmt term_stmt)*;

add_op_stmt: JINJA2_PLUS | JINJA2_MINUS;

term_stmt: factor_stmt (mul_op_stmt factor_stmt)*;

mul_op_stmt: JINJA2_STAR | JINJA2_SLASH | JINJA2_PERCENT;

factor_stmt: (JINJA2_PLUS | JINJA2_MINUS) factor_stmt | power_stmt;

power_stmt: primary_stmt (JINJA2_STAR JINJA2_STAR factor_stmt)?;

primary_stmt: atom_stmt (trailer_stmt)*;

atom_stmt:
    name
    | JINJA2_NUMBER
    | JINJA2_STRING
    | JINJA2_TRUE
    | JINJA2_FALSE
    | JINJA2_NONE
    | JINJA2_LPAREN expr_stmt2 JINJA2_RPAREN
    | JINJA2_LBRACK list_display_stmt? JINJA2_RBRACK
    | JINJA2_LBRACE dict_display_stmt? JINJA2_RBRACE
    | JINJA2_PIPE filter_args_stmt; // TODO just check1

trailer_stmt:
    JINJA2_DOT name
    | JINJA2_LPAREN arg_list_stmt? JINJA2_RPAREN
    | JINJA2_LBRACK subscript_stmt JINJA2_RBRACK
    | JINJA2_PIPE filter_args_stmt; // TODO just check2

expr_stmt2: test_stmt;

list_display_stmt: list_items_stmt;
list_items_stmt: (expr_stmt2 | star_expr_stmt) (JINJA2_EXPR_COMMA (expr_stmt2 | star_expr_stmt))* JINJA2_EXPR_COMMA?;

star_expr_stmt: JINJA2_STAR expr_stmt2;

dict_display_stmt:
    JINJA2_LBRACE
    (key_datum_stmt (JINJA2_COMMA key_datum_stmt)* JINJA2_COMMA?)?
    JINJA2_RBRACE;

key_datum_stmt: expr_stmt2 JINJA2_COLON expr_stmt2;

subscript_stmt: test_stmt | slice_op_stmt;
slice_op_stmt: test_stmt? JINJA2_COLON test_stmt? (JINJA2_COLON test_stmt?)?;



// FOR loop
for_stmt: JINJA2_FOR (name | name JINJA2_COMMA name) JINJA2_IN expr_stmt2 JINJA2_STATEMENT_CLOSE body JINJA2_STATEMENT_OPEN JINJA2_ENDFOR;

// SET variable
set_stmt: JINJA2_SET name JINJA2_EQUAL expr_stmt2;


with_stmt: JINJA2_WITH (with_target JINJA2_COMMA?)+  JINJA2_STATEMENT_CLOSE body JINJA2_STATEMENT_OPEN JINJA2_ENDWITH;
with_target:  JINJA2_NAME JINJA2_EQUAL expr_stmt2;

// Expression in statement
expr_stmt: expr;

body: (statement | text | expression | comment)*;

// ========================================
// UTILITY RULES
// ========================================
arg_list: argument (JINJA2_EXPR_COMMA argument)* JINJA2_EXPR_COMMA?;
argument: expr | name JINJA2_EXPR_EQUAL expr;

comp_for: JINJA2_FOR name JINJA2_IN or_test comp_iter?;
comp_iter: comp_for | comp_if;
comp_if: JINJA2_IF test comp_iter?;


block_stmt: JINJA2_BLOCK JINJA2_NAME JINJA2_STATEMENT_CLOSE body JINJA2_STATEMENT_OPEN JINJA2_ENDBLOCK;
extends_stmt: JINJA2_EXTENDS JINJA2_STRING;
include_stmt: JINJA2_INCLUDE JINJA2_STRING (JINJA2_WITH JINJA2_NAME JINJA2_EQUAL expr)? (JINJA2_COMMA JINJA2_NAME JINJA2_EQUAL expr)*;
import_stmt: JINJA2_IMPORT JINJA2_STRING JINJA2_AS JINJA2_NAME;
from_import_stmt: JINJA2_FROM JINJA2_STRING JINJA2_IMPORT JINJA2_NAME (JINJA2_COMMA JINJA2_NAME)* JINJA2_AS JINJA2_NAME?;



filter_stmt: JINJA2_FILTER JINJA2_NAME  filter_args_stmt? JINJA2_STATEMENT_CLOSE body JINJA2_STATEMENT_OPEN JINJA2_ENDFILTER;

//filter2: name filter_args?;
filter_args_stmt: /*JINJA2_LPAREN*/ arg_list_stmt? /*JINJA2_RPAREN*/;

// ========================================
// RAW BLOCK
// ========================================

raw_stmt: RAW_START RAW_TEXT* RAW_END;

//raw_body: (text | statement | expression | comment)* ;\

autoescape_stmt: JINJA2_AUTOESCAPE (JINJA2_TRUE | JINJA2_FALSE) JINJA2_STATEMENT_CLOSE body JINJA2_STATEMENT_OPEN JINJA2_ENDAUTOESCAPE;