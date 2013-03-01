package net.caoticode

package object boolex {
  implicit class BoolexOPS[T](op1: T) {
    def &&[A >: T](op2: => A): A = if (toBool) op2 else op1
    def ||[A >: T](op2: => A): A = if (toBool) op1 else op2
    
    def toBool: Boolean = any2Boolean(op1)
  }
  
  implicit def any2Boolean(elem: Any): Boolean = elem match {
      case e: BoolexOPS[_] => e.toBool
      case e: String => !(e isEmpty)
      case e: Number => e != 0
      case e: Boolean => e
      case e: Traversable[_] => !(e isEmpty)
      case e => e != null && e != None
    }
}
