package sward.offer28;

import sward.TreeNode;

/**
 * @program: SwordDirectionOffer
 * @description:
 * https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author: James
 * @create: 2019-08-29 08:09
 **/
public class IsSymmetrical28 {


    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null ) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        inOrder(pRoot, sb);
        StringBuilder sb1 = new StringBuilder();
        reverseInOrder(pRoot, sb1);
        System.out.println(sb.toString());
        System.out.println(sb1.toString());
        if (sb.toString().equals(sb1.toString())) {
            return true;
        } else {
            return false;
        }
    }

    private void inOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val+",");
        inOrder(node.left, sb);
        inOrder(node.right, sb);
    }

    private void reverseInOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val+",");
        reverseInOrder(node.right, sb);
        reverseInOrder(node.left, sb);
    }

    boolean isSymmetricalBetter(TreeNode pRoot) {
        return  isSymmetricalBetter( pRoot, pRoot);
    }

    boolean isSymmetricalBetter(TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        } else if (first == null || second == null) {
            return false;
        } else if (first.val != second.val) {
            return false;
        }
        boolean isFirstSymmetrical = isSymmetricalBetter(first.left, second.right);
        boolean isSecondSymmetrical = isSymmetricalBetter(first.right, second.left);
        return isFirstSymmetrical && isSecondSymmetrical;

    }



}
