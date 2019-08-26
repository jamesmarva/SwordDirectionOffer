package sward.offer26;


import sward.TreeNode;

/**
 * @program: myleetcode
 * @description:
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author: James
 * @create: 2019-08-21 00:58
 **/
public class HasSubtree26 {


    private boolean ans = false;

    /**
     * 这里的重点在于我们剑指里面吧如果母树的那个多出来的点是不做判断的，只要子树在里面就ok了
     * 所以判断的逻辑不同。
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return false;
        } else if (root1 == null) {
            return false;
        }
        preOrder(root1, root2);
        return ans;
    }
    private void preOrder(TreeNode node, TreeNode t) {
        if (node == null || ans) {
            return;
        }
        if (node.val == t.val) {
            if (isSame2(node, t)) {
                ans = true;
                return;
            }
        }
        preOrder(node.left, t);
        preOrder(node.right, t);
    }

    private boolean isSame2(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null) {
            return false;
        } else if (b == null) {
            return true;
        }
        if (a.val != b.val) {
            return false;
        }
        boolean isLeftSame = isSame2(a.left, b.left);
        boolean isRightSame = isSame2(a.right, b.right);
        return isLeftSame && isRightSame;
    }
}
