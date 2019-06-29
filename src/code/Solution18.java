package code;

import datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Solution18 {
    public static void main(String[] args) {
    }
    public static void mirror(TreeNode root){
        //前序遍历
        List<TreeNode> stack=new ArrayList<>();
        TreeNode node=root;
        while (!stack.isEmpty()||node!=null){
            while (node!=null){
                swap(node);
                stack.add(node);
                node=node.left;
            }
            if (!stack.isEmpty()){
                 node= stack.remove(stack.size()-1);
                 node=node.right;
            }
        }
    }
    public static void swap(TreeNode node){
        TreeNode temp=node.left;
        node.left=node.right;
        node.right=temp;
    }
    public static void printFromTopToBottom(TreeNode root) {
        ArrayList<TreeNode> queue=new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //每次访问一层，访问上一层的同时，将下一层加入到stack
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode node= queue.remove(0);
                System.out.println(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
        }
    }
}
