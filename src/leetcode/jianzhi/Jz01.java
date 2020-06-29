package jianzhi;

public class Jz01 {
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        for (int i = 0; i < rows; i++) {
            int lo = 0;
            int hi = array[i].length-1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (target > array[i][mid]) lo = mid + 1;
                else if (target < array[i][mid]) hi = mid - 1;
                else return true;
            }
        }

        return false;
    }
}
