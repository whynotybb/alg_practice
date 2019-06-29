package sort;

public class QuickSort {
    public static void main(String[] args) {
       QuickSort quickSort=new QuickSort();
       int[] arr={12,3,45,67,28,9,78,54};
//       quickSort.partition(arr,0,arr.length-1);
        quickSort.sort(arr);
       for (int a1:arr)
           System.out.print(a1+",");
    }
    private int partition(int[] a, int left, int right) {
        int leftPtr = left - 1, rightPtr = right;
        //将最右边的数字作为枢纽
        int pivot=a[right];
        while (true) {
            while (a[++leftPtr] < pivot) ;
            while (rightPtr >0 && a[--rightPtr] > pivot) ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(a, leftPtr, rightPtr);
        }
        //将枢纽放到合适位置
        swap(a, leftPtr, right);
        return leftPtr;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    private void recSort(int[] array,int left,int right){
        if (left<right){
            int p=partition(array,left,right);
            recSort(array,0,p-1);
            recSort(array,p+1,right);
        }
    }
    private void sort(int[] array){
        recSort(array,0,array.length-1);
    }
}
