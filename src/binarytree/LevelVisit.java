package binarytree;
import datastruct.TreeNode;

import java.util.ArrayList;

/**
 * 层次遍历
 */
public class LevelVisit {
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

        level(node8);
    }
    private static void level(TreeNode root){
        ArrayList<TreeNode> queue=new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node= queue.remove(0);
                System.out.print(node.val+",");
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
