//Brute force approach
/*class Solution {
    public int sumSubarrayMins(int[] arr) {
        int ans = 0;
        for(int i = 0; i<arr.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = i; j<arr.length; j++){
                min = Math.min(min, arr[j]);
                ans+=min;
            }
        }
        return ans;
    }
}*/

//Optimal Dynamic programming Approach

class Solution{
    public int sumSubarrayMins(int[] arr){
        int MOD = 1000000007;
        int n = arr.length;
        int[] stack = new int[n+1];
        int index = 0;
        int[] dp = new int[n];
        dp[0] = arr[0];
        long result = dp[0];
        for(int i = 1; i<n; i++){
            while(index>=0 && arr[stack[index]]>=arr[i]){
                index--;
            }
           dp[i] = index<0?arr[i]*(i+1):dp[stack[index]]+(arr[i]*(i-stack[index]));
            result += dp[i];
            stack[++index] = i; 
        }

        return (int)(result % MOD);
    }
}