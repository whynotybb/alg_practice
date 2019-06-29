package code;

import java.util.ArrayList;
import datastruct.TreeNode;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution59 {
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
    private static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        if (pRoot==null) return res;
        ArrayList<TreeNode> stack=new ArrayList<>();
        stack.add(pRoot);
        int c=0;
        while (!stack.isEmpty()){
            int size=stack.size();
            ArrayList<Integer> level=new ArrayList<>();
            c++;
            for (int i=0;i<size;i++){
                TreeNode node= stack.remove(0);
                level.add(node.val);
                if (node.left!=null){
                    stack.add(node.left);
                }
                if (node.right!=null){
                    stack.add(node.right);
                }
            }
            if ((c&1)==1) {
                res.add(level);
            }else {
                ArrayList<Integer> nLevel=new ArrayList<>();
                while (!level.isEmpty()){
                    Integer v= level.remove(level.size()-1);
                    nLevel.add(v);
                }
                res.add(nLevel);
            }
        }
        return res;
    }
}
