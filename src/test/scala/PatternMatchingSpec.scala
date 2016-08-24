import org.scalatest.{WordSpec, Matchers, FunSuite}

/**
 * Created by glenn on 2016. 8. 24..
 */
class PatternMatchingSpec extends WordSpec with Matchers{

  "Pattern Matching" should {

    "basic" in {

      // => 함수표현
      //한줄 한줄이 함수를 뜻함
      def func1(num : Int) : String = num match {
        case 1 => "one"
        case _ => "other"//default 없으면 MatchError 발생
      }

      func1(1) shouldBe "one"
      func1(2) shouldBe "other" // 1외의 아무 숫자나 넣었을 때


      def func2(num : Int) : Any = num match {
        case 1 => "one"
        case _ => num

        //동일 결과
        //(n : Int)
        //(_ : Int)
        //case n => n
      }

      func2(1) shouldBe "one"
      func2(2) shouldBe 2 // 1외의 아무 숫자나 넣었을 때
    }

    "type" in {

      //n : 변수가 있어야 한다.(한줄이 함수인걸 고려해야한다.)
      def func(obj : Any) : String = obj match {
        case n : String => "string"
        case n : Int => "number"
      }

      func("str") shouldBe "string" // 문자열을 넣으면
      func(1) shouldBe "number" // 숫자를 넣으면
    }

    "type2" in {

      trait Link
      class Facebook extends Link {
        def getID() = "아이디"
      }
      class Kakao extends Link {
        def getName() = "본명"
      }
      class KakaoStrory extends Link {
        def getNickName() = "닉네임"
      }

      //def getName(link : Link) : String = link match{
      def getName(link : Link) : Option[String] = link match{
        case n : Facebook => Some(n.getID())
        case n : Kakao => Some(n.getName())
        case n : KakaoStrory => Some(n.getNickName())
        //case _ => null //null은 사용하면 안된다.
      }

      getName(new Facebook) shouldBe "아이디"
    }


  }
}
