package lc158;

public class Solution158 extends Read4 {
    private int buffPointer = 0; // 记录read4返回的buff中，我们已经读到了哪一位
    private int buffCounter = 0; // 记录read4返回的buff的长度
    private char[] buff = new char[4]; // 给read4一个buff array
    public int read(char[] buf, int n) {
        // 每次调用前都初始化的pointer，记录我们read()方法读到哪里了
        // 为什么每次都初始化呢？因为我们的buf需要每次调用时只返回我们本次读到的东西
        // 所以每次都从头读
        int pointer = 0;
        while (pointer < n) {
            // 初始化也好，还是读完了reset过之后也好
            // 只要buffPointer是0，我们就要调用一下read4
            if (buffPointer == 0) {
                buffCounter = read4(buff);
            }
            if (buffCounter == 0) break;
            // 下面两个不等式都不能是等号，因为会数组越界
            while (pointer < n && buffPointer < buffCounter) {
                buf[pointer++] = buff[buffPointer++];
            }
            // 读到结尾了要reset
            if (buffPointer >= buffCounter) buffPointer = 0;
        }
        return pointer;
    }
}

class Read4 {
    public int read4(char[] buff) {
        return 4;
    }
}
