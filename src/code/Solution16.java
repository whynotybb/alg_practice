package code;

import datastruct.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution16 {
    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(5);
        ListNode node14 = new ListNode(6);

        node11.next = node12;
        node12.next = node13;
        node13.next = node14;

        ListNode node21=new ListNode(2);
        ListNode node22=new ListNode(4);
        ListNode node23=new ListNode(8);
        ListNode node24=new ListNode(9);
        node21.next=node22;
        node22.next=node23;
        node23.next=node24;

        ListNode node = Merge(node11, node21);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    /**
     * 归并排序的思想：
     * eg:1) 1,3,5,6
     * 2)2,4,8,9
     */
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        ListNode res ;
        ListNode c ;
        //判断合并后首节点
        if (list1.val <= list2.val) {
            res = list1;
            c=list1;
            list1 = list1.next;
        } else {
            res = list2;
            c=list2;
            list2 = list2.next;
        }
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                c.next = list1;
                c = list1;
                list1 = list1.next;
            } else {
                c.next = list2;
                c = list2;
                list2 = list2.next;
            }
        }
//处理一个队列已空，但是另一个队列还不空，则将所有元素都追加到后面即可
        if (list1 != null) {
            c.next = list1;
        }
        if (list2 != null) {
            c.next = list2;
        }
        return res;
    }
}
