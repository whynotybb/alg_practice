package code;

import datastruct.ListNode;

/**
 * 有n个小朋友围成一大圈，报数m，第m-1个小朋友出圈，求最后剩下的小朋友
 */
public class Solution46 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
//        ListNode head= solution46.createRingList(10);
        System.out.println(solution46.LastRemaining_Solution(6,7));
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n<=0||m<=0) return -1;
//         1,构建长度为n的环形链表
        ListNode head = createRingList(n);
        ListNode last=head;
        //2，每次走m步
        while (head.next.val!=head.val) {
            int t=m;
            while (t > 1) {
                last = head;
                head = head.next;
                t--;
            }
            //3，将head从环形链表中移除
            last.next = head.next;
            head=head.next;//从下一结点开始计数
        }
        return head.val;
    }

    private ListNode createRingList(int n) {
        ListNode head = null;
        ListNode last = null;
        for (int i = 0; i < n; i++) {
            ListNode listNode = new ListNode(i);
            if (i != 0) {
                last.next = listNode;
            } else {
                head = listNode;
            }
            last = listNode;
        }
        last.next = head;
        return head;
    }
}
