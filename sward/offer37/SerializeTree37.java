package sward.offer37;

import com.sun.source.tree.Tree;
import sward.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: SwordDirectionOffer
 * @description:
 * https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=13&tqId=11214&tPage=4&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author: James
 * @create: 2019-08-31 11:59
 **/
public class SerializeTree37 {

    String Serialize(TreeNode root) {
        StringBuilder sb = serialize(root, new StringBuilder());
        return sb.toString();
    }

    StringBuilder serialize(TreeNode node, StringBuilder sb) {

        if (node == null) {
            sb.append("#,");
            return sb;
        }
        sb.append(node.val + ",");
        serialize(node.left, sb);
        serialize(node.right, sb);
        return sb;
    }

    TreeNode Deserialize(String str) {
        LinkedList<String> list = new LinkedList(Arrays.asList(str.split(",")));
        return deserialize(list);
    }
    TreeNode deserialize(LinkedList<String> list) {
        if (list.get(0).equals("#")) {
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        node.left = deserialize(list);
        node.right = deserialize(list);
        return node;
    }

    public static void main(String[] args) {

    }

}
