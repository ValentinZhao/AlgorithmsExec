package CodingInterviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import CodingInterviews.Interview27.BinaryTreeNode;

/**
 * 把二叉树打印多行
 * @author zhaoziliang
 *
 */
public class Interview60 {
	ArrayList<ArrayList<Integer>> printByLayer(BinaryTreeNode head){
		if(head == null){
			return null;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> layerResult = new ArrayList<>();
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		int start = 0;
		int end = 1;
		queue.offer(head);
		while(!queue.isEmpty()){
			BinaryTreeNode cur = queue.poll();
			layerResult.add(cur.value);
			start++;
			if(cur.left != null) queue.offer(cur.left);
			if(cur.right != null) queue.offer(cur.right);
			if(start == end){
				//会达到这个条件就是说明当前层已经都访问到了。
				//原因就在于在上一层退出队列后会把子节点推入队列
				//这样当上一层遍历完之后，这时在队列中的就是正好是下一层的所有子节点了
				//这时候queue.size()就正好是end应该指向的指针
				end = queue.size();
				start = 0;
				result.add(layerResult);
				layerResult = new ArrayList<Integer>();
			}
		}
		return result;
	}
}
