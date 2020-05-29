
object Typeclasses extends App {

  // a) Определите тайп-класс Reversable, который представляет в обратном порядке значения.
  trait Reversable[T]
  {
    def reverse(a: T): T
  }
  // b) Реализуйте функцию Reverse для String.
  object Reversable{
    implicit object ReversableString extends Reversable[String] {
      def reverse(a: String): String = a.reverse
    }
  }
  def reversable[T](str:T)(implicit currentClass : Reversable[T]):T = currentClass.reverse(str)
  def testReversableString(str: String): String = reversable(str)
  println("Проверка ф-ии testReversableString "+testReversableString("Some_Interesting_String"))

  // c) Определите тайп-класс Smash таким образом чтобы в нем была функция smash, которая выполняет операцию со значениями одного типа.
  trait Smash[T]
  {
    def smash(a: T, b: T): T
  }

  // d) Реализуйте  функции Smash для типа Int и Double.
  //    Используйте сложение для типа Int у умножение для типа Double.
  object Smash{
    implicit object SmashInt extends Smash[Int] {
      def smash(a: Int, b: Int): Int = a+b
    }
    implicit object SmashDouble extends Smash[Double] {
      def smash(a: Double, b: Double): Double = a*b
    }
    implicit object SmashString extends Smash[String] {
      def smash(a: String, b: String): String = a + b
    }
  }
  def smash[T](a: T, b: T)(implicit currentClass : Smash[T]):T = currentClass.smash(a,b)
  def testSmashInt(a: Int, b: Int): Int = smash(a,b)
  def testSmashDouble(a: Double, b: Double): Double = smash(a,b)
  println("Проверка ф-ии testSmashInt "+testSmashInt(3,4))
  println("Проверка ф-ии testSmashDouble "+testSmashDouble(3,4))

  // e) Реализуйте функцию Smash для типа String. Необходимо выполнить конкатенацию строк, которые будут получены в качестве параметра.
  /**
   * implicit object SmashString extends Smash[String] {
   * def smash(a: String, b: String): String = a + b
   * }
   */
  def testSmashString(a: String, b: String): String = smash(a,b)
  println("Проверка ф-ии testSmashDouble "+testSmashString("Some_Interesting_String","_Not_Interesting_String"))
}
