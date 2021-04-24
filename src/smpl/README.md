# Application Architecture

## Code Organization

SMPLParser.cup returns `ICommand` for statements and `IExpression` for expressions. The lexer and the parser are found within the _[lang](lang)_ folder. Both the lexer and the parser are created by generators. The generator that is used in this project to create the lexer is called [JFlex](https://jflex.de/manual.html). **JFlex** takes in a _flex_ file that contains specification that makes heavy use of regular expressions to identify tokens within a string.

> [JFlex], a lexical analyser generator takes as input a specification with a set of regular expressions and corresponding actions. It generates a program (a lexer) that reads input, matches the input against the regular expressions in the spec file, and runs the corresponding action if a regular expression matched. Lexers usually are the first front-end step in compilers, matching keywords, comments, operators, etc, and generating an input token stream for parsers. They can also be used for many other purposes.

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