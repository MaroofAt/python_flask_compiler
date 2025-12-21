lexer grammar PythonLexer;

@lexer::members{
    private java.util.Queue<Token> pending = new java.util.LinkedList<>();
    private java.util.Stack<Integer> indents = new java.util.Stack<>(){{ push(0); }};
    private int opened = 0; // the opened (parenthes/brackets/braces) count

    private org.antlr.v4.runtime.CommonToken commonToken(int type, String text) {
        int tstart = _tokenStartCharIndex;
        int line = getLine();
        int charPos = getCharPositionInLine();
        org.antlr.v4.runtime.CommonToken t = new org.antlr.v4.runtime.CommonToken(
            this._tokenFactorySourcePair,
            type,
            org.antlr.v4.runtime.Token.DEFAULT_CHANNEL,
            tstart,
            _input.index()
        );
        t.setText(text);
        t.setLine(line);
        t.setCharPositionInLine(charPos);
        return t;
    }

    private int getIndentationCount(String spaces)throws RuntimeException{
        int count = 0;
        for (char ch : spaces.toCharArray()) {
            if (ch == '\t') {
                count += 4 - (count % 4); // we calculate this not this:"count += 4;" because it may be there spaces before '\t' and its count not a multiple of 4 so the \t will not represent 4 now it may represent less !!!
            } else {
                // spaces and any other visible whitespace we count as 1
                count += 1;
            }
        }
        if(count%4 != 0) throw new RuntimeException("IndentationError: unexpected indent");
        return count;
    }

    @Override
    public org.antlr.v4.runtime.Token nextToken()throws RuntimeException{
        // If we already queued tokens (INDENT/DEDENT/NEWLINE), return them first
        if (!pending.isEmpty()) {
            return pending.poll();
        }

        Token next = super.nextToken();

        // If EOF (end-of-file), unwind indent stack and emit DEDENT tokens (one per remaining indent level), then EOF
        if (next.getType() == org.antlr.v4.runtime.Token.EOF) {
            // emit DEDENTs (and optionally a final NEWLINE if your parser expects it).
            while (indents.size() > 1) {
                pending.add(commonToken(DEDENT, "<DEDENT>"));
                indents.pop();
            }
            // after queuing all DEDENTs, queue EOF token itself and return first pending
            pending.add(next); // next = EOF
            return pending.poll();
        }

        // If the token is NEWLINE, we must compute indentation (unless inside parentheses/brackets/braces)
        if (next.getType() == NEWLINE) {
            // If we're inside a parenthesized expression, NEWLINE is insignificant -> skip it.
            if (opened > 0) {
                // implicit line-joining
                // return the next token (effectively skip this newline)
                return nextToken();
            }

            // The text of NEWLINE token will include the following indentation spaces (see rule below)
            String newlineText = next.getText();
            // Extract only the whitespace after the newline characters to compute indent
            // the NEWLINE rule below sets text like "\n    " or "\r\n\t"
            int i = 0;
            while (i < newlineText.length() && (newlineText.charAt(i) == '\r' || newlineText.charAt(i) == '\n')) i++;
            String indentPart = newlineText.substring(i); //spaces and "\t"s that came after "\r\n"

            // Looking ahead to see if the next character is a COMMENT or NEWLINE -> skip blank_line/comment-only-line
            int next_chr = _input.LA(1);
            if (next_chr == '#' || next_chr == '\r' || next_chr == '\n' || next_chr == org.antlr.v4.runtime.Token.EOF) {
                // Blank or comment-only line -> skip
                return nextToken();
            }


            int indent = getIndentationCount(indentPart);
            int previous = indents.isEmpty() ? 0 : indents.peek();

            if (indent == previous) {
                // No change in indentation: emit a simple NEWLINE token
                return next; // next = NEWLINE
            }
            if (indent > previous) {
                // Increased indent level
                indents.push(indent);
                // We add the NEWLINE token first because this is the right implementation based on CPython's tokenizer
                pending.add(next); // next = NEWLINE
                pending.add(commonToken(INDENT, "<INDENT>"));
                return pending.poll();
            }

            // indent < previous
            // => emit one or more DEDENT tokens
            pending.add(next); // next = NEWLINE
            while ( (indents.size() > 1) && (indents.peek() > indent) ) {
                pending.add(commonToken(DEDENT, "<DEDENT>"));
                indents.pop();
            }

            return pending.poll();
        }

        // For tokens that open/close parentheses/brackets/braces, update 'opened' counter.
        // We rely on actions in the rules themselves (see LPAR/LSQB/LBRACE and RPAR/RSQB/RBRACE).
        return next;
    }

}

