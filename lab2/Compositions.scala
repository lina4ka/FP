object Compositions extends App{

  // a) Используйте данные функции. Вы можете реализовать свое решение прямо в тестовой функции.
  // Нельзя менять сигнатуры

  def testCompose[A, B, C, D](f: A => B)
                             (g: B => C)
                             (h: C => D): A => D = f andThen g andThen h
  println("Проверка ф-ии testCompose "+testCompose((i:Int)=>2*i)((i:Int) =>if (i%2==0) i+1 else i)((i:Int) => i+3)(4))


  // b) Напишите функции с использованием `map` и `flatMap`. Вы можете реализовать свое решение прямо в тестовой функции.
  // Нельзя менять сигнатуры

  def testMapFlatMap[A, B, C, D](f: A => Option[B])
                                (g: B => Option[C])
                                (h: C => D): Option[A] => Option[D] = _.flatMap(f).flatMap(g).map(h)

  println("Проверка ф-ии testMapFlatMap "+testMapFlatMap((i:Int)=> if (i%2==0) Some(i+1) else Some(i))((i:Int)=>Some(5*i))((i:Int)=>i+3)(Some(5)))


  // c) Напишите функцию используя for. Вы можете реализовать свое решение прямо в тестовой функции.
  // Нельзя менять сигнатуры

  def testForComprehension[A, B, C, D](f: A => Option[B])
                                      (g: B => Option[C])
                                      (h: C => D): Option[A] => Option[D] = for {res <- _
                                                                                 res <- f(res)
                                                                                 res <- g(res) } yield h(res)
  println("Проверка ф-ии testForComprehension "+testForComprehension((i:Int)=> if (i%2==0) Some(i+1) else Some(i))((i:Int)=>Some(5*i))((i:Int)=>i+3)(Some(5)))
}
