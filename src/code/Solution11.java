package code;

/*
* 二进制中1的个数
* */
public class Solution11 {
    public static void main(String[] args) {
       int res= NumberOf1(7);
        System.out.println(res);
    }
    public static int NumberOf1(int n) {
        int count=0;
        while (n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
}