LPAR             : '(' { opened++; }; // OPEN_PAREN
LSQB             : '[' { opened++; }; // OPEN_BRACK
LBRACE           : '{' { opened++; }; // OPEN_BRACE
RPAR             : ')' { opened--; if (opened < 0) opened = 0; }; // CLOSE_PAREN
RSQB             : ']' { opened--; if (opened < 0) opened = 0; }; // CLOSE_BRACK
RBRACE           : '}' { opened--; if (opened < 0) opened = 0; }; // CLOSE_BRACE
DOT              : '.';
COLON            : ':';
COMMA            : ',';
SEMI             : ';';
PLUS             : '+';
MINUS            : '-';
STAR             : '*';
SLASH            : '/';
VBAR             : '|';
AMPER            : '&';
LESS             : '<';
GREATER          : '>';
EQUAL            : '=';
PERCENT          : '%';
EQEQUAL          : '==';
NOTEQUAL         : '!=';
LESSEQUAL        : '<=';
GREATEREQUAL     : '>=';
CIRCUMFLEX       : '^';
DOUBLESTAR       : '**';
PLUSEQUAL        : '+=';
MINEQUAL         : '-=';
STAREQUAL        : '*=';
SLASHEQUAL       : '/=';
PERCENTEQUAL     : '%=';
CIRCUMFLEXEQUAL  : '^=';
ELLIPSIS         : '...';
EXCLAMATION      : '!';
RARROW           : '->';
//TILDE            : '~';
//LEFTSHIFT        : '<<';
//RIGHTSHIFT       : '>>';
//AMPEREQUAL       : '&=';
//VBAREQUAL        : '|=';
//LEFTSHIFTEQUAL   : '<<=';
//RIGHTSHIFTEQUAL  : '>>=';
DOUBLESTAREQUAL  : '**=';
//DOUBLESLASH      : '//';
//DOUBLESLASHEQUAL : '//=';
AT               : '@';
//ATEQUAL          : '@=';
//COLONEQUAL       : ':=';

// https://docs.python.org/3.13/reference/lexical_analysis.html#keywords
IMPORT   : 'import';
PASS     : 'pass';
NONE     : 'None';
BREAK    : 'break';
EXCEPT   : 'except';
IN       : 'in';
RAISE    : 'raise';
CLASS    : 'class';
FINALLY  : 'finally';
IS       : 'is';
RETURN   : 'return';
AND      : 'and';
CONTINUE : 'continue';
FOR      : 'for';
TRY      : 'try';
AS       : 'as';
DEF      : 'def';
FROM     : 'from';
WHILE    : 'while';
GLOBAL   : 'global';
NOT      : 'not';
OR       : 'or';
ELSE     : 'else';
ELIF     : 'elif';
IF       : 'if';
//AWAIT    : 'await';
//LAMBDA   : 'lambda';
//NONLOCAL : 'nonlocal';
//ASSERT   : 'assert';
//DEL      : 'del';
//WITH     : 'with';
//ASYNC    : 'async';
//YIELD    : 'yield';

NEWLINE : '\r'? '\n' [ \t]*; // NEWLINE with leading INDENTATION

// explicit tokens for parser to use
INDENT : '<INDENT>'; // synthesized by lexer Java code (text doesn't matter)
DEDENT : '<DEDENT>'; // synthesized by lexer Java code

WS: ' '+->skip;

COMMENT : '#' ~[\r\n]* ->skip;
MULTI_LINE_COMMENT: '"""' .*? '"""' ->skip;

fragment DIGIT: [0-9];
fragment NUM: '0' | [1-9] DIGIT*;
//fragment NUM_WITH_PLUS_MINUS_SIGN: [+-] NUM;
//fragment NUMBER: NUM | NUM_WITH_PLUS_MINUS_SIGN;

INT:    NUM;
FLOAT:  NUM '.' NUM;
fragment ESC: EXPLICIT_LINE_JOINING [vbfnrt"'\\];
EXPLICIT_LINE_JOINING: '\\';
F_STRING: 'f' STRING;
STRING: '"' (~["\\\r\n] | ESC)* '"'
      | '\'' (~["\\\r\n] | ESC)* '\'';

BOOLEAN: TRUE | FALSE;
FALSE    : 'False';
TRUE     : 'True';

KEYWORD_INT: 'int';
KEYWORD_FLOAT: 'float';
KEYWORD_CHAR: 'chr';
KEYWORD_STRING: 'str';
KEYWORD_BOOL: 'bool';

//METHOD_TYPE: 'type';
//METHOD_PRINT: 'print';
KEYWORD_CASE: 'case';

fragment CHARACTER: [_a-zA-Z];
NAME: CHARACTER (CHARACTER | [0-9])*;
