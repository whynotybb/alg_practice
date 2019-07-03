package binarytree;

import datastruct.TreeNode;

import java.util.Stack;

/**
 * 中序遍历
 */
public class InOrder {
    public static void main(String[] args) {
        TreeNode node8=new TreeNode(8);
        TreeNode node6=new TreeNode(6);
        TreeNode node10=new TreeNode(10);
        TreeNode node5=new TreeNode(5);
        TreeNode node7=new TreeNode(7);
        TreeNode node9=new TreeNode(9);
        TreeNode node11=new TreeNode(11);
        node8.left=node6;
        node8.right=node10;
        node6.left=node5;
        node6.right=node7;
        node10.left=node9;
        node10.right=node11;
        order(node8);
    }
    private static void order(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while (!stack.isEmpty()||node!=null){
            while (node!=null){
                stack.add(node);
                node=node.left;
            }
            if (!stack.isEmpty()){
                node= stack.pop();
                System.out.println(node.val);
                node=node.right;
            }
        }
    }
}
