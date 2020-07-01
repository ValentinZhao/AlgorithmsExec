package jianzhi;

public class Jz13 {
    public void reOrderArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            // j > i是保证j不会是0，这样j-1永远不会越界
            // 这里的意思就是，j永远是扫i后面的子数组
            for (int j = array.length-1; j > i; j--) {
                if (array[j] % 2 == 1 && array[j-1] % 2 == 0) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }
        }
    }
}
