package code;

import datastruct.TreeNode;

import java.util.ArrayList;

/**
 * 序列化二叉树：空节点用$表示
 */
public class Solution61 {
    public static void main(String[] args) {
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode10.left = treeNode5;
        treeNode10.right = treeNode3;
        treeNode5.left = treeNode4;
        treeNode5.right = treeNode6;
        treeNode6.left = treeNode2;
        Solution61 solution61 = new Solution61();
        String s = solution61.Serialize(treeNode10);
        System.out.println(s);
        TreeNode node = solution61.Deserialize(s);

    }

    //层次遍历
    String Serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        TreeNode last = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove(0);
                //访问最后一个元素之前遇到的空节点都要表示为$
                if (node != null) {
                    if (node.left != null) {
                        last = node.left;
                    }
                    if (node.right != null) {
                        last = node.right;
                    }
                    s.append(node.val + ",");
                    if (node == last) {
                        String s1 = null;
                        if (s.toString().endsWith(",")) {
                            s1 = s.substring(0, s.length() - 1);
                        }
                        return s1;
                    }
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    s.append('$' + ",");
                }
            }
        }
        return s.toString();
    }

    TreeNode Deserialize(String str) {
        String[] strings = str.split(",");
        ArrayList<TreeNode> queue = new ArrayList<>();
        int p = 0;
        TreeNode root = null;
        if (!strings[p].equals("$")) {
            root = new TreeNode(Integer.valueOf(strings[p]));
            queue.add(root);
        }
        while (!queue.isEmpty() && p < strings.length) {
            TreeNode node = queue.remove(0);
            //取出两位作为其子节点
            TreeNode node1, node2;
            if (p+1<strings.length&&!strings[++p].equals("$")) {
                node1 = new TreeNode(Integer.valueOf(strings[p]));
            } else {
                node1 = null;
            }
            if (p+1<strings.length&&!strings[++p].equals("$")) {
                node2 = new TreeNode(Integer.valueOf(strings[p]));
            } else {
                node2 = null;
            }
            node.left = node1;
            if (node1 != null)
                queue.add(node1);
            node.right = node2;
            if (node2 != null)
                queue.add(node2);
        }
        return root;
    }
}
