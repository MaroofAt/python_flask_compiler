//lexer grammar Jinja2Lexer;
//
//// ========================================
//// JINJA2 DELIMITERS
//// ========================================
//JINJA2_STATEMENT_OPEN: '{%' -> pushMode(STMT_MODE);
//JINJA2_EXPRESSION_OPEN: '{{' -> pushMode(EXPR_MODE);
//JINJA2_COMMENT_OPEN: '{#' -> pushMode(COMMENT_MODE);
//
//// ========================================
//// RAW BLOCKS (Special handling)
//// ========================================
//
//// ========================================
//// TEXT CONTENT (Default mode)
//// ========================================
////mode DEFAULT_MODE;
////
////    // HTML tags (optional but useful)
//////    HTML_TAG_OPEN: '<' [a-zA-Z][a-zA-Z0-9-]* ('>' | [ \t\r\n]) -> pushMode(HTML_MODE);
//////    HTML_COMMENT: '<!--' .*? '-->';
//////    HTML_DOCTYPE: '<!DOCTYPE' .*? '>';
////
////    // Text content between Jinja2 tags
////    TEXT_CONTENT: ~[<{%{#]+;
////
////    // Match single characters that might start Jinja2/HTML
//////    LT: '<' -> pushMode(HTML_MODE);  baybe we will use it in the html mode not now
////    JINJA2_START: [{] -> pushMode(JINJA2_CHECK_MODE);
//
//// ========================================
//// HTML MODE
//// ========================================
////mode HTML_MODE;
////
////    HTML_TAG_CLOSE: '>' -> popMode;
////    HTML_SELF_CLOSE: '/>' -> popMode;
////    HTML_TAG_NAME: [a-zA-Z][a-zA-Z0-9-]*;
////    HTML_ATTRIBUTE_NAME: [a-zA-Z_-]+;
////    HTML_EQUALS: '=';
////    HTML_STRING: ('"' ~["]* '"' | '\'' ~[']* '\'');
////    HTML_WHITESPACE: [ \t\r\n]+ -> skip;
////
////    // Inside HTML tags, we might encounter Jinja2
////    HTML_JINJA2_START: [{%{] -> more, pushMode(JINJA2_CHECK_MODE);
//
//// ========================================
//// JINJA2 CHECK MODE (Determine which Jinja2 delimiter)
//// ========================================
////mode JINJA2_CHECK_MODE;
////
////    // Check what follows the { or %
////    JINJA2_STMT_OPEN: '%' -> popMode, pushMode(STMT_MODE);
////    JINJA2_EXPR_OPEN: '{' -> popMode, pushMode(EXPR_MODE);
//////    JINJA2_COMMENT_OPEN2: '#' -> popMode, pushMode(COMMENT_MODE);
////
////    // If it's not a Jinja2 delimiter, go back and treat as text
////    NOT_JINJA2: . -> popMode, type(TEXT_CONTENT);
//
//// ========================================
//// STATEMENT MODE
//// ========================================
//mode STMT_MODE;
//
//
//    // Jinja2 keywords
//    JINJA2_IF: 'if';
//    JINJA2_ELIF: 'elif' | 'elseif';
//    JINJA2_ELSE: 'else';
//    JINJA2_FOR: 'for';
//    JINJA2_IN: 'in';
//    JINJA2_ENDFOR: 'endfor';
//    JINJA2_ENDIF: 'endif';
//    JINJA2_BLOCK: 'block';
//    JINJA2_ENDBLOCK: 'endblock';
//    JINJA2_EXTENDS: 'extends';
//    JINJA2_INCLUDE: 'include';
//    JINJA2_IMPORT: 'import';
//    JINJA2_FROM: 'from'; // use in import
//    JINJA2_AS: 'as';
//    JINJA2_SET: 'set'; // to set value to variable
////    JINJA2_MACRO: 'macro'; // we dont support this bart because we did not use it in our project
////    JINJA2_ENDMACRO: 'endmacro';
////    JINJA2_CALL: 'call'; // it need macro to work
////    JINJA2_ENDCALL: 'endcall';
//    JINJA2_FILTER: 'filter';
//    JINJA2_ENDFILTER: 'endfilter';
//    JINJA2_WITH: 'with';
//    JINJA2_ENDWITH: 'endwith';
//    JINJA2_RAW: 'raw';
//    JINJA2_ENDRAW: 'endraw';
//    JINJA2_AUTOESCAPE: 'autoescape'; // this use to secur the site from cross-site Scripting
//    JINJA2_ENDAUTOESCAPE: 'endautoescape';
//    JINJA2_IS: 'is';
//    JINJA2_NOT: 'not';
//    JINJA2_AND: 'and';
//    JINJA2_OR: 'or';
//
//    // Operators
//    JINJA2_PLUS: '+';
//    JINJA2_MINUS: '-';
//    JINJA2_STAR: '*';
//    JINJA2_SLASH: '/';
//    JINJA2_PERCENT: '%';
//    JINJA2_EQEQUAL: '==';
//    JINJA2_NOTEQUAL: '!=' ;
//    JINJA2_LESS: '<';
//    JINJA2_GREATER: '>';
//    JINJA2_LESSEQUAL: '<=';
//    JINJA2_GREATEREQUAL: '>=';
//
//    // Symbols
//    JINJA2_DOT: '.';
//    JINJA2_COMMA: ',';
//    JINJA2_COLON: ':';
//    JINJA2_LPAREN: '(';
//    JINJA2_RPAREN: ')';
//    JINJA2_LBRACK: '[';
//    JINJA2_RBRACK: ']';
//    JINJA2_LBRACE: '{';
//    JINJA2_RBRACE: '}';
//    JINJA2_EQUAL: '=';
//    JINJA2_PIPE: '|';
//
//    // Literals and identifiers
//    JINJA2_NAME: [a-zA-Z_][a-zA-Z0-9_]*;
//    JINJA2_STRING: ('"' (~["\\] | '\\' .)* '"') | ('\'' (~['\\] | '\\' .)* '\'');
//    STRING: ('"' (~["\\] | '\\' .)* '"') | ('\'' (~['\\] | '\\' .)* '\'');
//    JINJA2_NUMBER: [0-9]+ ('.' [0-9]+)?;
//    JINJA2_TRUE: 'True' | 'true';
//    JINJA2_FALSE: 'False' | 'false';
//    JINJA2_NONE: 'None' | 'none' | 'null' | 'Null';
//
//    JINJA2_STATEMENT_CLOSE: '%}' -> popMode;
//    // Whitespace
//    WS: [ \t\r\n]+ -> skip;
//
//// ========================================
//// EXPRESSION MODE
//// ========================================
//mode EXPR_MODE;
//
//    JINJA2_EXPRESSION_CLOSE: '}}' -> popMode;
//
//    // Expression content
//    JINJA2_EXPR_DOT: '.';
//    JINJA2_EXPR_NAME: [a-zA-Z_][a-zA-Z0-9_]*;
//    JINJA2_EXPR_STRING: ('"' (~["\\] | '\\' .)* '"') | ('\'' (~['\\] | '\\' .)* '\'');
//    JINJA2_EXPR_NUMBER: [0-9]+ ('.' [0-9]+)?;
//    JINJA2_EXPR_PIPE: '|';
//    JINJA2_EXPR_LPAREN: '(';
//    JINJA2_EXPR_RPAREN: ')';
//    JINJA2_EXPR_LBRACK: '[';
//    JINJA2_EXPR_RBRACK: ']';
//    JINJA2_EXPR_LBRACE: '{';
//    JINJA2_EXPR_RBRACE: '}';
//    JINJA2_EXPR_PLUS: '+';
//    JINJA2_EXPR_MINUS: '-';
//    JINJA2_EXPR_STAR: '*';
//    JINJA2_EXPR_SLASH: '/';
//    JINJA2_EXPR_PERCENT: '%';
//    JINJA2_EXPR_EQEQUAL: '==';
//    JINJA2_EXPR_NOTEQUAL: '!=' ;
//    JINJA2_EXPR_LESS: '<';
//    JINJA2_EXPR_GREATER: '>';
//    JINJA2_EXPR_LESSEQUAL: '<=';
//    JINJA2_EXPR_GREATEREQUAL: '>=';
//    JINJA2_EXPR_COMMA: ',';
//    JINJA2_EXPR_COLON: ':';
//    JINJA2_EXPR_TRUE: 'True' | 'true';
//    JINJA2_EXPR_FALSE: 'False' | 'false';
//    JINJA2_EXPR_NONE: 'None' | 'none' | 'null';
//    JINJA2_EXPR_AND: 'and';
//    JINJA2_EXPR_OR: 'or';
//    JINJA2_EXPR_NOT: 'not';
//    JINJA2_EXPR_IN: 'in';
//    JINJA2_EXPR_IS: 'is';
//
//    WS_EXPR: [ \t\r\n]+ -> skip;
//
//// ========================================
//// COMMENT MODE
//// ========================================
//mode COMMENT_MODE;
//
//    JINJA2_COMMENT_CLOSE: '#}' -> popMode;
//    JINJA2_COMMENT_TEXT: ~[#}]+ ;
//
//// ========================================
//// RAW MODE (everything is literal text)
//// ========================================
//mode RAW_MODE;
//
//    RAW_END: '{%' [ \t\r\n]* 'endraw' [ \t\r\n]* '%}' -> popMode;
//    RAW_TEXT: ~[{%]+ | '{' ~[%] | '{%' ~[rR]?;
//
//
//
//
//
//// HTML/XML tags (optional, for better HTML support)
//
////HTML_ATTRIBUTE: [a-zA-Z_-]+ '=' ('"' ~["]* '"' | '\'' ~[']* '\'');
//
//// Raw blocks
//
//
//// Autoescape blocks
//AUTOESCAPE: '{%' [ \t\r\n]* 'autoescape' [ \t\r\n]*;
//ENDAUTOESCAPE: '{%' [ \t\r\n]* 'endautoescape' [ \t\r\n]* '%}';
//
//// Any character that doesn't match other tokens
//ANY_TEXT: .;


