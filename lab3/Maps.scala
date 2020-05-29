object Maps extends App{

  case class User(name: String, age: Int)

  /* a) В данной Seq[User] сгруппируйте пользователей по имени (`groupBy`) и вычислите средний возраст: `name -> averageAge`
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру. */
  def testGroupUsers(users: Seq[User]): Map[String, Int] = users.groupBy(_.name).map(i => (i._1, i._2.foldLeft(0)(_ + _.age) / i._2.length))
  println("Проверка ф-ии testGroupUsers "+testGroupUsers(Seq(User("name",9),User("name",45),User("name2",3),User("name2",12))))
  /* b) Дана `Map[String, User]` состоящая из имен пользователей `User`, сколько имен пользователей, содержащихся в Map, содержат подстроку "Adam"?
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру. */
  def testNumberFrodos(map: Map[String, User]): Int = {var i = 0; map.keys.foreach( c => if(map(c).name.indexOf("Adam") != -1) i = i+1); i}
  println("Проверка ф-ии testNumberFrodos "+testNumberFrodos(Map(("a",User("name1",12)),("b",User("Adam",23)),("c",User("Adam",15)),("d",User("OtherName",43)),("e",User("notAdam",12)),("f",User("OtherName2",10)))))

  /* c) Удалите всех пользователей возраст которых менее 35 лет.
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру. */
  def testUnderaged(map: Map[String, User]): Map[String, User] = {
    var resultMap: Map[String, User] = Map()
    map.keys.foreach(i => if (map(i).age >= 35) resultMap += i->User(map(i).name,map(i).age))
    resultMap
  }
  println("Проверка ф-ии testNumberFrodos "+testUnderaged(Map(("a",User("name1",12)),("b",User("Adam",23)),("c",User("Adam",15)),("d",User("OtherName",43)),("e",User("notAdam",12)),("f",User("OtherName2",10)))))

}
