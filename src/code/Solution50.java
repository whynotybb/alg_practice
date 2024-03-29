package code;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Solution50 {
    public static void main(String[] args) {
       int[] a={};
       duplicate(a,7,new int[1]);
    }

    /**
     * 思路：从头开始扫描，如果发现数组中元素与下标不相等，就交换。
     */
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null||length<=0)
            return false;
        int i=0;
        //确保前面的元素是有序的
        while (i<length){
             while (numbers[i]!=i){
                if (numbers[i]==numbers[numbers[i]]){
                    duplication[0]=numbers[i];
                    return true;
                }
                swap(numbers,i,numbers[i]);
            }
            i++;
        }
        return false;
    }
    private static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
