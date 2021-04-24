# Application Architecture

## Code Organization

The files have been organized in folders and the code structured in Java packages that differentiate the behaviour of the source code within the application. The source code for this interpreter are organized into two main folders: _[lang](lang)_ - containing files that determine the syntax of the language - and _[sys](sys)_ - containing the semantics or the interpretation of the language.

### Language Files

The lexer and the parser are found within the _[lang](lang)_ folder. Both the lexer and the parser are created by generators. The generator that is used in this project to create the lexer is called [JFlex](https://jflex.de/manual.html). **JFlex** takes in a _flex_ file (_SMPLLexer.flex_) that contains specification that makes heavy use of regular expressions to identify tokens within a string.

> [JFlex], a lexical analyser generator takes as input a specification with a set of regular expressions and corresponding actions. It generates a program (a lexer) that reads input, matches the input against the regular expressions in the spec file, and runs the corresponding action if a regular expression matched. Lexers usually are the first front-end step in compilers, matching keywords, comments, operators, etc, and generating an input token stream for parsers. They can also be used for many other purposes.

The parser determines the grammar of the language and uses the token returned by the lexer. The generator that is used to create the parser is [CUP](http://www2.cs.tum.edu/projects/cup/index.php), which is an LALR Parser Generator for Java.

> CUP stands for Construction of Useful Parsers and is an LALR parser generator for Java. It was developed by C. Scott Ananian, Frank Flannery, Dan Wang, Andrew W. Appel and Michael Petter. It implements standard LALR(1) parser generation. As a parser author, you specify the symbols of Your grammar (terminal T1,T2; non terminal N1, N2;), as well as the productions (LHS :== RHS1 | RHS2 ;). If you provide each production alternative with action code ({: RESULT = myfunction(); :}), the parser will call this action code after performing a reduction with the particular production. You can use these callbacks to assemble an AST (Abstract Syntax Tree) or for arbitrary purposes. You should also have a look at the scanner generator JFlex, which is suited particularly well for collaboration with CUP.

The CUP file (_SMPLParser.cup_) returns `ICommand` for statements and `IExpression` for expressions. These statements and expressions are controlled by the system files of this application.

### System Files

The `ICommand` implementations are done within files that are within the `smpl.sys.commands` package and found within _[sys/commands](sys/commands)_ folder path in this folder. The implementations of `ICommand` would initialize that particular command and contain unique process flow within the `execute` function. Each `ICommand` class has behaviour specific to its intended nature. A main hashtable is passed from the beginning of the program stack onto all commands within that stack. That main hashtable maintains the _global scope_ for variables in the script that is being interpreted.


## Java Libraries Used

 - [Math](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html)
 - [ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
 - [Hashtable](https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html)
 - [Long](https://docs.oracle.com/javase/8/docs/api/java/lang/Long.html)
 - [Double](https://docs.oracle.com/javase/8/docs/api/java/lang/Double.html)
 - [Boolean](https://docs.oracle.com/javase/8/docs/api/java/lang/Boolean.html)

## Further Reading

1. Design Patterns: Elements of Reusable Object-Oriented Software by Erich Gamma, Richard Helm, Ralph Johnson and John Vlissides
2. [SourceMaking](https://sourcemaking.com/)
3. [Refactoring.Guru](https://refactoring.guru/)