object Functions extends App {

  // a) Напишите функцию, которая рассчитывает площадь окружности
  def circle(r: Double): Double = Math.pow(r,2)*Math.PI

  def testCircle(r: Double): Double = circle(r)
  println("Проверка ф-ии testCircle "+testCircle(3.4))

  //b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
  def rectangleCurried(a: Double,b: Double): Double = a*b
  def testRectangleCurried(a: Double, b: Double): Double = rectangleCurried(a,b)
  println("Проверка ф-ии testRectangleCurried "+testRectangleCurried(3.4,5.1))

  // c) Напишите не карированную функцию для расчета площади прямоугольника.
  def rectangleUc(a: Double)(b: Double): Double = a*b
  def testRectangleUc(a: Double, b: Double): Double = rectangleUc(a)(b)
  println("Проверка ф-ии testRectangleCurried "+testRectangleUc(3.4,5.6))
}
