# SMPL

SMPL is a small, but expressive toy programming language. Credits to Prof. Daniel Coore for the [specification](./src/smpl/lang). This repo contains the prototype of the SMPL project that uses the Java platform and uses JFlex and CUP tools. Plans are in mind to build this project using C by making use of the Lex & Yacc tools (or, better yet, Flex & Bison<sup>[+](https://aquamentus.com/flex_bison.html)</sup>).

## To-Do

- [x] Update specification
- [x] Evolve grammar
- [ ] Build interpreter
    - Address all source TODOS and FIXME
    - Complete implementation for array and dictionary data structures
    - Complete implementation for complex constrol strucutres: cases, elses, loops
    - Complete implementation for spread parameters
    - Complete implementation for reading in data entry
- [x] Write build script in Ant
- [ ] Write unit tests and example scripts
- [ ] Document application architecture in smpl/
- [ ] Create javadoc Ant task for generating markdown for all source files
- [ ] Calibrate documentation according to Github standards
- [ ] Build CI pipeline with Github actions
- [ ] Build [MathJax](https://www.mathjax.org/) translator. SMPL --> MathJax

## Notes

 - [Java 8 API](https://docs.oracle.com/javase/8/docs/) <sup><a href="https://docs.oracle.com/javase/8/docs/api/overview-summary.html">&#8251;</a></sup>
 - [Java 9 API](https://docs.oracle.com/javase/9/)
 - [Java 10 API](https://docs.oracle.com/javase/10/)
 - [Java 11 API](https://docs.oracle.com/en/java/javase/11/)

### Creating a .jar file

<small>Adapted from João Silva from [StackOverflow](https://stackoverflow.com/questions/4597866/java-creating-jar-file)</small>

In order to create a _.jar_ file, you need to use `jar` instead of `java`:

```bash
jar cf myJar.jar myClass.class
```

Additionally, if you want to make it executable, you need to indicate an entry point (i.e., a class with `public static void main(String[] args))` for your application. This is usually accomplished by creating a [manifest](http://download.oracle.com/javase/tutorial/deployment/jar/manifestindex.html) file that contains the `Main-Class` header (e.g., `Main-Class: myClass`).

However, as Mark Peters pointed out, with JDK 6, you can use the `e` option to define the entry point:

```bash
jar cfe myJar.jar myClass myClass.class 
```

Finally, you can execute it:

```bash
java -jar myJar.jar
```

### Dissertation

[This](https://andreil26.github.io/me/uniprojects/2019/06/21/lexer_parser.html) dissertation can prove to be useful in the documentation. Can it be simplified any more?

### Miscellaneous

This will be a symbolic language almost like a language expressed by academic Mathematicians. So, [this resource](https://byjus.com/maths/math-symbols/) listing the symbols will prove to be useful. May need to also pull out my Discrete Mathematics text book.

Prof. Coore mentioned that his initial specification was inspired by [Scheme](https://home.adelphi.edu/sbloch/class/archive/270/scheme.shtml). Scheme is inspired by [Lisp](https://lisp-lang.org/).

Plan to maintain the language as loosely typed. So, using Java [this StackOverflow entry](https://stackoverflow.com/questions/28042626/check-if-object-is-instance-of-any-number-class) may prove useful.

#### See also

 - [Creating a JAR File](http://download.oracle.com/javase/tutorial/deployment/jar/build.html)
 - [Setting an Application's Entry Point with the JAR Tool](http://download.oracle.com/javase/tutorial/deployment/jar/appman.html)

## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

## Dependency Management

The `JAVA DEPENDENCIES` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-pack/blob/master/release-notes/v0.9.0.md#work-with-jar-files-directly).

```bash
sudo apt install jflex
```

Navigate to `src` folder.

```bash
jflex src/smpl/lang/SMPLLexer.flex -d src/smpl/lang
```

Find JFlex manual [here](https://jflex.de/manual.html).

For CLI manual, perform the following

```bash
jflex --help
```

Generate parser

```bash
java -jar lib/java-cup-11b.jar -interface -destdir src/smpl/lang -parser SMPLParser src/smpl/lang/SMPLParser.cup
```

Find Java CUP LALR Parser Generator [here](http://www2.cs.tum.edu/projects/cup/index.php).

For CLI manual, perform the following

```bash
java -jar lib/java-cup-11b.jar -help
```

Clean all old generated class files

```bash
find bin -type f -name "*.class" -delete
```

Compile all files

```bash
javac -cp lib/java-cup-11b-runtime.jar:. src/*.java
```

Running documentation generator

```bash
javadoc -cp lib/java-cup-11b-runtime.jar:. -d doc src/smpl/**/*.java
```

Installing Ant
```bash
sudo apt-get install ant
```

To perform all the above commands in proper sequence,
```bash
ant
```

Run main and pass text containing expression to it

```bash
java -cp lib/java-cup-11b-runtime.jar:bin App test/examples/identifiers.smpl test/examples/hypotenuse.smpl
```

## Further Reading

1. Compilers: Principles, Techniques and Tools by Alfred V. Aho, Ravi Sethi and Jeffrey D. Ullman
2. Compiler Design in C by Allen I. Hobub
3. flex &amp; bison by John Levine
4. Ant: The Definitive Guide by Steve Holzner