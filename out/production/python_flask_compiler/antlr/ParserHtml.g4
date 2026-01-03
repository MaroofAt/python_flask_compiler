parser grammar ParserHtml;

options {
    tokenVocab = LexerHtml;
}

document
    : element* EOF
    ;

element
    : openTag content closeTag              #NormalElementNode
    | selfClosingTag                        #SelfClosingElementNode
    | voidElement                           #VoidElementNode
    | TEXT                                  #TextNode
    ;

openTag
    : LT TAG_WS? TAG_NAME (TAG_WS attribute)* TAG_WS? GT
    ;

closeTag
    : LT TAG_WS? SLASH TAG_WS? TAG_NAME TAG_WS? GT
    ;

selfClosingTag
    : LT TAG_WS? TAG_NAME (TAG_WS attribute)* TAG_WS? SLASH TAG_WS? GT
    ;

voidElement
    : LT TAG_WS? VOID_TAG (TAG_WS attribute)* TAG_WS? GT

    ;

attribute
    : TAG_NAME TAG_WS? EQUALS TAG_WS? STRING #NormalAttributeNode
    | TAG_NAME                               #BooleanAttributeNode
    ;

content
    : element*
    ;
