package CodingInterviews;
/**
 * 顺时针打印矩阵
 * @author zhaoziliang
 *
 */
public class Interview20 {
	public static void printMatrixClockwisely(int[][] numbers, int columns, int rows){
		if(numbers == null || columns <= 0 || rows <= 0){
			return;
		}
		int start = 0;
		while(columns > start * 2 && rows > start * 2){
			printMatrixInCircle(numbers, columns, rows, start);
			++start;
		}
	}

	private static void printMatrixInCircle(int[][] numbers, int columns, int rows, int start) {
		int endX = columns - 1 - start;
		int endY = rows - 1 - start;
		//从左至右
		for(int i = start; i <= endX; ++i){
			int number = numbers[start][i];
			System.out.println(number);
		}
		//从上至下
		if(start < endY){
			for(int i = start + 1; i <= endY; ++i){
				int number = numbers[i][endX];
				System.out.println(number);
			}
		}
		//从右至左
		if(start < endX && start < endY){
			for(int i = endX - 1; i >= start; --i){
				int number = numbers[endY][i];
				System.out.println(number);
			}
		}
		//从下至上
		if(start < endY - 1 && start < endX){
			for(int i = endY - 1; i >= start + 1; --i){
				int number = numbers[i][start];
				System.out.println(number);
			}
		}
	}
}
