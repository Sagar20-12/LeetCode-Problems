class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        int[][] triangleArray = new int[n][n];
        for(int i = 0; i<n; i++){
            List<Integer> rowList = triangle.get(i);
            for(int j = 0; j<=i; j++){
                triangleArray[i][j] = rowList.get(j);
            }
        }
        return solve(0, 0, triangleArray, n, dp);
        
    }
    private int solve(int i, int j, int[][] triangle, int n, int[][] dp){
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(i == n-1)
            return triangle[i][j];
        int down = triangle[i][j] + solve(i + 1,j, triangle, n, dp);
        int diagonal = triangle[i][j] + solve(i + 1, j+1, triangle, n, dp);
        return dp[i][j] = Math.min(down, diagonal);
    }
}