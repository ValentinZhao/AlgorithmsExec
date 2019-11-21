package lc1052;

public class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int base = 0; // 代表一开始有多少客人本来就会很满意
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) base += customers[i];
        }

        int[] sadCustomers = new int[customers.length];
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                sadCustomers[i] = customers[i];
            }
        }

        int gain = 0;
        for (int i = 0; i < X; i++) {
            gain += sadCustomers[i];
        }

        int max = gain;
        for (int i = X; i < sadCustomers.length; i++) {
            gain += sadCustomers[i];
            gain -= sadCustomers[i-X];
            max = Math.max(max, gain);
        }

        return base + max;
    }
}
