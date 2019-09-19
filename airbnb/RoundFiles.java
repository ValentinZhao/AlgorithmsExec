/**
他们公司list价格分成好几个部分，但是都是整数，如果在美金是整数，到了欧洲的网页显示汇率转换之后就变成了floating point，然后要round成整数，但是全部加起来round，和单独rou‍‍‌‌‌‌‍‌‌‌‍‌‍‍‌‍‌‍‌nd再加起来，结果会不一样
# base price    100 =>  131.13   => 131
# cleaning fee   20 =>   26.23   => 26
# service fee    10 =>   13.54   => 14
# tax                5 =>    6.5      => 7
#                        =>  177.4E   => 178E
# sum           135$ => 178.93E => 179E

那么问题就来了，给个input list of floating points, 要求output list of integers, 满足以下两个constraint， 就是和跟Round(x1+x2+... +xn)的结果一样，但是minimize output 和input的绝对值差之和
#Input: A = [x1, x2, ..., xn]
# Sum T = Round(x1+x2+... +xn)  ;  178.93E => 179
# Output: B = [y1, y2, ...., yn]

# Constraint #1: y1+y2+...+yn = T
# Constraint #2: minimize sum(abs(diff(xi - yi)))

举例
# A = [1.2, 2.3, 3.4]
# Round(1.2 + 2.3 + 3.4) = 6.9 => 7
# 1 + 2 + 3 => 6

# 1 + 3 + 3 => 7
# 0.2 + 0.7 + 0.4 = 1.3

# 1 + 2 + 4 => 7
# 0.2 + 0.3 + 0.6 = 1.1
所以[1,2,4]比[1,3,3]要好
 */

 class Solution {
     public int[] roundUp(double[] arr) {
         int n = arr.length;
         double sum = 0;
         int floorSum = 0;
         NumWithDiff[] diffs = new NumWithDiff[n];
         for (double i = 0; i < n; i++) {
             int floor = (int) arr[i];
             int ceil = floor;
             if (floor < arr[i]) ceil++;
             diffs[i] = new NumWithDiff(ceil, ceil - arr[i]);
             sum += arr[i];
             floorSum += floor;
         }
         sum = Math.round(sum);
         int diff = sum - floorSum;
         Arrays.sort(diffs, new Comparator<NumWithDiff>() {
             @Override
             public int compare(NumWithDiff n1, NumWithDiff n2) {
                 if (n1.diffWithCeil <= n2.diffWithCeil) return -1;
                 else return 1;
             }
         });
         int[] res = new int[n];
         int i = 0;
         for (; i < diff; i++) {
             res[i] = diffs[i].num; // 把这些ceil放进去，因为diffWithCeil升序排列，这些diffWithCeil是最小的
         }
         for (; i < n; i++) {
             res[i] = diffs[i].num - 1; // 原来存的都是ceil，为了取floor直接-1
         }
         return res;
     }

     class NumWithDiff {
         int num;
         float diffWithCeil;

         public NumWithDiff(int num, float diff) {
             this.num = num;
             this.diffWithCeil = diff;
         }
     }
 }