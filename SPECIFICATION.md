# SMPL Specification

<div align="right">
    <p>November 1, 2000</p>
</div>

## 1 Introduction

_SMPL_ is a small, but expressive toy programming language. As the name suggests, _SMPL_ is easy to learn but, as you will discover, it is quite powerful.

This document only partly specifies _SMPL_. Specifically, only the core subset of _SMPL_ is described. There are a number of extensions and modifications that can be made to _SMPL_ , which you will get to experiment with at some point.

_SMPL_ is dynamically typed<sup><a href="#footnote-1">1</a></sup> and tail-recursive<sup><a href="#footnote-2">2</a></sup>. Its procedures are first class objects<sup><a href="#footnote-3">3</a></sup>. All _SMPL_ sentences are in fact expressions in the sense that they implicitly return values. Some expressions are permitted to return an “unspecified value” to indicate that the value is not useful; these expressions are essentially statements.

_SMPL_ has integers, the two boolean literals, characters, strings, pairs and vectors as primitive data types. Storage that is dynamically allocated is automatically recovered by a garbage collector. There are no explicit pointers, all references to compound data are automatically treated as pointers to the data. All parameters are passed using the “call-by-value” convention. Variables are statically scoped and may denote a value of any data type.

## 2 Syntax

The syntax of _SMPL_ uses infix notation, and all binary operators must be separated from their operands by at least one whitespace character. The whitespace characters are the usual ones: space, carriage return and tab characters. (Feel free to include other control characters such as
form feed and line feed if you wish).

### 2.1 Literals and Values

_SMPL_ can denote the following types of literals:

- Signed integers that can fit into 32-bit two’s complement representation, strings and characters. Integers are assumed to be in decimal, unless prefixed with `#x` or `#b` in which case they are in hexadecimal or binary, respectively.

