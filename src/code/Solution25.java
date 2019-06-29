package code;

import datastruct.RandomListNode;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution25 {
    public static void main(String[] args) {
       RandomListNode node1=new RandomListNode(1);
       RandomListNode node2=new RandomListNode(2);
       RandomListNode node3=new RandomListNode(4);
       RandomListNode node4=new RandomListNode(6);
       node1.next=node2;
       node2.next=node3;
       node3.next=node4;

       node2.random=node4;
       node4.random=node3;

       RandomListNode node= Clone(node1);
       while (node!=null){
           System.out.println(node.label);
           node=node.next;
       }
    }
    public static RandomListNode Clone(RandomListNode pHead){
        //复制每个链表，将其插入原结点的后面
        RandomListNode head=pHead;
        while (head!=null){
            RandomListNode newNode=new RandomListNode(head.label);
            RandomListNode nodeCopy=head.next;
            //插入newNode
            head.next=newNode;
            newNode.next=nodeCopy;
            head=nodeCopy;
        }
        //2 复制random
        head=pHead;
        while (head!=null){
            if (head.random!=null){
                head.next.random=head.random.next;
            }
            head=head.next.next;
        }
        //3 将奇数链表和偶数链表拆分
        //1->1'->2->2'->3->3'
        head =pHead.next;
        while(head.next!=null){
            head.next=head.next.next;
            head=head.next;
        }
        //aa'b'c'-需要删除头结点
        RandomListNode res=pHead.next;
        pHead.next=null;
        return res;
    }
}
