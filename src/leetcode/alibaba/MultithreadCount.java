package alibaba;

public class MultithreadCount {

    static class MyThread1 implements Runnable {

        // 下面两个使用static，是为了提出锁和变量，让线程共用
        private static Object lock = new Object();

        private static int count = 0;

        private int id;

        public MyThread1(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (count > 100) break;
                    // 对应编号转到你了才能++
                    if (count % 3 == this.id) {
                        System.out.println(this.id + "--->" + count);
                        count++;
                    } else {
                        try {
                            // lock wait会释放锁并进入等待状态
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 操作都完成，就释放锁让其他线程继续
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyThread1(0));
        Thread t2 = new Thread(new MyThread1(1));
        Thread t3 = new Thread(new MyThread1(2));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}