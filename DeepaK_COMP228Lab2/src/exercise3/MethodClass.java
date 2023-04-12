package exercise3;

public class MethodClass {
    public static void main(String[] args) {
        System.out.println(multiply(100,200));
        System.out.println(multiply(10000,200,220));
        System.out.println(multiply(100,200,240,400));
    }

    public static int multiply(int a, int b)
    {
        return a*b;
    }
    public static int multiply(int a, int b,int c)
    {
        return a*b*c;
    }
    public static int multiply(int a, int b,int c,int d)
    {
        return a*b*c*d;
    }

}
