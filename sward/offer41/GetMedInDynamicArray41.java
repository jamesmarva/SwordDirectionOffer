package sward.offer41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: SwordDirectionOffer
 * @description:
 * @author: James
 * @create: 2019-08-31 15:37
 **/
public class GetMedInDynamicArray41 {

    // poll 是当下最大的，最大堆
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);

    // poll 是当下最小的, 最小堆
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    public void Insert(Integer num) {
        if (left.size() == right.size()) {
            right.offer(num);
            Integer temp = right.poll();
            left.offer(temp);
        } else {
            left.offer(num);
            Integer temp = left.poll();
            right.offer(temp);
        }
    }

    public Double GetMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek() / 1.0;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        Integer[] ints = {1, 2, 9, 8, 3, 5, 7, 4, 6};
        left.addAll(Arrays.asList(ints));
        while (left.size() > 0) {
            System.out.println(left.poll());
        }
        System.out.println("-----------------------");
        right.addAll(Arrays.asList(ints));
        while (right.size() > 0) {
            System.out.println(right.poll());
        }
    }
}
