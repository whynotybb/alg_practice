package code;

public class Solution10 {
    public static void main(String[] args) {

    }
    public int RectCover(int target) {
        if (target<=0) return 0;
        int[] a=new int[target+1];
        int i=1;
        a[0]=1;
        a[1]=1;
        while (i<target){
            i++;
            a[i]=a[i-1]+a[i-2];
        }
        return a[target];
    }
}
