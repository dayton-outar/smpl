To compile this interpreter perform the following,
```bash
make
```

You can find details in the _Makefile_

The article, [_Using Lex with Yacc_](https://silcnitc.github.io/ywl.html) was very useful

### Commands for compiling each component

```bash
bison -d mbl.y
```

```bash
flex mbl.l
```

```bash
cc -o $@ fb1-5.tab.c lex.yy.c -lfl
```