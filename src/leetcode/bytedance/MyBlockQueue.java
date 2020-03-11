package bytedance;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockQueue {
    private Queue<Integer> queue;
    private ReentrantLock lock;

    private Condition isFull;
    private Condition isNull;

    private volatile int size;

    private volatile int capacity;

    public MyBlockQueue (int cap) {
        queue = new LinkedList<>();
        lock = new ReentrantLock();

        isFull = lock.newCondition();
        isNull = lock.newCondition();

        size = 0;
        capacity = cap;
    }

    public void add(int num) {
        try {
            lock.lock();
            while (size >= capacity) {
                System.out.println("Blocking queue is full!");
                try {
                    isFull.await();
                } catch (InterruptedException e) {
                    // release the lock if any error happens
                    isFull.signal();
                    e.printStackTrace();
                }
            }

            ++size;
            queue.offer(num);
            isNull.signal();
        } finally {
            lock.unlock();
        }
    }

    public int poll() {
        try {
            lock.lock();
            while (size <= 0) {
                System.out.println("Blocking queue is empty!");
                try {
                    isNull.await();
                } catch (InterruptedException e) {
                    // release the lock if any error happens
                    isNull.signal();
                    e.printStackTrace();
                }
            }

            --size;
            isFull.signal();
            return queue.poll();
        } finally {
            lock.unlock();
        }
    }

}
