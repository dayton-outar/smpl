# SMPL

SMPL is a small, but expressive toy programming language. Credits to Prof. Daniel Coore for the [specification](./SPECIFICATION.md).

## To-Do

- [ ] Complete updating and formatting documentation. Conform to Github standards
- [ ] Find entry point of Logo Lexer and Parser
- [ ] Build SMPL according to specs
- [ ] Catch up on some Java and Java tools: Ant, Maven, etc.

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

```bash
jflex SMPLLexer.flex
```

Find JFlex manual [here](https://jflex.de/manual.html).

Generate parser

```bash
java -jar ../lib/java-cup-11b.jar -interface -parser SMPLParser SMPLParser.cup
```

Find Java CUP LALR Parser Generator [here](http://www2.cs.tum.edu/projects/cup/index.php).

Compile all files

```bash
javac -cp ../lib/java-cup-11b-runtime.jar:. *.java
```

Run main and pass text containing expression to it

```bash
java -cp ../lib/java-cup-11b-runtime.jar:. Main < bomdas.txt
```