%{
   enum yytokentype {
     NUMBER = 1,
     ADD = 4,
     SUB = 5,
     MUL = 6,
     DIV = 7,
     ABS = 8,
     RAD = 9,
     MOD = 10,
     AMP = 11,
     XOR = 12,
     TIL = 13,
     IMP = 14,
     NOT = 15,
     AND = 16,
     OR = 17,
     QRY = 18,
     GT = 19,
     GEQ = 20,
     LT = 21,
     LEQ = 22,
     NEQ = 23,
     EQ = 24,
     LPR = 25,
     RPR = 26,
     LBR = 27,
     RBR = 28,
     LBK = 29,
     RBK = 30,
     COM = 31,
     COL = 32,
     SEMI = 33,
     EOL = 264 /* end of line */
   };

   int yylval;

%}

%%
"+"	        { return ADD; }
"-"         { return SUB; }
"×"         { return MUL; }
"÷"         { return DIV; }
"|"         { return ABS; }
"√"         { return RAD; }
"%"         { return MOD; }
"&"         { return AMP; }
"⊻"         { return XOR; }
"~"         { return TIL; }
"⇒"         { return IMP; }
"¬"         { return NOT; }
"∧"         { return AND; }
"∨"         { return OR;  }
"?"         { return QRY; }
">"         { return GT;  }
"≥"         { return GEQ; }
"<"         { return LT;  }
"≠"         { return LEQ; }
"≠"         { return NEQ; }
"="         { return EQ;  }
"("         { return LPR; }
")"         { return RPR; }
"{"         { return LBR; }
"}"         { return RBR; }
"["         { return LBK; }
"]"         { return RBK; }
","         { return COM; }
":"         { return COL; }
";"         { return SEMI;}

[0-9]+      { yylval = atoi(yytext); return NUMBER; }
\n          { return EOL; }
[ \t]       { /* ignore white space */ }
.           { printf("Mystery character %c\n", *yytext); }
%%