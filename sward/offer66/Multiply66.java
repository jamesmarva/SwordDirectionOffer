package sward.offer66;

/**
 * @program: SwordDirectionOffer
 * @description:
 *
 * https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 构建乘积数组
 * @author: James
 * @create: 2019-09-08 11:55
 **/
public class Multiply66 {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0){
            return null;
        }
        int len = A.length;
        int[] B = new int[len];
        int[] C = new int[len];
        int[] D = new int[len];
        C[0] = 1;
        for (int i = 1; i < len; ++i){
            C[i] = C[i - 1] * A[i - 1];
        }
        D[len - 1] = 1;
        B[len - 1] = D[len - 1] * C[len - 1];
        for (int i = len - 2; i >= 0; --i) {
            D[i] = D[i + 1] * A[i + 1];
            B[i] = C[i] * D[i];
        }
        return B;
    }

    public int[] multiplyRight(int[] A) {
        if (A == null || A.length == 0){
            return null;
        }
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;
        //计算下三角连乘
        for(int i = 1; i < length; i++){
            B[i] = B[i-1] * A[i-1];
        }
        int temp = 1;
        //计算上三角
        for(int j = length-2; j >= 0; j--){
            temp *= A[j+1];
            B[j] *= temp;
        }
        return B;
    }
}

