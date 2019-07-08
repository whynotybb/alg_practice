package dp;

/**
 * 求字符串的公共子序列的长度
 */
public class LCS {
    public static void main(String[] args) {
        String a="loveaddjaid";
        String b="hhxiloveyou";
        LCS lcs=new LCS();
        System.out.println(lcs.lcs(a,a.length(),b,b.length()));
    }
    public int lcs(String a,int n,String b,int m){
        int[][] dp=new int[n][m];
        //init
        for (int i=0;i<n;i++){
            if (a.charAt(i)==b.charAt(0)){
                dp[i][0]=1;
                for (int j=i+1;j<n;j++){
                    dp[j][0]=1;
                }
                break;
            }
        }
        for (int j=0;j<n;j++){
            if (a.charAt(0)==b.charAt(j)){
                dp[0][j]=1;
                for (int i=j+1;j<m;j++){
                    dp[0][i]=1;
                }
                break;
            }
        }
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
               if (a.charAt(i)==b.charAt(j)){
                   dp[i][j]=max(dp[i-1][j-1]+1,dp[i][j-1],dp[i-1][j]);
               }else {
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }
            }
        }
        return dp[n-1][m-1];
    }
    private int max(int a,int b,int c){
        int max=a>b?a:b;
        return max>c?max:c;
    }
}
