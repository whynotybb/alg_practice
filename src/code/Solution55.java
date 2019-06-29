package code;

import datastruct.ListNode;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Solution55 {
    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
//        ListNode listNode2=new ListNode(2);
//        ListNode listNode3=new ListNode(3);
//        ListNode listNode4=new ListNode(4);
//        ListNode listNode5=new ListNode(5);
//
//        listNode1.next=listNode2;
//        listNode2.next=listNode3;
//        listNode3.next=listNode4;
//        listNode4.next=listNode5;
//        listNode5.next=listNode2;

//        int size= getSizeOfRing(listNode1);
//        System.out.println(size);
        System.out.println("------------------");
        ListNode head= EntryNodeOfLoop(listNode1);
        System.out.println(head.val);
    }

    /**
     * 如果链表存在环，那么一定在尾部，因为每个链表只能指向它的下一个结点
     * 先求出环的长度，利用一快一慢两个指针
     */
    public static ListNode EntryNodeOfLoop(ListNode pHead){
        int size= getSizeOfRing(pHead);
        if (size==0) return null;
        //等于求解倒数第size个结点,用两个指针
        ListNode p=pHead;
        ListNode q=pHead;
        //让p想走size步
        while (size!=0){
            p=p.next;
            size--;
        }
        //p,q一起走
        while (p!=q){
            p=p.next;
            q=q.next;
        }
        return p;
    }
    private static int getSizeOfRing(ListNode pHead){
        if (pHead==null||pHead.next==null)
            return 0;
        ListNode p=pHead;
        ListNode q=pHead.next;
        while (p!=q){
            p=p.next.next;
            q=q.next;
        }
        int res=1;
        q=q.next;
        while (q!=p){
            res++;
            q=q.next;
        }
        return res;
    }
}
