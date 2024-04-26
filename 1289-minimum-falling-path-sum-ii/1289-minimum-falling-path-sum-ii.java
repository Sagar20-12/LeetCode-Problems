// class Solution {
//     public int minFallingPathSum(int[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        int ans = Integer.MAX_VALUE;
//        for(int j = 0; j<m; j++){
//         ans = Math.min(ans, grid[0][j] + solve(grid, 1, j));
//        }
//        return ans;
//     }
//     public static int solve(int[][] grid, int i, int notj){
//         int n = grid.length;
//         int m = grid[0].length;
//         if(i == n) return 0;
//         int ans = Integer.MAX_VALUE;
//         for(int j = 0; j<m; j++){
//             if(j == notj) continue;
//             ans = Math.min(ans, grid[i][j] + solve(grid, i+1, j));
//         }
//         return ans;
//     }
// }

class Solution {
    public static int solve(int i, int j, int grid[][], int dp[][]) {
        if (i == grid.length) {
            return 0;
        }
        if (dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < grid[i].length; k++) {
            if (k == j) continue;
            min = Math.min(min, grid[i][k] + solve(i + 1, k, grid, dp));
        }
        return dp[i][j] = min;
    }

    public int minFallingPathSum(int[][] grid) {
        int dp[][] = new int[grid.length + 1][grid.length + 1];
        for (int num[] : dp) Arrays.fill(num, -1);
        return solve(0, grid.length, grid, dp);
    }
}