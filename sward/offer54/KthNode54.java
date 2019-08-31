package sward.offer54;

import sward.TreeNode;

/**
 * @program: SwordDirectionOffer
 * @description: https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215&tPage=4&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 二叉搜索树的第k个结点
 * @author: James
 * @create: 2019-08-31 14:13
 **/
public class KthNode54 {

    private int globalK = 0;
    private int globalCount = 1;
    private TreeNode globalNode = null;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        globalK = k;
//        inorder(pRoot);
//        inorderCore(TreeNode pRoot, int k);
//        return globalNode;
        return inorderCore(pRoot, k);
    }

    private void inorder(TreeNode pRoot) {
        if (pRoot == null) {
            return ;
        }
        inorder(pRoot.left);
        if (globalCount == globalK && globalNode == null) {
            globalNode = pRoot;
        }
        globalCount++;
        inorder(pRoot.right);
        return ;

    }


    private TreeNode inorderCore(TreeNode pRoot, int k) {
        TreeNode target = null;
        if (pRoot.left != null) {
            target = inorderCore(pRoot.left, k);
        }
        if (target == null) {
            if (k == 1) {
                target = pRoot;
            }
            k--;
        }
        if (pRoot.right != null && target == null) {
            target = inorderCore(pRoot.right, k);
        }
        return target;
    }
}
