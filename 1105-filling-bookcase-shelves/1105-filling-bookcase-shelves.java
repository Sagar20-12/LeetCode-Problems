class Solution {
    int dp[];
    int helper(int books[][], int shelfWidth, int index) {
        if (index >= books.length) return 0;
        if (dp[index] != -1) return dp[index];
        
        int max = 0;
        int ans = Integer.MAX_VALUE;
        
        for (int i = index, w = 0; i < books.length; i++) {
            w += books[i][0];
            if (w > shelfWidth) break;
            max = Math.max(max, books[i][1]);
            ans = Math.min(ans, max + helper(books, shelfWidth, i + 1));
        }
        
        return dp[index] = ans;
    }
    
    public int minHeightShelves(int[][] books, int shelfWidth) {
        dp = new int[books.length];
        Arrays.fill(dp, -1);
        return helper(books, shelfWidth, 0);
    }
}
