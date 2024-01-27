class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return solve(n, k, dp);
    }
    public static final int MOD = 1000000007;
    public int solve(int n, int k, int[][] dp){
        if(k<0) return 0;
        else if(k == 0) return 1;
        else if(n<=0) return 0;
        else if(dp[n][k]!=-1) return dp[n][k];

        // Checking the permutation of the digit to be in inverse pair
        // check striver method of always taking 'left' and 'right'
        dp[n][k] = (solve(n-1,k,dp) + solve(n, k-1, dp))%MOD;
        dp[n][k] = (dp[n][k] - solve(n-1, k-n, dp) + MOD)%MOD;
        return dp[n][k];
    }
}