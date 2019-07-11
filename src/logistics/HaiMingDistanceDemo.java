package logistics;

/**
 * 海明距离：两个数中不相同的位数
 */
public class HaiMingDistanceDemo {
    public static void main(String[] args) {
        System.out.println(new HaiMingDistanceDemo().getDistance(7,16));
    }
    private int getDistance(int a,int b){
        int t= a^b;
        //求t的二进制中1的个数
        int count=0;
        while (t!=0){
            t=t&(t-1);
            count++;
        }
        return count;
    }
}
