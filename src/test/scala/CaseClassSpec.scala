import org.scalatest.{Matchers, FunSuite}

/**
 * Created by glenn on 2016. 8. 29..
 */
class CaseClassSpec extends FunSuite with Matchers{

  val aOption = Option(1)
  test("CaseClass"){
    //클래스 종류중 하나
    //class?? case class??

    val aValue = aOption match{
      case Some(value) => value
      case None => 0
    }

    println(aOption)
  }

  test("왜?, 어디에 쓰이나?"){
    case class Foo(a: Int, b: Boolean)
    val foo = Foo(1, false)
    foo.a
    foo.b
    //Lombok @Data
    //new keyword X
    println(foo)

    //값 비교를 잘한다.
    val foo1 = Foo(1, false)
    val foo2 = Foo(2, false)
    assert(foo == foo1)
    assert(foo != foo2)
    //DTO
    //Value

    //case class끼리는 상속이 안된다.
    //case class Bar extents Foo

    //class 상속이 안된다.
    //불변속성을 가지고 있다.
    val foo3 = foo.copy(a=10, b=false)
    println(foo)
    println(foo3)

    //val(final), var
    var f = foo
    f = foo1

    //case object
    case class Bar(a:Int, b:Int){
      def sum() = a + b
    }

    val bar = Bar(10, 20)
    println(bar.sum())

    case class Bar1(var a:Int, var b:Int){
      def sum() = a + b
    }
    val bar1 = new Bar1(10, 20)
    bar1.b = 30


    //간단한 비즈니스 로직을 다룰땐 case class를 사용하는것이 좋다.
  }

}

















