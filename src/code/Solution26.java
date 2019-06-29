package code;

import java.util.ArrayList;
import datastruct.TreeNode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution26 {
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
        TreeNode node= Convert(treeNode1);
        while (node!=null){
            System.out.print(node.val+"->");
            node=node.right;
        }
    }
    //按照中序遍历顺序，因为二叉搜索树的中序遍历是从小到大排列的
    public static TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode res=null;
        ArrayList<TreeNode> stack=new ArrayList<>();
        TreeNode node=pRootOfTree;
        TreeNode last=null;
        while (!stack.isEmpty()||node!=null){
           while (node!=null){
               stack.add(node);
               node=node.left;
           }
           if (!stack.isEmpty()){
               int index=stack.size()-1;
               node=stack.remove(index);
               if (res==null) {
                   res = node;
               }else {
                   //todo
                   last.right=node;
                   node.left=last;
               }
               last=node;
               node=node.right;
           }
       }
       return res;
    }
}
