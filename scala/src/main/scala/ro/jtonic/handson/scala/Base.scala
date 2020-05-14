package ro.jtonic.handson.scala

sealed abstract class Base

final case class SubtypeOne(a: Int) extends Base

final case class SubtypeTwo(b: String) extends Base
