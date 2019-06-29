package code;

import java.util.Stack;

/**
 * //        请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * // 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * // 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * // 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * // 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */
public class Solution65 {

    public static void main(String[] args) {
        Solution65 solution66 = new Solution65();
//        ABCEHJIG
//        SFCSLOPQ
//        ADEEMNOE
//        ADIDEJFM
//        VCEIFGGS",5,8,"SLHECCEIDEJFGGFIE
        char[] matrix =    {'a','b','c','e','h','j','i','g',
                             's','f','c','s','l','o','p','q',
                            'a','d','e','e','m','n','o','e',
                            'a','d','i','d','e','j','f','m',
                            'v','c','e','i','f','g','g','s'};
//        ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS",5,8,"SGGFIECVAASABCEHJIGQEMS"
        System.out.println(solution66.hasPath(matrix, 5, 8, new char[]
                {'s','g', 'g', 'f','i','e','c','v','a',
                        'a','s','a','b','c','e','h','j','i','g','q','e','m','s'}));
    }

    /**
     * 1,用栈记录运动的轨迹，这样做是为了可以回退
     * 2，当发现第一个字符是相同的，逐个检查，如果某个字符的相邻（上下左右都不相同，则回退到上一个字符继续查找。）
     * 3，因为题目说不能重复进入，所以需要一个二维布尔型数组记录是否访问。
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //构建二维数组
        char[][] mat = getMatrix(matrix, rows, cols);
        boolean[][] visited = new boolean[rows][cols];
        Stack<Integer> stack=new Stack<>();
        //从第一个元素开始搜索，找到与给定的路径相同的就直接返回true，如果不相同就要继续找
        int p = 0;
        int l = str.length;
        int flag=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j]==str[p]) {
                    int r = i, c = j;
                    flag = -1;//用来识别前进模式以及是否前进。
                    visited[r][c]=true;
                    while (p + 1 < l) {
                        if (r > 0 && !visited[r - 1][c] && mat[r - 1][c] == str[p + 1]) {
                            r--;
                            flag = 0;
                        } else if (r + 1 < rows && !visited[r + 1][c] && mat[r + 1][c] == str[p + 1]) {
                            r++;
                            flag = 1;
                        } else if (c > 0 && !visited[r][c - 1] && mat[r][c - 1] == str[p + 1]) {
                            c--;
                            flag = 2;
                        } else if (c + 1 < cols && !visited[r][c + 1] && mat[r][c + 1] == str[p + 1]) {
                            c++;
                            flag = 3;
                        } else {
                            if (p == 0) {
                                reset(visited);
                                break;
                            }
                            //如何退到上一步，
                            p--;
                            flag = stack.pop();
                            if (flag == 0) {
                                r++;
                            } else if (flag == 1) {
                                r--;
                            } else if (flag == 2) {
                                c++;
                            } else {
                                c--;
                            }
                            flag=-1;
                        }
                        if (flag != -1) {
                            stack.push(flag);
                            visited[r][c]=true;
                            p++;
                        }
                    }
                    if (p == l - 1)
                        return true;
                    }
                }
            }
        return false;
    }

    private void reset(boolean b[][]){
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[0].length; j++) {
               b[i][j] = false;
            }
    }
    //用二维数组进行模拟
    private char[][] getMatrix(char[] matrix, int rows, int cols) {
        char[][] chars = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                chars[i][j] = matrix[i * cols + j];
            }
        }
        return chars;
    }
}
