lexer grammar LexerCss;

STAR    : '*';
DOT     : '.';
HASH    : '#';
COLON   : ':';
COMMA   : ',';
LBRACE  : '{';
RBRACE  : '}';
LPAREN  : '(';
RPAREN  : ')';
SEMI    : ';';

AT      : '@';
MEDIA   : 'media';

HEXCOLOR
    : '#' [0-9a-fA-F]+
    ;

NUMBER
    : [0-9]+ ('.' [0-9]+)?
    ;

UNIT
    : 'px' | 'em' | 'rem' | '%' | 'vh' | 'vw' | 's' | 'fr'
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
