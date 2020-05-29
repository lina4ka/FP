object RecursiveData extends App{

  // a) Реализуйте функцию, определяющую является ли пустым `List[Int]`.


  def listIntEmpty(list: List[Int]):Boolean = list.isEmpty
  def testListIntEmpty(list: List[Int]): Boolean = listIntEmpty(list)
  println("Проверка ф-ии testListIntEmpty "+testListIntEmpty(List(1,2)))
  println("Проверка ф-ии testListIntEmpty "+testListIntEmpty(List()))
  // b) Реализуйте функцию, которая получает head `List[Int]`или возвращает -1 в случае если он пустой.

  def listIntHead(list: List[Int]): Int = list.size match {
    case 0 => -1
    case _ => list.head
  }
  def testListIntHead(list: List[Int]): Int = listIntHead(list)
  println("Проверка ф-ии testListIntHead "+testListIntHead(List(1,2)))
  println("Проверка ф-ии testListIntHead "+testListIntHead(List()))
  // c) Можно ли изменить `List[A]` так чтобы гарантировать что он не является пустым?
  def notEmptyListHead[A](list: List[A])(f: A=>A): List[A] = {
    if (list.nonEmpty) list.map(f(_)) else list:+f(5.asInstanceOf[A])
  }
  def testNotEmptyListHead[A] (list: List[A])(f: A=>A): List[A] =notEmptyListHead(list)(f)
  println("Проверка ф-ии testNotEmptyListHead "+testNotEmptyListHead(List(1,2))((i :Int)=>2*i))
  println("Проверка ф-ии testNotEmptyListHead "+testNotEmptyListHead(List())((i :Int)=>2*i))
  /* d) Реализуйте универсальное дерево (Tree) которое хранит значения в виде листьев и состоит из:
   *      node - левое и правое дерево (Tree)
   *      leaf - переменная типа A
   */
  class Tree[A](ltNode: Tree[A], rNode: Tree[A], value: A)

}
