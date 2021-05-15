# Unit Tests

## Requirements

- [Java 11 SDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [JUnit 5](https://junit.org/junit5/)
- ...

## Installation

To install JUnit

...

## Usage

`Run Test` in VS Code

...

## Test Cases

### Logical Expressions

| Case | Expected | Actual |
| :--- | :--- | :--- |

### Mathematical Expressions

| Case | Expected | Actual |
| :--- | :--- | :--- |
| <h5>Adding 9 to 22</h5><ol><li>Create `LongExpression` with value of constructor value of 9</li><li>Create `LongExpression` with value of constructor value of 21</li><li>Inject both `LongExpression` objects into `AdditionExpression`</li></ol> | 31 | 31 |
| <h5>Adding 8 to 9.5</h5><ol><li>Create `LongExpression` with value of constructor value of 8</li><li>Create `DoubleExpression` with value of constructor value of 9.5</li><li>Inject `LongExpression` object and `DoubleExpression` object into `AdditionExpression`</li></ol> | 17.5 | 17.5 |

### String Expressions

Any set of characters within two double quotes (`"` ... `"`) are identified as a string in SMPL. Strings in SMPL allows for the interpolation of logical and mathematical expressions by opening with the dollar sign and opening brace symbol (`${`) that is referred to as the _injex_ and closing with a brace (`}`).

String expressions in SMPL are mainly for the purpose of communicating information to an output stream such as a display unit.

| Case | Expected | Actual |
| :--- | :--- | :--- |

## References

1. [Java Testing - JUnit 5 Crash Course](https://www.youtube.com/watch?v=flpmSXVTqBI&list=WL&index=10)
2. [JUnit 5: Using Lists as an argument for parameterized tests](https://blog.felix-seifert.com/junit-5-parameterized-tests-using-lists-as-argument/)
3. [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)