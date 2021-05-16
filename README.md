<div align="center">
  <img src=".attachments/snipe-eel-smpl.png" />
  <br/>
  <b>a simple math programming language</b>
  <br/>
  <br/>
</div>

[This README is currently a messy sketch of notes]

# SMPL

SMPL is a small, but expressive math programming language.

Credits to Prof. Daniel Coore for the original specification. Herein this project is the manifestation of a custom version of that specification. The result of the modifications are found [here](./src/smpl/lang).

This repo contains the prototype of the SMPL project that uses the Java platform and uses JFlex and CUP tools. Plans are in mind to build this project using C by making use of the Lex & Yacc tools (or, better yet, Flex & Bison<sup>[+](https://aquamentus.com/flex_bison.html)</sup>).

JFlex and CUP, which is the Java version modeled off flex and bison (formerly lex and yacc), in my opinion, is far more superior than [ANTLR](https://www.antlr.org/) <sup><a href="https://theantlrguy.atlassian.net/wiki/spaces/ANTLR3/pages/2687102/Five+minute+introduction+to+ANTLR+3">[+]</a></sup>. The only benefit to be had from using ANTLR is its attempt to involve as many target programming language as is it possible. For the experienced programmer, this isn't enough to influence a decision to use it.

Find tutorials [here](tests/examples).

## Requirements

![Java](.attachments/java-eps-vector-logo.png)
![CUP](.attachments/cup_logo.gif)

 - [Java 11 SDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
 - [JFlex](https://jflex.de/)
 - [CUP](http://www2.cs.tum.edu/projects/cup/index.php)
 - [JUnit 5](https://junit.org/junit5/)
 - [Ant](https://ant.apache.org/) 1.10.7

![Apache Ant](.attachments/Apache-Ant-logo.png)
## Installation

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

Compile files in src

```bash
javac -cp lib/java-cup-11b-runtime.jar:. src/*.java
```
Compile files in tests

```bash
javac -cp lib/java-cup-11b-runtime.jar:lib/smpl-coore-outar-1.0.0.jar:lib/junit-platform-console-standalone-1.8.0.jar:. tests/**/*.java -d bin
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

Run JUnit tests :sweat: :test_tube:

```bash
java -jar lib/junit-platform-console-standalone-1.8.0.jar -cp bin --include-engine=junit-jupiter --scan-classpath
```

## Usage

...

How can this be used in another java file?

Reference example README. Demo ability of SMPL.

## Contributing

### Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

...

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

### Miscellaneous

This will be a symbolic language almost like a language expressed by academic Mathematicians. So, [this resource](https://byjus.com/maths/math-symbols/) listing the symbols will prove to be useful. May need to also pull out my Discrete Mathematics text book.

Prof. Coore mentioned that his initial specification was inspired by [Scheme](https://home.adelphi.edu/sbloch/class/archive/270/scheme.shtml). Scheme is inspired by [Lisp](https://lisp-lang.org/).

Plan to maintain the language as loosely typed. So, using Java [this StackOverflow entry](https://stackoverflow.com/questions/28042626/check-if-object-is-instance-of-any-number-class) may prove useful.

#### See also

 - [Creating a JAR File](http://download.oracle.com/javase/tutorial/deployment/jar/build.html)
 - [Setting an Application's Entry Point with the JAR Tool](http://download.oracle.com/javase/tutorial/deployment/jar/appman.html)

## Further Reading

1. Compilers: Principles, Techniques and Tools by Alfred V. Aho, Ravi Sethi and Jeffrey D. Ullman
2. Compiler Design in C by Allen I. Hobub
3. flex &amp; bison by John Levine
4. [Implementing String Interpolation in Flex & Bison](https://stackoverflow.com/questions/57971191/implementing-string-interpolation-in-flex-bison) - StackOverflow
5. Ant: The Definitive Guide by Steve Holzner
6. [Building and testing Java with Ant](https://docs.github.com/en/actions/guides/building-and-testing-java-with-ant)