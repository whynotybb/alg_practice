package code;

import java.util.ArrayList;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Solution44 {
    public static void main(String[] args) {
        System.out.println(ReverseSentence("  "));
    }

    /**
     * 先反转整个句子，再反转每个单词
     */
    public static String ReverseSentence(String str) {
        if (str.trim().length()<=1){
            return str;
        }
        StringBuilder stringBuilder=new StringBuilder();
        String s1= reverse(str);
        String[] s1s=s1.split(" ");
        for (String s:s1s){
             stringBuilder.append(reverse(s)+" ");
        }
        String s= stringBuilder.toString();
        if(s.endsWith(" ")){
            return s.substring(0,str.length());
        }
        return stringBuilder.toString();
    }

    private static String reverse(String str) {
        char[] chars=new char[str.length()];
        int j=0;
        for (int i = str.length()-1; i>=0; i--) {
            chars[j++]=str.charAt(i);
        }
        return new String(chars);
    }
}
