lexer grammar LexerHtml;
LT:'<' -> pushMode(TAG);

TEXT:~[<]+ ;

WS:[ \t\r\n]+ -> skip;

mode TAG;

GT:'>' -> popMode;

SLASH:'/';

EQUALS:'=';

STRING:'"' (~["\r\n])* '"';

TAG_NAME:[a-zA-Z] [a-zA-Z0-9_-]*;

TAG_WS:[ \t\r\n]+ -> skip;


