package code;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Solution48 {
    public static void main(String[] args) {
        System.out.println(sum(5,7));
    }
    //&:查看两个数字的哪些位均为1，这些位需要进位，结果需要左移一位。
    //^:查看哪些位只有一个1，这些位不需要进位。
    public static int sum(int a,int b){
        while (b!=0){
             int temp=a^b;//不考虑进位的结果
             b=(a&b)<<1;//进位
             a=temp;
        }
        return a;
    }
}
