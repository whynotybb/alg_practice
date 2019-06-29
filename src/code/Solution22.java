package code;

import datastruct.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树的层次遍历
 */
public class Solution22 {
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

        ArrayList<Integer> res= PrintFromTopToBottom(treeNode1);
        for (Integer r:res){
            System.out.print(r+" ");
        }
    }
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null) return res;
         ArrayList<TreeNode> stack=new ArrayList<>();
         stack.add(root);
         while (!stack.isEmpty()){
             //每次访问一层，访问上一层的同时，将下一层加入到stack
             int size=stack.size();
             for (int i=0;i<size;i++){
                 TreeNode node= stack.remove(0);
                 res.add(node.val);
                 if (node.left!=null){
                     stack.add(node.left);
                 }
                 if (node.right!=null){
                     stack.add(node.right);
                 }
             }
         }
         return res;
    }
}
