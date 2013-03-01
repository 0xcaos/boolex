Boolex
======

Makes boolean operations work as in Python or JavaScript

including net.caoticode.boolex._ allows to do two things:
* use any value where booleans are expected (like in an if expression)
* use two new operators: &&& and ||| they are like the usual AND and OR operators but instead of returning a boolean they return the value associated with the "truth" or "falsity" of the expression

for example:
```scala
val something = "Hi!"
val nothing = ""

(nothing ||| something) == "Hi!" // :D
```

the values considered false are:
* empty Strings
* a Number equals to 0
* an empty Traversable
* the Boolean false
* null and None
