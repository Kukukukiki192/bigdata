//cpt5.Test10
public class TestRecursion {
    public static void main(String[] args) {
        //计算阶乘
        System.out.println(factorial(5));   //120
        System.out.println(fact(4));   //24

    }

    //1.循环
    public static int factorial(int n) {
        int mul=1;
        int i=0;
        while(++i<=n) {
            mul*=i;
        }
        return mul;
    }

    //2.递归
    public static int fact(int n) {
        //基准情形 0!=1
        if(n==0) return 1;
        return fact(n-1)*n;
    }

}
