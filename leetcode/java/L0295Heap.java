package leetcode.java;

import java.util.*;

class MedianFinder {
    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */

    private PriorityQueue<Double> minQueue;
    private PriorityQueue<Double> maxQueue;

    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double a, Double b) {
                if (a == b)
                    return 0;
                else if (a < b)
                    return 1;
                else
                    return -1;
            }
        });
    }

    public void addNum(int num) {
        if (minQueue.size() == 0)
            minQueue.offer(Double.valueOf(num));
        else if (num < minQueue.peek())
            maxQueue.offer(Double.valueOf(num));
        else
            minQueue.add(Double.valueOf(num));
        while (maxQueue.size() - minQueue.size() > 1)
            minQueue.add(maxQueue.poll());
        while (minQueue.size() - maxQueue.size() > 1)
            maxQueue.add(minQueue.poll());
    }

    public double findMedian() {
        System.out.println(String.format("Queue size: [min]%d [max]%d", minQueue.size(), maxQueue.size()));
        System.out.println(minQueue);
        System.out.println(maxQueue);
        if (minQueue.size() == maxQueue.size())
            return (minQueue.peek() + maxQueue.peek()) / 2;
        else
            return minQueue.size() > maxQueue.size() ? minQueue.peek() : maxQueue.peek();
    }
}

public class L0295Heap {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1); // arr = [1]
        medianFinder.addNum(2); // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3); // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(7);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(8);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(9);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian()); // return 2.0);
    }
}
