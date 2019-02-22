package lc722;

import java.util.ArrayList;
import java.util.List;

/**
 * 就是硬核一句句的来匹配//和/*以及 *\/,遇到相关的token，我们就在循环遍历中把对应的东西跳过
 * 直到它的pair出现把模式调转
 */
public class Solution722 {
    public List<String> removeComments(String[] source) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean mode = false;
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (mode) {
                    if (line.charAt(i) == '*' && i < line.length() - 1 && line.charAt(i + 1) == '/') {
                        i++;
                        mode = false;
                    }
                } else {
                    if (line.charAt(i) == '/' && i < line.length() - 1 && line.charAt(i + 1) == '/') break;
                    else if (line.charAt(i) == '/' && i < line.length() - 1 && line.charAt(i + 1) == '*') {
                        i++; // 因为这个循环走完之后，i又会加1，这就使得i加了两次，也就把i+1位置的字符跳过了
                        mode = true;
                    } else {
                        sb.append(line.charAt(i));
                    }
                }
            }
            if (!mode && sb.length() > 0) {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return list;
    }
}
