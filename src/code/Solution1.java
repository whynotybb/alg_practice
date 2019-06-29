package code;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] a1=new int[]{1,2,3,4};
        int[] a2=new int[]{5,6,7,8};
        int[] a3=new int[]{9,10,15,19};
        int[][] a={a1,a2,a3};
        System.out.println(Find(12,a));
    }
    //先倒序与每列首元素进行对比，
    // 如果比某列首元素大，则可能，在此列的其余元素，也可能在此行的左侧
    public static boolean Find(int key, int [][] a) {
       if(a==null){
           return false;
       }
        int col=a[0].length-1;
       int row=0;
       if (col<=0) return false;
       int[] rc=new int[]{row,col};
       while (true){
           if (a[rc[0]][rc[1]]>key){
               if (!goLeft(a,rc,key)){
                   return false;
               }
           }
           if (a[rc[0]][rc[1]]==key){
               System.out.println("r："+rc[0]+" c:"+rc[1]);
               return true;
           }
           else {
               if (!goDown(a,rc,key)){
                   return false;
               }
           }
           if (a[rc[0]][rc[1]]==key){
               System.out.println("r："+rc[0]+" c:"+rc[1]);
               return true;
           }
       }
    }
    public static boolean goLeft(int[][] a,int[] rc,int key){
        while (rc[1]>=0&&a[rc[0]][rc[1]]>key){
            --rc[1];
        }
        if (rc[1]==-1){
            return false;
        }
        return true;
    }
    public static boolean goDown(int[][] a,int[] rc,int key){
        while(rc[0]<a.length&&a[rc[0]][rc[1]]<key){
            rc[0]++;
        }
        if (rc[0]==a.length){
            return false;
        }
        return true;
    }
}
