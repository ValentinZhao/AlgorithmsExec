package lc804;

import java.util.HashSet;
import java.util.Set;

public class Solution804 {
    private String[] MORSE_DICT = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                builder.append(MORSE_DICT[word.charAt(i)-'a']);
            }
            set.add(builder.toString());
        }
        return set.size();
    }
}
