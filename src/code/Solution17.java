package code;

import datastruct.TreeNode;

import java.util.ArrayList;

//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
public class Solution17 {
    public static void main(String[] args) {

    }

    /**
     * 前序遍历
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        ArrayList<TreeNode> stack1 = new ArrayList<>();
        ArrayList<TreeNode> stack2 = new ArrayList<>();
        TreeNode node1=root1;
        TreeNode node2=root2;
        while (node1!=null||!stack1.isEmpty()){
            while (node1!=null){
                if (node1.val==node2.val){
                    stack2.add(node2);
                }
                stack1.add(node1);
                node1=node1.left;
            }
            if (!stack1.isEmpty()){
                node1=stack1.remove(stack1.size()-1);
                node1=node1.right;
            }
        }
        return true;
    }
}
