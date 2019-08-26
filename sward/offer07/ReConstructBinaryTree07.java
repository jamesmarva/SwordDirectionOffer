package sward.offer07;

import sward.TreeNode;

/**
 * @program: myleetcode
 * @description:
 * @author: James
 * @create: 2019-08-21 21:02
 **/
public class ReConstructBinaryTree07 {


    private int[] globalPre;
    private int[] globalIn;
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        globalPre = pre;
        globalIn  = in;
        return buildTree(0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode buildTree(int preBegin, int preEnd, int inBegin, int inEnd) {
        if (preBegin > preEnd) {
            return null;
        }

        TreeNode node = new TreeNode(globalPre[preBegin]);
        int dis = 0 ;
        for (int i = inBegin; i <= inEnd; ++i) {
            if (globalIn[i] == globalPre[preBegin]) {
                dis = i - inBegin;
                break;
            }
        }
        node.left = buildTree(preBegin + 1, preBegin + dis, inBegin, inBegin + dis - 1);
        node.right = buildTree(preBegin + dis + 1, preEnd, inBegin + dis +1, inEnd);
        return node;
    }

    public static void main(String[] args ) {

    }


}
