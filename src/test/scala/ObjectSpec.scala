import org.scalatest.{Matchers, FunSuite}

/**
 * Created by glenn on 2016. 8. 1..
 */
class ObjectSpec extends FunSuite with Matchers{
  //object keyword를 사용하면 singlton으로 생성됨
  object Obj{
    def fnc1 = "1"
  }

  test("object"){
    Obj.fnc1 shouldBe "1"
  }

  test("equal"){
    val x = Obj
    val y = x

    x eq y shouldBe true
    x == y shouldBe true


    class Foo

    val a = new Foo
    val b = new Foo

    a eq b shouldBe false
  }

  //class의 private변수에 접근할수 있다.
  test("companion object"){
    class Person(val name: String, private val superheroName: String) //The superhero name is private!

    object Person {
      def showMeInnerSecret(x: Person) = x.superheroName
    }

    val clark = new Person("Clark Kent", "Superman")
    val peter = new Person("Peter Parker", "Spiderman")
    val bruce = new Person("Bruce Wayne", "Batman")
    val diana = new Person("Diana Prince", "Wonder Woman")

    Person.showMeInnerSecret(clark) shouldBe "Superman"
    Person.showMeInnerSecret(peter) shouldBe "Spiderman"
    Person.showMeInnerSecret(bruce) shouldBe "Batman"
    Person.showMeInnerSecret(diana) shouldBe "Wonder Woman"
  }

}
