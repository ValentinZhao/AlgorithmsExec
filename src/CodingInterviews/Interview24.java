package CodingInterviews;

/**
 * BST的后序遍历序列
 * @author zhaoziliang
 *
 */
public class Interview24 {
	public static boolean verifySquenceOfBST(int[] sequence){
		if(sequence.length == 0){
			return false;
		}
		if(sequence.length == 1){
			return true;
		}
		return judge(sequence, 0, sequence.length - 1);
	}

	private static boolean judge(int[] sequence, int start, int end) {
		if(start >= end){
			return true;
		}
		int i = start;
		while(sequence[i] < sequence[end]){
			++i;
		}
		for(int j = i; j < end; j++){
			if(sequence[j] < sequence[end]){
				return false;
			}
		}
		return judge(sequence, start, i - 1) &&  judge(sequence, i, end - 1);
	}
}
