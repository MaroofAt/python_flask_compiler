parser grammar ParserCss;

options {
    tokenVocab = LexerCss;
}

stylesheet
    : ruleSet* EOF
    ;

ruleSet
    : selectorList LBRACE declaration* RBRACE     #RuleSetNode
    ;

selectorList
    : selector (COMMA selector)*                  #SelectorListNode
    ;

selector
    : simpleSelector+                             #SelectorNode
    ;

simpleSelector
    : IDENT                #TypeSelector
    | DOT IDENT            #ClassSelector
    | HASH IDENT           #IdSelector
    ;

declaration
    : property COLON value SEMI                   #DeclarationNode
    ;

property
    : IDENT                                       #PropertyNode
    ;

value
    : valueSequence (COMMA valueSequence)*    #ValueList
    ;

valueSequence
    : valuePart+                              #ValueSequenceNode
    ;



valuePart
    : HEXCOLOR                                    #ColorValue
    | NUMBER UNIT?                                #NumberValue
    | STRING                                      #StringValue
    | IDENT                                       #IdentValue
    ;

