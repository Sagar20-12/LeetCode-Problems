class Solution {
    public int findRotateSteps(String ring, String key) {
        // Initialise the dp
        int[][] dp = new int[key.length()+1][ring.length()];
        for(int i = key.length()-1; i>=0; i--){
            for(int j = 0; j<ring.length(); j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 0; k<ring.length(); k++){
                    if(ring.charAt(k) == key.charAt(i)){
                        int dist = Math.abs(k-j);
                        int minDist = Math.min(dist, ring.length()-dist);
                        dp[i][j] = Math.min(dp[i][j], minDist + dp[i+1][k]);
                    }
                }
            }
        }
        // Given length = Total buttons clicked thats why we added key length here
        return key.length() + dp[0][0];
    }
}