package collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Queue {

    // LinkedList 는 크게 3가지로 사용할수있다.
    // 1. List , 2. Deque 3. Queue
    // 왜 LinkedList 로받지? queue 를 Node 로 관리하면 LinkedList 로받는것.
    public static void main(String[] args) {
        java.util.Queue<Integer> queue = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    }
}
