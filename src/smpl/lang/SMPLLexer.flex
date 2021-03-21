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

num             = [0-9]+
alpha           = [A-Za-z_]+
alphanum        = {alpha}|{num}
id              = {alpha}|{alpha}{alphanum}|{num}{alphanum}

%state STRING

%%

<YYINITIAL> "true"              { return new Symbol(sym.TRUE);  }
<YYINITIAL> "false"             { return new Symbol(sym.FALSE); }
<YYINITIAL> "nil"               { return new Symbol(sym.NIL);   }
<YYINITIAL> "size"              { return new Symbol(sym.SIZE);  }

<YYINITIAL> {
  /* identifiers */
  {id}                          { return new Symbol(sym.IDENTIFIER, yytext()); }

  /* literals */
  {num}                         { return new Symbol(sym.NUMBER, Integer.valueOf(yytext())); }
  \"                            { string.setLength(0); yybegin(STRING); }

  /* operators */  
  "*"                           { return new Symbol(sym.TIMES); }
  "/"                           { return new Symbol(sym.DIVIDE);}
  "%"                           { return new Symbol(sym.MOD);   }
  "+"                           { return new Symbol(sym.PLUS);  }
  "-"                           { return new Symbol(sym.MINUS); }
  "&"                           { return new Symbol(sym.AMP);   }
  "|"                           { return new Symbol(sym.BAR);   }
  "~"                           { return new Symbol(sym.TILDE); }
  "->"                          { return new Symbol(sym.IMPLY); }
  "!"                           { return new Symbol(sym.NOT);   }
  "&&"                          { return new Symbol(sym.AND);   }
  "||"                          { return new Symbol(sym.OR);    }
  "?"                           { return new Symbol(sym.QUERY); }
  "?:"                          { return new Symbol(sym.CASES);  }
  "=="                          { return new Symbol(sym.EQ);    }
  ">"                           { return new Symbol(sym.GT);    }
  ">="                          { return new Symbol(sym.GTEQ);  }
  "<"                           { return new Symbol(sym.LT);    }
  "<="                          { return new Symbol(sym.LTEQ);  }
  "!="                          { return new Symbol(sym.NOTEQ); }
  "="                           { return new Symbol(sym.ASSIGN);}
  "("                           { return new Symbol(sym.LPAREN);}
  ")"                           { return new Symbol(sym.RPAREN);}
  "{"                           { return new Symbol(sym.LBRACE);}
  "}"                           { return new Symbol(sym.RBRACE);}
  "=>"                          { return new Symbol(sym.MAP);   }
  "["                           { return new Symbol(sym.LBRAK); }
  "]"                           { return new Symbol(sym.RBRAK); }
  ","                           { return new Symbol(sym.COMMA); }
  ":"                           { return new Symbol(sym.COLON); }
  ":>"                          { return new Symbol(sym.PRINT); }
  "<:"                          { return new Symbol(sym.READ);  }
  ";"                           { return new Symbol(sym.SEMI);  }

  /* comments */
  {comment}                     { /* ignore */ }

  /* whitespace */
  {ws}                          { /* ignore */ }
}

<STRING> {
  \"                             { yybegin(YYINITIAL);
                                       return new Symbol(sym.STRING,
                                       string.toString()); }
  [^\n\r\"\\]+                   { string.append( yytext() ); }
  \\t                            { string.append('\t'); }
  \\n                            { string.append('\n'); }

  \\r                            { string.append('\r'); }
  \\\"                           { string.append('\"'); }
  \\                             { string.append('\\'); }
}

/* error fallback */
[^]                              { throw new Error("Illegal character <"+
                                                        yytext()+">"); }