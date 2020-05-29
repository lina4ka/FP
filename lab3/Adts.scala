import scala.util.{Try, Failure, Success}

object Adts extends App {
  // a) Дан List[Int], верните элемент с индексом n
  def getNth(list: List[Int], n: Int): Option[Int] =if (list.size>=n)Some(list.dropRight(list.size-n-1).drop(n-1).head) else None
  def testGetNth(list: List[Int], n: Int): Option[Int] = getNth(list,n)
  println("Проверка ф-ии getNth "+getNth(List(0,1,2,3,4,5),3))

  // b) Напишите функцию, увеличивающую число в два раза.
  def double(n: Option[Int]): Option[Int] = n.map(_*2)
  def testDouble(n: Option[Int]): Option[Int] = double(n)
  println("Проверка ф-ии testDouble "+testDouble(Some(4)))

  // c) Напишите функцию, проверяющую является ли число типа Int четным. Если так, верните Right. В противном случае, верните Left("Нечетное число.").
  def isEven(n: Int): Either[String, Int] = if (n%2==0) Right(n) else Left("Нечетное число.")
  def testIsEven(n: Int): Either[String, Int] = isEven(n)
  println("Проверка ф-ии testIsEven "+testIsEven(4))

  // d) Напишите функцию, реализующую безопасное деление целых чисел. Верните Right с результатом или Left("Вы не можете делить на ноль.").
  def safeDivide(a: Int, b: Int): Either[String, Int] = b match {
    case 0 => Left("Вы не можете делить на ноль.")
    case _ => Right(a/b)
  }
  def testSafeDivide(a: Int, b: Int): Either[String, Int] = safeDivide(a,b)
  println("Проверка ф-ии testSafeDivide "+testSafeDivide(4,0))

  // e) Обработайте исключения функции с побочным эффектом вернув 0.
  def goodOldJava(impure: String => Int, str: String): Try[Int] = Try (impure(str)) match {
    case Success(a)     => Try(impure(str))
    case Failure(error) => Try(0)
  }
  def testGoodOldJava(impure: String => Int, str: String): Try[Int] = goodOldJava(impure,str)
  println(("Проверка ф-ии testGoodOldJava "+testGoodOldJava(i=>i.toInt,"5")))
}
