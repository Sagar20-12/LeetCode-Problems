class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    solvedfs(i, j, grid, vis);
                    count++;
                }
            }
        }
        return count;
    }
    public static void solvedfs(int row, int col, char[][] grid, boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = true;
        // we have to move in all direction
        int[] dp1 = {1, -1, 0, 0};
        int[] dp2 = {0,0,-1,1};
        for(int i = 0; i<4; i++){
            int nrow = dp1[i] + row;
            int ncol = dp2[i] + col;
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol <m && !vis[nrow][ncol] && grid[nrow][ncol] == '1'){
                solvedfs(nrow, ncol, grid, vis);
            }
        }
    }
}