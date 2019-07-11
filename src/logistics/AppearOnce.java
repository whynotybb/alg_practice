package logistics;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class AppearOnce {
    public static void main(String[] args) {
        AppearOnce appearOnce = new AppearOnce();
        int[] array = {1, 2, 3, 4, 3, 4, 6, 6};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        appearOnce.FindNumsAppearOnce(array, num1, num2);
        System.out.println("num1:" + num1[0] + " num2:" + num2[0]);
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int r = array[0];
        for (int i = 1; i < array.length; i++) {
            r = r ^ array[i];
        }
        //找到为1的位数，记为index
        int index = 0;
        while ((r & 1) == 0) {
            index++;
            r = r >> 1;
        }
        //将数组元素按照index位是否为1分为两组
        //再分别进行异或
        for (int i = 0; i < array.length; i++) {
            if (((array[i] >> index) & 1) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }
}
