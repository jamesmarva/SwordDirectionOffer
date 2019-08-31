package sward.offer13;

/**
 * @program: SwordDirectionOffer
 * @description: https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219&tPage=4&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-31 19:06
 **/
public class RobotMovingCount13 {


    private int rowLen = 0;
    private int colLen = 0;
    private boolean[][] visited = null;
    private int ans = 0;
    private int globalHold = 0;
    public int movingCount(int threshold, int rows, int cols) {
        visited = new boolean[rows][cols];
        rowLen = rows;
        colLen = cols;
        globalHold = threshold;
        // findRoad(0, 0, 1);
        return findRoadBetter(0, 0);
    }

    private void findRoad(int rowIndex, int colIndex, int tempAns) {
        if (rowIndex >= rowLen || colIndex >= colLen || rowIndex < 0 || colIndex < 0
                || visited[rowIndex][colIndex] == true) {
            return;
        }
        if (isValid(rowIndex, colIndex, globalHold)) {
            ans = Math.max(tempAns, ans);
            visited[rowIndex][colIndex] = true;
            findRoad(rowIndex + 1, colIndex, tempAns + 1);
            findRoad(rowIndex - 1, colIndex, tempAns + 1);
            findRoad(rowIndex, colIndex + 1, tempAns + 1);
            findRoad(rowIndex, colIndex - 1, tempAns + 1);
            visited[rowIndex][colIndex] = false;
        }
    }

    private int findRoadBetter(int rowIndex, int colIndex) {
        if (rowIndex >= rowLen || colIndex >= colLen || rowIndex < 0 || colIndex < 0
                || visited[rowIndex][colIndex] == true) {
            return 0;
        }
        int count = 0;
        if (isValid(rowIndex, colIndex, globalHold)) {
            visited[rowIndex][colIndex] = true;
            count = 1 + findRoadBetter(rowIndex + 1, colIndex)
                    + findRoadBetter(rowIndex - 1, colIndex)
                    + findRoadBetter(rowIndex, colIndex + 1)
                    + findRoadBetter(rowIndex, colIndex - 1);
        }
        return count;
    }

    private boolean isValid (int rowIndex, int colIndex, int validHold) {
        char[] nums = (rowIndex+""+colIndex).toCharArray();
        int temp = 0;
        for (char item : nums) {
            temp += Integer.parseInt(item+"");
            if (temp > validHold) {
                return false;
            }
        }
        return true;
    }
}
