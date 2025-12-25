parser grammar Jinja2Parser;

options {tokenVocab = Jinja2Lexer;}

// ========================================
// ROOT RULES
// ========================================
template:
    (text
    | statement
    | expression
    | comment
    | raw_stmt
    | document
    )*
    EOF;

// ========================================
// HTML
// ========================================

document
    : element                         #DocumentNode
    ;

element
    : openTag content closeTag              #NormalElementNode
    | selfClosingTag                        #SelfClosingElementNode
    | voidElement                           #VoidElementNode
    | text                                  #HtmlTextNode
    ;

openTag
    : HTML_LT HTML_TAG_WS? HTML_TAG_NAME (HTML_TAG_WS attribute)* HTML_TAG_WS? HTML_GT
        #OpenTagNode
    ;

closeTag
    : HTML_LT HTML_TAG_WS? HTML_SLASH HTML_TAG_WS? HTML_TAG_NAME HTML_TAG_WS? HTML_GT
        #CloseTagNode
    ;

selfClosingTag
    : HTML_LT HTML_TAG_WS? HTML_TAG_NAME (HTML_TAG_WS attribute)* HTML_TAG_WS? HTML_SLASH HTML_TAG_WS? HTML_GT
        #SelfClosingTagNode
    ;

voidElement
    : HTML_LT HTML_TAG_WS? HTML_VOID_TAG (HTML_TAG_WS attribute)* HTML_TAG_WS? HTML_GT
        #VoidTagElementNode
    ;

attribute
    : HTML_TAG_NAME HTML_TAG_WS? HTML_EQUALS HTML_TAG_WS? HTML_STRING
        #NormalAttributeNode
    | HTML_TAG_NAME
        #BooleanAttributeNode
    ;

content
    : (element | statement | expression)*
        #ContentNode
    ;

// ========================================
// END HTML
// ========================================

text: (TEXT_CONTENT | ANY_TEXT)+
    #TextContent;

comment: JINJA2_COMMENT_OPEN JINJA2_COMMENT_TEXT* JINJA2_COMMENT_CLOSE
    #CommentNode;

// ========================================
// EXPRESSIONS
// ========================================
expression: JINJA2_EXPRESSION_OPEN expr JINJA2_EXPRESSION_CLOSE
    #ExpressionNode;

expr: test
    #ExprTest;

test: or_test (JINJA2_EXPR_IS name test_arg?)?
    #TestNode;

name: JINJA2_EXPR_NAME                 #ExprName
    | JINJA2_NAME                      #StmtName;

test_arg: JINJA2_EXPR_LPAREN arg_list? JINJA2_EXPR_RPAREN
    #TestArgNode;

or_test: and_test (JINJA2_EXPR_OR and_test)*
    #OrTestNode;

and_test: not_test (JINJA2_EXPR_AND not_test)*
    #AndTestNode;

not_test: JINJA2_EXPR_NOT not_test
    #NotTestNode
    | comparison
    #ComparisonNotTest;

comparison: arith_expr (comp_op arith_expr)*
    #ComparisonNode;

comp_op:
    JINJA2_EXPR_EQEQUAL                #ExprEqualOp
    | JINJA2_EXPR_NOTEQUAL             #ExprNotEqualOp
    | JINJA2_EXPR_LESS                 #ExprLessOp
    | JINJA2_EXPR_GREATER              #ExprGreaterOp
    | JINJA2_EXPR_LESSEQUAL            #ExprLessEqualOp
    | JINJA2_EXPR_GREATEREQUAL         #ExprGreaterEqualOp;

arith_expr: term (add_op term)*
    #ArithExprNode;

add_op: JINJA2_EXPR_PLUS               #ExprPlusOp
    | JINJA2_EXPR_MINUS                #ExprMinusOp;

term: factor (mul_op factor)*
    #TermNode;

mul_op: JINJA2_EXPR_STAR               #ExprMultiplyOp
    | JINJA2_EXPR_SLASH                #ExprDivideOp
    | JINJA2_EXPR_PERCENT              #ExprModuloOp;

