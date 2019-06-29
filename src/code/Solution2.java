package code;

/**
 * 替换字符串中的空格
 *      * 将一个字符串中的每个空格替换成“%20”。
 *      * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution2 {
    public static void main(String[] args) {
        String res= replaceSpace(new StringBuffer("Hello world"));
        System.out.println(res);
    }

    /**
     * 从后往前移动，不需要移动元素
     */
    public static String replaceSpace(StringBuffer str) {
        String in= str.toString();
        int spaceCount=0;
        for (int i = 0; i <in.length(); i++) {
            if (in.charAt(i)==32)
                spaceCount++;
        }
        //计算插入空格后的字符串长度
        int newLength=str.length()+2*spaceCount;
        char[] chars=new char[newLength];
        //维护两个指针
        int oldPointer=in.length()-1;
        int newPointer=newLength-1;
        while (oldPointer>=0&&newPointer>oldPointer){
            if (in.charAt(oldPointer)==32){
                chars[newPointer--]='0';
                chars[newPointer--]='2';
                chars[newPointer--]='%';
            }else {
                chars[newPointer--]=in.charAt(oldPointer);
            }
            oldPointer--;
        }
        //将oldPointer前的字符直接拷贝到chars
        while (oldPointer>=0){
            chars[newPointer--]=in.charAt(oldPointer);
            oldPointer--;
        }
        return new String(chars);
    }
}
