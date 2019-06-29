package code;

import datastruct.TreeNode;

import java.util.ArrayList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution60 {
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

        ArrayList<ArrayList<Integer>> res= Print(treeNode1);
        for (ArrayList<Integer> r:res){
            for (Integer r1:r){
                System.out.print(r1+" ");
            }
            System.out.println();
        }
    }
    static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (pRoot==null) return res;
        ArrayList<TreeNode> queue=new ArrayList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> level=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node= queue.remove(0);
                level.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
