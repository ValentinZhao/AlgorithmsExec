package alibaba;

public class Deadlock {
    public static void main (String[] args) {
        Object A = new Object();
        Object B = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                synchronized (A) {
                    System.out.println(name+" gets lock A and wants B");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println(name+" gets lock B!");
                        System.out.println(name+" say hello!");
                    }
                }
            }
        }, "Thread A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                synchronized (B) {
                    System.out.println(name+" gets lock B and wants A");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (A) {
                        System.out.println(name+" gets lock A!");
                        System.out.println(name+" say hello!");
                    }
                }
            }
        }, "Thread A").start();
    }
}