| Escape Sequence | Character Denoted |
| :--- | :--- |
| `\\` | backslash (`\`) |
| `\n` | newline |
| `\t` | tab |

Table 1: Escaped codes for control characters in strings

| Code | Character |
| :--- | :--- |
| `sp` | space |
| `tb` | tab |
| `nl` | newline |
| `cr` | carriage return |
| `ff` | form feed (or newpage) |

Table 2: Table of special character codes

- String constants are denoted between double quotes `"`. Within a string, certain control characters can be denoted by an escape sequence. Table 1 lists the set of escape sequences that should be recognised within _SMPL_ strings.
- Character literals are denoted as `#\` followed immediately by the character representation. For example, the character `a` is represented as `#\a`. Common special characters have two letter codes. Table 2 lists the codes for recognized special characters. To accomodate the remaining characters, character literals may also be specified by their unicode representation given as four hexadecimal digits immediately following the `#\`. So the character `a` may also be denoted as `#\0061`.
- The boolean constants _`true`_ and _`false`_ are denoted `#t` and `#f` respectively.
- The empty list, called _`nil`_, is denoted by `#e`. An _SMPL_ list is actually a sequence of pairs that terminate with the empty list.

_SMPL_ has two types of compound data: the vector and the pair. A vector is somewhat like an array, except that it is not constrained to hold only one typeof data. A pair contains two arbitrary objects. Table 3 describes the builtin functions availablefor manipulating compound data in _SMPL_.

Vector initialisation is quite flexible. A vector may be initialised by specifying a collection of disjoint subvectors, or the individual elements, or a combination of the two. A subvector is specified by two expressions: the first (after it has been evaluated) gives the size of the subvector, the second (after it has been evaluated) must be a procedure that when given an index less than the size, returns the value to be stored at that position _in the subvector_. The following examples should help to clarify the description. In them, assume that the value of `x` has previously been set to 5.

```python
[: 1,2,3 :]                                 ⇒ [1 2 3]
[: 1,2,x :]                                 ⇒ [1 2 5]
[: 5: proc(i) i :]                          ⇒ [0 1 2 3 4]
[: 1, 3: proc(n) 2 * n, 3 :]                ⇒ [1 0 2 4 3]
[: 3: proc(n) 2 * n, 4: proc(n) 3 * n :]    ⇒ [0 2 4 0 3 6 9]
```

| Builtin | Explanation |
| :--- | :--- |
| `pair(`&#12296;e<sub>1</sub> ,e<sub>2</sub>&#12297;`)` | Create a pair containing the objects denoted by e<sub>1</sub> and e<sub>2</sub>. |
| `1st(`&#12296;p&#12297;`)` | Return the first object in the pair _p_. |
| `2nd(`&#12296;p&#12297;`)` | Return the second object in the pair _p_. |
| `[:[`&#12296;e<sub>1</sub>&#12297;, &hellip;,&#12296;e<sub>n</sub>&#12297;`]:]` | Return a newly allocated vector initialised with the given specifications<br/>Each specification is either an expression or of the form<br/>&#12296;expr<sub>size</sub>&#12297; : &#12296;expr<sub>init</sub>&#12297; |
| &#12296;expr<sub>vec</sub>&#12297;`[`&#12296;n&#12297;`]` | Return the <i>n<sup>th</sup></i> element of vector _vec_(indexed from 0).<br/>When on the LHS of an assignment, sets the <i>n<sup>th</sup></i> element to the RHS. |
| `size(`&#12296;vec&#12297;`)` | Return the length of the vector _vec_. |

Table 3: Builtin expressions

### 2.2 Statements and Expressions

Table 4 lists the keywords of _SMPL_ and their purposes.

***Identifiers*** in _SMPL_ must:
 - Contain at least one non-digit character
 - Not begin with the character `#`
 - Not contain any special characters (Only alpha-numeric characters allowed)
 
 The following are ***legal identifiers***: `foo`, `bar1`, `1bar`, `ba1r`.<sup><a href="#footnote-4">4</a></sup>
 
 The following are _illegal identifiers_: `#bar`, `12`, `(foo)`, `{bar}`, `[baz]`, `foo`, `bar`, `foo:bar`.

***Function calls*** are denoted by the function name followed immediately by a sequence of comma-separated argument expressions enclosed in parentheses. The following expressions are all ***legal function calls***: `f(a, b)`, `g()`, `foo(a, b, c, d)`.

_SMPL_ understands the following common binary operators:
- Arithmetic operators: `+`, `-`, `*`, `/`, `%`
- Bitwise operators: `&`, `|`, `~`
- Relational operators: `==`<sup><a href="#footnote-5">5</a></sup>, `>`, `<`, `<=`, `>=`, `!=`
- Logical operators: `and`, `or`, `not`

Operator precedence, from highest to lowest is as follows: 

`∼`	**⇒** `∗`, `/`, `%` **⇒** `+`, `−` **⇒** `&`, `|` **⇒** `=`, `>`, `<`, `≤`, `≥`, `≠`	**⇒** `not`	**⇒** `and`	**⇒** `or`

In order to apply a unary minus to an expression, the combined expression must be surrounded by parentheses. So the negative of the variable `x` is expressed as `(- x)`, not  `- x`.

<div align="right">
    <b><a href="#smpl-specification"">↥ To Top</a></b>
</div>

## 3 Examples

Here are some example procedures in _SMPL_.

| Keyword | Purpose |
| :--- | :--- |
| `proc(`_p_<sub>1</sub>, _p_<sub>2</sub>, &hellip;, _p_<sub>n</sub>`)` &#12296;_body_&#12297; | return a procedure of _n_ arguments with formal parameters _p_<sub><i>i</i></sub>. |
| `let(`_b_<sub>1</sub> , _b_<sub>2</sub>, &hellip;, _b_<sub>n</sub>`)` &#12296;_body_&#12297; | evaluate _body_ in an environment extended by bindings _b_<sub><i>i</i></sub>.<br />The syntax of a binding is &#12296;_id_&#12297; be &#12296;_expr_&#12297;. |
| `def 〈id〉 〈expr〉` | define _id_ and set it to the value of _expr_ in the current environment. |
| `〈id〉 := 〈expr〉` | assign the value of _expr_ to variable _id_. |
| `if 〈expr〉 then 〈expr〉`<br />**[**`else 〈expr〉`**]** | test predicate, evaluate then clause if non-false<br />otherwise evaluate else clause, if given. |
| `case {`<br />**[**_p_<sub><i>1</i></sub>:_c_<sub><i>1</i></sub> &hellip; _p_<sub><i>n</i></sub>:_c_<sub><i>n</i></sub>**]**`}`<br />`〈expr〉 : 〈expr〉`  | Evaluate the consequent of the first clause whose<br />predicate is true.<br />A clause of a case expression. If predicate is the keyword `else`, it is regarded as true. |
| `{...}` | compound expression |
| `print(〈expr〉)` | Print the value of the given expression. |
| `read()` | Read and return a string from the keyboard. |
| `readint()` | Read and return an integer from the keyboard. |
| `//`<br />`/*... */` | comment to rest of line<br />block comment (nestable) |


Table 4: Table of _SMPL_ commands

```python
fact := proc(n)
    // return factorial n
    if n <= 1
        then 1
        else n * fact(n - 1)

def fib proc(n)
    /* return the nth fibonacci number */
    if n <= 1
        then 1
        else fib(n - 1) + fib(n - 2)

def map proc(f, list)
    /* return a new list, obtained by applying f to each element of list */
    if list = #e
        then #e
        else pair(f(1st(list)),
            map(f, 2nd(list)))

def vecMap proc(f, v)
    /* return a newly allocated vector obtained by applying f to each element of v. */
    [: size(v): proc(i) f(v[i]) :]


def vecAppend proc(v1, v2)
    /* return a newly allocated vector containing elements of v1 followed by elements of v2 */
    [: size(v1): proc(i) v1[i], size(v2): proc(i) v2[i] :]
```

<div align="right">
    <b><a href="#smpl-specification"">↥ To Top</a></b>
</div>

## 4 Extensions

Here are a few ideas for extensions to _SMPL_ :

- arbitrary precision integer arithmetic. It would be good if _SMPL_ were not restricted to integers that could fit within the 32-bit two’s complement representation. These “big” integers could be represented by using multiple words of contiguous storage to store the bits of the number. Each of the primitive arithmetic operators would have to be redefined to accommodate these
    large numbers. However, the only difference the user should observe is that she is no longer restricted to small integers. (A good test case for this is tosee whether your extended language
    can compute the factorial of 1000.)
- Floating point numbers. This might not be very difficult if the target language (or machine, in the case of an interpreter) already supports floating point numbers. In that case, the biggest
    issue is probably how best to implement the type conversion rules for arithmetic computations that mix integers and floating point numbers.
- Variable numbers of arguments to procedures. Procedure declarations would allow a special parameter syntax to indicate that the procedure could be called with a variable number of
    arguments.
- Static types. Type declarations could be permitted in _SMPL_. In which case, compile-time type checking could then be performed to improve the run timeperformance of programs.
- Additional control structures. Typical looping constructs such as `for`, `repeat` and `while` in Pascal could be included in _SMPL_.
- Macros. A limited form of language extension can be accomplished through the use of macros. It should not be too difficult to extend _SMPL_ to include macros that are declared and used in
    a similar way to procedures.
- Call by: reference, lazy and name parameter passing conventions. At the moment _SMPL_ supports only call by value (CBV). It could be extended to allow procedure declarations that
    would support parameter passing by other conventions.

<div align="right">
    <b><a href="#smpl-specification"">↥ To Top</a></b>
</div>

<hr />

<a id="footnote-1"><sup>1</sup></a> Variable types are not explicitly specified by the programmer

<a id="footnote-2"><sup>2</sup></a> Procedure calls that are the final expressions in the calling procedure’s body return their values to the calling procedure’s caller

<a id="footnote-3"><sup>3</sup></a> First class objects may be named, stored in data structures, passed as arguments and returned as values from procedures

<a id="footnote-4"><sup>4</sup></a> The original specification included special characters such as `!`, `?`, `#`. These are removed in this specification. So, these: `foo!`, `bar?`, `fo#o`, `foo.bar` are also allowed.

<a id="footnote-5"><sup>5</sup></a> The original concepts was to use `=` for the conditional expression indicating equality. The developer opted for `==`, which was more ubiquitous across many current languages. This would make `=` available for the assignment operator.

&copy; Prof. Daniel Coore