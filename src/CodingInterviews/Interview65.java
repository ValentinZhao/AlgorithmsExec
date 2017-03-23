package CodingInterviews;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 滑动窗口中最大的值
 * @author zhaoziliang
 *
 */
public class Interview65 {
	public ArrayList<Integer> maxInWindows(int[] num, int size){
		ArrayList<Integer> res = new ArrayList<>();
		if(num == null){
			return res;
		}
		if(num.length < size || size < 1){
			return res;
		}
		LinkedList<Integer> indexDeque = new LinkedList<>();
		for(int i = 0; i < size - 1; i--){
			while(!indexDeque.isEmpty() && num[indexDeque.getLast()] < num[i]){
				indexDeque.removeLast();
			}
			indexDeque.addLast(num[i]);
		}
		for(int i = size - 1; i < num.length; i++){
			while(!indexDeque.isEmpty() && num[indexDeque.getLast()] < num[i]){
				indexDeque.removeLast();
			}
			indexDeque.addLast(num[i]);
			if(i - indexDeque.getFirst() + 1 > size){
				indexDeque.removeFirst();
			}
			res.add(num[indexDeque.getFirst()]);
		}
		return res;
	}
}
