package binarytree;

import datastruct.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 后序遍历二叉树，利用图的深度搜索思想
 */
public class PostOrder {
    public static void main(String[] args) {
        TreeNode node8 = new TreeNode(8);
        TreeNode node6 = new TreeNode(6);
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node11 = new TreeNode(11);
        node8.left = node6;
        node8.right = node10;
        node6.left = node5;
        node6.right = node7;
        node10.left = node9;
        node10.right = node11;
        order(node8);
    }

    private static void order(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();//记录已访问的结点
        TreeNode node = root;
        stack.add(node);
        visited.add(node);
        while (!stack.isEmpty()) {
            node = getUnVisitedNode(stack.peek(), visited);
            if (node == null) {
                System.out.println(stack.pop().val);
            } else {
                stack.add(node);
                visited.add(node);
            }
        }
    }

    private static TreeNode getUnVisitedNode(TreeNode node, Set<TreeNode> visited) {
        if (node.left != null && !visited.contains(node.left)) {
            return node.left;
        } else if (node.right != null && !visited.contains(node.right))
            return node.right;
        else
            return null;
    }
}
