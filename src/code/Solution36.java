package code;

import datastruct.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Solution36 {
    public static void main(String[] args) {
//        ListNode node1=new ListNode(1);
//        ListNode node2=new ListNode(3);
//        ListNode node3=new ListNode(5);
//        ListNode node4=new ListNode(7);
//        ListNode node5=new ListNode(9);
//        ListNode node6=new ListNode(10);
//        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
//        node6.next=node4;
//        {1,2,3,4},{5,6,7},
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        ListNode node7=new ListNode(7);
        node5.next=node6;
        node6.next=node7;
        ListNode node= FindFirstCommonNode(node1,node5);
        System.out.println(node.val);
    }
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //1，先遍历两个链表求出其长度
        ListNode node=pHead1;
        int l1= getLengthOfListNode(node);
        node=pHead2;
        int l2=getLengthOfListNode(node);
        int dif=l1-l2;
        //让其中一个先走dif步
        node = dif > 0 ? pHead1 : pHead2;
        while (dif != 0 && node != null) {
            if (dif < 0) dif++;
            else dif--;
            node = node.next;
        }
        //然后让两个一起走，边走边判断结点是否相等
        ListNode node1=pHead1!=node?pHead2:pHead1;
        while (node!=null&&node1!=null&&node!=node1){
            node=node.next;
            node1=node1.next;
        }
        return node;
    }
    private static int getLengthOfListNode(ListNode node){
        int count=0;
        while (node!=null){
            node=node.next;
            count++;
        }
        return count;
    }
}
