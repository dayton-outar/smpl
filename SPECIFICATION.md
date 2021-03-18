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

- Numbers that can fit into double-precision 64-bit two’s complement representation, strings and characters. Numbers can represent fractions that can store values up to 16 decimal places. Signed integers has a minimum value of -2<sup>63</sup> and a maximum value of 2<sup>63</sup> &#8211; 1. Numbers are assumed to be in decimal, unless prefixed with `0x`, `0o` or `0b` in which case they are in hexadecimal, octal or binary, respectively.<sup><a href="#footnote-e">e</a></sup>

| Escape Sequence | Character Denoted |
| :--- | :--- |
| `\\` | backslash (`\`) |
| `\n` | newline |
| `\t` | tab |

Table 1: Escaped codes for control characters in strings

- String constants are denoted between double quotes `"`. Within a string, certain control characters can be denoted by an escape sequence. Table 1 lists the set of escape sequences that should be recognised within _SMPL_ strings.
- Character literals are denoted as `#\` followed immediately by the character representation. For example, the character `a` is represented as `#\a`. Character literals may also be specified by their unicode representation given as four hexadecimal digits immediately following the `#\`. So the character `a` may also be denoted as `#\0061`.<sup><a href="#footnote-f">f</a></sup>
- The boolean constants are _`true`_ and _`false`_.
- The empty list, called _`nil`_, is denoted by `#e`. An _SMPL_ list is actually a sequence of pairs that terminate with the empty list.

### 2.2 Compound Data

_SMPL_ has two types of compound data: the vector and the pair. A vector is somewhat like an array, except that it is not constrained to hold only one typeof data. A pair contains two arbitrary objects. Table 3 describes the builtin functions available for manipulating compound data in _SMPL_.

Vector initialisation is quite flexible. A vector may be initialised by specifying a collection of disjoint subvectors, or the individual elements, or a combination of the two. A subvector is specified by two expressions: the first (after it has been evaluated) gives the size of the subvector, the second (after it has been evaluated) must be a procedure that when given an index less than the size, returns the value to be stored at that position _in the subvector_. The following examples should help to clarify the description. In them, assume that the value of `x` has previously been set to 5.

```haskell
[ 1,2,3 ]                                   ⇒ [1 2 3]
[ 1,2,x ]                                   ⇒ [1 2 5]
[ 5: (i) { i; } ]                           ⇒ [0 1 2 3 4]
[ 1, 3: (n) { 2 * n; }, 3 ]                 ⇒ [1 0 2 4 3]
[ 3: (n) { 2 * n; }, 4: (n) { 3 * n; } ]    ⇒ [0 2 4 0 3 6 9]
```

| Builtin | Explanation |
| :--- | :--- |
| `pair(`&#12296;e<sub>1</sub> ,e<sub>2</sub>&#12297;`)` | Create a pair containing the objects denoted by e<sub>1</sub> and e<sub>2</sub>. |
| `1st(`&#12296;p&#12297;`)` | Return the first object in the pair _p_. |
| `2nd(`&#12296;p&#12297;`)` | Return the second object in the pair _p_. |
| `[`&#12296;e<sub>1</sub>&#12297;, &hellip;,&#12296;e<sub>n</sub>&#12297;`]`<sup><a href="#footnote-a">a</a></sup> | Return a newly allocated vector initialised with the given specifications<br/>Each specification is either an expression or of the form<br/>&#12296;expr<sub>size</sub>&#12297; : &#12296;expr<sub>init</sub>&#12297; |
| &#12296;expr<sub>vec</sub>&#12297;`[`&#12296;n&#12297;`]` | Return the <i>n<sup>th</sup></i> element of vector _vec_(indexed from 0).<br/>When on the LHS of an assignment, sets the <i>n<sup>th</sup></i> element to the RHS. |
| `size(`&#12296;vec&#12297;`)` | Return the length of the vector _vec_. |

Table 3: Builtin expressions

### 2.3 Statements and Expressions

Table 4 lists the keywords of _SMPL_ and their purposes.

_SMPL_ ***Identifiers***:
 - Can contain at least one non-digit character
 - Must not contain any special characters (Only alpha-numeric characters allowed)
 
 The following are ***legal identifiers***: `foo`, `bar1`, `1bar`, `ba1r`.<sup><a href="#footnote-4">4</a></sup>
 
 The following are _illegal identifiers_: `#bar`, `12`, `(foo)`, `{bar}`, `[baz]`, `foo`, `bar`, `foo:bar`, `foo!`, `bar?`, `fo#o`, `foo.bar`.

***Function calls*** are denoted by the function name followed immediately by a sequence of comma-separated argument expressions enclosed in parentheses. The following expressions are ***legal function calls***: `f(a, b)`, `g()`, `foo(a, b, c, d)`.

_SMPL_ ***operators*** include:
- Arithmetic operators: `+`, `-`, `*`, `/`, `%`
- Bitwise operators: `&`, `|`, `~`
- Relational operators: `==`<sup><a href="#footnote-5">5</a></sup>, `>`, `<`, `<=`, `>=`, `!=`
- Logical operators: `&&`, `||`, `!`

Operator precedence, from highest to lowest is as follows: 

`∼`	**⇒** `∗`, `/`, `%` **⇒** `+`, `−` **⇒** `&`, `|` **⇒** `=`, `>`, `<`, `≤`, `≥`, `≠`	**⇒** `!`	**⇒** `&&`	**⇒** `||`

In order to apply a unary minus to an expression, the combined expression must be surrounded by parentheses. So the negative of the variable `x` is expressed as `(- x)`, not  `- x`.

| Statement | Purpose |
| :--- | :--- |
| `〈id〉 = 〈expr〉`<sup><a href="#footnote-5">5</a></sup>&nbsp;<sup><a href="#footnote-6">6</a></sup> | Define and assign the value of _expr_ to variable _id_. |
| `〈id〉 = (〈parameters〉)`<sup><a href="#footnote-7">7</a></sup><br />`{...}`<sup><a href="#footnote-9">9</a></sup> | Return a procedure of _n_ arguments with formal parameters _p_<sub><i>i</i></sub> like so, _p_<sub>1</sub>, _p_<sub>2</sub>, &hellip;, _p_<sub>n</sub>, or lik so `(...〈p〉)` (a spread operator, which will pass an array of values passed to function).<sup><a href="#footnote-d">d</a></sup><br />Compound expression containing list of statements. |
| `〈condition〉 ? 〈expr〉`<sup><a href="#footnote-8">8</a></sup><br />`: 〈expr〉` | Test predicate, evaluate then clause if non-false.<br />Otherwise evaluate else clause, if given. |
| `?: {`<br />**[**_p_<sub><i>1</i></sub>:_c_<sub><i>1</i></sub> &hellip; _p_<sub><i>n</i></sub>:_c_<sub><i>n</i></sub>**]**`}`<br />`〈condition〉 : 〈expr〉`  | Evaluate the consequent of the first clause whose<br />predicate is true.<br />A clause of a case expression. If predicate is the keyword `else`, it is regarded as true. |
| `(〈expr〉) ?: {`<br/>**[**_l_<sub><i>1</i></sub>:〈expr〉<sub><i>n</i></sub> &hellip; _l_<sub><i>n</i></sub>:〈expr〉<sub><i>n</i></sub>**]**<br />`}` | Evaluates an expression and matches the value of the expression to one of the cases within it code block |
| `(〈initialization〉; 〈condition〉; 〈expr〉)`<sup><a href="#footnote-c">c</a></sup><br />`〈expr〉` | Looping construct. Can be done with or without `〈initialization〉` or `〈expr〉` (an increment expression). |
| `:> 〈expr〉`<sup><a href="#footnote-10">10</a></sup> | Print the value of the given expression. |
| `:<`<sup><a href="#footnote-11">11</a></sup> | Read and return a stream from the keyboard either a number or a string. |
| `//` | Comment to rest of line |
| `/*... */` | Block comment (nestable) |


Table 4: Table of _SMPL_ statements

<div align="right">
    <b><a href="#smpl-specification"">↥ To Top</a></b>
</div>

## 3 Examples

Here are some example procedures in _SMPL_.

```haskell
// return factorial n
fact = (n) { (n <= 1) ? 1 : n * fact(n - 1); }

/* return the nth fibonacci number */
fib = (n) { (n <= 1) ? 1 : fib(n - 1) + fib(n - 2); }

/* return a new list, obtained by applying f to each element of list */
map = (f, list) { (list = #e) ? #e : pair(f(1st(list)), map(f, 2nd(list))); }

/* return a newly allocated vector obtained by applying f to each element of v. */
vecMap = (f, v) { [ size(v): (i) -> f(v[i]) ]; }

 /* return a newly allocated vector containing elements of v1 followed by elements of v2 */
vecAppend = (v1, v2) { [ size(v1): (i) -> v1[i], size(v2): (i) -> v2[i] ]; }
    
```

<div align="right">
    <b><a href="#smpl-specification"">↥ To Top</a></b>
</div>

## 4 Extensions

Here are a few ideas for extensions to _SMPL_ :

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

&copy; Prof. Daniel Coore

<a id="footnote-e"><sup>e</sup></a> Implementing extension for _Arbitrary precision integer arithmetic_ and _Floating point numbers_ in first iteration (A good test case for this is to see whether your extended language can compute the factorial of 1000).

<a id="footnote-f"><sup>f</sup></a> Removed _Table of special character codes_. Will be using the uniquitous character codes already established in Java, JavaScript and C.

<a id="footnote-a"><sup>a</sup></a> Changed the token for enclosing arrays to the ubiquitous tokens, `[` `]`, rather than `[:`, `:]`.

<a id="footnote-4"><sup>4</sup></a> The original specification included special characters such as `!`, `?`, `#`. These are removed in this specification. So, these: `foo!`, `bar?`, `fo#o`, `foo.bar` are not allowed.

<a id="footnote-5"><sup>5</sup></a> The original concepts was to use `=` for the conditional expression indicating equality. This version will use `==`, which is more ubiquitous across most popular languages. This would make `=` available for the assignment operator.

<a id="footnote-6"><sup>6</sup></a> `def 〈id〉 〈expr〉` was removed for this specification as `〈id〉 = 〈expr〉` was thought to be sufficiently identifiable and useful for the same purpose.

<a id="footnote-7"><sup>7</sup></a> `proc(`_p_<sub>1</sub>, _p_<sub>2</sub>, &hellip;, _p_<sub>n</sub>`)` &#12296;_body_&#12297; was changed to `〈id〉 = (`_p_<sub>1</sub>, _p_<sub>2</sub>, &hellip;, _p_<sub>n</sub>`)` &#12296;_body_&#12297; to look more like assignment. Mimicking JavaScript design (not the syntax but the interpretation) of function variables.

<a id="footnote-8"><sup>8</sup></a> `if 〈expr〉 then 〈expr〉 else 〈expr〉` was removed as `〈expr〉 ? 〈expr〉 : 〈expr〉` was thought to be more brief

<a id="footnote-9"><sup>9</sup></a> `let(`_b_<sub>1</sub> , _b_<sub>2</sub>, &hellip;, _b_<sub>n</sub>`)` &#12296;_body_&#12297; was removed as `{...}` thought to be sufficient for evaluating a list of statements

<a id="footnote-10"><sup>10</sup></a> `print(〈expr〉)` was replaced by `:> 〈expr〉` as part of the philosophy to make the language more symbolic

<a id="footnote-11"><sup>11</sup></a> `read()` and `readint()` was replaced by `<:` as part of the philosophy to make the language more symbolic and minimalistic

<a id="footnote-c"><sup>c</sup></a> Implementing extension for _Additional control structures_ in first iteration.

<a id="footnote-d"><sup>d</sup></a> Implementing the spread operator (from JavaScript) to fulfill extension for _Variable numbers of arguments to procedures_ in first iteration.

&copy; Dayton Outar