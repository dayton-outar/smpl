# Examples

What can we achieve using _SMPL_?



## Mathematical Examples



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
:> M[0, 0]; // Output: 1
```

A **vector** is a 1 × _n_ matrix

For example, the expression below is a 4-dimensional vector,

_**v**_ = [4, 3, 2, 1]

_**v**_<sub>i</sub> is the _i<sup>th</sup>_ entry of the vector

So, _**v**<sub>1</sub>_ can be represented as,

```
:> v[1];
```

![Matrix Addition](/.attachments/matrix-addition.png)

![Scalar Division](/.attachments/scalar-division.png)

![Scalar Multiplication](/.attachments/scalar-multiplication.png)

### Trigonometry


 - Factorial
 - Permutations
 - Probabilies

### Calculus


# References

 - [Mathematical Formulas](https://www.matematica.pt/en/useful/math-formulas.php)
 - [Basic Math Symbols](https://www.rapidtables.com/math/symbols/Basic_Math_Symbols.html)
 - [Unicode Characters in the 'Symbol, Math' Category](https://www.fileformat.info/info/unicode/category/Sm/list.htm)
 - [List of Unicode Characters of Category “Math Symbol”](https://www.compart.com/en/unicode/category/Sm)