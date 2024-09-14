//cpt1
public class Student {
    private String name;
    private Integer age;
    private static String school="K";

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.println( "Student{" +"name=" + this.name +", age=" + this.age + ", school=" + Student.school + '}');
    }

    public static void main(String[] args) {
        Student a=new Student("a",20);
        Student b = new Student("b", 14);
        a.print();
        b.print();
    }
}