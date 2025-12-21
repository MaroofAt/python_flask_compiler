parser grammar ParserHtml;

options {
    tokenVocab = LexerHtml;
}

document
    : element* EOF
    ;

element
    : openTag content closeTag   #ElementNode
    | selfClosingTag             #SelfClosingElementNode
    | TEXT                       #TextNode
    ;

openTag
    : LT TAG_NAME attribute* GT  #OpenTagNode
    ;

closeTag
    : LT SLASH TAG_NAME GT       #CloseTagNode
    ;

selfClosingTag
    : LT TAG_NAME attribute* SLASH GT  #SelfClosingTagNode
    ;

attribute
    : TAG_NAME EQUALS STRING     #AttributeNode
    ;

content
    : element*                   #ContentNode
    ;
