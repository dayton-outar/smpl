# Examples

What can we achieve using _SMPL_?

## Logical Expressions

Logical expressions are what make a programming language. A language is said to be _Turing-complete_ when it has the ability to ask logical questions in a conditional statement and perform the appropriate instructions when conditions are met.

SMPL contains the popular ternary _if_ expression, _if-else_ statement, _case_ statement and a loop structure.

...

## Mathematical Expressions

### Number Systems

SMPL supports 4 number systems for long integer expressions: binary, octal, hexadecimal and decimal.

#### Binary Numbers

Binary numbers are prefixed with `0b` before the sequence of `1`'s and `0`'s. See below a snippet of code, where two binary numbers are added.

```
b0 = 0b100101;
b1 = 0b010101;
:> b0 + b1; // Output: 111010
```

In order to convert the binary number to its decimal representation, the number can be multiplied by 1. Where the 1 is placed at the leftmost position to have its radix gain precedence of the expression. See below snippet of code,

```
:> 1 * b0; // Output: 37
:> 1 * b1; // Output: 21
:> 1 * (b0 + b1); // Output: 58
```

Numbers in decimal representation can also be converted to binary by multiplying the long integer expression by `0b1`. See snippet below,

```
:> 0b1 * 8; // Output: 1000
:> 0b1 * 20; // Output: 10100
```

_This conversion cannot be done for fractional decimal representation. Multiplying the fractional number by `0b1` does not change the radix. For example,_

```
:> 0b1 * 8.5; // Output: 8.5
```

The binary numbers can use all the mathematical and logical expressions that are available in SMPL. See below some more examples of binary numbers in SMPL expressions,

```
:> b0**2; // Output: 10101011001
:> 1 * ( b0**2); // Output: 1369
```

#### Octal Numbers

Binary numbers are prefixed with `0b` before the sequence of numbers between `0` and `7`.


```
o0 = 0o1027;
o1 = 0o0501;
:> o0 - o1; // Output: 326
:> 1 * (o0 - o1); // Output: 214
```

Octal numbers can be used within all mathematical and logical expressions within SMPL.

#### Hexadecimal Numbers

Hexadecimal numbers are prefixed with `0b` before the sequence of numbers between `0` and `9` and letters between `a` and `f` (it is case insensitive).


```
h0 = 0xFF027;
h1 = 0x0050a;
:> h0 & h1; // Output: 2
```

Hexadecimal numbers can be used within all mathematical and logical expressions within SMPL.

### Geometry

![Square Shape](/.attachments/quadrado.png)

```
// Area of square
square = (:l) { l**2; } // Same as A = l²

:> square(4); // Outputs 16
```
![Rectangle Shape](/.attachments/retangulo.png)

```
// Area of rectangle
rectangle = (:w, :h) { w * h; } // Same as A = w × h

:> rectangle(5, 6); // Outputs 30
```

![Triangle](/.attachments/triangulo.png)
```
// Area of triangle
triangle = (:b, :h) {
    (b × h) / 2;
}

:> triangle(6, 9); // Outputs 27
```
Take note that both the asterisk and the unicode times symbol can be used as a multiplication operator

![Trapezoid](/.attachments/trapezio.png)

```
// Area of trapezoid
trapezoid = (:x, :y, :h) { ((x+y)/2) × h; }

:> trapezoid(4, 2, 5); // Outputs 15
```

![Circle](/.attachments/circulo.png)

```
// Area of circle
circle = (:r) { π × r**2; }

:> circle(3); // Outputs 28.27431
```

![Cone](/.attachments/cone.png)

```
// Area of cone
cone = (:r, :s) { π × r × s; }

:> cone(3, 5); // Outputs
```

![Sphere](/.attachments/esfera.png)
```
// Volume of sphere
sphere = (:r) {
    (4 × π × r**3 ) ;
}

:> sphere(8); // Outputs 2144.66058

```

![Pythagoras Theorem](/.attachments/pythagoras-theorem.png)

```
hypotenuse = (:a, :b) { √(a**2 + b**2); }

:> hypotenuse(3, 4); // Outputs 5.0
```
### Algebra

SMPL is also very good at expressing algebra expressions.

#### Factorial

The snippet below calculates the factorial of 7 (7!) to be 5040.

```
fact = (:n) { (n <= 1) ? 1 : n * fact( n - 1 ); }

x = 7;
:> "Factorial of ${x} is ... ${ fact(x)} \n";
```


#### Linear Algebra

A **matrix** is a 2-dimensional array of numbers

![3 x 4 Matrix](/.attachments/3x4-matrix.png)

_**M**_ is a 3 × 4 matrix: it has 3 rows and 4 columns.

This can be represented in smpl as,

```
// if we think of the first index parameter is the row and the second index parameter column
M = [ [1, 2, 3, 4], [0, 0, 0, 0], [4, 3, 2, 1] ];
```

Matrices consist of **entries**.

_**M**<sub>i, j</sub>_ is the entry in the _i<sup>th</sup>_ row and _j<sup>th</sup>_ column of _**M**_.

So, _**M**<sub>0, 0</sub>_ can be represented as,

```
:> M[0][0]; // Output: 1
```

