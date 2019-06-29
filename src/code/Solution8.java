package code;

/**
 * 跳台阶：青蛙每可以跳上1级台阶，也可以跳上两级台阶，问跳上n级台阶有多少种方法
 */
public class Solution8 {
    public static void main(String[] args) {
        Solution8 solution8=new Solution8();
        System.out.println(solution8.JumpFloor(2));
    }
    public int JumpFloor(int target) {
        if (target<=0) return 0;
        int[] a=new int[target+1];
       int i=1;
       a[0]=1;
       a[1]=1;
       while (i<target){
           i++;
           a[i]=a[i-1]+a[i-2];
       }
       return a[target];
    }
}
