package code;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，
 * 序列间按照开始数字从小到大的顺序.至少包括两个数
 */
public class Solution41 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res= FindContinuousSequence(15);
        for (ArrayList<Integer> r:res){
            for (Integer r1:r){
                System.out.print(r1+" ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (sum<=0){
            return res;
        }
        int p=1,q=1;
        int tSum=q;
        while (2*p<sum){
            ArrayList<Integer> temp=new ArrayList<>();
            while (tSum<sum){
                tSum+=++q;
            }
            while (tSum>sum){
                tSum-=p++;
            }
            if (tSum==sum&&p!=q) {
                int t = p;
                while (t <= q) {
                    temp.add(t++);
                }
                res.add(temp);
                q++;
                tSum+=q;
            }
        }
        return res;
    }
}
