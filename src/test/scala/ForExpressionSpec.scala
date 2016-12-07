import org.scalatest.{Matchers, FunSuite}

/**
 * Created by glenn on 2016. 12. 7..
 */
case class MyList[A](list: List[A]){

  //f: A => List[B]
  def flatMap[B](f: A => MyList[B]) : MyList[B] =
    for{
      list <- f
      num <- list
    } println(num)

  //flatMap을 이용해서

}

class ForExpressionSpec extends FunSuite with Matchers {

  test("myList"){
    val my1 = MyList(List(1, 2, 3))
    val my2 = my1.flatMap((i: Int) => MyList(List(i + 10)))
    my2 shouldBe MyList(List(11,12,13))
  }

  var numList = List(1, 2, 3, 4)

  test("for basic"){
    for(num <- numList) println(num)

    numList.foreach((num: Int) => println(num))
    numList.foreach(num => println(num))
    numList.foreach(println)
  }

  test("filter"){
    //num <- numList : generator
    for(num <- numList if num % 2 == 0) println(num)

    numList.filter(_ % 2 == 0).foreach(println)
  }

  val numsList = List(List(1,2,3), List(4,5,6))

  test("multiple generator"){
    for(nums <- numsList; num <- nums) println(num)

    //yield : 결과를 집합 ))
    var result: List[(Int, String)] = for(x <- List(1,2); y <- List("One", "Two")) yield (x,y)
    println(result)
  }

  test("binding"){
    for{
      num <- numList
      numStr = "S" + num.toString
    } println(numStr)
  }

  test("remind"){
    //제너레이더 : 리스트의 원소 (pat) <- 콜렉션(expr)
    //정의 pat = expr(pat을 expr의 값에 바인딩)
    //필터 if expr
  }

  test("one generator to map"){
    val list1: List[String] = for (num <- numList) yield num.toString
    val list2 = numList.map(num => num.toString)

    list1 shouldBe list2
  }

  test("generator filter to withFilter-map"){
    val expr1: List[Int] = for(num <- numList if num % 2 == 0) yield num * 10

    val expr2 =
    for(num <- numList withFilter(num => num % 2 == 0)) yield num * 10

    val expr3 = numList.filter(num => num % 2 == 0).map(x => x * 10)

    expr1 shouldBe expr2
  }

  test("two generator to flatMap"){
    val numsList = List(List(0), List(1, 3, 5), List(2, 4))

    val expr1: List[String] = for{
      nums <- numList
      num <- nums
    } yield println(num.toString)

    //val expr2 = numList.flatMap(nums => nums.map(num => num.toString))
  }
}
