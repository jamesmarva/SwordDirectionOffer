package sward.offer35;

import java.util.HashMap;

/**
 * @program: myleetcode
 * @description:
 * https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=13&tqId=11178&tPage=2&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * @author: James
 * @create: 2019-08-24 08:52
 **/
public class Clone35 {
    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode node = dummy;
        RandomListNode pNode = pHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (pNode != null)  {
            RandomListNode temp = new RandomListNode(pNode.label);
            node.next = temp;
            map.put(pNode, temp);
            node = node.next;
            pNode = pNode.next;
        }
        pNode = pHead;
        node = dummy.next;
        while (pNode != null) {
            RandomListNode randomTemp = pNode.random;
            if (randomTemp != null && map.containsKey(randomTemp)) {
                node.random = map.get(randomTemp);
            }
            node = node.next;
            pNode = pNode.next;
        }
        return dummy.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
