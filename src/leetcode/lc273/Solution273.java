package lc273;

public class Solution273 {
    private final String[] LOWER_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
    "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String word = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                word = helper(num % 1000) + THOUSANDS[i] + " " + word;
            }
            num /= 1000;
            i++;
        }
        return word.trim();
    }

    private String helper(int i) {
        if (i == 0) return "";
        else if (i < 20) return LOWER_THAN_20[i] + " ";
        else if (i < 100) return TENS[i / 10] + " " + helper(i % 10);
        else return LOWER_THAN_20[i / 100] + " Hundred " + helper(i % 100);
    }
}

class Solution {
    private final String[] LOWER_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int idx = 0;
        String word = "";
        while (num != 0) {
            if (num % 1000 != 0) {
                // 这里的THOUSANDS[idx]就很关键，一开始idx是0，这里是没有字符串的，也就是说，当num本身并不大于1000时
                // 这里直接就返回的是helper()返回的单词，然后就结束了，很巧妙！
                // 那么如果是大于1000的，我们通过取余，把百位及以前的数字全部翻译过英语后，返回给word，这种情况下在第一步时也是不需要千位的
                word = helper(num%1000) + THOUSANDS[idx] + " " + word;
            }
            idx++;
            num /= 1000;
        }
        return word.trim();
    }

    private String helper(int i) {
        if (i == 0) return "";
        else if (i < 20) return LOWER_THAN_20[i] + " "; // 小于20，那就只需要返回那个数字
        else if (i < 100) return TENS[i/10] + " " + helper(i%10); // 大于20小于100，那他应该是比如32，那应该是Thirty Two，那就应该是这样返回
        else return LOWER_THAN_20[i/100] + " Hundred " + helper(i%100);// 大于100，那他应该是比如225，那应该是Two Hundred Twenty Five，那就应该是这样返回
    }
}