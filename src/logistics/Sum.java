package logistics;

/**
 * 不用加减乘除做加法
 */

public class Sum {
    public static void main(String[] args) {
        System.out.println(new Sum().get(5,7));
    }
    private int get(int num1,int num2){
        //一直加到num2为0，直接返回num1
        while (num2!=0) {
            int temp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = temp;
        }
        return num1;
    }
}
