package code;

import java.util.HashSet;
import java.util.Set;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class Solution49 {
    public static void main(String[] args) {
        System.out.println(StrToInt("1234"));
    }

    /**
     *   //0-9的ascii码:48,57
     */
    private static int StrToInt(String str) {
        int res=0;
        boolean neg=false;
        for (int i = 0; i < str.length(); i++) {
            int c=str.charAt(i);
            if (i==0){
                if (c=='-'){
                    neg=true;
                    continue;
                }else if (c=='+'){
                    continue;
                }
            }
            if (c<=57&&c>=48)
                res=res*10+(c-48);
            else
                return 0;
        }
        return neg?res*-1:res;
    }
}
