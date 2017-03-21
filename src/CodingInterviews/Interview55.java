package CodingInterviews;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 字符流中第一个不重复的字符
 * @author zhaoziliang
 *
 */
public class Interview55 {
	private HashMap<Character, Integer> map = new HashMap<>();
	private ArrayList<Character> list = new ArrayList<>();
	public void insert(char ch){
		if(map.containsKey(ch)){
			map.put(ch, map.get(ch) + 1);
		} else {
			map.put(ch, 1);
		}
		list.add(ch);
	}
	
	public char firstAppearOnceChar(){
		char c = '#';
		for(char ch : list){
			if(map.get(ch) == 1){
				c = ch;
				break;
			}
		}
		return c;
	}
}
