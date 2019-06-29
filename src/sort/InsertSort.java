package sort;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr={12,3,45,67,28,9,78,54};
        InsertSort insertSort=new InsertSort();
        insertSort.sort(arr);
        for (int a:arr)
            System.out.print(a+" ");
    }
    private  void  sort(int array[]){
        for (int i = 1; i <array.length ; i++) {
            int temp=array[i];
            int j=i;
            while (j>0&&temp<array[j-1]){
                array[j]=array[j-1];
                j--;
            }
            array[j]=temp;
        }
    }
}
