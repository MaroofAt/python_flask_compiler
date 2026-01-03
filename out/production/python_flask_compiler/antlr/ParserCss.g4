parser grammar ParserCss;

options {
    tokenVocab = LexerCss;
}

stylesheet
    : (ruleSet | mediaRule)* EOF
    ;

mediaRule
    : AT MEDIA mediaCondition LBRACE ruleSet* RBRACE

    ;

mediaCondition
    : LPAREN IDENT COLON value RPAREN
    ;

ruleSet
    : selectorList LBRACE declaration* RBRACE
    ;

selectorList
    : selector (COMMA selector)*
    ;

selector
    : simpleSelector+
    ;

simpleSelector
    : STAR                                      #UniversalSelector
    | IDENT                                     #TypeSelector
    | DOT IDENT                                 #ClassSelector
    | HASH IDENT                                #IdSelector
    | COLON IDENT                               #PseudoClassSelector
    ;

declaration
    : property COLON value SEMI
    ;

property
    : IDENT
    ;

value
    : valueSequence (COMMA valueSequence)*
    ;

valueSequence
    : valuePart+
    ;

valuePart
    : HEXCOLOR                                  #ColorValue
    | NUMBER UNIT?                              #NumberValue
    | STRING                                    #StringValue
    | IDENT                                     #IdentifierValue
    | functionCall                              #FunctionValue
    ;

functionCall
    : IDENT LPAREN value (COMMA value)* RPAREN
    ;
