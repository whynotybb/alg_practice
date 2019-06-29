package code;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution13 {
    public static void main(String[] args) {
       int[] a={1,2,3,4,5,6,7};
       reOrderArray(a);
       for(int a1:a){
           System.out.print(a1+" ");
       }
    }
    //插入排序:遇到奇数插入到偶数之前
    public static void reOrderArray(int [] a) {
        for (int i=1;i<a.length;i++){
            if ((a[i]&1)==1){
                int j=i;
                int temp=a[i];
                while (--j>=0&&(a[j]&1)==0){
                    //将元素a[j]后移
                    a[j+1]=a[j];
                }
                a[j+1]=temp;
            }
        }
    }
}
