package sward.offer12;

/**
 * @program: SwordDirectionOffer
 * @description:
 * https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc?tpId=13&tqId=11218&tPage=4&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-31 17:13
 **/
public class HasPath12 {


    private int rowLen = 0;
    private int colLen = 0;
    char[][] matrixNew = null;
    char[] strChars = null;
    boolean[][] visited = null;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        visited = new boolean[rows][cols];
        matrixNew = new char[rows][cols];
        rowLen = rows;
        colLen = cols;
        strChars = str;
        for (int i = 0; i < rows ; i++) {
            for(int j = 0; j < cols; j++) {
                matrixNew[i][j] = matrix[i*cols + j];
            }
        }
        for (int i = 0; i < rows ; i++) {
            for(int j = 0; j < cols; j++) {
                if(find(i, j, 0)){
                    return  true;
                }
            }
        }
        return false;
    }

    private boolean find(int rowIndex, int colIndex, int index) {
        if (index >= strChars.length) {
            return true;
        }
        if (rowIndex >= rowLen || colIndex >= colLen || rowIndex < 0 || colIndex < 0
                || visited[rowIndex][colIndex] == true) {
            return false;
        }
        boolean res = false;
        if (strChars[index] == matrixNew[rowIndex][colIndex]) {
            visited[rowIndex][colIndex] = true;
            res = find(rowIndex + 1, colIndex, index + 1) ||
                    find(rowIndex - 1, colIndex, index + 1) ||
                    find(rowIndex, colIndex + 1, index + 1) ||
                    find(rowIndex, colIndex - 1, index + 1);
            visited[rowIndex][colIndex] = false;
        }
        return res;
    }
}
