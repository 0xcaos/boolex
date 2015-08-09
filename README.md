Boolex
======

Makes boolean operations work as in Python or JavaScript

including net.caoticode.boolex._ allows to:
* use any value where booleans are expected (like in an if expression)
* use && and || with any value: they work like the usual && and || boolean operators, but instead of returning a boolean, they return the value associated with the "truth" or "falsity" of the expression

for example:
```scala
import net.caoticode.boolex._

val something = "Hi!"
val nothing = ""

(nothing || something) == "Hi!" // :D
```

the values considered false are:
* empty Strings
* a Number equal to 0
* an empty Traversable
* the Boolean false
* null and None

## Build and install

add the following line to **sbt** build file
```
libraryDependencies += "net.caoticode.boolex" %% "boolex" % "1.0.0"
```

or clone and package it manually

```
git clone https://github.com/mdread/boolex.git
cd boolex
sbt package
```

## Note

The library is cross compiled for scala 2.10/2.11
