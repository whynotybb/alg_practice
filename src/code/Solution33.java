package code;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Solution33 {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(10));
    }
    //{2,3,4,5,6,8,9,10}
    public static int GetUglyNumber_Solution(int index) {
       if (index<=0) return 0;
       int p2=0,p3=0,p5=0;
       int[] uglys=new int[index];
       uglys[0]=1;
       int current=1;
       while (current<index){
           //寻找最小值
           int m2= uglys[p2]*2;
           int m3= uglys[p3]*3;
           int m5=uglys[p5]*5;
           int min=min(m2,m3,m5);
           uglys[current]=min;
           if (min==m2) p2++;
           if (min==m3) p3++;
           if (min==m5) p5++;
           current++;
       }
       return uglys[current-1];
    }
    private static int min(int a,int b,int c){
        int min=a<b?a:b;
        return min<c?min:c;
    }
}
