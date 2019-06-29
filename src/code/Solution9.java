package code;

/**
 * 变态跳台阶：青蛙每次可以跳1阶，也可以跳2阶，..问跳上n阶共有多少中方法
 */
public class Solution9 {
    public static void main(String[] args) {
        Solution9 solution9=new Solution9();
        System.out.println(solution9.JumpFloorII(2));
    }
    //2^(n-1)
    public int JumpFloorII(int target) {
        if (target<=0) return 0;
        return 1<<(target-1);
    }
}
