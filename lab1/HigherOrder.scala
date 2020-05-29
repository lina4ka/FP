object HigherOrder extends App {
  /* a) Напишите функцию, которая принимает `f: (Int, Int) => Int`, параменты `a` и `b`
 *    и коэффициент умножения `n` и возвращает n * f(a, b). Назовите `nTimes`.
 */
  def nTimes(f: (Int, Int) => Int,a: Int,b: Int, n: Int) = n*f(a,b)
  def testNTimes(f: (Int, Int) => Int, a: Int, b: Int, n: Int): Int = nTimes(f,a,b,n)
  println("Проверка ф-ии testNTimes "+testNTimes((i: Int, j: Int) => 2*i+j,2,4,6))
  /* b) Напишите анонимную функцию, функцию без идентификатора ((a, b) => ???) для `nTimes` которая
   *    выполняет следующее:
   *          if (a > b) a else b
   */
  def testAnonymousNTimes(a: Int, b: Int, n: Int): Int = nTimes((_1,_2)=> if (_1 > _2) _1 else _2, a, b,n)
  println("Проверка ф-ии testAnonymousNTimes "+testAnonymousNTimes(2,4,6))
  println("Проверка ф-ии testAnonymousNTimes "+testAnonymousNTimes(10,4,6))
}
