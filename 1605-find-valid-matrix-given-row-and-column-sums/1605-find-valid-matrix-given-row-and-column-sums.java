class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row = rowSum.length;
        int col = colSum.length;
        int r = 0;
        int c = 0;
        int res[][] = new int[row][col];

        // r and c will run simultaneously
        while(r < row && c < col){
            int minVal = Math.min(rowSum[r], colSum[c]);
            res[r][c] = minVal;
            rowSum[r] -= minVal;
            colSum[c] -= minVal;
            if(rowSum[r] == 0 ){
                r++;
            } else{
                c++;
            }
        }
        return res;
    }
}