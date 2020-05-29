object Strings extends App {

  /* a) Преобразуйте все символы типа Char в верхний регистр (не используйте заглавные буквы). */
  def upperCase(str: String): String = str.toLowerCase()
  def testUppercase(str: String): String = upperCase(str)
  println("Проверка ф-ии testUppercase "+testUppercase("Some_LONG_sEntence_1!"))

  /* b) Вставьте следующие значения в строку:
   *       Hi my name is <name> and I am <age> years old.  */
  def interpolations(name: String, age: Int): String = s"Hi my name is $name and I am $age years old."
  def testInterpolations(name: String, age: Int): String = interpolations(name,age)
  println("Проверка ф-ии testInterpolations "+testInterpolations("Pchelka",1))

  /* c) Добавьте два числа в следующую строку:
   *       Hi,
   *       now follows a quite hard calculation. We try to add:
   *         a := <value of a>
   *         b := <value of b>
   *
   *         result is <a + b> */
  def computation(a: Int, b: Int): String = "Hi,\n" +
    "now follows a quite hard calculation. We try to add:\n" +
    s"a := $a\n" +
    s"b := $b\n\n" +
    s"result is ${a + b}"
  def testComputation(a: Int, b: Int): String = computation(a,b)
  println("Проверка ф-ии testComputation "+testComputation(7,1))

  // d) Если длина строки равна 2, верните всю строку, иначе верните первые два символа строки.
  def takeTwo(str: String): String = str.take(2)
  def testTakeTwo(str: String): String = takeTwo(str)
  println("Проверка ф-ии testTakeTwo "+testTakeTwo("Some_LONG_sEntence_2!"))
}
