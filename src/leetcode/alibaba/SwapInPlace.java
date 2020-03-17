package alibaba;

/**
 * int a=10,b=12; //a=1010^b=1100;
 * a=a^b; //a=0110^b=1100;
 * b=a^b; //a=0110^b=1010;
 * a=a^b; //a=1100=12;b=1010;
 * 此算法能够实现是由异或运算的特点决定的，通过异或运算能够使数据中的某些位翻转，其他位不变。这就意味着任意一个数与任意一个给定的值连续异或两次，值不变。
 * ————————————————
 * 版权声明：本文为CSDN博主「ispotu」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/superit401/article/details/51228416
 */
public class SwapInPlace {
    public static void swapInPlace(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a: " + a + " b: " + b);
    }

    public static void main(String[] args) {
        swapInPlace(10, 12);
    }
}
