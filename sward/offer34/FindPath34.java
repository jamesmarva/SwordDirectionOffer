package sward.offer34;

import sward.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: myleetcode
 * @description:
 * offer 34
 * @author: James
 * @create: 2019-08-24 07:42
 **/
public class FindPath34 {

    public int globalTarget;
    public ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        globalTarget = target;
        preTraverse(root, new ArrayList<Integer>(), 0);
        ans.sort((o1, o2) -> o2.size() - o1.size());
        return ans;
    }

    public void preTraverse(TreeNode node, ArrayList<Integer> tempList, int tempTarget) {
        if (node == null) {
            return;
        }
        int temp = tempTarget + node.val;
        tempList.add(node.val);
        if (temp == globalTarget && node.left == null && node.right == null) {
            ans.add((ArrayList) tempList.clone());
        }
        preTraverse(node.left, tempList, temp);
        preTraverse(node.right, tempList, temp);
        tempList.remove(tempList.size() - 1);
    }

    public static void main(String[] args) {
        Integer[] test = {1, 2, 3, 4, 5};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(test));
        ArrayList<Integer> listClone = (ArrayList) list.clone();
        System.out.println(listClone);
    }
}
