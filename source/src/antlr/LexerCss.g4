lexer grammar LexerCss;

LBRACE  : '{';
RBRACE  : '}';
COLON   : ':';
SEMI    : ';';
COMMA   : ',';
DOT     : '.';

HASH
    : '#'
    ;

HEXCOLOR
    : '#' [0-9a-fA-F]+
    ;

NUMBER
    : [0-9]+ ('.' [0-9]+)?
    ;

UNIT
    : 'px' | 'em' | 'rem' | '%' | 'vh' | 'vw'
    ;

STRING
    : '"' (~["\r\n])* '"'
    | '\'' (~['\r\n])* '\''
    ;

IDENT
    : [a-zA-Z_-] [a-zA-Z0-9_-]*
    ;

COMMENT
    : '/*' .*? '*/' -> skip
    ;

WS
    : [ \t\r\n]+ -> skip
    ;
