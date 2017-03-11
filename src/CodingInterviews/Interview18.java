package CodingInterviews;

/**
 * 树的子结构
 * @author zhaoziliang
 *
 */
public class Interview18 {
	class BinaryTreeNode{
		int value;
		BinaryTreeNode left;
		BinaryTreeNode right;
	}
	
	public static boolean hasSubtree(BinaryTreeNode head1, BinaryTreeNode head2){
		boolean result = false;
		if(head1 != null && head2 != null){
			result = doesTree1HasTree2(head1, head2);
			if(!result){
				result = hasSubtree(head1.left, head2);
			}
			if(!result){
				result = hasSubtree(head1.right, head2);
			}
		}
		return result;
	}

	private static boolean doesTree1HasTree2(BinaryTreeNode head1, BinaryTreeNode head2) {
		if(head2 == null){
			return true;
		}
		if(head1 == null){
			return false;
		}
		if(head1.value != head2.value){
			return false;
		}
		return doesTree1HasTree2(head1.left, head2.left) && 
				doesTree1HasTree2(head1.right, head2.right);
	}
}
