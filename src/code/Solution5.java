package code;

import java.util.Stack;

/**
 * 用两个栈实现队列的插入和移除操作
 */
public class Solution5 {
    public static void main(String[] args) {
        Solution5 solution5=new Solution5();
        solution5.push(1);
        solution5.push(2);
        solution5.push(3);
        solution5.push(4);

        System.out.println(solution5.pop());
        System.out.println(solution5.pop());
        solution5.push(5);
        solution5.push(6);
        System.out.println(solution5.pop());
        System.out.println(solution5.pop());
        System.out.println(solution5.pop());
    }
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //首先将元素压入栈1
    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        if (stack2.isEmpty()){
            //将stack1的元素压入栈2
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        return -1;
    }
}
