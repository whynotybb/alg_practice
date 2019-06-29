package code;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution37 {
    public static void main(String[] args) {
        Solution37 solution37=new Solution37();
        System.out.println(solution37.GetNumberOfK(new int[]{1,2,3,4,4,5,6,6,7},4));
    }
    //1,2,3,4,4,5,6,6,7
    public  int GetNumberOfK(int [] array , int k) {
        int res=1;
        //先利用二分法查找k的位置
        int left=0;
        int right=array.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (array[mid]==k) {
                int i=mid,j=mid;
                while (--i>=0&&array[i]==k){
                    res++;
                }
                while (++j<array.length&&array[j]==k)
                    res++;
                return res;
            }
            if (array[mid]>k){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return 0;
    }
}
