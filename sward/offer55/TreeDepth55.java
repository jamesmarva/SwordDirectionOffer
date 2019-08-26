package sward.offer55;

import sward.TreeNode;

/**
 * @program: myleetcode
 * @description: https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=11191&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-25 18:15
 **/
public class TreeDepth55 {


    /**
     *  深度优先可以的。也可以广度
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null ) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }



    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null ) {
            return true;
        }
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        if (Math.abs(left -right) > 1) {
            return false;
        }
        boolean isLeftBalance = IsBalanced_Solution(root.left);
        boolean isRightBalance = IsBalanced_Solution(root.right);
        return isLeftBalance && isRightBalance;
    }

    private int getTreeDepth(TreeNode root) {
        if (root == null ) {
            return 0;
        }
        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);
        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }


}
