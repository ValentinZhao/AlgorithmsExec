package alibaba;

public class Singleton {
    private static volatile Singleton uniqueInstance = null;

    public static Singleton getInstance() {
        if (uniqueInstance == null) { // 第一次检查，单纯看是否实例化过
            synchronized (Singleton.class) {
                if (uniqueInstance == null) { // 第二次检查，主要是避免通过第一次检查的线程重复创建。因为有可能存在释放锁之后进入第二检查的线程
                    uniqueInstance = new Singleton(); // new的时候，是有三个步骤的，要避免指令重排：1 分配内存空间 2 初始化对象 3 将对象指向刚分配的内存空间
                }
            }
        }
        return uniqueInstance;
    }
}
