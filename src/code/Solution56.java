package code;

import datastruct.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution56 {
    public static void main(String[] args) {

//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(4);
//        ListNode node6 = new ListNode(4);
//        ListNode node7 = new ListNode(5);
//        {1,1,2,3,3,4,5,5}
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next=node8;
//        {1,1,1,1,1,1,2}
        ListNode node = deleteDuplication(node1);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    //删除重复结点：p是重复结点之前的结点，c.next是重复结点之后的结点
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead==null) return null;
        ListNode p=null;
        ListNode c=pHead;
        while (c!=null){
            ListNode n=c.next;
            boolean needDelete=false;
            if (n!=null&&c.val==n.val)
                needDelete=true;
            if (!needDelete){
                p=c;
                c=n;
            }else {
                ListNode toBeDel=c;
                int value=c.val;
                while (toBeDel!=null&&toBeDel.val==value){
                    n=toBeDel.next;
                    toBeDel=n;
                }
                if (p==null)
                    pHead=n;
                else
                    p.next=n;
                c=n;
            }
        }
        return pHead;
    }
}
