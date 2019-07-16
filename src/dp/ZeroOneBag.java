package dp;

import java.util.List;

/**
 * 有N 件物品和一个容量为V 的背包。放入第i 件物品耗费的容量是vi，得到的价值是Wi。
 * 求解将哪些物品装入背包可使价值总和最大。
 */
public class ZeroOneBag {
    public static void main(String[] args) {
        int[] v = {2, 2, 3, 4, 3};
        int[] w = {2, 2, 2, 2, 2};
        ZeroOneBag zeroOneBag = new ZeroOneBag();
        zeroOneBag.bag(v, w, 7);
    }

    /**
     * 重量不超过W的情况下实现价值最大化
     *
     * @param v 物品价值数组
     * @param w 物品重量数组
     * @param W 最大容量
     */
    private void bag(int[] v, int[] w, int W) {
        int SIZE = v.length;
        int dp[][] = new int[SIZE+1][W+1];
//        init dp[0]
        for (int i=0;i<=W;i++){
            dp[0][i]=0;
        }
        for (int i=0;i<=SIZE;i++){
            dp[i][0]=0;
        }
        for (int i = 1; i <=SIZE; i++) {
            for (int j=1;j<=W;j++){
                if (j>=w[i-1]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i-1]]+v[i-1]);
                }
            }
        }
        System.out.println("------------------");
        for (int[] d1:dp){
            for (int d:d1){
                System.out.print(d+",");
            }
            System.out.println();
        }
        System.out.println("------------------");
        //回溯：寻找加入背包的物品
        int j=W;
        for (int i=SIZE;i>0;i--){
            if (dp[i][j]>dp[i-1][j]){
                System.out.print(i+",");
                j=j-w[i-1];
                if (j<=0){
                    break;
                }
            }
        }
    }
}
