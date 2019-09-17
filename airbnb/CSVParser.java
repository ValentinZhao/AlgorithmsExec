// Write a method to parse input string in CSV format.
/**
Input: csvformat

John,Smith,john.smith@gmail.com,Los Angeles,1
Jane,Roberts,janer@msn.com,"San Francisco, CA",0
"Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1 """Alexandra Alex"""

Output: escaped string

John|Smith|john.smith@gmail.com|Los Angeles|1
Jane|Roberts|janer@msn.com|San Francisco, CA|0
Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1 "Alexandra Alex"
 */

// 就大概三个规则
// 1. 碰到quote，不把这个quote记入，除非有两个连续的quote，我们只需要推一个进入当前string
// 2. 碰到逗号即结束一个string段的拼接，推入集合并重置stringbuilder
// 3. 除此之外碰到啥就在stringbuilder里面塞啥
class Solution {
    public String parseCSV(String str) {
        List<String> list = new ArrayList<>();
        boolean inQuote = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (inQuote) {
                if (str.charAt(i) == '\""') {
                    if (i < str.length() - 1 && str.charAt(i + 1) == '\""') {
                        builder.append('\""');
                    } else {
                        inQuote = false;
                    }
                } else {
                    builder.append(str.charAt(i));
                }
            } else {
                if (str.charAt(i) == '\"') {
                    inQuote = true;
                } else if (str.charAt(i) == ',') {
                    list.add(builder.toString());
                    builder.setLength(0);
                } else {
                    builder.append(str.charAt(i));
                }
            }
        }
        // 如果builder里面还有东西剩余，直接推入集合
        if (builder.length() > 0) {
            list.add(builder.toString);
        }
        return String.join('|', list);
    }
}