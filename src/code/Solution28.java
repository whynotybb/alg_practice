package code;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution28 {
    public static void main(String[] args) {
        int[] a={1,2,3,2,2,2,5,4,2};
        int r= find(a);
        System.out.println(r);
    }
    //基于划分的思想，找到中间的数字,因为中间位置一定是出现次数超过一半的数字
    //当重复数字不超过一半时，只能用原始方法区查找
    public static int MoreThanHalfNum_Solution(int [] array) {
        int mid=array.length/2;
        int r =partition(array,array[mid]);
        while (r!=mid){
           r= partition(array,array[mid]);
        }
        return array[mid];
    }
    public static int partition(int[] array,int pivot){
        int left=0;
        int right= array.length;
        while (true) {
            while (++left< array.length&&array[left] <= pivot) ;
            while (array[--right] > pivot) ;
            if (left >= right)
                break;
            swap(array, left, right);
        }
        swap(array,0,right);
        return right;
    }
    public static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    /**
     * 如果当前数字与重复数字相同，则次数+1;
     * 否则 -1;
     * 当次数为0时，说明当前重复的数字和其他数字出现的次数相同，这时要移动重复出现数字的指针
     */
    public static int find(int[] array){
        int p=array[0];
        int times=1;
        for (int i=1;i<array.length;i++){
            if (times==0){
                p=array[i];
            }
            if (array[i]==p){
                times++;
            }else
                times--;
        }
        if (times>=0&&exist(array,p))
            return p;
        return 0;
    }
    public static boolean exist(int[] a,int p){
        int c=0;
        for (int a1:a){
            if (a1==p)
                c++;
        }
        return c>a.length/2;
    }
}
