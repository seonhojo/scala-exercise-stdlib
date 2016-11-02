import org.scalatest.{FunSuite, Matchers}

/**
 * Created by glenn on 2016. 11. 2..
 */
class ImplicitSpec2 extends FunSuite with Matchers {
  //implicit 뜻 '은연중' <-> '명시적' explicit
  //기존의 스칼라 라이브러리들이 많이 사용하고 있으며
  //라이브러리를 사용할때 잘이용할수 있다.

  test("parameter") {
    def foo(a: Int): String = {
      a + " " + a
    }

    val bar: Int = 10
    println(foo(10))

    //암묵적으로 함수의 파라미터를 바인딩 하고 싶다.
    def foo2(implicit a: Int): String = {
      a + " " + a
    }

    //implicit 찾는조건
    //1. 같은타입
    //2. 현재 스코프 implicit
    //3. import된 스코프 implicit
    //4. companion object
    implicit val bar2: Int = 200
    println(foo2)
    println(foo2(bar))
  }

  object testImplicit {
    implicit val objectImplicitVal = "object implicit"
  }

  test("example") {
    import testImplicit.objectImplicitVal
    // 1. 함수에서 implicit 함수의 인자를 받는 함수를 만든다.
    // 2. implicit 변수를 만든다.
    // 3. 실행
    // 4. 다양한 스코프에 실행

    //implicit val implicitVal = "test implicit"
    def implicitTestFnc(implicit str: String) : String = {
      str + "," + str
    }

    println(implicitTestFnc)
  }

  test("형변화 implicit"){
    //형변환
    //Int to String
    def foo(a: Int): String = a.toString + " " + a.toString
    val foo1: String = foo(10)

    case class Alcol(name: String)
    case class Edina(want: String)

    implicit def toAlcol(edina: Edina) : Alcol = Alcol(edina.want)

    val edina = Edina("와인")
    println(toAlcol(edina))

    //현재의 타입에서 바뀔 다입으로 구성된 implicit 함수를 찾는다.
    val alcol: Alcol = edina
    println(alcol)
  }

  test("type casting implicit"){
    //def
  }
}



















