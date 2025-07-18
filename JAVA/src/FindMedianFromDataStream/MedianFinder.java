package FindMedianFromDataStream;
import java.util.*;
public class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll());
    }

    public double findMedian() {
        if(maxHeap.size()>minHeap.size()) return (double)maxHeap.peek();
        else return (maxHeap.peek()+minHeap.peek())/2.0;
    }
}