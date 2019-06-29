package code;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的
 */
public class Solution42 {
    public static void main(String[] args) {

    }
    //从两端开始向中间找
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res=new ArrayList<>();
        int i=0;
        int j=array.length-1;
        while (i<=j){
            int temp=array[i]+array[j];
            if (temp==sum){
                res.add(array[i]);
                res.add(array[j]);
                return res;
            }
            if (temp>sum){
                j--;
            }else {
                i++;
            }
        }
        return res;
    }
}
