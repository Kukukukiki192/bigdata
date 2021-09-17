//cpt3
public class TestOperator {
    public static void main(String[] args) {
        //关系/比较运算符
        String s1 = "hello";
        String s2 = new String("hello");
        System.out.println(s1==s2);         //比较地址
        System.out.println(s1.equals(s2));  //比较内容

        //赋值运算符
        byte b=1;
        b=(byte)(b+1);
        b+=1;   //默认会做强转
        System.out.println(b);

        int x=1;
        x=x++;  //1.t=x t为1 2.x++ x为2 3.x=t 2被赋值为1
        System.out.println(x); //1
    }
}
