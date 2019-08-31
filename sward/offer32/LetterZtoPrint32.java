package sward.offer32;

import sward.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: SwordDirectionOffer
 * @description:
 * @author: James
 * @create: 2019-08-31 11:12
 **/
public class LetterZtoPrint32 {

    /**
     * 之字形打印
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> zPrint(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int add = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            LinkedList<Integer> tempList = new LinkedList<>();
            while (count > 0) {
                TreeNode temp = queue.poll();
                tempList.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                count--;
            }
            if (add % 2 == 0) {
                ans.add(new ArrayList<>(tempList));
            } else {
                ArrayList<Integer> ansTempList = new ArrayList<>();
                while (!tempList.isEmpty()) {
                    ansTempList.add(tempList.removeLast());
                }
                ans.add(ansTempList);
            }
            add++;
        }
        return ans;
    }


    public ArrayList<ArrayList<Integer>> zPrintBetter(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) {
            return ans;
        }
        Stack<TreeNode> stackZero = new Stack<>();
        Stack<TreeNode> stackOne = new Stack<>();
        stackZero.push(pRoot);
        int add = 0;
        while ((!stackZero.isEmpty()) || (!stackOne.isEmpty())) {
            ArrayList<Integer> tempList = new ArrayList<>();
            if (add % 2 == 0) {
                while (!stackZero.isEmpty()) {
                    TreeNode temp = stackZero.pop();
                    tempList.add(temp.val);
                    if (temp.left != null) {
                        stackOne.push(temp.left);
                    }
                    if (temp.right != null) {
                        stackOne.push(temp.right);
                    }
                }
            } else {
                while (!stackOne.isEmpty()) {
                    TreeNode temp = stackOne.pop();
                    tempList.add(temp.val);
                    if (temp.right != null) {
                        stackZero.push(temp.right);
                    }
                    if (temp.left != null) {
                        stackZero.push(temp.left);
                    }
                }
            }
            ans.add(tempList);
            add++;
        }
        return ans;
    }
}