A **vector** is a 1 × _n_ matrix

For example, the expression below is a 4-dimensional vector,

_**v**_ = [4, 3, 2, 1]

_**v**_<sub>i</sub> is the _i<sup>th</sup>_ entry of the vector

So, _**v**<sub>1</sub>_ can be represented as,

```
:> v[1]; // Output: 3
```
##### Matrix Addition

- **Matrix addition** is simply adding the entries of two or more matrices one by one
- This summation results in another matrix:
  > _**M**<sub>0</sub>_ + _**M**<sub>1</sub>_ = _**M**<sub>2</sub>_

For example,

![Matrix Addition](/.attachments/matrix-addition.png)

The example above is achieved in SMPL as follows,

```
m0 = [ [2, 3, 4], [0, 0, 0], [3, 2, 1] ];
m1 = [ [1, 1, 1], [0, 0, 0], [1, 1, 1] ];

:> m0 + m1; // Output: [[3, 4, 5], [0, 0, 0], [4, 3, 2]]
```

Notice that the resulting matrix retains the same dimensions (3 × 3).

**NB** _When matrices of different dimensions are added, **SMPL** accommodates the expression by expanding the result to the biggest matrix. See example below_

```
m2 = [ [1, 5, 9], [3, 0, 3] ];
:> m2 + m1; // The (2 × 3) matrix resulted in a (3 × 3) matrix when added to a 3 × 3 matrix ==> [[2, 6, 10], [3, 0, 3], [1, 1, 1]]
```

Is allowing expandable matrices a good idea? (Let's see)

##### Scalar Multiplication

- To **multiply a matrix by scalar** (a raw number), one also simply multiplies all its entries by this scalar
- It results in another matrix with the same dimentions

For example,

![Scalar Multiplication](/.attachments/scalar-multiplication.png)

- Note that the multiplication of a matrix by a scalar and the multiplication of a scalar by a matrix are equal

![Scalar to Matrix and Matrix to Scalar](/.attachments/scalar-matrix-matrix-scalar.png)

- A matrix can be divided by a scalar in the same way

![Scalar Division](/.attachments/scalar-division.png)

Scalar multiplication of matrices is demonstrated in the SMPL syntax below,

```
:> [2, 3] * [4, 6, 9]; // Output: [8, 18, 0]
:> "\n"; // New line
:> [55, 32] / [5, 4, 9]; // Output: [11, 8, 0]
```

### Trigonometry

Deriving trigonometric functions from its foundational principles can be achieved in SMPL. See below snippet that creates a _sin_ function by using a factorial function to create an expression based on the taylor series to calculate a shallow approximation of the result of _sin_ function.

```
fact = (:n) { (n <= 1) ? 1 : n * fact( n - 1 ); }

// To get a better approximation for cos(r), you need more terms in your Taylor polynomial.
sin = (:n) {
    r = ( n / 180.0 ) * π;
    v = r - ( (r**3)/fact(3) ) + ( (r**5)/fact(5) ) - ( (r**7)/fact(7) ) + ( (r**9)/fact(9) ) - ( (r**11)/fact(11) );
    v;
}
```

The tangent function is more easily derived once the above snippet is implemented to create the _sin_ function. See below snippet of _tan_ trigonometric function,

```
tan = (:n) {
    t = sin(n) ÷ √( 1 - sin(n)**2 );
    t;
}
```

Once the trigonometric functions have been established, they can be used as follows,

```
:> "Sine of 30 degrees is ${ sin(30) }\n";

:> "Tangent of 30 degrees is ${ tan(30) }\n";
```

See the [trigonometry](trigonometry.smpl) SMPL file for _cos_ function.

## String Expressions

Strings are included in SMPL to facilitate elaborate communication to a user interface. SMPL inherently facilitates the interpolation of mathematical and logical expressions within strings by placing those expressions within enclosing symbols: `${`, `}`.

For example, given that the functions `sin` and `tan` have been implemented, the following string expression evaluates the function expression within `${` and `}`.

```
:> "Sine of 30 degrees is ${ sin(30) }\n";

:> "Tangent of 30 degrees is ${ tan(30) }\n";
```

String expressions can be used within arrays and dictionaries in SMPL. See below example,

```
a = [ "apples", "bananas", "melon" ];
:> a; :> "\n";

b = "The first set of fruits in the bunch is ... ${a[0]}\n";
:> b;

c = [ "nike", "adidas", "puma" ];
d = "Booyah";
e = [ "fruits" => a, "brands" => c, "message" => d];

:> "\n";
:> "A complex data structure ${ e }";
:> "\n"
```

With some ingenuity and industry, SMPL is capable of making calculations on very complex data structures

# References

 - [Mathematical Formulas](https://www.matematica.pt/en/useful/math-formulas.php)
 - [Basic Math Symbols](https://www.rapidtables.com/math/symbols/Basic_Math_Symbols.html)
 - [Unicode Characters in the 'Symbol, Math' Category](https://www.fileformat.info/info/unicode/category/Sm/list.htm)
 - [List of Unicode Characters of Category “Math Symbol”](https://www.compart.com/en/unicode/category/Sm)