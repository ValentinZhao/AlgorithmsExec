package lc251;

public class Solution251 {
    int i = 0, j = 0;
    int[][] vector;

    public Solution251(int[][] v) {
        this.vector = v;
    }
    
    public int next() {
        int res = vector[i][j];

        j++;
        // check empty array element
        // since j has been reset to 0
        // if vector[i].length == 0, which means we meet a empty array
        while (i < vector.length && j == vector[i].length) {
            i++;
            j = 0;
        }
        return res;
    }
    
    public boolean hasNext() {
        // check empty array element
        while (i < vector.length && j >= vector[i].length) {
            i++;
            j = 0;
        }
        return i < vector.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
