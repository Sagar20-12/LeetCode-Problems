class Solution {
    public int rob(int[] nums) {
       if(nums.length == 1) return nums[0];
       int[] dp = new int[nums.length];
       Arrays.fill(dp, -1);
       //Considering the first house so we have to leave the last one so upto n-1
       int first = solve(nums, 0, nums.length-1, dp);
       Arrays.fill(dp, -1);
       //Considering the last house so we will start form 2nd house and go up till n
       int second = solve(nums, 1, nums.length, dp);
       return Math.max(first, second);
    }
    static int solve(int[] arr, int i, int n, int[] dp){
        if(i==n-1) return dp[i] = arr[i];
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        //considering the fist house 
        int take = arr[i] + solve(arr, i+2, n, dp);
        int nottake = solve(arr, i+1,n,dp);
        return dp[i] = Math.max(take, nottake);
    }
}