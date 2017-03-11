package CodingInterviews;

/**
 * 调整数组使奇数位于偶数前面
 * @author zhaoziliang
 *
 */

public class Interview14 {
	public static void main(String[] args){
		
	}
	
	public static void reorderOddAndEven(int[] number, int length){
		if(number == null || length == 0){
			return;
		}
		int begin = 0;
		int end = length - 1;
		while(begin < end){
			while(begin < end && (number[begin] & 0x1) != 0){//位与1相当于对2求余
				begin++;//取到偶数时停下
			}
			while(begin < end && (number[end] & 0x1) == 0){
				end--;//取到奇数时停下
			}
			if(begin < end){
				int temp = begin;
				begin = end;
				end = temp;
			}
		}
	}
}
