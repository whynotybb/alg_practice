package code;

import java.util.ArrayList;

/**
 * 最小的k个数
 */
public class Solution29 {
    public static void main(String[] args) {
//        int[] a=new int[]{22,4,67,8,2,10};
        int[] a=new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> res= GetLeastNumbers_Solution(a,8);
        System.out.println("result:");
        for (Integer r: res){
            System.out.print(r+" ");
        }
    }
    //两个指针left&right向中间走，直到右边发现比pivot小的数字，左边发现比pivot大的数字，然后将其交换
    //终止条件是越界或者left>=right
    public static int partition(int[] a,int pivot){
        int left=0;
        int right=a.length-1;
        int leftPtr=left;//选择最左端数字作为枢纽，最后将其交换到合适位置
        int rightPtr=right+1;
        while (true){
            while (leftPtr<right&&a[++leftPtr]<pivot);
            while (a[--rightPtr]>pivot);
            if (leftPtr>=rightPtr)
                break;
            swap(a,leftPtr,rightPtr);
        }
        swap(a,rightPtr,left);
        return rightPtr;
    }
    public static void swap(int[] a,int l,int r){
        int temp=a[l];
        a[l]=a[r];
        a[r]=temp;
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] a, int k) {
       //划分后pivot的位置就是pivot排序之后的位置
        ArrayList<Integer> res=new ArrayList<>();
        if (k>a.length ||k<=0) return res;
        int p= partition(a,a[0]);
        while (p!=k-1){
            p=partition(a,a[k-1]);
        }
        for (int i=0;i<k;i++){
            res.add(a[i]);
        }
        return res;
    }
}
