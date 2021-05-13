# Examples

What can we achieve using _SMPL_?

## Logical Expressions

## Mathematical Expressions



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

#### Factorial

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

### Statistics & Probability

### Calculus

## String Expressions

...

# References

 - [Mathematical Formulas](https://www.matematica.pt/en/useful/math-formulas.php)
 - [Basic Math Symbols](https://www.rapidtables.com/math/symbols/Basic_Math_Symbols.html)
 - [Unicode Characters in the 'Symbol, Math' Category](https://www.fileformat.info/info/unicode/category/Sm/list.htm)
 - [List of Unicode Characters of Category “Math Symbol”](https://www.compart.com/en/unicode/category/Sm)