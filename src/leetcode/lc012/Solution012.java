package lc012;

public class Solution012 {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) return "";
        // 规律是，只组出1，4，5，9、10，40，50，90...就可以组成该区间内所有数字了
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                builder.append(strs[i]);
            }
        }
        return builder.toString();
    }
}