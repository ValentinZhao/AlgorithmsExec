package jianzhi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jz32 {
    public String PrintMinNumber(int [] numbers) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int n : numbers) list.add(n);
        Collections.sort(list, (n1, n2) -> {
            String s1 = n1+""+n2;
            String s2 = n2+""+n1;
            return s1.compareTo(s2);
        });
        for (int n : list) sb.append(n);
        return sb.toString();
    }
}
