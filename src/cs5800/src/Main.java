import com.cs5800.hackerrank.DayOfTheProgrammer;
import com.neu.cs5800.AVLInsertion;
import com.neu.cs5800.AVLNode;
import com.neu.cs5800.BSTNode;
import com.neu.cs5800.NormalBSTInsertion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<int[]> list = new ArrayList<>();
//
//        NormalBSTInsertion nrmlInsrt = new NormalBSTInsertion();
//        AVLInsertion avlInsert = new AVLInsertion();
//        int times = 1000000;
//        for (int i = 0; i < times; i++) {
//            BSTNode bst = nrmlInsrt.generateBST();
//            AVLNode avl = avlInsert.generateAVL();
//            list.add(Arrays.copyOf(avlInsert.dataset, 11));
//        }
//        for (int i = 1; i < list.size(); i++) {
//            for (int j = 0; j < 11; j++) {
//                list.get(0)[j] += list.get(i)[j];
//            }
//        }
//        int[] res = new int[11];
//        for (int i = 0; i < 11; i++) {
//            res[i] = list.get(0)[i] / times;
//        }

        DayOfTheProgrammer solution = new DayOfTheProgrammer();
        String res = solution.solve(2010);
        System.out.println(res);
    }
}
