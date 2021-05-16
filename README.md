<div align="center">
  <img src=".attachments/snipe-eel-smpl.png" />
  <br/>
  <b>a simple math programming language</b>
  <br/>
  <br/>
</div>

# SMPL

SMPL is a small, but expressive math programming language.

I was introduced to _Compiler Design_ by Prof. Daniel Coore in my final year while doing Undergraduate studies for Computer Science and Electronics degree at the University of the West Indies, Mona. It's the most memorable project that I have had while studying at the university. Herein is an updated version of building that project. I have made a few modification to the original specification provided by Prof. Coore and the result of the modifications are found [here](./src/smpl/lang).

Prof. Coore mentioned that his initial specification was inspired by [Scheme](https://home.adelphi.edu/sbloch/class/archive/270/scheme.shtml). Scheme is inspired by [Lisp](https://lisp-lang.org/). Some of the modifications are inspired by [JavaScript](https://developer.mozilla.org/en-US/docs/Web/JavaScript). The plan is to maintain the language as loosely typed language.

This compiler project is built on the Java platform and uses JFlex and CUP tools. While conducting researching and developing the project, I was fascinated by other compiler design tools such as the Lex & Yacc tools (or, better yet, Flex & Bison<sup>[+](https://aquamentus.com/flex_bison.html)</sup>). Apparently JFlex and CUP was modeled off flex and bison (formerly lex and yacc) that is, in my opinion, far more superior than any other tool in this genre simply because of the language used: C. With C, you can build more native machine applications rather than depending on a virtual machine or language runtime environment.

[ANTLR](https://www.antlr.org/) <sup><a href="https://theantlrguy.atlassian.net/wiki/spaces/ANTLR3/pages/2687102/Five+minute+introduction+to+ANTLR+3">[+]</a></sup> also caught my attention. It's main selling point seems to be that it can be used in many of the popular programming languages. Nonetheless, for the experienced programmer, this isn't enough to influence a decision to use it.

## Requirements

[![Java](.attachments/java.png)]((https://www.oracle.com/java/technologies/javase-jdk11-downloads.html))
[![CUP](.attachments/cup.gif)]((http://www2.cs.tum.edu/projects/cup/index.php))

 - [Java 11 SDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
 - [JFlex](https://jflex.de/)
 - [CUP](http://www2.cs.tum.edu/projects/cup/index.php)
 - [JUnit 5](https://junit.org/junit5/)
 - [Ant](https://ant.apache.org/) 1.10.7

[![Apache Ant](.attachments/apache-ant.png)]((https://ant.apache.org/))

## Installation

Download your preferred version of _smpl-coore-outar-x-x-x.jar_ file in the [releases](https://github.com/dayton-outar/smpl/releases) section. Transfer that file into your _lib_ folder from which your Java compiler will read and understand.

For Java Projects created in VS Code such as this, you can transfer the file into the _lib_ folder found at the root of the project.

When compiling in the terminal, reference must be made to this jar file and the _java-cup-11b.jar_ file in the _javac_ command. For example,

```bash
javac -cp lib/smpl-coore-outar-1.0.0.jar:lib/java-cup-11b.jar src/App.java
```

You will also need to make reference to these dependecies To run the generated class file as follows,

```bash
java -cp lib/smpl-coore-outar-1.0.0.jar:lib/java-cup-11b.jar src/App
```

## Usage

SMPL can be used through an interactive shell or by passing a folder path or a set of file paths to the _App_ class. All the class and function definitions can be accessed from the SMPL (_smpl-coore-outar-x-x-x.jar_) library.

### Getting Started

Once you have completed installation of SMPL (_smpl-coore-outar-x-x-x.jar_) library, you can try the snippet of Java code shown below,

```java
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.ByteArrayInputStream;
import java.util.Hashtable;

import java_cup.runtime.Symbol;
import smpl.lang.SMPLLexer;
import smpl.lang.SMPLParser;
import smpl.sys.Program;
import smpl.sys.values.IValue;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World! Trying out SMPL");

        Hashtable<String, IValue> heap = new Hashtable<String, IValue>();
        
        String myExpression = "v = 8; :> v * 4;"; // Output: 32

        InputStream in = new ByteArrayInputStream(myExpression.getBytes(StandardCharsets.UTF_8));
        SMPLLexer lexer = new SMPLLexer( new InputStreamReader(in) );
        SMPLParser p = new SMPLParser(lexer);
        
        Symbol parseResult = p.parse();
        
        Program program = (Program)parseResult.value;
        program.execute( heap );
    }
}
```

Now, once this works well for you, you can begin tinkering with SMPL by trying out the [examples](tests/examples) listed and documented [here](tests/examples).

To use the SMPL interactive shell, you must perform the following command (assuming that the dependencies are in a _lib_ folder within the folder that you are running the command),

```bash
java -cp lib/java-cup-11b.jar:lib/smpl-coore-outar-1.0.0.jar App
```

You can exit the interactive shell by entering `exit`or `quit` and then press ENTER.

To read a folder containing text files with extension _.smpl_, perform the following command (assuming _examples_ is the path of folder within the folder that you are running the command),

```bash
java -cp lib/java-cup-11b.jar:lib/smpl-coore-outar-1.0.0.jar App examples
```

To read a file containing SMPL syntax (no strict filtering done for file path arguments), perform the following command,

```bash
java -cp lib/java-cup-11b.jar:lib/smpl-coore-outar-1.0.0.jar App myplayground.smpl
```

For multiple files,

```bash
java -cp lib/java-cup-11b.jar:bin App identifiers.smpl hypotenuse.smpl
```

## Contributing

Contributions are welcomed to this project. It is expected that you make a fork of this repo, make the changes that you request and then create a pull request, where your changes can be reviewed for merging into the main branch.

It is expected that prospective contributors acquaint themselves with an understanding of the code convention, the application's architecture and the way how this software works before contributing via pull request. There should be enough documentation in this repo through README files that can inform the prospective contributor.

### Folder Structure

The workspace contains several folders, where:

- `src`: maintain source code for core function
- `test`: contains SMPL syntax samples and JUnit tests
- `lib`: maintains dependencies
- `bin`: contains generated class files from compilation
- `docs`: contains generated HTML and XML files from _javadoc_ and _junitreport_
- `.attachments`: contains media for README documentation
- `.vscode`: VS Code configuration
- `.github`: GitHub Actions CI workflow

The `JAVA DEPENDENCIES` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-pack/blob/master/release-notes/v0.9.0.md#work-with-jar-files-directly).


### The Lexer

JFlex is found in the Aptitude package repository and can be downloaded for use on Ubuntu/Debian machines by performing the following command,

```bash
sudo apt install jflex
```

If making changes to the lexer to add or modify a new token, the Java file can be generated by navigating to the `src` folder and performing the following command,

```bash
jflex src/smpl/lang/SMPLLexer.flex -d src/smpl/lang
```

Details of using JFlex can be found [here](https://jflex.de/manual.html).

Details for using the CLI are accessible by performing the following,

```bash
jflex --help
```
### The Parser

If changes are required to the grammar, the contributor can look at the _.cup_ file, acquaint themself with the LALR CUP language found [here](http://www2.cs.tum.edu/projects/cup/index.php) and perform the following command to generate the new Parser,

```bash
java -jar lib/java-cup-11b.jar -interface -destdir src/smpl/lang -parser SMPLParser src/smpl/lang/SMPLParser.cup
```

Details for using the CLI are accessible by performing the following,

```bash
java -jar lib/java-cup-11b.jar -help
```

### Compiling the Project

The Ant build tool is used to automate a number of possibilities. The _build.xml_ is configured to:
 - Generate the lexer
 - Generate the parser
 - Compile the core source code
 - Generate a new _smpl-coore-outar-x-x-x.jar_ file
 - Generate updated HTML documentation
 - Perform unit tests
 - Generate unit tests reports
 - Perform SMPL examples

Before we can use ant, ensure that it is installed by performing the following,

```bash
ant --version
```

If it is not installed, you can install ant on Ubuntu/Debian machine by performing the following,

```bash
sudo apt-get install ant
```

In order to perform all the possibilities, perform the following in the root folder that contains _build.xml_,

```bash
ant
```

For just compiling the project, perform the following,

```bash
ant compile
```

To generate the class library, _smpl-coore-outar-x-x-x.jar_, perform the following,

```bash
ant build-lib
```

For performing the unit tests, perform the following,

```bash
ant test
```

To remove the generated _bin_ and _docs_ folder, perform the following,

```bash
ant clean
```

## Miscelaneous Notes

Run JUnit tests :sweat: :test_tube:

```bash
java -jar lib/junit-platform-console-standalone-1.8.0.jar -cp bin --include-engine=junit-jupiter --scan-classpath
```

## Further Reading

1. Compilers: Principles, Techniques and Tools by Alfred V. Aho, Ravi Sethi and Jeffrey D. Ullman
2. Compiler Design in C by Allen I. Hobub
3. flex &amp; bison by John Levine
4. [Implementing String Interpolation in Flex & Bison](https://stackoverflow.com/questions/57971191/implementing-string-interpolation-in-flex-bison) - StackOverflow
5. Ant: The Definitive Guide by Steve Holzner
6. [Building and testing Java with Ant](https://docs.github.com/en/actions/guides/building-and-testing-java-with-ant)