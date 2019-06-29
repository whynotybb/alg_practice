package code;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution32 {
    public static void main(String[] args) {
       int[] a={3334,3,3333332};
        System.out.println(PrintMinNumber(a));
    }
    /**
     * {1,2,4,3,23}
     */
    public static String PrintMinNumber(int [] a) {
        StringBuilder res=new StringBuilder();
        for (int i = 1; i < a.length; i++) {
            int j=i;
            int temp=a[i];
            //将比a[i]大的元素后移一位
            while(j>0&&bigger(a[j-1],temp)){
                a[j]=a[j-1];
                j--;
            }
            a[j]=temp;
        }
        for (int i:a) {
            res.append(i);
        }
        return res.toString();
    }
    private static boolean bigger(int a,int b){
        String r1=""+a+b;
        String r2=""+b+a;
        return Long.valueOf(r1)>Long.valueOf(r2);
    }
}
