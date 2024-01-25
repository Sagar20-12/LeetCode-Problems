class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length()+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);

        }
        return solve(text1, text2, 0, 0, dp);
    }
    public int solve(String text1, String text2, int i, int j, int[][] dp){
        if(i>=text1.length() || j>=text2.length())
            return 0;
        else if(dp[i][j]!=-1) return dp[i][j];
        int max = 0;
        int index = i;
        if(text2.charAt(j) == text1.charAt(index)){
            max = Math.max(max, 1+solve(text1, text2, index+1, j+1, dp));
        } else{
            max = Math.max(max, solve(text1, text2, index, j+1, dp));
            max = Math.max(max, solve(text1, text2, index+1, j, dp));
        }
        dp[i][j] = max;
        return dp[i][j];
    }
    
}