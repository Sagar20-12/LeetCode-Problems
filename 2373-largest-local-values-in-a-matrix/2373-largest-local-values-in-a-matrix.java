class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length-2;
        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                dp[i][j] = solve(grid,  i, j);
            }
        }
        return dp;
    }
    public int solve(int[][] grid, int row, int col){
        int maxV = 0;
        for(int i = row; i<row + 3; i++){
            for(int j = col; j<col + 3; j++){
                maxV = Math.max(maxV, grid[i][j]);
            }
        }
        return maxV;
    }
}