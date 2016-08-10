import org.scalatest.{Matchers, FunSuite}

/**
 * Created by glenn on 2016. 8. 10..
 */
class ListSpec extends FunSuite with Matchers{
  test("list"){
    //가변성, 동시성에 좋지않다., 동기화
    //자바 단점 : 메모리를 마음대로 쓰지못하고, CPU도 못씀, BlockIO
    //List<String> list = new ArrayList<>;


    //scala
    //import scala.collection.mutable
    //import scala.collection.immutable
    val list = List(1, 2, 3, 4)
    val nil = Nil
    val nil2 = List()

    // cons '::'
    //list 뒤에서 부터 추가됨
    val list2 = 1 :: 2 :: 3 :: 4 :: Nil
    val list3 = Nil.::(4).::(3).::(2).::(1)

    list shouldBe list2
    list shouldBe list3

    val list5 = list ::: List(5)
    //list(1, 2, 3, 4)
    //list5(1, 2, 3, 4, 5)

    //list 하나의 데이터를 추가
    //list.add(5)
    5 :: list

    //list.addAll(list2)
    println(list5 :: list)
    println(list5 ::: list)
    println(list ::: list5)


    //** 패턴 매칭
    //fp
    val list6 = List(1, 2 ,3 ,4)
    list6 match {
      case a :: b :: c :: d :: Nil => println(a, b, c, d)
      case a :: xs => println(s"1개이상 있나? $a ($xs)")
      case a :: b :: c :: d :: Nil => println(s"4 있나? $a, $b, $c, $d")
      case a :: b :: c :: Nil => println(s"3 있나? $a, $b, $c")
      case a :: b :: Nil => println(s"2 있나? $a, $b")
      case a :: Nil => println(s"하나 있나? $a")
      case Nil => println("Empty!!")
    }
  }

  test("map"){
    val a = List(1, 3, 5, 7)
    //println(a.map(x => x * 2))
    //println(a.map(_ * 2))

    a.map(_ * 2) shouldBe(List(2, 6, 10, 14))
  }

  test("filter"){
    val a = List(1, 3, 5, 7)
    //println(a.filter(x => x % 3 == 0))
    a.filter(x => x % 3 == 0) shouldBe(List(3))
  }

  test("fold"){
    val a = List(1, 3, 5, 7)
    //println(a.foldLeft(0)(_ + _))
    //println(a.foldLeft(10)(_ + _))

    a.foldLeft(1)(_ * _) shouldBe 105
    a.foldLeft(0)(_ * _) shouldBe 0
  }

  test("toList"){
    val list = (1 to 10).toList
    val list2 = "abc".toList

    println(list2)
    list shouldBe (List(1,2,3,4,5,6,7,8,9,10))



    val d = Nil
    val c = 3 :: d
    val b = 2 :: c
    val a = 1 :: b
    println(a)
    println(c.tail)
    println(b.tail)
    println(a.tail)
  }
}

