factor: (JINJA2_EXPR_PLUS | JINJA2_EXPR_MINUS) factor
    #UnaryFactorNode
    | power
    #PowerFactorNode;

power: primary (JINJA2_EXPR_STAR JINJA2_EXPR_STAR factor)?
    #PowerNode;

primary: atom (trailer)*
    #PrimaryNode;

atom:
    name                                    #NameAtom
    | JINJA2_EXPR_NUMBER                    #NumberAtom
    | JINJA2_EXPR_STRING                    #StringAtom
    | JINJA2_EXPR_TRUE                      #TrueAtom
    | JINJA2_EXPR_FALSE                     #FalseAtom
    | JINJA2_EXPR_NONE                      #NoneAtom
    | JINJA2_EXPR_LPAREN expr JINJA2_EXPR_RPAREN
        #ParenAtom
    | JINJA2_EXPR_LBRACK list_display? JINJA2_EXPR_RBRACK
        #ListAtom
    | JINJA2_EXPR_LBRACE dict_display? JINJA2_EXPR_RBRACE
        #DictAtom
    | JINJA2_EXPR_PIPE filter_args
        #FilterAtom;

trailer:
    JINJA2_EXPR_DOT name
        #AttributeTrailer
    | JINJA2_EXPR_LPAREN arg_list? JINJA2_EXPR_RPAREN
        #CallTrailer
    | JINJA2_EXPR_LBRACK subscript JINJA2_EXPR_RBRACK
        #SubscriptTrailer
    | JINJA2_EXPR_PIPE filter_args
        #FilterTrailer;

subscript: test                           #TestSubscript
    | slice_op                            #SliceSubscript;

slice_op: test? JINJA2_EXPR_COLON test? (JINJA2_EXPR_COLON test?)?
    #SliceOpNode;

list_display: list_items
    #ListDisplayNode;

list_items: (expr | star_expr) (JINJA2_EXPR_COMMA (expr | star_expr))* JINJA2_EXPR_COMMA?
    #ListItemsNode;

dict_display:
    JINJA2_EXPR_LBRACE
    (key_datum (JINJA2_EXPR_COMMA key_datum)* JINJA2_EXPR_COMMA?)?
    JINJA2_EXPR_RBRACE
    #DictDisplayNode;

key_datum: expr JINJA2_EXPR_COLON expr
    #KeyDatumNode;

star_expr: JINJA2_EXPR_STAR expr
    #StarExprNode;

testlist_comp: (test | star_expr) (comp_for | (JINJA2_EXPR_COMMA (test | star_expr))* JINJA2_EXPR_COMMA?)
    #TestlistCompNode;

// ========================================
// FILTERS
// ========================================
filter_args: arg_list?
    #FilterArgsNode;

// ========================================
// STATEMENTS
// ========================================
statement: JINJA2_STATEMENT_OPEN stmt JINJA2_STATEMENT_CLOSE
    #StatementNode;

stmt: if_stmt                           #IfStatement
    | for_stmt                          #ForStatement
    | set_stmt                          #SetStatement
    | expr_stmt2                        #ExprStatement
    | extends_stmt                      #ExtendsStatement
    | block_stmt                        #BlockStatement
    | with_stmt                         #WithStatement
    | include_stmt                      #IncludeStatement
    | import_stmt                       #ImportStatement
    | from_import_stmt                  #FromImportStatement
    | filter_stmt                       #FilterStatement
    | autoescape_stmt                   #AutoescapeStatement;

// IF statement
if_stmt: JINJA2_IF test_stmt JINJA2_STATEMENT_CLOSE body
    (JINJA2_STATEMENT_OPEN JINJA2_ELIF test_stmt JINJA2_STATEMENT_CLOSE body)*
    (JINJA2_STATEMENT_OPEN JINJA2_ELSE JINJA2_STATEMENT_CLOSE body)?
    JINJA2_STATEMENT_OPEN JINJA2_ENDIF
    #IfStmtNode;

