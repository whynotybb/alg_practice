package code;

import sun.reflect.generics.tree.Tree;

/**
 * 中序遍历的下一个结点
 */
public class Solution57 {
    static class TreeLinkNode{
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;//指向父节点

        public TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeLinkNode node1=new TreeLinkNode(5);
        TreeLinkNode node2=new TreeLinkNode(3);
        TreeLinkNode node3=new TreeLinkNode(7);
        TreeLinkNode node4=new TreeLinkNode(2);
        TreeLinkNode node5=new TreeLinkNode(4);
        TreeLinkNode node6=new TreeLinkNode(6);
        TreeLinkNode node7=new TreeLinkNode(8);
        node1.left=node2;
        node1.right=node3;
        node2.next=node1;
        node3.next=node1;
        node2.left=node4;
        node2.right=node5;
        node5.next=node2;
        node4.next=node2;
        node3.left=node6;
        node3.right=node7;
        node7.next=node3;
        node6.next=node3;

        TreeLinkNode node= nextNodeInOrder(node5);
        System.out.println(node.val);
    }
    public static TreeLinkNode nextNodeInOrder(TreeLinkNode node){
        //如果有右子结点，直接返回右子结点中最左的
        if (node==null) return null;
        if (node.right!=null){
            TreeLinkNode current= node.right;
            TreeLinkNode parent=current;
            while (current!=null){
                parent=current;
                current=current.left;
            }
            return parent;
        }
        //如果是左子结点，则返回父节点
        if (node.next!=null&&node.next.left==node){
            return node.next;
        }
        //如果是右子结点，则返回包含此结点的左子树的根结点
        if (node.next!=null&&node.next.right==node){
            TreeLinkNode current= node.next;
            while (current.next!=null&&current.next.right==current){
                current=current.next;
            }
            return current.next;
        }
        return null;
    }
}
