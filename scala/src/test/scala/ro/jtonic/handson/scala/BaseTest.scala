package ro.jtonic.handson.scala

class BaseTest extends org.scalatest.FunSuite {

  def proceedExhaustively(base: Base): String = base match {
    case SubtypeOne(i) => i.toString
    case SubtypeTwo(name) => name
  }

  def proceedWithDefault(base: Base): String = base match {
    case SubtypeOne(i) => i.toString
    case SubtypeTwo(name) => name
    case _ => base.toString
  }

  test("test exhausted pattern match for java/scala interoperability - scala sealed class implementation") {
    val result = proceedExhaustively(SubtypeOne(1))
    assert(result == "1")
  }

  test("test exhausted pattern match for java/scala interoperability - java subtype of the sealed class - MatchError thrown") {
    val base = new BaseHelper().getBase
    assertThrows[MatchError](proceedExhaustively(base))
  }

  test("test pattern match with default case for java/scala interoperability - java subtype of the sealed class - MatchError thrown") {
    val base = new BaseHelper().getBase
    proceedWithDefault(base)
  }
}
