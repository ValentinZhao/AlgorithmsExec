package companys;

public class MaxInnerRec {
	public int countArea(int[] A, int n) {
        // write code here
        int maxArea = 0;
        int min;
        for(int i = 0; i < n; i++){
            min = Integer.MAX_VALUE;
            for(int j = i; j >= 0; j--){
                min = Math.min(min, A[j]);
                maxArea = Math.max(maxArea, (i - j + 1) * min);
            }
        }
        return maxArea;
    }
}
