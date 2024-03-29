package code;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=“abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class Solution43 {
    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcXYZdef",3));
    }
    //将字符串分为前n位和后n位
    private static String LeftRotateString(String str,int n) {
        String sub1=str.substring(0,n);
        String sub2=str.substring(n,str.length());
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(sub2);
        stringBuilder.append(sub1);
        return stringBuilder.toString();
    }
}
