package alibaba;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 我们用两种模式，一种阻塞队列，一种
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);

        new Thread(p).start();
        new Thread(c).start();

        System.out.println("Producer and consumer start to work!");
    }

    static class Consumer implements Runnable {

        private BlockingQueue<Message> queue;

        public Consumer(BlockingQueue<Message> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                Message msg = queue.take();
                while (!msg.getMsg().equals("exit")) {
                    System.out.println("Consume: " + msg.getMsg());
                    Thread.sleep(10);
                    msg = queue.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Producer implements Runnable {

        private BlockingQueue<Message> queue;

        public Producer(BlockingQueue<Message> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(i);
                    queue.put(new Message(i+""));
                    System.out.println("Produce: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                queue.put(new Message("exit"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Message {
        public String msg;

        public Message(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }
}
