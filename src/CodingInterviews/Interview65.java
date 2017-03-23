package CodingInterviews;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 滑动窗口中最大的值
 * @author zhaoziliang
 * 对于新来的元素k，将其与双端队列中的元素相比较
 * 前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了！）
 * 前面比k大的x，比较两者下标，判断x是否已不在窗口之内，不在了，直接移出队列
 * 队列中的第一个元素是滑动窗口的最大值
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
		for(int i = 0; i < size - 1; i++){//先对前size - 1个，也就是滑动窗口初始状态时应记录的最大值进行记录，若是降序的则都进入队列
			while(!indexDeque.isEmpty() && num[indexDeque.getLast()] < num[i]){
				indexDeque.removeLast();
			}
			indexDeque.addLast(num[i]);
		}
		for(int i = size - 1; i < num.length; i++){//从初始状态往后一个一个走
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
