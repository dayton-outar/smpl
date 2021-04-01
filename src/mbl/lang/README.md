
```bash
bison -d mbl.y
```

```bash
flex mbl.l
```

```bash
cc -o $@ fb1-5.tab.c lex.yy.c -lfl
```