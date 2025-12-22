lexer grammar LexerHtml;

LT      : '<' -> pushMode(TAG);
TEXT    : ~[<]+;
WS      : [ \t\r\n]+ -> skip;


mode TAG;

GT      : '>' -> popMode;
SLASH   : '/';
EQUALS  : '=';

STRING
    : '"' (~["\r\n])* '"'
    ;


VOID_TAG
    : 'input'
    | 'img'
    | 'br'
    | 'hr'
    | 'meta'
    | 'link'
    ;


TAG_NAME
    : [a-zA-Z] [a-zA-Z0-9_-]*
    ;

TAG_WS
    : [ \t\r\n]+
    ;
