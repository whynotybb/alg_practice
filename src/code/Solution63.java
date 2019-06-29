package code;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Solution63 {
    public static void main(String[] args) {
        Solution63 solution63=new Solution63();
        solution63.Insert(1);
        solution63.Insert(4);
        solution63.Insert(3);
        solution63.Insert(6);
        solution63.Insert(9);
        System.out.println(solution63.GetMedian());
    }
    int n;
    int[] arr=new int[10];
    //插入时对数据进行插入排序
    public void Insert(Integer num){
        //把num移动到合适位置
        if (n==0){
            arr[n++]=num;
            return;
        }
        int temp=num;
        int j=n;
        while (j>0&&arr[j-1]>temp){
            arr[j]=arr[j-1];
            j--;
        }
        arr[j]=num;
        n++;
    }
    public Double GetMedian() {
        if ((n&1)==0){
            return (arr[n/2]+arr[n/2-1])/2.0;
        }
        else {
            return arr[n/2]/1.0;
        }
    }
}
