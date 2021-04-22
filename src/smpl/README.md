# Application Architecture

## Code Organization

SMPLParser.cup returns `ICommand` for statements and `IExpression` for expressions.

The `ICommand` interface demands and implementation of `execute` for every class that uses it. Each class that implements the `ICommand` interface should have behaviour specific to its intended nature. ...TODO Should each implementation transform the current state of the application, which includes the heap and the stack?


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