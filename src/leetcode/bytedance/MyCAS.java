//package bytedance;
//
//import sun.misc.Unsafe;
//
//import java.lang.reflect.Field;
//
//public class MyCAS {
//    int i = 0;
//
//    //Unsafe unsafe = Unsafe.getUnsafe()//不能直接使用，需要通过反射来获取
//    static Unsafe unsafe; // java 中操作内存的一个类
//    static long valueOffset; //内存中的地址(偏移量)
//
//    static {
//        try {
//            Field field = Unsafe.class.getDeclaredField("theUnsafe");
//            field.setAccessible(true);  //因为是私有，设置成可访问
//            unsafe = (Unsafe) field.get(null);
//            // 通过数据去拿到内存中的i地址（偏移量）
//            // 直接操作内存，获取属性的偏移量（同它来定位对象内具体属性的内存地址）
//            valueOffset = unsafe.objectFieldOffset(MyCAS.class.getDeclaredField("i"));
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void increment() {
//        int current = 0; // 内存中的值,当前值
//        do {
//            current = unsafe.getIntVolatile(this,valueOffset); // 获取当前内存中的值
//
//        } while (!unsafe.compareAndSwapInt(this, valueOffset, current, current+1));
//    }
//
//    public static void main(String[] args) {
//        MyCAS myCAS = new MyCAS();
//
//        for (int i = 0; i < 2; i++) {
//            new Thread(() -> {
//                for (int j = 0; j < 10000; j++) {
//                    myCAS.increment();
//                }
//            }).start();
//        }
//
//        System.out.println("Start to increment, wait a minute plz!");
//
//        try {
//            Thread.sleep(2000);
//            System.out.println("i="+myCAS.i);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
