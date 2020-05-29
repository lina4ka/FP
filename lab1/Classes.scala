  sealed trait Food

  case object Meat extends Food

  case object Vegetables extends Food

  case object Plants extends Food

  sealed trait Animal {
    val name: String
    val food: Food

    def eats(f: Food): Boolean = food == f
  }

  case class Mammals(name: String, food: Food) extends Animal

  case class Birds(name: String, food: Food) extends Animal

  case class Fishs(name: String, food: Food) extends Animal


  object Animal {
    val cat: Mammals = Mammals("cat", Meat)
    val goldfish: Fishs = Fishs("goldfish", Plants)
    val parrot: Birds = Birds("parrot", Vegetables)


    def knownAnimal(name: String): Boolean = {
      name match {
        case cat.name | parrot.name | goldfish.name => true;
        case _ => false;
      }
    }

    def apply(name: String): Option[Animal] = {
      name match {
        case cat.name => Some(cat);
        case parrot.name => Some(parrot);
        case goldfish.name => Some(goldfish);
        case _ => None;
      }
    }

  }

  object Classes extends App {
    println("Проверка ф-ии eats " + Animal("parrot").get.eats(Meat))
    println("Проверка ф-ии knownAnimal " + Animal.knownAnimal("goldfish"))
    println("Проверка ф-ии apply " + Animal.apply("dog"))
  }
