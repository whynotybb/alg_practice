package code;

/**
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住
 */
public class Solution30 {
    public static void main(String[] args) {
       int[] a={-2,-8,-1,-5,-9};
       int r= FindGreatestSumOfSubArray(a);
        System.out.println(r);
    }

    /**
     *  sum: 如果当前连续数字和>0,则要继续追加
     *  否则，要重新开始累加
     */
//    6,-3,-2,7,-15,1,2,2
    public static int FindGreatestSumOfSubArray(int[] array) {
        int sum=0;
        int cSum=-Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
             if (sum>=0){
                 sum+=array[i];
             }
             if (sum<0){
                 sum=array[i];
             }
             if (sum>cSum){
                 cSum=sum;
             }
        }
        return cSum;
    }
}
