package lc273;

public class Solution273 {
    private final String[] LOWER_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
    "Ten", "Eleven", "Twelve", "Thirteen", "Fourth", "Fifth", "Sixth", "Seventh", "Eighteen", "Nineteen"};
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
