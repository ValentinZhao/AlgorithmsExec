public class Solution463 {
    public int islandPerimeter(int[][] grid) {
      int m = grid.length, n = grid[0].length;
      int count = 0;
      int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
      for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
          if(grid[i][j] == 1){
            for(int[] d:  dir){
              int x = i + d[0], y = j + d[1];
              if(x < 0 || y < 0 || x == m || y == n || grid[x][y] == 0){
                count++;
              }
            } 
          }
        }
      }
      return count;  
    }
}
