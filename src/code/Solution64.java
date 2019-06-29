package code;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组
 * {2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Solution64 {
    public static void main(String[] args) {
        int[] a={2,3,4,2,6,2,5,1};
        ArrayList<Integer> r= maxInWindows(a,0);
        for (Integer r1:r){
            System.out.print(r1+" ");
        }
    }
    // 如果在前进过程中，发现后面一个数字比前一个大，要删除之前比当前小的数字，
    // 因为从当前开始，这些前面较小的数字不再可能成为最大值
    // 如果后面的数字比前面小，要记录下来，它有可能再最大值过期后成为最大值。
    public static ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> res=new ArrayList<>();
        if(num==null||size<=0)
            return res;
        ArrayList<Integer> queue=new ArrayList<>();
        int maxIndex=0;
        for (int i =0; i < num.length; i++) {
            //当前元素大于窗口中其余的值，之后的最大值都不可能是其余值
            while (!queue.isEmpty()&&num[i]>queue.get(queue.size()-1)){
                queue.remove(queue.size()-1);
            }
            if (queue.isEmpty() || num[i] < queue.get(queue.size()-1)) {
                queue.add(num[i]);
                if (num[i]==queue.get(0)){
                    maxIndex=i;
                }
            }
            if (i >=size-1) {
                res.add(queue.get(0));
            }
            //检查队列中的数字是否已超出窗口
            if ((i-maxIndex+1)>=size){
                queue.remove(0);
            }
        }
            return res;
        }
    }

