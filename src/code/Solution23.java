package code;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 5,7,6,9,10,11,8
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution23 {
    public static void main(String[] args) {
//        5,7,6,9,10,11,8
        int[] a={5,7,6,9,10,11,8};
        boolean v= VerifySquenceOfBST(a);
        System.out.println(v);
    }
    /**
     * 最后一位是根结点，前面比根结点小的是左子树结点，反之为右子树结点
     */
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null||sequence.length<=0){
            return false;
        }
        return core(sequence,0,sequence.length-1);
    }
    public static boolean core(int[] sequence,int left,int right){
        int i=left;
        int root= sequence[right];
        while (sequence[i]<root){
            i++;
        }
        //left停在了右子树开始的地方
        //检查右子树结点是否都比root大
        int mid=i;
        while (i<right){
            if (sequence[i]<=root){
                return false;
            }
            i++;
        }
        return true;
    }
}
