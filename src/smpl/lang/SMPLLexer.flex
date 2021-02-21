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
%column

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

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
ws     = {LineTerminator} | [ \t\f]

/* comments */
comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
// Comment can be the last line of the file, without line terminator.
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*

id = [:jletter:] [:jletterdigit:]*

num = [0-9]+
alpha = [A-Za-z_]
alphanum = {alpha}|{num}

%state STRING

%%

<YYINITIAL> {
  /* identifiers */
  {id}                          { return new Symbol(sym.IDENTIFIER); }

  /* literals */
  {num}                         { return new Symbol(sym.INTEGER); }

  /* operators */
  "+"                           { return new Symbol(sym.PLUS); }
  "-"                           { return new Symbol(sym.MINUS); }
  "*"                           { return new Symbol(sym.TIMES); }
  "("                           { return new Symbol(sym.LPAREN); }
  ")"                           { return new Symbol(sym.RPAREN); }

  /* comments */
  {comment}                     { /* ignore */ }

  /* whitespace */
  {ws}                          { /* ignore */ }
}