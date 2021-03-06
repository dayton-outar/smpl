# Unit Tests

A few unit tests were done to demonstrate the use of the expression classes (`IExpression`) within the `smpl.sys` namespace and in one case the command classes function (`ICommand`). The functions can be accessed by importing the _smpl-coore-outar-x.x.x.jar_ file generated by the build of this project and deposited in the [lib](/lib) folder.

## Requirements

- [Java 11 SDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [JUnit 5](https://junit.org/junit5/)

## Installation

To install [JUnit 5](https://junit.org/junit5/) in this application, the latest JUnit Platform Console Standalone jar file can be downloaded [here](https://mvnrepository.com/artifact/org.junit.platform/junit-platform-console-standalone) and placed in the [lib](/lib) folder. This repo already contains the jar file needed to perform JUnit tests.

The source paths has been set in the [settings.json](/.vscode/settings.json) to discover tests files in VS Code Testing Explorer.

## Usage

In VS Code, there will be a `Run Test` tip hovering over each test class and test method. When this tip is clicked, it will perform the tests that can be viewed in the Test Explorer.

Apart from this, the Ant _[build.xml](/build.xml)_ file in the root of this project contains configuration to perform all tests within the _[/tests/expressions](/tests/expressions)_ folder. So, to perform that build automation, open a terminal within the root directory of this project and perform the following command,

```bash
ant test
```

To take it a step further to see the results of the examples in the _[examples](examples)_ folder, the following command can be performed,

```bash
ant
```

## Test Cases

### Logical Expressions

| Case | Expected | Actual |
| :--- | :--- | :--- |
| <h5>Variable containing 5 equal 5?</h5><ol><li>Create a `VariableExpression` object with constructor value of "x" (Assuming that the `AssignmentExpressionCommand` object has been used to assign the `LongExpression` value of 5 to "x")</li><li>Create a `LongExpression` object with constructor value of 5</li><li>Inject the `VariableExpression` object and the `LongExpression` object created above into a `EqualsExpression` object</li><li>Evaluate the expression object in last step above</li></ol> | true | true |

### Mathematical Expressions

| Case | Expected | Actual |
| :--- | :--- | :--- |
| <h5>Adding 9 to 22</h5><ol><li>Create a `LongExpression` object with constructor value of 9</li><li>Create `LongExpression` with constructor value of 21</li><li>Inject both `LongExpression` objects into `AdditionExpression`</li><li>Evaluate the expression object in last step above</li></ol> | 31 | 31 |
| <h5>Adding 8 to 9.5</h5><ol><li>Create `LongExpression` with constructor value of 8</li><li>Create `DoubleExpression` with value of constructor value of 9.5</li><li>Inject `LongExpression` object and `DoubleExpression` object into constructor of `AdditionExpression`</li><li>Evaluate the expression object in last step above</li></ol> | 17.5 | 17.5 |
| <h5>Repeatedly adding decimal numbers</h5><ol><li>Create a `DoubleExpression` object with constructor value of 8.5</li><li>Create `DoubleExpression` with constructor value of 9.5</li><li>Inject both `DoubleExpression` objects into `AdditionExpression`</li><li>Evaluate the expression object in last step above</li></ol> | 18 | 18 |
| <h5>Subtract 7 from a number</h5><blockquote>`number`:<br />40<br />13<br />28</blockquote><ol><li>Create a `LongExpression` object with constructor value of `number`</li><li>Create `LongExpression` with constructor value of 7</li><li>Inject both `LongExpression` objects into `SubtractionExpression`</li><li>Evaluate the expression object in last step above</li></ol> | 33<br />6<br />21 | 33<br />6<br />21 |
| <h5>Multiply a number times 5</h5><blockquote>`number`:<br />3.1<br />11.2<br />13.5</blockquote><ol><li>Create a `DoubleExpression` object with constructor value of `number`</li><li>Create `DoubleExpression` with constructor value of 5</li><li>Inject both `DoubleExpression` objects into `MutiplicationExpression`</li><li>Evaluate the expression object in last step above</li></ol> | 15.5<br />56<br />67.5 | 15.5<br />56<br />67.5 |
| <h5>Adding number to boolean is not implemented</h5><ol><li>Create a `LongExpression` object with constructor value of 10</li><li>Create `BooleanExpression` with constructor value of **true**</li><li>Inject the `LongExpression` and the `BooleanExpression` objects into `AdditionExpression`</li><li>Evaluate the expression object in last step above</li></ol> | Exception -> "... not yet implemented" | Exception -> "... not yet implemented" |

### String Expressions

Any set of characters within two double quotes (`"` ... `"`) are identified as a string in SMPL. Strings in SMPL allows for the interpolation of logical and mathematical expressions by opening with the dollar sign and opening brace symbol (`${`) that is referred to as the _injex_ and closing with a brace (`}`).

String expressions in SMPL are mainly for the purpose of communicating information to an output stream such as a display unit.

| Case | Expected | Actual |
| :--- | :--- | :--- |
| <h5>Welcome to SMPL!</h5><ol><li>Create an empty vector (or collection) of expressions, `IExpression`</li><li>Create a `StringExpression` with constructor value of "Welcome to SMPL!"</li><li>Add the `StringExpression` object created above in the collection of expressions</li><li>Inject the collection of expressions into the constructor of a `CombinedStringExpression` object</li><li>Evaluate the expression object in last step above</li></ol> | Welcome to SMPL! | Welcome to SMPL! |
| <h5>Injecting πr²</h5><ol><li>Create an empty vector (or collection) of expressions, `IExpression`</li><li>Create a `StringExpression` with constructor value of "Area of circle with radius 3 is "</li><li>Create a `DoubleExpression` object with constructor value of 3.14159 (π)</li><li>Create an `ExponentExpression` object with,<ol><li>Create `LongExpression` object with constructor value of 3</li><li>Create `LongExpression` object with contructor value of 2</li><li>Inject these two expressions created in the sub-steps above into the `ExponentExpression`</li></ol></li><li>Create a `MultiplicationExpression` object with the constructor values of the `DoubleExpression` for π and the `ExponentExpression`</li><li>Create another `StringExpression` object with constructor value of "."</li><li>Add expression objects create in steps 2, 5 and 6 to the expression collection</li><li>Inject the expression collection into the `CombinedStringExpression` object</li><li>Evaluate the expression object in last step above</li></ol> | Area of circle with radius 3 is 28.27431. | Area of circle with radius 3 is 28.27431. |

## References

1. [Java Testing - JUnit 5 Crash Course](https://www.youtube.com/watch?v=flpmSXVTqBI&list=WL&index=10)
2. [JUnit 5: Using Lists as an argument for parameterized tests](https://blog.felix-seifert.com/junit-5-parameterized-tests-using-lists-as-argument/)
3. [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)
4. [How To Write Automation Tests With Java](https://betterprogramming.pub/how-to-write-automation-tests-with-java-ed468e0af305)