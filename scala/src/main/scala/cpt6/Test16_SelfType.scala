package cpt6

/**
 * 特质自身类型
 */
object Test16_SelfType {
  def main(args: Array[String]): Unit = {
    val registerUser = new RegisterUser("kkk","1234")
    registerUser.insert()
  }

}

//用户类
class User(val name: String, val password: String)

//DB操作
trait UserDao {
  _: User =>  //特质自身类型(_代表this) 要使用User的属性又不想有继承关系->指定自身类型->外部插入User->实现依赖注入功能

  //插入数据到DB
  def insert(): Unit ={
    println(s"insert into db: ${name} ${this.password}")
  }
}

//注册用户
class RegisterUser(name: String, password: String) extends User(name, password) with UserDao