class Solution {

    public int isSafe(int n, int k, int target, int dp[][]) {

        if(n < 0 || target < 0) return 0;
        if(n == 0 && target == 0) return 1;

        if(dp[n][target] != -1) return dp[n][target];

        int ans = 0;

        for(int i = 1; i <= k; i++) {

            if(i <= target) {

                ans = (ans + isSafe(n-1, k, target-i, dp)) % 1000000007;
            }
        }
        dp[n][target] = ans;
        return ans;
    }

    public int numRollsToTarget(int n, int k, int target) {
        
        int dp[][] = new int[n+1][target + 1];

        for(int diceroll[] : dp) {
            Arrays.fill(diceroll, -1);
        }

        return isSafe(n, k, target, dp);
    }
}