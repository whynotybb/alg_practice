package code;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution38 {
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

//        System.out.println(TreeDepth(null));
        System.out.println(treeDepth(treeNode1));
    }
    public static int TreeDepth(TreeNode root) {
        int res=0;
        if (root==null){
            return res;
        }
        List<TreeNode> queue =new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            res++;
            for (int i=0;i<size;i++){
                TreeNode node=queue.remove(0);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
//递归版本
    public static int treeDepth(TreeNode root){
        if(root==null) return 0 ;
        return Math.max(1+treeDepth(root.left), 1+treeDepth(root.right));
    }
}