lexer grammar Jinja2Lexer;

// ========================================
// JINJA2 DELIMITERS (in DEFAULT_MODE)
// ========================================
JINJA2_STATEMENT_OPEN: '{%' -> pushMode(STMT_MODE);
JINJA2_EXPRESSION_OPEN: '{{' -> pushMode(EXPR_MODE);  // FIXED: Direct to EXPR_MODE
JINJA2_COMMENT_OPEN: '{#' -> pushMode(COMMENT_MODE);

// ========================================
// RAW BLOCKS
// ========================================
RAW_START: '{%' WS* 'raw' WS* '%}' -> pushMode(RAW_MODE);

// ========================================
// DEFAULT MODE (Text content)
// ========================================
mode DEFAULT_MODE;

    TEXT_CONTENT: ~[<{%{#]+;  // Text without special characters

    // HTML support (commented out for now)
    // HTML_TAG_OPEN: '<' [a-zA-Z] -> pushMode(HTML_MODE);

    // Single { that's not Jinja2
    SINGLE_LCURLY: '{' -> type(TEXT_CONTENT);

    ANY_TEXT: .;  // Catch-all

// ========================================
// STATEMENT MODE ({% ... %})
// ========================================
mode STMT_MODE;

    JINJA2_STATEMENT_CLOSE: '%}' -> popMode;

    // Keywords
    JINJA2_IF: 'if';
    JINJA2_ELIF: 'elif';
    JINJA2_ELSE: 'else';
    JINJA2_FOR: 'for';
    JINJA2_IN: 'in';
    JINJA2_ENDFOR: 'endfor';
    JINJA2_ENDIF: 'endif';
    JINJA2_BLOCK: 'block';
    JINJA2_ENDBLOCK: 'endblock';
    JINJA2_EXTENDS: 'extends';
    JINJA2_INCLUDE: 'include';
    JINJA2_IMPORT: 'import';
    JINJA2_FROM: 'from';
    JINJA2_AS: 'as';
    JINJA2_SET: 'set';
    JINJA2_FILTER: 'filter';
    JINJA2_ENDFILTER: 'endfilter';
    JINJA2_WITH: 'with';
    JINJA2_ENDWITH: 'endwith';
    JINJA2_RAW: 'raw';
    JINJA2_ENDRAW: 'endraw';
    JINJA2_AUTOESCAPE: 'autoescape';
    JINJA2_ENDAUTOESCAPE: 'endautoescape';

    // Logical operators
    JINJA2_IS: 'is';
    JINJA2_NOT: 'not';
    JINJA2_AND: 'and';
    JINJA2_OR: 'or';

    // Comparison operators
    JINJA2_EQEQUAL: '==';
    JINJA2_NOTEQUAL: '!=';
    JINJA2_LESS: '<';
    JINJA2_GREATER: '>';
    JINJA2_LESSEQUAL: '<=';
    JINJA2_GREATEREQUAL: '>=';

    // Arithmetic operators
    JINJA2_PLUS: '+';
    JINJA2_MINUS: '-';
    JINJA2_STAR: '*';
    JINJA2_SLASH: '/';
    JINJA2_PERCENT: '%';

    // Symbols
    JINJA2_DOT: '.';
    JINJA2_COMMA: ',';
    JINJA2_COLON: ':';
    JINJA2_LPAREN: '(';
    JINJA2_RPAREN: ')';
    JINJA2_LBRACK: '[';
    JINJA2_RBRACK: ']';
    JINJA2_LBRACE: '{';
    JINJA2_RBRACE: '}';
    JINJA2_EQUAL: '=';
    JINJA2_PIPE: '|';

    // Literals
    JINJA2_TRUE: 'True' | 'true';
    JINJA2_FALSE: 'False' | 'false';
    JINJA2_NONE: 'None' | 'none' | 'null' | 'Null';
    JINJA2_NAME: [a-zA-Z_][a-zA-Z0-9_]*;
    JINJA2_STRING: ('"' (~["\\] | '\\' .)* '"') | ('\'' (~['\\] | '\\' .)* '\'');
    JINJA2_NUMBER: [0-9]+ ('.' [0-9]+)?;
    JINJA2_DOUBLESLASH: '//';
    WS: [ \t\r\n]+ -> skip;

// ========================================
// EXPRESSION MODE ({{ ... }})
// ========================================
mode EXPR_MODE;

    JINJA2_EXPRESSION_CLOSE: '}}' -> popMode;

    // Expression operators (same as statement but with EXPR_ prefix)
    JINJA2_EXPR_AND: 'and';
    JINJA2_EXPR_OR: 'or';
    JINJA2_EXPR_NOT: 'not';
    JINJA2_EXPR_IN: 'in';
    JINJA2_EXPR_IS: 'is';

    JINJA2_EXPR_EQEQUAL: '==';
    JINJA2_EXPR_NOTEQUAL: '!=';
    JINJA2_EXPR_LESS: '<';
    JINJA2_EXPR_GREATER: '>';
    JINJA2_EXPR_LESSEQUAL: '<=';
    JINJA2_EXPR_GREATEREQUAL: '>=';

    JINJA2_EXPR_PLUS: '+';
    JINJA2_EXPR_MINUS: '-';
    JINJA2_EXPR_STAR: '*';
    JINJA2_EXPR_SLASH: '/';
    JINJA2_EXPR_PERCENT: '%';
    JINJA2_EXPR_PIPE: '|';

    JINJA2_EXPR_EQUAL: '=';
    JINJA2_EXPR_DOT: '.';
    JINJA2_EXPR_COMMA: ',';
    JINJA2_EXPR_COLON: ':';
    JINJA2_EXPR_LPAREN: '(';
    JINJA2_EXPR_RPAREN: ')';
    JINJA2_EXPR_LBRACK: '[';
    JINJA2_EXPR_RBRACK: ']';
    JINJA2_EXPR_LBRACE: '{';
    JINJA2_EXPR_RBRACE: '}';

    JINJA2_EXPR_NAME: [a-zA-Z_][a-zA-Z0-9_]*;
    JINJA2_EXPR_STRING: ('"' (~["\\] | '\\' .)* '"') | ('\'' (~['\\] | '\\' .)* '\'');
    JINJA2_EXPR_NUMBER: [0-9]+ ('.' [0-9]+)?;
    JINJA2_EXPR_TRUE: 'True' | 'true';
    JINJA2_EXPR_FALSE: 'False' | 'false';
    JINJA2_EXPR_NONE: 'None' | 'none' | 'null';
    JINJA2_EXPR_DOUBLESLASH: '//';
    WS_EXPR: [ \t\r\n]+ -> skip;

// ========================================
// COMMENT MODE ({# ... #})
// ========================================
mode COMMENT_MODE;
    JINJA2_COMMENT_CLOSE: '#}' -> popMode;
    JINJA2_COMMENT_TEXT: ~[#}]+;

// ========================================
// RAW MODE
// ========================================
mode RAW_MODE;
    RAW_END: '{%' WS* 'endraw' WS* '%}' -> popMode;
    RAW_TEXT: ~[\r\n]* ( '\r'? '\n'  ) /*~[{%]+ | '{' ~[%] | '{%' ~[rR]?*/;

// ========================================
// HTML MODE (commented out)
// ========================================
/*
mode HTML_MODE;
    HTML_TAG_CLOSE: '>' -> popMode;
    HTML_TAG_NAME: [a-zA-Z][a-zA-Z0-9-]*;
    WS_HTML: [ \t\r\n]+ -> skip;
*/

// Fragment for whitespace
//fragment WS: [ \t\r\n];