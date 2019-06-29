package code;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Solution21 {
    public static void main(String[] args) {
         int[] a={1,2,3,4,5};
         int[] b={4,5,3,1,2};
        System.out.println(IsPopOrder(a,b));
    }
    //两个指针分别指向a和b
    //如果插入队列中的元素不等于栈顶元素，就一直插入
    // 如果相等，就移除
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<>();
        int l= pushA.length;
        int i=0,j=0;
        stack.push(pushA[i]);
        for (j=0;j<l;j++) {
            while (popA[j] != stack.peek()) {
                if (++i>=l)
                    return false;
                stack.push(pushA[i]);
            }
            stack.pop();

        }
        return true;
    }
}
