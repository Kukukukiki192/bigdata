//cpt6.Test8
public class TestDynamicBind {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Person teacher1 = new Teacher();
        System.out.println(teacher.name);
        teacher.hello();
        System.out.println(teacher1.name);  //静态绑定属性
        teacher1.hello();   //动态绑定方法
    }
}

class Person {
    public String name = "person";
    public void hello() {
        System.out.println("hello person");
    }
}

class Teacher extends Person {
    public String name = "teacher";

    @Override
    public void hello() {
        System.out.println("hello teacher");
    }
}