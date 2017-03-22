package CodingInterviews;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import CodingInterviews.Interview27.BinaryTreeNode;

/**
 * 按之字形顺序打印之字形
 * @author zhaoziliang
 *
 */
public class Interview61 {
	ArrayList<ArrayList<Integer>> printByZippedLayer(BinaryTreeNode head){
		if(head == null){
			return null;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> layerResult = new ArrayList<>();
		LinkedList<BinaryTreeNode> queue = new LinkedList<>();
		queue.addLast(null);//层分隔符
		queue.addLast(head);
		boolean leftToRight = true;
		while(!queue.isEmpty()){
			BinaryTreeNode cur = queue.removeFirst();
			if(cur == null){//到达层分隔符
				Iterator<BinaryTreeNode> iterator = null;
				if(leftToRight){
					iterator = queue.iterator();
				} else {
					iterator = queue.descendingIterator();
				}
				leftToRight = !leftToRight;
				while(iterator.hasNext()){
					BinaryTreeNode temp = iterator.next();
					layerResult.add(temp.value);
				}
				result.add(new ArrayList<Integer>(layerResult));
				layerResult.clear();
				queue.addLast(null);//插入层分隔符
				continue;
			}
			if(cur.left != null) queue.addLast(cur.left);
			if(cur.right != null) queue.addLast(cur.right);
		}
		return result;
	}
}
