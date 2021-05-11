package smpl.lang;

import java_cup.runtime.*;

/**
 * This class is a simple example lexer.
 */
%%

%cup
%public
%class SMPLLexer

%type java_cup.runtime.Symbol

%eofval{
	return new Symbol(sym.EOF);
%eofval}

%unicode
%line

%{
  StringBuffer string = new StringBuffer();

  public int getChar()
  {
    return yychar + 1;
  }

  public int getLine()
  {
	  return yyline + 1;
  }

  public String getText()
  {
	  return yytext();
  }
%}

lt              = \r|\n|\r\n
ic              = [^\r\n]
ws              = {lt} | [ \t\f]

/* comments */
comment         = {tc} | {eolcomment} | {doccomment}

tc              = "/*" [^*] ~"*/" | "/*" "*"+ "/"
// Comment can be the last line of the file, without line terminator.
eolcomment      = "//" {ic}* {lt}?
doccomment      = "/**" {commentcontent} "*"+ "/"
commentcontent  = ( [^*] | \*+ [^/*] )*

long            = [0-9]+
double          = [0-9]*\.?[0-9]+
alpha           = [A-Za-z_]+
alphanum        = {alpha}|{long}
binary          = 0b[01]+
hex             = 0x[0-9A-Fa-f]+
octal           = 0o[0-7]+
id              = {alpha}|{alpha}{alphanum}

%state STRING INJEXP

%%

<YYINITIAL> "true"              { return new Symbol(sym.TRUE);  }
<YYINITIAL> "false"             { return new Symbol(sym.FALSE); }
<YYINITIAL> "}"                 { return new Symbol(sym.RBRACE);}
<INJEXP>    "}"                 {
                                    string.delete(0, string.length());
                                    yybegin(STRING);
                                }
<YYINITIAL> {
  "{"                           { return new Symbol(sym.LBRACE);}
  ";"                           { return new Symbol(sym.SEMI);  }

  /* operators */
  "*="                          { return new Symbol(sym.ASSIGNTIMES); }
  "/="                          { return new Symbol(sym.ASSIGNDIVIDE);}
  "%="                          { return new Symbol(sym.ASSIGNMOD);   }
  "+="                          { return new Symbol(sym.ASSIGNADD);   }
  "-="                          { return new Symbol(sym.ASSIGNSUB);   }
  "&="                          { return new Symbol(sym.ASSIGNAMP);   }
  "|="                          { return new Symbol(sym.ASSIGNBAR);   }
  "^="                          { return new Symbol(sym.ASSIGNCARET); }
  "++"                          { return new Symbol(sym.INCREMENT);   }
  "--"                          { return new Symbol(sym.DECREMENT);   }
  "?:"                          { return new Symbol(sym.CASES);       }

  /* I/O */
  ":>"                          { return new Symbol(sym.PRINT);       }
  "<:"                          { return new Symbol(sym.READ);        }
}

<YYINITIAL,INJEXP> {
  /* identifiers */
  {id}                          { return new Symbol(sym.IDENTIFIER, yytext()); }

  /* literals */
  {long}                        { return new Symbol(sym.LONG, Long.valueOf(yytext())); }
  {binary}                      { return new Symbol(sym.BINARY, yytext().substring(2)); }
  {hex}                         { return new Symbol(sym.HEX, yytext().substring(2)); }
  {octal}                       { return new Symbol(sym.OCTAL, yytext().substring(2)); }
  {double}                      { return new Symbol(sym.DOUBLE, Double.valueOf(yytext())); }
  \"                            {
                                    string.setLength(0);
                                    yybegin(STRING);
                                }

  /* operators */
  "="                           { return new Symbol(sym.ASSIGN);      }
  "*"                           { return new Symbol(sym.TIMES);       }
  "×"                           { return new Symbol(sym.TIMES);       }  
  "**"                          { return new Symbol(sym.EXPONENT);    }
  "/"                           { return new Symbol(sym.DIVIDE);      }
  "÷"                           { return new Symbol(sym.DIVIDE);      }
  "√"                           { return new Symbol(sym.RADICAL);     }  
  "%"                           { return new Symbol(sym.MOD);         }
  "+"                           { return new Symbol(sym.PLUS);        }
  "-"                           { return new Symbol(sym.MINUS);       }
  "&"                           { return new Symbol(sym.AMP);         }  
  "|"                           { return new Symbol(sym.BAR);         }
  "^"                           { return new Symbol(sym.CARET);       }  
  "~"                           { return new Symbol(sym.TILDE);       }
  "->"                          { return new Symbol(sym.IMPLY);       }
  "⇒"                           { return new Symbol(sym.IMPLY);       }
  "!"                           { return new Symbol(sym.NOT);         }
  "&&"                          { return new Symbol(sym.AND);         }
  "||"                          { return new Symbol(sym.OR);          }
  "?"                           { return new Symbol(sym.QUERY);       }
  "=="                          { return new Symbol(sym.EQ);          }
  ">"                           { return new Symbol(sym.GT);          }
  ">="                          { return new Symbol(sym.GTEQ);        }
  "≥"                           { return new Symbol(sym.GTEQ);        }
  "<"                           { return new Symbol(sym.LT);          }
  "<="                          { return new Symbol(sym.LTEQ);        }
  "≤"                           { return new Symbol(sym.LTEQ);        }
  "!="                          { return new Symbol(sym.NOTEQ);       }
  "≠"                           { return new Symbol(sym.NOTEQ);       }
  "("                           { return new Symbol(sym.LPAREN);      }
  ")"                           { return new Symbol(sym.RPAREN);      }
  "=>"                          { return new Symbol(sym.MAP);         }
  "["                           { return new Symbol(sym.LBRAK);       }
  "]"                           { return new Symbol(sym.RBRAK);       }
  ","                           { return new Symbol(sym.COMMA);       }
  ":"                           { return new Symbol(sym.COLON);       }
  "π"                           { return new Symbol(sym.PI);          }
  "ℇ"                           { return new Symbol(sym.EULER);       }
  "∑"                           { return new Symbol(sym.SIGMA);       }

  /* comments */
  {comment}                     { /* ignore */ }

  /* whitespace */
  {ws}                          { /* ignore */ }
}

<STRING> {
  \"                            {
                                    yybegin(YYINITIAL);
                                    return new Symbol(sym.STRING, string.toString());
                                }
  [^\n\r\"\\${]+                { string.append( yytext() ); }
  \\t                           { string.append('\t'); }
  \\n                           { string.append('\n'); }

  \\r                           { string.append('\r'); }
  \\\"                          { string.append('\"'); }
  \\                            { string.append('\\'); }
  "${"                          { 
                                    yybegin(INJEXP);
                                    return new Symbol(sym.STRING, string.toString());
                                }
}

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                        yytext()+">"); }