class Solution {
    public int[][] onesMinusZeros(int[][] diff) {
        int[] row = new int[diff.length];
        int[] col = new int[diff[0].length];
        for(int i = 0; i<diff.length; i++){
            for(int j = 0; j<diff[0].length; j++){
                row[i] = row[i] + diff[i][j];
                col[j] = col[j] + diff[i][j];

            }
        }
        for(int i = 0; i<diff.length; i++){
            for(int j = 0; j<diff[0].length; j++){
                diff[i][j] = 2 * (row[i] + col[j]) - diff.length - diff[0].length;
            }
        }
        return diff;
    }
}