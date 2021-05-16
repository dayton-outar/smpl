# Dependencies

The dependencies for generating the lexer, the parser, compiling the source code and performing unit tests can be found here.

Also deposited here, is the _smpl-coore-outar-x.x.x.jar_ file, which is a product of this project.

## Creating a .jar file

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

## See also

 - [Creating a JAR File](http://download.oracle.com/javase/tutorial/deployment/jar/build.html)
 - [Setting an Application's Entry Point with the JAR Tool](http://download.oracle.com/javase/tutorial/deployment/jar/appman.html)