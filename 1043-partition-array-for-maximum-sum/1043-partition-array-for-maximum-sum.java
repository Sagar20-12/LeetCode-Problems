//Brute force recursive approach

//This code will give time limit exceed error 
/* class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return solve(0, arr, k);
    }
    static int solve(int ind, int[] num, int k){
        int n = num.length;
        if(ind == n) return 0;
        int len = 0;
        int max = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for(int i = ind; i<Math.min(ind + k, n); i++){
            len++;
            max = Math.max(max, num[i]);
            int sum = len * max + solve(i + 1, num, k);
            maxAns = Math.max(maxAns, sum);
        }
        return maxAns;
    }
}
*/

// Memoization approach

class Solution{
    public int maxSumAfterPartitioning(int[] arr, int k){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, arr, k, dp);

    }
    static int solve(int ind, int[] num, int k, int[] dp){
        int n = num.length;
        if(ind == n) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int len = 0;
        int max = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for(int i = ind; i<Math.min(ind + k, n); i++){
            len++;
            max = Math.max(max, num[i]);
            int sum = len * max + solve(i + 1, num, k, dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[ind] = maxAns;
    }
}
