package CodingInterviews;

import java.util.Arrays;

//扑克牌的顺子
public class Interview44 {
	public boolean isContinuous(int[] numbers){
		if(numbers == null || numbers.length == 0){
			return false;
		}
		Arrays.sort(numbers);
		int numOfZeros = 0;
		int numOfGaps = 0;
		for(int i = 0; i < numbers.length; i++){
			if(numbers[i] == 0){
				numOfZeros++;
			}
		}
		int small = numOfZeros;
		int big = small + 1;
		while(big < numbers.length){
			if(numbers[small] == numbers[big]){
				return false;
			}
			numOfGaps = numbers[big] - numbers[small] - 1;
			small = big;
			++big;
		}
		return numOfZeros > numOfGaps ? true : false;
	}
}
