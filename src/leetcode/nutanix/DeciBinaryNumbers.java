package nutanix;


/**
 * Given a number, you have to represent this number as sum of minimum number of possible psuedobinary numbers.
 * A number is said to be psuedobinary number if its decimal number consists of only two digits (0 and 1).
 * Example: 11,10,101 are all psuedobinary numbers.
 *
 * Input : 44
 * Output : 11 11 11 11
 *
 * Explanation : 44 can be represented as sum of
 * minimum 4 psuedobinary numbers as 11+11+11+11
 *
 * Input : 31
 * Output : 11 10 10
 *
 * Explanation : 31 can be represented as sum of
 * minimum 3 psuedobinary numbers as 11+10+10
 */
public class DeciBinaryNumbers {
    public static void psuedoBinary(int n)
    {
        // Repeat below steps until n > 0
        while (n != 0)
        {
            // calculate m (A number that has same
            // number of digits as n, but has 1 in
            // place of non-zero digits 0 in place
            // of 0 digits)
            int temp = n, m = 0, p = 1;
            while(temp != 0)
            {
                int rem = temp % 10;
                temp = temp / 10;

                if (rem != 0)
                    m += p;

                p *= 10;
            }

            System.out.print(m + " ");

            // subtract m from n
            n = n - m;
        }
        System.out.println(" ");
    }
}
