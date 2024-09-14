/** 包对象
 * 文件名默认 package.scala
 * 包对象名称和当前包名一致 cpt6
 * 对象成员是对应包下所有class和object的共享变量,可被直接访问
 */
package object cpt6 {
  //定义当前包共享的属性和方法
  var commonValue = "公共变量"
  def commonMethod(): Unit = {
    println("公共方法")
  }
}
