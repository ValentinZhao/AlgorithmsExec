package lc443;

public class Solution443 {
    public int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            // 只要下一位字母和当前位一致，就推动read，直到下一位不一样了
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                // anchor就是待压缩串的起始位置
                // write是一个跟随read的变量，当read到了当前repeat的结尾，就由write来复写in-place原数组
                // 这里write++的原因是写好了第一个字符，准备在后面写数字了
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    // 数字打散，塞进去，最后write会停在下一个repeat组的第一位
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
}
