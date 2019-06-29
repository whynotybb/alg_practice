package code;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class Solution34 {
    public static void main(String[] args) {
       int[] a={1,2,3,2,4,3};
       int[] a1=new int[1];
       int[] a2=new int[1];
       FindNumsAppearOnce(a,a1,a2);
       System.out.println(a1[0]+","+a2[0]);
    }
    /**
     * {1,1,2,3,2,4,3}
     */
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        //将所有数字进行异或的结果就是两个出现一次的进行异或操作的结果
        int xor=0;
        for (int i = 0; i < array.length; i++) {
            xor^=array[i];
        }
        // 如果异或后的结果是1，说明有一个数字在该位上为0，另一个为1。
        int index=0;
        while ((xor&1)==0){
            xor= xor>>1;
            index++;
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i]&(1<<index))==0){
                num1[0]^=array[i];
            }else {
                num2[0]^=array[i];
            }
        }
    }
}
