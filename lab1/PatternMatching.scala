object PatternMatching extends App {

  sealed trait Hand
  case object Rock    extends Hand
  case object Paper   extends Hand
  case object Scissor extends Hand

  sealed trait Result
  case object Win  extends Result
  case object Lose extends Result
  case object Draw extends Result

  sealed trait Food
  case object Meat       extends Food
  case object Vegetables extends Food
  case object Plants     extends Food

  sealed trait Animal {

    val name: String
    var food: Food
  }
  case class Mammal(name: String,var food: Food, weight: Int) extends Animal
  case class Fish(name: String,var food: Food)                extends Animal
  case class Bird(name: String,var food: Food)                extends Animal



  /* a) Напишите функцию, которая ставит в соответствие числу строку слудеющим образом:
   * Если:
   *     1 => "it is one"
   *     2 => "it is two"
   *     3 => "it is three"
   *     иначе => "what's that"
   */
  def intToString(value: Int):String = value match {
    case 1 => "it is one"
    case 2 => "it is two"
    case 3 => "it is three"
    case _ =>  "what's that"
  }
  def testIntToString(value: Int): String = intToString(value)
  println("Проверка ф-ии testIntToString "+testIntToString(1))
  println("Проверка ф-ии testIntToString "+testIntToString(2))
  println("Проверка ф-ии testIntToString "+testIntToString(3))
  println("Проверка ф-ии testIntToString "+testIntToString(4))

  /* b) Напишите функцию которая возвращает true если переменная `value` принимает значение:
   *     "max" или "Max
   *     "moritz" или "Moritz"
   */
  def isMaxAndMoritz(str: String): Boolean = str.toLowerCase match {
    case "moritz"|"max"=> true
    case _ => false
  }
  def testIsMaxAndMoritz(value: String): Boolean = isMaxAndMoritz(value)
  println("Проверка ф-ии testIntToString "+isMaxAndMoritz("Moritz"))
  println("Проверка ф-ии testIntToString "+isMaxAndMoritz("max"))
  println("Проверка ф-ии testIntToString "+isMaxAndMoritz("Pchelka"))

  // c) Напишите функцию проверки является ли `value` четным
  def isEven(value: Int): Boolean = value%2==0
  def testIsEven(value: Int): Boolean = isEven(value)

  println("Проверка ф-ии testIsEven "+testIsEven(4))
  println("Проверка ф-ии testIsEven "+testIsEven(3))

  /* d) Напишите функцию, моделирующую игру в Камень ножницы бумага
   *     1. камень побеждает ножницы
   *     2. ножницы побеждают бумагу
   *     3. бумага побеждает камень
   *    Выиграет ли игрок `a`?
   */
  def winsA(a: Hand, b:Hand): Result = a match {
    case Rock=>b match {
      case Rock => Draw
      case Paper => Lose
      case Scissor => Win
    }
    case Paper=>b match {
      case Rock => Win
      case Paper => Draw
      case Scissor => Lose
    }
    case Scissor=> b match {
      case Rock => Lose
      case Paper => Win
      case Scissor => Draw
    }
  }
  def testWinsA(a: Hand, b: Hand): Result = winsA(a,b)

  println("Проверка ф-ии testWinsA "+testWinsA(Rock,Rock))
  println("Проверка ф-ии testWinsA "+testWinsA(Rock,Paper))
  println("Проверка ф-ии testWinsA "+testWinsA(Rock,Scissor))

  // e) Верните вес (weight: Int) объекта Mammal, иначе верните -1.
  def extractMammalWeight(animal: Animal):Int = animal match {
    case mammal: Mammal => mammal.weight
    case _ => -1
  }
  def testExtractMammalWeight(animal: Animal): Int = extractMammalWeight(animal)
  println("Проверка ф-ии testExtractMammalWeight "+testExtractMammalWeight(Mammal("name",Meat,4)))
  println("Проверка ф-ии testExtractMammalWeight "+testExtractMammalWeight(Bird("bird",Plants)))

  // f) Измените поле еда объектов классов Fishes и Birds на Plants, класс Mammels оставьте неизмененным.

  def updateFood(animal: Animal): Animal = animal match {
    case fish: Fish => fish.food = Plants; fish
    case bird: Bird=> bird.food = Plants; bird
    case mammal: Mammal => mammal
  }
  def testUpdateFood(animal: Animal): Animal = updateFood(animal)

  println("Проверка ф-ии testUpdateFood "+testUpdateFood(Mammal("name",Meat,4)))
  println("Проверка ф-ии testUpdateFood "+testUpdateFood(Bird("bird",Vegetables)))
  println("Проверка ф-ии testUpdateFood "+testUpdateFood(Fish("fish",Meat)))
}
