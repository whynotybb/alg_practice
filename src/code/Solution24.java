package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import datastruct.TreeNode;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution24 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(12);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        ArrayList<ArrayList<Integer>> r = FindPath(treeNode1, 22);
        for (ArrayList<Integer> arrayList : r) {
            for (Integer a : arrayList) {
                System.out.println(a);
            }
            System.out.println();
        }
    }

    //深度优先搜索
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null) return null;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);
        int visitedSum=root.val;
        check(target,res,stack,visitedSum,root);
        while (!stack.isEmpty()) {
            //获取栈顶元素的next unvisited vertex
            TreeNode node = getUnvisitedNode(stack.get(stack.size() - 1), visited);
            if (node == null) {
                //移除栈顶元素
                TreeNode node1= stack.remove(stack.size() - 1);
                visitedSum-=node1.val;
            } else {
                visited.add(node);
                visitedSum+=node.val;
                stack.add(node);
                check(target, res, stack, visitedSum, node);
            }
        }
        return res;
    }

    private static void check(int target, ArrayList<ArrayList<Integer>> res, ArrayList<TreeNode> stack, int visitedSum, TreeNode node) {
        if (visitedSum==target&&node.left==null&&node.right==null){
            ArrayList<Integer> temp=new ArrayList<>();
            for (TreeNode s:stack){
                temp.add(s.val);
            }
            res.add(temp);
        }
    }

    //获取结点连接的下一节点，优先返回左子结点
    private static TreeNode getUnvisitedNode(TreeNode node, Set<TreeNode> visited) {
        if (!visited.contains(node.left))
            return node.left;
        else if (!visited.contains(node.right))
            return node.right;
        return null;
    }
}
