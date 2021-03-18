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

LineTerminator  = \r|\n|\r\n
InputCharacter  = [^\r\n]
ws              = {LineTerminator} | [ \t\f]

/* comments */
comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

num = [0-9]+
alpha = [A-Za-z_]+
alphanum = {alpha}|{num}
id = {alpha}|{alpha}{alphanum}|{num}{alphanum}

%%

<YYINITIAL> "true"              { return new Symbol(sym.TRUE); }
<YYINITIAL> "false"             { return new Symbol(sym.FALSE); }

<YYINITIAL> {
  /* identifiers */
  {id}                          { return new Symbol(sym.IDENTIFIER); }

  /* literals */
  {num}                         { return new Symbol(sym.NUMBER, Integer.valueOf(yytext())); }

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
  "?:"                          { return new Symbol(sym.CASE);  }
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
  ";"                           { return new Symbol(sym.SEMI);  }

  /* comments */
  {comment}                     { /* ignore */ }

  /* whitespace */
  {ws}                          { /* ignore */ }
}