test_stmt: or_test_stmt (JINJA2_IS name test_arg_stmt?)?
    #TestStmtNode;

test_arg_stmt: JINJA2_LPAREN arg_list_stmt? JINJA2_RPAREN
    #TestArgStmtNode;

arg_list_stmt: argument_stmt (JINJA2_COMMA argument_stmt)* JINJA2_COMMA?
    #ArgListStmtNode;

argument_stmt: expr_stmt2               #PositionalArgStmt
    | name JINJA2_EQUAL expr_stmt2      #KeywordArgStmt;

or_test_stmt: and_test_stmt (JINJA2_OR and_test_stmt)*
    #OrTestStmtNode;

and_test_stmt: not_test_stmt (JINJA2_AND not_test_stmt)*
    #AndTestStmtNode;

not_test_stmt: JINJA2_NOT not_test_stmt
    #NotTestStmtNode
    | comparison_stmt
    #ComparisonStmtNotTest;

comparison_stmt: arith_stmt (comp_op_stmt arith_stmt)*
    #ComparisonStmtNode;

comp_op_stmt:
    JINJA2_EQEQUAL                      #StmtEqualOp
    | JINJA2_NOTEQUAL                   #StmtNotEqualOp
    | JINJA2_LESS                       #StmtLessOp
    | JINJA2_GREATER                    #StmtGreaterOp
    | JINJA2_LESSEQUAL                  #StmtLessEqualOp
    | JINJA2_GREATEREQUAL               #StmtGreaterEqualOp;

arith_stmt: term_stmt (add_op_stmt term_stmt)*
    #ArithStmtNode;

add_op_stmt: JINJA2_PLUS                #StmtPlusOp
    | JINJA2_MINUS                      #StmtMinusOp;

term_stmt: factor_stmt (mul_op_stmt factor_stmt)*
    #TermStmtNode;

mul_op_stmt: JINJA2_STAR                #StmtMultiplyOp
    | JINJA2_SLASH                      #StmtDivideOp
    | JINJA2_PERCENT                    #StmtModuloOp;

factor_stmt: (JINJA2_PLUS | JINJA2_MINUS) factor_stmt
    #UnaryFactorStmtNode
    | power_stmt
    #PowerFactorStmtNode;

power_stmt: primary_stmt (JINJA2_STAR JINJA2_STAR factor_stmt)?
    #PowerStmtNode;

primary_stmt: atom_stmt (trailer_stmt)*
    #PrimaryStmtNode;

atom_stmt:
    name                                #StmtNameAtom
    | JINJA2_NUMBER                     #StmtNumberAtom
    | JINJA2_STRING                     #StmtStringAtom
    | JINJA2_TRUE                       #StmtTrueAtom
    | JINJA2_FALSE                      #StmtFalseAtom
    | JINJA2_NONE                       #StmtNoneAtom
    | JINJA2_LPAREN expr_stmt2 JINJA2_RPAREN
        #StmtParenAtom
    | JINJA2_LBRACK list_display_stmt? JINJA2_RBRACK
        #StmtListAtom
    | JINJA2_LBRACE dict_display_stmt? JINJA2_RBRACE
        #StmtDictAtom
    | JINJA2_PIPE filter_args_stmt
        #StmtFilterAtom;

trailer_stmt:
    JINJA2_DOT name
        #StmtAttributeTrailer
    | JINJA2_LPAREN arg_list_stmt? JINJA2_RPAREN
        #StmtCallTrailer
    | JINJA2_LBRACK subscript_stmt JINJA2_RBRACK
        #StmtSubscriptTrailer
    | JINJA2_PIPE filter_args_stmt
        #StmtFilterTrailer;

expr_stmt2: test_stmt
    #ExprStmt2Node;

list_display_stmt: list_items_stmt
    #ListDisplayStmtNode;

list_items_stmt: (expr_stmt2 | star_expr_stmt) (JINJA2_EXPR_COMMA (expr_stmt2 | star_expr_stmt))* JINJA2_EXPR_COMMA?
    #ListItemsStmtNode;

