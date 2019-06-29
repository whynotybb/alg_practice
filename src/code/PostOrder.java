package code;
import datastruct.TreeNode;

import java.util.*;

public class PostOrder {
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
        postorder(treeNode1);
    }
    private static void postorder(TreeNode root){
        ArrayList<TreeNode> stack=new ArrayList<>();
        Set<TreeNode> visited=new HashSet<>();
        stack.add(root);
        visited.add(root);
        Map<TreeNode,Integer> map=new HashMap<>();
        while (!stack.isEmpty()){
            TreeNode node= getUnvisitedNode(stack.get(stack.size()-1),visited);
            if(node==null){
                TreeNode node1 =stack.remove(stack.size()-1);
                System.out.println(node1.val);
            }else {
                stack.add(node);
                visited.add(node);
            }
        }
    }
    private static TreeNode getUnvisitedNode(TreeNode node, Set<TreeNode> visited){
        if (node.left!=null&&!visited.contains(node.left)){
            return node.left;
        }
        if (node.right!=null&&!visited.contains(node.right)){
            return node.right;
        }
        return null;
    }
}
