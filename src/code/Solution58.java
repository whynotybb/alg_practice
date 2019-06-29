package code;
import datastruct.TreeNode;

import java.util.ArrayList;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Solution58 {
    public static void main(String[] args) {
//        {8,6,6,5,7,7}
//        {5,5,5,5,#,#,5,5,#,5}
        TreeNode treeNode1=new TreeNode(5);
        TreeNode treeNode2=new TreeNode(5);
        TreeNode treeNode3=new TreeNode(5);
        TreeNode treeNode4=new TreeNode(5);
        TreeNode treeNode5=new TreeNode(5);
        TreeNode treeNode6=new TreeNode(5);
        TreeNode treeNode7=new TreeNode(5);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode3.right=treeNode5;
        treeNode4.left=treeNode6;
        treeNode5.left=treeNode7;

        boolean r= isSymmetrical(null);
        System.out.println(r);
    }

    /**
     * 基于层次遍历方法
     *  1,不管节点的子节点是否为空，都将其加入queue，这样做是维持左右子结点顺序
     *  2,因为第一层只有一个元素或者没有元素，所以第一层不用判断
     *  3,每遍历完一层，已将下一层元素添加到队列中，
     *  此时对其进行分析，分别从两端开始往中间进行判断：
     *  1，如果有且仅有一个结点为空，则返回false
     *  2，如果两个结点均不为空，但是值不相等，则返回false
     *  只要存在不对称的情况，就直接返回false，但是如果发现是局部对称的，还需继续进行判断，以确保全局对称。
     */
    static boolean isSymmetrical(TreeNode root){
        ArrayList<TreeNode> queue=new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode node= queue.remove(0);
                if (node!=null){
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
                int s=0;
                int e=queue.size()-1;
                while (s<e){
                    if ((queue.get(s)!=null&&queue.get(e)==null)||(queue.get(s)==null&&queue.get(e)!=null))
                        return false;
                    if ((queue.get(s)!=null&&queue.get(e)!=null)&&queue.get(s).val!=queue.get(e).val)
                        return false;
                    s++;
                    e--;
                }
        }
        return true;
    }
}
