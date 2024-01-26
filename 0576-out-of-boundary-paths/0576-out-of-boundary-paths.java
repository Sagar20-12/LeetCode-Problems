class Solution {
    public static int MOD = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        HashMap<List<Integer>, Integer> dp = new HashMap<>();
        return solve(m, n, maxMove, startRow, startColumn, 0, dp);
    }
    public int solve(int m, int n, int maxMove, int startRow, int startColumn, int moveCount, HashMap<List<Integer>, Integer> dp){
        if(moveCount<=maxMove && startRow<0 || startRow>=m || startColumn<0 || startColumn >= n){
            return 1;
        } else if(moveCount == maxMove) return 0;

        else if(dp.containsKey(Arrays.asList(startRow, startColumn, moveCount)))
        return dp.get(Arrays.asList(startRow, startColumn, moveCount)) % MOD;
        int count = 0;
        count = (count + solve(m, n, maxMove, startRow-1, startColumn, moveCount + 1, dp))%MOD;
        count = (count + solve(m, n, maxMove, startRow, startColumn - 1, moveCount + 1, dp))%MOD;
        count = (count + solve(m, n, maxMove, startRow, startColumn + 1, moveCount + 1, dp))%MOD;
        count = (count + solve(m,n, maxMove, startRow + 1, startColumn, moveCount + 1, dp))%MOD;
        dp.put(Arrays.asList(startRow, startColumn, moveCount), count % MOD);
        return count%MOD;
    }
}