package smpl.lang;

import java.util.Hashtable;

// Adapted from https://stackoverflow.com/questions/7775919/writing-an-initialized-static-hashtable-elegantly
public final class SyntaxErrorTable {
    
    public static final Hashtable<String, String> sed;

    static{
        sed = new Hashtable<>();
        String numberSuggestion = "Numbers are usually to be placed within a mathematical expression";
        String[][] pairs = {
            { "EOF", "" },
            { "error", "" },
            { "SEMI", "" },
            { "COLON", "" },
            { "LPAREN", "" },
            { "RPAREN", "" },
            { "LBRACE", "" },
            { "RBRACE", "" },
            { "LBRAK", "" },
            { "RBRAK", "" },
            { "MAP", "" },
            { "COMMA", "Commas must delimit an expression within an array, a pair in a dictionary or function call. E.g. [5, 6]" },
            { "IDENTIFIER", "Variables can be ..." },
            { "STRING", "" },
            { "BINARY", "" },
            { "HEX", "" },
            { "OCTAL", "" },
            { "LONG", numberSuggestion },
            { "DOUBLE", numberSuggestion },
            { "TRUE", "" },
            { "FALSE", "" },
            { "PI", "" },
            { "EULER", "" },
            { "SIGMA", "" },
            { "PRINT", "" },
            { "READ", "" },
            { "PLUS", "" },
            { "ASSIGNADD", "" },
            { "INCREMENT", "" },
            { "MINUS", "" },
            { "ASSIGNSUB", "" },
            { "DECREMENT", "" },
            { "TIMES", "" },
            { "ASSIGNTIMES", "" },
            { "EXPONENT", "" },
            { "DIVIDE", "" },
            { "ASSIGNDIVIDE", "" },
            { "RADICAL", "" },
            { "MOD", "" },
            { "ASSIGNMOD", "" },
            { "AMP", "" },
            { "ASSIGNAMP", "" },
            { "BAR", "" },
            { "ASSIGNBAR", "" },
            { "CARET", "" },
            { "ASSIGNCARET", "" },
            { "TILDE", "" },
            { "EQ", "" },
            { "GT", "" },
            { "LT", "" },
            { "LTEQ", "" },
            { "GTEQ", "" },
            { "NOTEQ", "" },
            { "AND", "" },
            { "OR", "" },
            { "NOT", "" },
            { "ASSIGN", "" },
            { "IMPLY", "" },
            { "QUERY", "" },
            { "CASES", "" }
        };

        for (String[] pair : pairs) {
            sed.put(pair[0], pair[1]);
        }
    }
}
