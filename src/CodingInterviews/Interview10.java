package CodingInterviews;

public class Interview10 {
	
	public int numOfOnes(int n){
		if(n == 0){
			return 0;
		}
		int count = 0;
		int flag = 1;
		while(flag != 0){
			if(n & flag){
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
}
