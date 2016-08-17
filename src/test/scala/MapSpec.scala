import org.scalatest.{Matchers, FunSuite}

/**
 * Created by glenn on 2016. 8. 17..
 */
class MapSpec extends FunSuite with Matchers{

  test("Map"){
    //mutable, immutable

    //1.Map(A, B)
    //2.Map(A -> B)
    val map = Map[Int, String]((10, "ten"), (1, "one"))
    val map2 = Map((10, "ten"), (1, "one"))
    val map3 = Map(10 -> "ten", 1 -> "one")


    map shouldBe map2
    map2 shouldBe map3

    //mutable 새로운 객체를 반환한다.
    //map 복사가 되는것은 아님. 참조를 하고있다.
    val map4 = map + (2 -> "이")

    map4.get(2) shouldBe Some("이")
    map4.get(3) shouldBe None

    map4.getOrElse(4, "사") shouldBe "사"

  }
}
