import org.scalatest.{Matchers, FunSuite}

/**
 * Created by glenn on 2016. 9. 7..
 */
class RangeSpec extends FunSuite with Matchers{

  test("range"){
    //특정 argument를 받아서 데이터를 생성할때 사용
    val ten = Range(1, 10)
    println(ten)
    val ten2 = 1 to 10
    println(ten2)
    val ten3 = Range(1, 10,2)
    println(ten3)
    val ten4 = 1 until 10
    println(ten4)
    val ten5 = 'a' until 'z'
    ten5.foreach(x => print(x.toChar))

  }
}
