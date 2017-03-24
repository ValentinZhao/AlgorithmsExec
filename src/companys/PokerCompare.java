package companys;

import java.util.Scanner;

public class PokerCompare {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String[] left, right;
		String nextLine;
		String output = null;
		nextLine = s.nextLine();
		String[] comparePairs = nextLine.split("-");
		left = comparePairs[0].split(" ");
		right = comparePairs[1].split(" ");
		//王炸最大
		if(nextLine.contains("joker JOKER")){
			output = "joker JOKER";
		} else if(left.length == 4 && right.length != 4){//接下来就是炸弹最大
			output = comparePairs[0];
		} else if(right.length == 4 && left.length != 4){
			output = comparePairs[1];
		} else if(left.length == right.length){//其他情况就是对子、顺子等这种情况，我们直接比较其最小的数值，因为按照规则顺子只能对顺子，对子只能对对子
			if(compute(left[0]) < compute(right[0])){
				output = comparePairs[1];
			} else {
				output = comparePairs[0];
			}
		} else {
			output = "ERROR";
		}
		
		System.out.println(output);
	}

	private static int compute(String str) {
		return "345678910JQKA2jokerJOKER".indexOf(str);//indexOf函数返回参数这个传入的子串在对象字符串中第一次出现的位置
	}
}
