import scala.annotation.tailrec
// Примечание: напишите функции с хвостовой рекурсией

object Sequence extends App{

  /* a) Найдите последний элемент Seq.*/
  def lastElement[A](list: Seq[A]):Option[A] = {
    @tailrec
    def loop(eList: Seq[A]): Option[A] = eList.length match {
      case 1        => Some(eList.head)
      case _ => loop(eList.drop(1))
    }
    loop(list)
  }
  def testLastElement[A](seq: Seq[A]): Option[A] = lastElement(seq)
  println("Проверка ф-ии testLastElement "+testLastElement(Seq(1,2,4,6)))

  /* b) Объедините две Seqs (то есть Seq(1, 2) и Seq(3, 4) образуют Seq((1, 3), (2, 4))) - если Seq длиннее игнорируйте оставшиеся элементы.*/
  def zip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = {
    @tailrec
    def loop(result: Seq[(A, A)],a: Seq[A], b: Seq[A])(f:(Seq[A], Seq[A]) => Seq[A]): Seq[(A, A)] = f(a,b).size match {
      case 0        => result
      case _ => loop(result:+(a.head,b.head),a.drop(1),b.drop(1))(f)
    }
    loop(Nil,a,b)((a,b) => if (a.size<b.size) a else b)
  }
  def testZip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = zip(a,b)
  println("Проверка ф-ии testZip "+testZip(Seq(1,2,4,6),Seq(9,10,11,12,13)))

  /* c) Проверьте, выполняется ли условие для всех элементов в Seq. */
  def forAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = {
    @tailrec
    def loop(seq: Seq[A],result: Boolean)(cond: A => Boolean): Boolean = result match {
      case true        => seq.size match {
        case 0 => result
        case _ => loop(seq.drop(1),seq.dropRight(seq.size-1).forall(cond))(cond)
      }
      case _ => false
    }
    loop(seq,true)(cond)
  }
  def testForAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = forAll(seq)(cond)
  println("Проверка ф-ии testForAll "+testForAll(Seq(1,2,4,6))(i =>{i%2==0}))

  /* d) Проверьте, является ли Seq палиндромом */
  def palindrom[A](seq: Seq[A]): Boolean = {
    @tailrec
    def loop(seq: Seq[A],result: Boolean): Boolean = result match {
      case true        => seq.size match {
        case 0 => result
        case _ => loop(seq.drop(1).dropRight(1),seq.head==seq.last)
      }
      case _ => false
    }
    loop(seq,true)
  }
  def testPalindrom[A](seq: Seq[A]): Boolean = palindrom(seq)
  println("Проверка ф-ии testPalindrom "+testPalindrom(Seq(6,4,2,3,4,6)))

  /* e) Реализуйте flatMap используя foldLeft. */
  def flatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] =
    seq.foldLeft(List[B]())((curr, acc) => f(acc).foldLeft(curr)((inCurr, inAcc) => inAcc :: inCurr)).reverse
  def testFlatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] =  flatMap(seq)(f)
  println("Проверка ф-ии testFlatMap "+testFlatMap(Seq(1,2,3,4,5))(i => Seq(i,i+1)))

}
