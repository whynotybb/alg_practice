package code;

import datastruct.ListNode;

/**
 * 反转链表，返回反转后链表的头指针，即链表的尾结点
 */
public class Solution15 {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
//        ListNode node2=new ListNode(8);
//        ListNode node3=new ListNode(2);
//        ListNode node4=new ListNode(9);
//        ListNode node5=new ListNode(4);
//        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
        ListNode newHead= ReverseList(node1);
        while (newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }
    }
    public static ListNode ReverseList(ListNode head) {
        ListNode node=head;
        ListNode nodeP=null;
        ListNode nodeN;
        while (node!=null){
            //将node.next记录下来
            nodeN=node.next;
            node.next=nodeP;
            nodeP=node;
            node=nodeN;
        }
        return nodeP;
    }
}
