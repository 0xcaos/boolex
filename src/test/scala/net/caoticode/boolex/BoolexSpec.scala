package net.caoticode.boolex

import org.specs2._

/**
 * @author Daniel Camarda <maniacal.dread@gmail.com>
 */

class BoolexSpec extends Specification { def is = s2"""

 This is the specification for Boolex, it checks the correct execution of boolean operations
 
 AND (&&) operator on booleans should
   return true if both operands are true                 $and1
   return false if one operand is false                  $and2
   
 AND (&&) operator on strings should behave like this
   "hello" && "world" == "world"                         $and3
   "" && "world"      == ""                              $and4
   "hello" && ""      == ""                              $and5
   "" && ""           == ""                              $and6
   
 AND (&&) operator on numbers should behave like this
   1.0 && 2.3 == 2.3                                     $and7
   0 && 20    == 0                                       $and8
   20 && 0    == 0                                       $and9
   0 && 0.0   == 0                                       $and10
   
 AND (&&) operator on traversables should behave like this
   List(1,2,3) && List(4,5,6) == List(4,5,6)             $and11
   List() && List(4,5,6) == List()                       $and12
   List(1,2,3) && List() == List()                       $and13
   List() && List() == List()                            $and14
   
 OR (||) operator on booleans should
   return true if almost one operand is true             $or1
   return false if both operands are false               $or2
   
 OR (||) operator on strings should behave like this
   "hello" || "world" == "hello"                         $or3
   "" || "world"      == "world"                         $or4
   "hello" || ""      == "hello"                         $or5
   "" || ""           == ""                              $or6
   
 OR (||) operator on numbers should behave like this
   1.0 || 2.3 == 1.0                                     $or7
   0 || 20    == 20                                      $or8
   20 || 0    == 20                                      $or9
   0 || 0.0   == 0.0                                     $or10
   
 OR (||) operator on traversables should behave like this
   List(1,2,3) || List(4,5,6) == List(1,2,3)             $or11
   List() || List(4,5,6) == List(4,5,6)                  $or12
   List(1,2,3) || List() == List(1,2,3)                  $or13
   List() || List() == List()                            $or14
   
 Null and None
   null must be converted to false                       $null1
   None must be converted to false                       $none1
                                                         """
   // AND for booleans
  def and1 = (new BoolexOPS(true).&&(true)) must beTrue
  def and2 = ((new BoolexOPS(false).&&(true)) must beFalse) and
             ((new BoolexOPS(true).&&(false)) must beFalse)

  // AND for strings
  def and3 = ("hello" && "world") must_== "world"
  def and4 = ("" && "world") must_== ""
  def and5 = ("hello" && "") must_== ""
  def and6 = ("" && "") must_== ""

  // AND for numbers
  def and7 = (1.0 && 2.3) must_== 2.3
  def and8 = (0 && 20) must_== 0
  def and9 = (20 && 0) must_== 0
  def and10 = (0 && 0.0) must_== 0
  
  // AND for traversables
  def and11 = (List(1,2,3) && List(4,5,6)) must_== List(4,5,6)
  def and12 = (List() && List(4,5,6)) must_== List()
  def and13 = (List(1,2,3) && List()) must_== List()
  def and14 = (List() && List()) must_== List()
  
  // OR for booleans
  def or1 = ((new BoolexOPS(false).||(true)) must beTrue) and
            ((new BoolexOPS(true).||(false)) must beTrue)
  def or2 = (new BoolexOPS(false).||(false)) must beFalse
  
  // OR for strings
  def or3 = ("hello" || "world") must_== "hello"
  def or4 = ("" || "world") must_== "world"
  def or5 = ("hello" || "") must_== "hello"
  def or6 = ("" || "") must_== ""
  
  // OR for numbers
  def or7 = (1.0 || 2.3) must_== 1.0
  def or8 = (0 || 20) must_== 20
  def or9 = (20 || 0) must_== 20
  def or10 = (0 || 0.0) must_== 0.0
  
  // OR for traversables
  def or11 = (List(1,2,3) || List(4,5,6)) must_== List(1,2,3)
  def or12 = (List() || List(4,5,6)) must_== List(4,5,6)
  def or13 = (List(1,2,3) || List()) must_== List(1,2,3)
  def or14 = (List() || List()) must_== List()
  
  def null1 = (any2Boolean(null)) must beFalse
  def none1 = (any2Boolean(None)) must beFalse
  
}