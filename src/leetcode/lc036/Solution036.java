package lc036;

import java.util.HashSet;

/**
 * Stefan非常巧妙的算法，只需要nested loop板子，然后维护hashset作为历史存储，比较当前数字与该行i该列j，以及i/3和j/3位置的值即可
 * 这个/3的算法非常巧妙，我们知道板子是9x9的，每个位置都除3的话相当于把所有格子都映射到3x3的小板子里，意味着**所有的3x3小格子内，所有格子的坐标在映射后都一样**
 * 这句话的意思是，比如从左到右数第4个sub-grid，它的坐标系为
 * [(3,0), (3,1), (3,2)                     [(1,0), (1,0), (1,0)
 *  (4,0), (4,1), (4,2)   在映射后就变成了     (1,0), (1,0), (1,0)
 *  (5,0), (5,1), (5,2)]                     (1,0), (1,0), (1,0)]
 * 这就非常巧妙，我们在记录下横纵坐标的同时记录下格子的值，用字符串串在一起作为signature来比较就可以知道是否在自己的sub-grid出现过了
 * 比如原来的(3,0)位置有一个值5，那就穿起来就是"5 in block 3 0"的这样一串signature，如果这个sub-grid又有一个5，那会生成一样的signature，此时就可全局返回false了
 * hashset.add如果加入了duplicate的值会返回false
 */
public class Solution036 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!set.add(number + "in row" + i) ||
                            !set.add(number + "in col" + j) ||
                            !set.add(number + "in block" + i/3 + '-' + j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
