package code;

import java.util.ArrayList;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class Solution54 {
    private int[] a=new int[128];
    private ArrayList<Character> queue=new ArrayList<>();
    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        solution54.Insert('G');
        solution54.Insert('o');
        solution54.Insert('o');
        solution54.Insert('G');
        solution54.Insert('l');
        solution54.Insert('e');
        System.out.println(solution54.FirstAppearingOnce());
    }
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (a[ch]==0){
            queue.add(ch);
        }
        a[ch]+=1;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (!queue.isEmpty()){
            char c1= queue.get(0);
            if (a[c1]==1){
                return c1;
            }
            else
                queue.remove(0);
        }
        return '#';
    }
}
