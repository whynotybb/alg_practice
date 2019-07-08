package dp;

/**
 * 找零钱问题：有一个大小为n的数组，元素表示纸币的面额，问有多少种组合可以凑够aim
 */
public class Exchange {
    /**
     * @param a   给定的面额数组
     * @param n   a的长度
     * @param aim 总额度
     */
    public int exchange(int[] a, int n, int aim) {
        int[][] dp = new int[n][aim + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; a[0] * i <= aim; i++) {
            dp[0][a[0] * i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= aim; j++) {
                if (j >= a[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - a[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][aim];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4};
        Exchange exchange = new Exchange();
        System.out.println(exchange.exchange(a, 3, 3));
    }
}
