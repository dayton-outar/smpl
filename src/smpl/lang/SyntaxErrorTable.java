package smpl.lang;

import java.util.Hashtable;

// Adapted from https://stackoverflow.com/questions/7775919/writing-an-initialized-static-hashtable-elegantly
public final class SyntaxErrorTable {
    
    public static final Hashtable<String, String> sed;

    static{
        sed = new Hashtable<>();
        String numberSuggestion = "Numbers are usually to be placed within a mathematical expression";
        String assignmentSuggestion = "Assignments must be a single statement of expression and can only be done within function definitions, if-elses, cases and loops.";
        String[][] pairs = {
            { "EOF", "All statements must be terminated with a semi-colon or, for function definitions, if-elses and cases, a brace" },
            { "error", "Ensure that all string, interpolated string expressions and statements are properly terminated" },
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
            { "IDENTIFIER", "Variables are used in assignments, array, dictionary or function calls." },
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
            { "PRINT", "Check syntax before the print statement" },
            { "READ", "" },
            { "PLUS", "" },
            { "ASSIGNADD", assignmentSuggestion },
            { "INCREMENT", "" },
            { "MINUS", "" },
            { "ASSIGNSUB", assignmentSuggestion },
            { "DECREMENT", "" },
            { "TIMES", "" },
            { "ASSIGNTIMES", assignmentSuggestion },
            { "EXPONENT", "" },
            { "DIVIDE", "" },
            { "ASSIGNDIVIDE", assignmentSuggestion },
            { "RADICAL", "" },
            { "MOD", "" },
            { "ASSIGNMOD", assignmentSuggestion },
            { "AMP", "" },
            { "ASSIGNAMP", assignmentSuggestion },
            { "BAR", "" },
            { "ASSIGNBAR", assignmentSuggestion },
            { "CARET", "" },
            { "ASSIGNCARET", assignmentSuggestion },
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
            { "ASSIGN", assignmentSuggestion },
            { "IMPLY", "" },
            { "QUERY", "" },
            { "CASES", "" }
        };

        for (String[] pair : pairs) {
            sed.put(pair[0], pair[1]);
        }
    }
}
