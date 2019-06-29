package code;

/**
 * 斐波那契数列
 */
public class Solution7 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
    }
    public static int Fibonacci(int n) {
        int f = 0, g = 1;
        while(n--!=0) {
            g += f;
            f = g - f;//f为之前的g
        }
        return f;
    }
}
