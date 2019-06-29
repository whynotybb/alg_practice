package code;
import datastruct.*;

import java.util.ArrayList;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8)中，
 * 按结点数值大小顺序第三小结点的值为4。
 */
public class Solution62 {
    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(8);
        TreeNode treeNode2=new TreeNode(6);
        TreeNode treeNode3=new TreeNode(10);
        TreeNode treeNode4=new TreeNode(5);
        TreeNode treeNode5=new TreeNode(7);
        TreeNode treeNode6=new TreeNode(9);
        TreeNode treeNode7=new TreeNode(11);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.left=treeNode6;
        treeNode3.right=treeNode7;

        TreeNode node= KthNode(treeNode1,3);
        System.out.println(node.val);
    }
    //中序遍历的第k个结点
    static TreeNode KthNode(TreeNode pRoot, int k) {
        TreeNode res=null;
        ArrayList<TreeNode> stack=new ArrayList<>();
        TreeNode node=pRoot;
        while (!stack.isEmpty()||node!=null){
           while (node!=null){
               stack.add(node);
               node=node.left;
           }
           if (!stack.isEmpty()){
               int index=stack.size()-1;
               node=stack.remove(index);
               if (--k==0) {
                   return node;
               }
               node=node.right;
           }
       }
       return res;
    }
}
