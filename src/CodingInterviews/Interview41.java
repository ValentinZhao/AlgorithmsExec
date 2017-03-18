package CodingInterviews;
/**
 * 和为s的连续正数序列
 */
import java.util.Scanner;

public class Interview41 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		findContinuousSequence(s.nextInt());
	}
	public static void findContinuousSequence(int sum){
		if(sum < 3){
			return;
		}
		int front = 1;
		int rear = 2;
		int mid = (sum + 1) >> 1;
		int currentSum = 3;
		while(front < mid){
			if(currentSum == sum){
				printContinuousSequence(front, rear);
			}
			while(front < mid && currentSum > sum){
				currentSum -= front;
				front++;//若现在比sum大，则把原来的currentSum减掉front，再把front向前移动，此时相当于缩短了sequence
				if(currentSum == sum){
					printContinuousSequence(front, rear);
				}
			}
			rear++;
			currentSum += rear;
		}
	}

	private static void printContinuousSequence(int front, int rear) {
		for(int i = front; i <= rear; ++i){
			System.out.print(i + " ");
		}
		System.out.println("");
	}
}
