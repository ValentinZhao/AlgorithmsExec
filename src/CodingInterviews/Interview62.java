package CodingInterviews;

import CodingInterviews.Interview27.BinaryTreeNode;

/**
 * 序列化二叉树
 * @author zhaoziliang
 *
 */
public class Interview62 {
	public static int index = -1;
	public static String serialize(BinaryTreeNode head){
		StringBuilder builder = new StringBuilder();
		if(head == null){
			builder.append("#,");
			return builder.toString();
		}
		builder.append(head.value + ",");
		builder.append(serialize(head.left));
		builder.append(serialize(head.right));
		return builder.toString();
	}
	
	public static BinaryTreeNode deserialize(String str){
		index++;
		int len = str.length();
		if(index >= len){
			return null;
		}
		String[] strr = str.split(",");
		BinaryTreeNode node = null;
		if(!strr[index].equals("#")){
			node = new BinaryTreeNode(Integer.valueOf(strr[index]));
			node.left = deserialize(str);
			node.right = deserialize(str);
		}
		return node;
	}
}
