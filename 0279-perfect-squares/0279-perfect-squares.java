class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        return solve(n, dp);
    }
    public int solve(int n, int[] dp){
        if(n<4)
            return n;
        if(dp[n]!=0)
            return dp[n];
        int ans = n;
        for(int i = 1; i*i<=n; i++){
            int square = i*i;
            ans = Math.min(ans, 1 + solve(n-square, dp));
        }
        return dp[n] = ans;
    }
}