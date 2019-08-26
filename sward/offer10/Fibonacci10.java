package sward.offer10;

import java.util.Arrays;

/**
 * @program: myleetcode
 * @description:
 * @author: James
 * @create: 2019-08-21 07:25
 **/
public class Fibonacci10 {


    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * Backtracking recursion
     */
    public int fibonacciBack(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciBack(n - 1) + fibonacciBack(n - 2);
    }

    /**
     * 跳台阶问题
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }


    public int JumpFloorII(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        int[] dp = new int[target+1];
        Arrays.fill(dp, 1);
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; ++i) {
            int temp = 0;
            for (int j = i - 1; j >= 0; --j) {
                temp += dp[j];
            }
            dp[i] = temp;
        }
        return dp[target];
    }




    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        int[] dp = new int[target+1];
        dp[1] =1;
        dp[2] = 2;
        for (int i = 3; i <= target; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
