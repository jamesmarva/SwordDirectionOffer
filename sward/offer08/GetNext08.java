package sward.offer08;

import sward.TreeLinkNode;

/**
 * @program: SwordDirectionOffer
 * @description:
 * https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=3&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-29 07:39
 **/
public class GetNext08 {


    /**
     * 1 如果有右子树的，那么就是找右子树的那个最左的节点
     * 2
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null ) {
            return pNode.next;
        }

        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else if (pNode.next != null) {
            TreeLinkNode current = pNode;
            TreeLinkNode parent = pNode.next;
            while (parent != null && current == parent.right) {
                current = parent;
                parent = parent.next;
            }
            return parent;
        }
        return null;

    }

}
