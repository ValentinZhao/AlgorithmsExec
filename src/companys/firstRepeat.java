package companys;

import java.util.HashSet;
import java.util.Set;

public class firstRepeat {
	public char findFirstRepeat(String A, int n) {
        // write code here
        Set<Character> set = new HashSet<>();
        char[] array = A.toCharArray();
        for(int i = 0; i < n; i++){
            if(!set.add(array[i])){
                return array[i];
            }
        }
        return '0';
    }
}
