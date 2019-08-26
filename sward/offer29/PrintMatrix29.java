package sward.offer29;

import java.util.ArrayList;

/**
 * @program: myleetcode
 * @description:
 * https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&tPage=1&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author: James
 * @create: 2019-08-23 06:57
 **/
public class PrintMatrix29 {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int startX = 0;
        int startY = 0;
        int endX = matrix[0].length - 1;
        int endY = matrix.length - 1;

        while (startX <= endX || startY <= endY) {
            for (int i = startX; startY <= endY && i <= endX; ++i) {
                list.add(matrix[startY][i]);
            }
            if (startY <= endY) {
                startY++;
            }

            for (int i = startY; startX <= endX  && i <= endY; ++i) {
                list.add(matrix[i][endX]);
            }
            if (startX <= endX) {
                endX--;
            }

            for (int i = endX; startY <= endY && i >= startX; --i) {
                list.add(matrix[endY][i]);
            }
            if (startY <= endY) {
                endY--;
            }

            for (int i = endY; startX <= endX && i >= startY; --i) {
                list.add(matrix[i][startX]);
            }
            if (startX <= endX) {
                startX++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        int[][] test = {{1, 2, 3, 4},{12, 13, 14, 5},{11, 16, 15, 6},{10, 9, 8, 7}};
//        int[][] test = {{1},{2},{3},{4},{5}};
        int[][]  test = {{1 , 2 , 3, 4, 5}};
        ArrayList<Integer> list = printMatrix(test);
        System.out.println(list);

    }


}
