lexer grammar JinjaLexer;

WS                          : [ \t\r\n]+ -> skip;
HTML_COMMENT                : '<!--' .*? '-->' -> skip;
LT                          : '<';
SELF_CLOSE                  : SLASH GT;
GT                          : '>';
SLASH                       : '/';
EQUAL                       : '=';
BACKSLASH                   : '\\';
DOT                         : '.';
fragment NUM                : '0' | [1-9] DIGIT*;
fragment ESC                : BACKSLASH [vbfnrt"'\\];
STRING_START
        : '"' -> pushMode(STRING_MODE)
        ;
SINGLE_COTATION_STRING_START
        : '\''-> pushMode(STRING_MODE_SINGLE_COTATION)
        ;
//STRING: '"' (~["\\\r\n] | ESC)* '"'
//      | '\'' (~['\\\r\n] | ESC)* '\'';

fragment CHARACTER : [_a-zA-Z];
fragment DIGIT  : [0-9];

IDENTIFIER
    : CHARACTER (CHARACTER | DIGIT | '-')*
    ;

JINJA_EXPR_OPEN   : '{{' -> pushMode(JINJA_SYNTAX_MODE);
JINJA_STMT_OPEN   : '{%'-> pushMode(JINJA_SYNTAX_MODE);
//JINJA_OPEN_COMMENT : '{#'-> pushMode(JINJA_COMMENT_MODE);
JINJA_COMMENT : '{#' .*? '#}' -> skip;
TEXT
    : ( ('{' ~[{#%}])  | (~[<{]) )+
    ;

ERROR_CHAR
    : .
      //{ throw new RuntimeException("Illegal character: " + getText()); }
    ;


mode STRING_MODE;
STRING_END: '"' -> popMode;
JINJA_OPEN_EXPR_IN_STRING: '{{' -> pushMode(JINJA_SYNTAX_MODE);
STRING_BODY: (~["\\\r\n] | ESC)+; // if the string is empty this token will not be produced
STRING_START_SINGLE_COTATION: '\'' -> pushMode(STRING_MODE_SINGLE_COTATION);

mode STRING_MODE_SINGLE_COTATION;
STRING_END_SINGLE_COTATION: '\'' -> popMode;
JINJA_OPEN_EXPR_IN_STRING_SINGLE_COTATION: '{{' -> pushMode(JINJA_SYNTAX_MODE);
STRING_BODY_SINGLE_COTATION: (~["\\\r\n] | ESC)+; // if the string is empty this token will not be produced


mode JINJA_SYNTAX_MODE;
JINJA_STMT_CLOSE: '%}' -> popMode;
JINJA_EXPR_CLOSE: '}}' -> popMode;
WS_JINJA: [ \t\r\n]+ -> skip;
STRING: '"' (~["\\\r\n] | ESC)* '"'
      | '\'' (~['\\\r\n] | ESC)* '\'';
IF      : 'if';
ELIF    : 'elif';
ELSE    : 'else';
ENDIF   : 'endif';

FOR     : 'for';
ENDFOR  : 'endfor';

IN      : 'in';
IS      : 'is';

AND     : 'and';
OR      : 'or';
NOT     : 'not';

SET     : 'set';
BLOCK   : 'block';
EXTENDS : 'extends';
INCLUDE : 'include';

ID: CHARACTER (CHARACTER | DIGIT | '-')* -> type(IDENTIFIER);
LPAR                : '(';
LSQB                : '[';
RPAR                : ')';
RSQB                : ']';
DOT1                : '.' -> type(DOT);
COLON               : ':';
COMMA               : ',';
SEMI                : ';';
PLUS                : '+';
MINUS               : '-';
STAR                : '*';
SLSH                : '/' -> type(SLASH);
VBAR                : '|';
AMPER               : '&';
LESS                : '<';
GREATER             : '>';
EQ                  : '=' -> type(EQUAL);
PERCENT             : '%';
EQEQUAL             : '==';
NOTEQUAL            : '!=';
LESSEQUAL           : '<=';
GREATEREQUAL        : '>=';
DOUBLESTAR          : '**';
PLUSEQUAL           : '+=';
MINEQUAL            : '-=';
STAREQUAL           : '*=';
SLASHEQUAL          : '/=';
PERCENTEQUAL        : '%=';
DOUBLESTAREQUAL     : '**=';
EXCLAMATION         : '!';
FALSE               : 'False' | 'false';
TRUE                : 'True' | 'true';
None                : 'None' | 'none';
FLOAT               : NUM '.' NUM;
INT                 : NUM;

// attrs
//GLOBAL_ATTR    : 'id' | 'class' | 'style' | 'title' | 'lang' | 'dir'
//                | 'tabindex' | 'hidden' | 'draggable' | 'contenteditable'
//                | 'spellcheck' | 'autocapitalize' | 'onclick' | 'onkeydown'
//                | 'onfocus';
//META_ATTR: 'charset' | 'name' | 'content' | GLOBAL_ATTR;
//LINK_ATTR: 'rel' | 'href' | GLOBAL_ATTR;
//A_ATTR: 'href' | GLOBAL_ATTR;
//BUTTON_ATTR: 'type' | GLOBAL_ATTR;
//INPUT_ATTR: 'accept' | GLOBAL_ATTR;
//LABEL_ATTR: 'for' | GLOBAL_ATTR;
//IMG_ATTR: 'src' | 'alt' | GLOBAL_ATTR;
