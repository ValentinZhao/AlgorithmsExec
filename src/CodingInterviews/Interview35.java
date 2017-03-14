package CodingInterviews;

public class Interview35 {
	public static int firstNotRepeatLetter(String str){
		if(str == null || str.length() == 0){
			return -1;
		}
		char[] c = str.toCharArray();
		int[] letters = new int['Z' + 1];
		for(char letter : c){
			letters[letter]++;//以对应字母为数组下标，记录每个字母出现的次数
		}
		for(int i = 0; i < c.length; i++){
			if(letters[c[i]] == 1){
				return i;
			}
		}
		return -1;
	}
}
