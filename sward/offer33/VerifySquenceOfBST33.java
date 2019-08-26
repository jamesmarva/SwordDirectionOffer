package sward.offer33;

/**
 * @program: myleetcode
 * @description:
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=2&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author: James
 * @create: 2019-08-23 23:57
 **/
public class VerifySquenceOfBST33 {

    int[] globalSeq = null;
    public boolean verifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        globalSeq = sequence;
        return verifyCore(0, sequence.length - 1);
    }

    /**
     *
     * @param start
     * @param end
     * @return
     */
    public boolean verifyCore(int start, int end) {
        int rootValue = globalSeq[end];
        int leftEnd = start;
        for (; leftEnd < end; ++leftEnd) {
            if (globalSeq[leftEnd] > rootValue) {
                break;
            }
        }

//      走完这个循环就表示这个是有右子树的
        int rightEnd = leftEnd;
        for (; rightEnd < end; ++rightEnd) {
            if (globalSeq[rightEnd] < rootValue) {
                return false;
            }
        }

        boolean isLeft = true;
        if (leftEnd > start) {
            isLeft = verifyCore(start, leftEnd - 1);
        }

        // 如果左子树的最后一个点小于 end - 1，那么
        boolean isRight = true;
        if (leftEnd < end - 1) {
            isRight = verifyCore(leftEnd, end - 1);
        }
        return (isLeft && isRight);
    }

    public static void main(String[] arg) {
        int[] test = {5, 6, 7, 9, 11, 10, 8};
        VerifySquenceOfBST33 verifySquenceOfBST33 = new VerifySquenceOfBST33();
        verifySquenceOfBST33.verifySquenceOfBST(test);
    }
}