star_expr_stmt: JINJA2_STAR expr_stmt2
    #StarExprStmtNode;

dict_display_stmt:
    JINJA2_LBRACE
    (key_datum_stmt (JINJA2_COMMA key_datum_stmt)* JINJA2_COMMA?)?
    JINJA2_RBRACE
    #DictDisplayStmtNode;

key_datum_stmt: expr_stmt2 JINJA2_COLON expr_stmt2
    #KeyDatumStmtNode;

subscript_stmt: test_stmt               #StmtTestSubscript
    | slice_op_stmt                     #StmtSliceSubscript;

slice_op_stmt: test_stmt? JINJA2_COLON test_stmt? (JINJA2_COLON test_stmt?)?
    #SliceOpStmtNode;


for_stmt: JINJA2_FOR (name | name JINJA2_COMMA name) JINJA2_IN expr_stmt2 JINJA2_STATEMENT_CLOSE body JINJA2_STATEMENT_OPEN JINJA2_ENDFOR
    #ForStmtNode;


set_stmt: JINJA2_SET name JINJA2_EQUAL expr_stmt2
    #SetStmtNode;

with_stmt: JINJA2_WITH (with_target JINJA2_COMMA?)+  JINJA2_STATEMENT_CLOSE body JINJA2_STATEMENT_OPEN JINJA2_ENDWITH
    #WithStmtNode;

with_target:  JINJA2_NAME JINJA2_EQUAL expr_stmt2
    #WithTargetNode;


expr_stmt: expr
    #ExprStmtNode;


body:
    (statement
    | text
    | document
    | expression
    | comment
    )*
    #BodyNode;

// ========================================
// UTILITY RULES
// ========================================
arg_list: argument (JINJA2_EXPR_COMMA argument)* JINJA2_EXPR_COMMA?
    #ArgListNode;

argument: expr                          #PositionalArgument
    | name JINJA2_EXPR_EQUAL expr       #KeywordArgument;

comp_for: JINJA2_FOR name JINJA2_IN or_test comp_iter?
    #CompForNode;

comp_iter: comp_for                     #CompIterFor
    | comp_if                           #CompIterIf;

comp_if: JINJA2_IF test comp_iter?
    #CompIfNode;

block_stmt: JINJA2_BLOCK JINJA2_NAME JINJA2_STATEMENT_CLOSE body JINJA2_STATEMENT_OPEN JINJA2_ENDBLOCK
    #BlockStmtNode;

extends_stmt: JINJA2_EXTENDS JINJA2_STRING
    #ExtendsStmtNode;

include_stmt: JINJA2_INCLUDE JINJA2_STRING (JINJA2_WITH JINJA2_NAME JINJA2_EQUAL expr)? (JINJA2_COMMA JINJA2_NAME JINJA2_EQUAL expr)*
    #IncludeStmtNode;

import_stmt: JINJA2_IMPORT JINJA2_STRING JINJA2_AS JINJA2_NAME
    #ImportStmtNode;

from_import_stmt: JINJA2_FROM JINJA2_STRING JINJA2_IMPORT JINJA2_NAME (JINJA2_COMMA JINJA2_NAME)* JINJA2_AS JINJA2_NAME?
    #FromImportStmtNode;

filter_stmt: JINJA2_FILTER JINJA2_NAME  filter_args_stmt? JINJA2_STATEMENT_CLOSE body JINJA2_STATEMENT_OPEN JINJA2_ENDFILTER
    #FilterStmtNode;

filter_args_stmt: arg_list_stmt?
    #FilterArgsStmtNode;

// ========================================
// RAW BLOCK
// ========================================

raw_stmt: RAW_START RAW_TEXT* RAW_END
    #RawStmtNode;

// ========================================
// AUTOESCAPE
// ========================================

autoescape_stmt: JINJA2_AUTOESCAPE (JINJA2_TRUE | JINJA2_FALSE) JINJA2_STATEMENT_CLOSE body JINJA2_STATEMENT_OPEN JINJA2_ENDAUTOESCAPE
    #AutoescapeStmtNode;