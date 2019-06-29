package code;

import datastruct.TreeNode;

import java.util.*;

public class Solution39 {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.right=node6;
        node5.right=node7;

        System.out.println(IsBalanced_Solution(node1));
    }
    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root==null)
            return true;
        ArrayList<TreeNode> stack = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.add(root);
        visited.add(root);
        Map<TreeNode, Integer> map = new HashMap<>();
        while (!stack.isEmpty()) {
            TreeNode node = getUnvisitedNode(stack.get(stack.size() - 1), visited);
            if (node == null) {
                TreeNode node1 = stack.remove(stack.size() - 1);
                if (node1.left == null && node1.right == null)
                    map.put(node1, 1);
                else {
                    int left = map.getOrDefault(node1.left, 0);
                    int right = map.getOrDefault(node1.right, 0);
                    int diff = left - right;
                    if (diff > 1 || diff < -1)
                        return false;
                    map.put(node1, left > right ? left + 1 : right + 1);
                }
            } else {
                stack.add(node);
                visited.add(node);
            }
        }
        return true;
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