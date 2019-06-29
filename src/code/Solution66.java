package code;

import java.util.Stack;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class Solution66 {
    public static void main(String[] args) {
         Solution66 solution67=new Solution66();
        System.out.println(solution67.movingCount(15,20,20));
    }

    /**
     * 深度优先搜索的思想，如果当前方格可以进入，将其入栈，再去判断其上下左右相邻的四个方格是否也可以进入。
     * 每次去除栈顶元素进行判断，对已访问的元素进行标记。
     */
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold<=0||rows<=0||cols<=0)
            return 0;
        int count=0;
        boolean[][] visited=new boolean[rows][cols];
        Stack<Block> stack=new Stack<>();
        stack.add(new Block(0,0));
        visited[0][0]=true;
        count++;
        while (!stack.isEmpty()){
            Block b= stack.pop();
            //访问b的四周
            if (b.i-1>0&&!visited[b.i-1][b.j]&&getSum(b.i-1,b.j)<=threshold){
                count++;
                stack.add(new Block(b.i-1,b.j));
                visited[b.i-1][b.j]=true;
            }
            if (b.i+1<rows&&!visited[b.i+1][b.j]&&getSum(b.i+1,b.j)<=threshold){
                count++;
                stack.add(new Block(b.i+1,b.j));
                visited[b.i+1][b.j]=true;
            }
            if (b.j-1>0&&!visited[b.i][b.j-1]&&getSum(b.i,b.j-1)<=threshold){
                count++;
                stack.add(new Block(b.i,b.j-1));
                visited[b.i][b.j-1]=true;
            }
            if (b.j+1<cols&&!visited[b.i][b.j+1]&&getSum(b.i,b.j+1)<=threshold){
                count++;
                stack.add(new Block(b.i,b.j+1));
                visited[b.i][b.j+1]=true;
            }
        }
        return count;
    }
    //求两个数字的数位之和
    private int getSum(int a, int b) {
        int sum = 0;
        while (a != 0) {
            sum+=a%10;
            a=a/10;
        }
        while (b != 0) {
            sum+=b%10;
            b=b/10;
        }
        return sum;
    }
    static class Block{
        int i;
        int j;

        public Block(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
