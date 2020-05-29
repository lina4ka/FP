
import scala.collection.immutable.List
import scala.annotation.tailrec

object RecursiveFunctions extends App {

  /* a) Напишите функцию которая записывает в обратном порядке список:
   *        def reverse[A](list: List[A]): List[A]
   */
  def reverse[A](list: List[A]): List[A] = {
    @tailrec
    def loop(rList: List[A],eList: List[A]): List[A] = eList.length match {
      case 0         => rList
      case _ => loop(eList.head+:rList,eList.drop(1))
    }
    loop(List[A](),list)
  }
  def testReverse[A](list: List[A]): List[A] = reverse(list)
  println("Проверка ф-ии testReverse "+testReverse(List(1,2,3,4)))

  /* b) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def map[A, B](list: List[A])(f: A => B): List[B]
   */
  def map[A,B](list: List[A])(f: A=> B):List[B] = {
    @tailrec
    def loop(eList: List[A],rList: List[B],f: A=> B):List[B] = eList.length match {
      case 0         => rList
      case _ => loop(eList.drop(1),rList:+f(eList.head),f)

    }
    loop(list,List[B](),f)
  }
  def testMap[A, B](list: List[A], f: A => B): List[B] = map(list)(f)
  println("Проверка ф-ии testMap "+testMap(List(1,2,3,4),(i: Int) =>2*i))

  /* c) Напишите функцию, которая присоединяет один список к другому:
   *        def append[A](l: List[A], r: List[A]): List[A]
   */
  def append[A](l: List[A], r: List[A]): List[A] = {
    @tailrec
    def loop(l: List[A],r: List[A]):List[A] = l.length match {
      case 0         => r
      case _ => loop(l.drop(1),r:+l.head)
    }
    loop(l,r)
  }
  def testAppend[A](l: List[A], r: List[A]): List[A] = append(l,r)
  println("Проверка ф-ии testAppend "+testAppend(List(1,2,3,4),List(1,2,3,4)))
  /* d) Напишите функцию, которая применяет функцию к каждому значению списка:
   *        def flatMap[A, B](list: List[A])(f: A => List[B]): List[B]
   *
   *    она получает функцию, которая создает новый List[B] для каждого элемента типа A в
   *    списке. Поэтому вы создаете List[List[B]].
   */

  def flatMap[A, B](list: List[A])(f: A => List[B]): List[List[B]] ={
    @tailrec
    def loop(list: List[A],result: List[List[B]],f: A => List[B]):List[List[B]] = list.length match {
      case 0         => result
      case _ => loop(list.drop(1),result:+f(list.head),f)

    }
    loop(list,List[List[B]](),f)
  }
  def testFlatMap[A, B](list: List[A], f: A => List[B]): List[List[B]] = flatMap(list)(f)
  println("Проверка ф-ии testFlatMap "+testFlatMap(List(1,2,3,4),(i: Int) => List(2*i)))

  /* e) Вопрос: Возможно ли написать функцию с хвостовой рекурсией для `Tree`s? Если нет, почему? */
  //Нет, т.к при считывании\добавлении элементов необходимо сначало взять элемент и ,лишь после проверок, записать его, чего не позволяет хвостовая рекурсия
}
