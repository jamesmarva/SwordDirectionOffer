package sward.offer27;

import sward.TreeNode;

/**
 * @program: myleetcode
 * @description:
 * chrome-extension://klbibkeccnjlkjkiokjodocebajanakg/suspended.html#ttl=合并两个排序的链表_牛客网&pos=0&uri=https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-21 19:59
 **/
public class Mirror27 {


    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        pre(root);
    }

    public void pre(TreeNode node ) {
        if (node == null) {
            return;
        }
        TreeNode tempNode = node.left;
        node.left = node.right;
        node.right = tempNode;
        pre(node.left);
        pre(node.right);
    }


}
