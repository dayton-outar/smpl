# SMPL

SMPL is a small, but expressive math programming language.

Credits to Prof. Daniel Coore for the original specification. Herein this project is the manifestation of a custom version of that specification. The result of the modifications are found [here](./src/smpl/lang).

This repo contains the prototype of the SMPL project that uses the Java platform and uses JFlex and CUP tools. Plans are in mind to build this project using C by making use of the Lex & Yacc tools (or, better yet, Flex & Bison<sup>[+](https://aquamentus.com/flex_bison.html)</sup>).

## To-Do

- [x] Update specification
- [x] Evolve grammar
- [ ] Build interpreter
    - Address all source TODOS
    - Complete implementation for dictionary data structure
    - Complete interpolated string
    - Make cases able to evaluate and compare expression rather than string
    - Complete implementation for spread parameters
    - Fix recursion issue
- [x] Write build script in Ant
- [x] Write example scripts
- [ ] Write unit tests
- [x] Document application architecture in smpl/
- [ ] Update Coding Convention src/ README
- [ ] Update tests/examples/ README
- [ ] Update tests/ README
- [x] Create javadoc Ant task for generating markdown for all source files
- [ ] Update root README according to Github standards
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

## Interpolated String Concept

Adapted from [StackOverflow](https://stackoverflow.com/questions/57971191/implementing-string-interpolation-in-flex-bison)

You could reparse the string, if you really wanted you, by generating a [reentrant parser](https://www.gnu.org/software/bison/manual/bison.html#index-reentrant-parser). You would probably want a [reentrant scanner](http://westes.github.io/flex/manual/Reentrant.html), as well, although I suppose you could kludge something together with a default scanner, using flex's buffer stack. Indeed, it's worth learning how to build reentrant parsers and scanners on the general principle of avoiding unnecessary globals, whether or not you need them for this particular purpose.

But you don't really need to reparse anything; you can do the entire parse in one pass. You just need enough smarts in your scanner so that it knows about nested interpolations.

The basic idea is to let the scanner split the string literal with interpolations into a series of tokens, which can easily be assembled into an appropriate AST by the parser. Since the scanner may return more than one token out of a single string literal, we'll need to introduce a [start condition](http://westes.github.io/flex/manual/Start-Conditions.html) to keep track of whether the scan is currently inside a string literal or not. And since interpolations can, presumably, be nested we'll use flex's optional [start condition stack](http://westes.github.io/flex/manual/Start-Conditions.html#index-start-conditions_002c-use-of-a-stack), enabled with `%option stack`, to keep track of the nested contexts.

So here's a rough sketch.

As mentioned, the scanner has extra start conditions: `SC_PROGRAM`, the default, which is in effect while the scanner is scanning regular program text, and `SC_STRING`, in effect while the scanner is scanning a string. `SC_PROGRAM` is only needed because flex does not provide an official interface to check whether the start condition stack is empty; aside from nesting, it is identical to the `INITIAL` top-level start condition. The start condition stack is used to keep track of interpolation markers (`[` and `]` in this example), and it is needed because an interpolated expression might use brackets (as array subscripts, for example) or might even include a nested interpolated string. Since `SC_PROGRAM` is, with one exception, identical to `INITIAL`, we'll make it an inclusive rule.

```lex
%option stack
%s SC_PROGRAM
%x SC_STRING
%%
```

Since we're using a separate start condition to analyse string literals, we can also normalise escape sequences as we parse. Not all applications will want to do this, but it's pretty common. But since that's not really the point of this answer, I've left out most of the details. More interesting is the way that embedded interpolation expressions are handled, particularly deeply nested ones.

The end result will be to turn string literals into a series of tokens, possibly representing a nested structure. In order to avoid actually parsing in the scanner, we don't make any attempt to create AST nodes or otherwise rewrite the string literal; instead, we just pass the quote characters themselves through to the parser, delimiting the sequence of string literal pieces:

```lex
["]                 { yy_push_state(SC_STRING);    return '"'; }
<SC_STRING>["]      { yy_pop_state();              return '"'; }
A very similar set of rules is used for interpolation markers:

<*>"["              { yy_push_state(SC_PROGRAM);   return '['; }
<INITIAL>"]"        {                              return ']'; }
<*>"]"              { yy_pop_state();              return ']'; } 
```

The second rule above avoids popping the start condition stack if it is empty (as it will be in the `INITIAL` state). It's not necessary to issue an error message in the scanner; we can just pass the unmatched close bracket through to the parser, which will then do whatever error recovery seems necessary.

To finish off the `SC_STRING` state, we need to return tokens for pieces of the string, possibly including escape sequences:

```lex
<SC_STRING>{
  [^[\\"]+          { yylval.str = strdup(yytext); return T_STRING; }

  \\n               { yylval.chr = '\n';           return T_CHAR; }
  \\t               { yylval.chr = '\t';           return T_CHAR; }
          /* ... Etc. */
  \\x[[:xdigit]]{2} { yylval.chr = strtoul(yytext, NULL, 16);
                                               return T_CHAR; }
  \\.               { yylval.chr = yytext[1];      return T_CHAR; }
}
```

Returning escaped characters like that to the parser is probably not the best strategy; normally I would use an internal scanner buffer to accumulate the entire string. But it was simple for illustrative purposes. (Some error handling is omitted here; there are various corner cases, including newline handling and the annoying case where the last character in the program is a backslash inside an unterminated string literal.)

In the parser, we just need to insert a concatenation node for interpolated strings. The only complication is that we don't want to insert such a node for the common case of a string literal without any interpolations, so we use two syntax productions, one for a string with exactly one contained piece, and one for a string with two or more pieces:

```lex
string : '"' piece '"'                 { $$ = $2; }
       | '"' piece piece_list '"'      { $$ = make_concat_node(
                                                prepend_to_list($2, $3));
                                       }
piece  : T_STRING                      { $$ = make_literal_node($1); }  
       | '[' expr ']'                  { $$ = $2; }
piece_list
       : piece                         { $$ = new_list($1); }
       | piece_list piece              { $$ = append_to_list($1, $2); }
```

## Further Reading

1. Compilers: Principles, Techniques and Tools by Alfred V. Aho, Ravi Sethi and Jeffrey D. Ullman
2. Compiler Design in C by Allen I. Hobub
3. flex &amp; bison by John Levine
4. Ant: The Definitive Guide by Steve Holzner