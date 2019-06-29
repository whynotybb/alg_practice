package code;

import datastruct.ListNode;

/**
 * 求链表的倒数第k个结点
 */
public class Solution14 {
    public static void main(String[] args) {
//        6,{1,2,3,4,5}
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        FindKthToTail(node1,6);
    }

    /**
     * 利用两个指针，一个先走k步，另一个再开始走
     */
    public static ListNode FindKthToTail(ListNode head,int k) {
        if (head==null||k<=0) return null;
        ListNode p=head;
         ListNode q=head;
         while (p!=null&&k--!=0){
             p=p.next;
         }
         //k>队列的长度
         if (p==null&&k>0) return null;
         while (p!=null){
             q=q.next;
             p=p.next;
         }
         return q;
    }
}
