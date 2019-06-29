package code;

import datastruct.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
* 从尾到头打印链表
* */
public class Solution3 {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(8);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(9);
        ListNode node5=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ArrayList<Integer> res= printListFromTailToHead(node1);
        for (Integer r:res){
            System.out.print(r+" ");
        }
    }
    //顺序访问链表，将值存入到栈中，然后再依次输出
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
         ArrayList<Integer> res=new ArrayList<>();
         if (listNode==null){
             return res;
         }
         List<Integer> stack=new ArrayList<>();
         while (listNode!=null){
             stack.add(listNode.val);
             listNode=listNode.next;
         }
         while (!stack.isEmpty()){
             int size=stack.size();
             res.add(stack.remove(size-1));
         }
         return res;
    }
}
