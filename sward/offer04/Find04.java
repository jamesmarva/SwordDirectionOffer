package sward.offer04;

/**
 * @program: myleetcode
 * @description:
 * 剑指offer04
 * @author: James
 * @create: 2019-08-21 01:10
 **/
public class Find04 {

    public boolean Find(int target, int [][] array) {
        if (array == null) {
            return false;
        }
        int rowLen = array.length;
        if (rowLen == 0) {
            return false;
        }
        int columnLen = array[0].length;
        if (columnLen == 0) {
            return false;
        }
        int rowIndex = 0;
        int columnIndex = columnLen - 1;
        while (rowIndex <=  rowLen - 1 && columnIndex >= 0) {
            int temp = array[rowIndex][columnIndex];
            if ( temp < target) {
                rowIndex++;
            } else if (temp > target) {
                columnIndex--;
            } else if (temp == target) {
                return true;
            }
        }
        return false;
    }
}
