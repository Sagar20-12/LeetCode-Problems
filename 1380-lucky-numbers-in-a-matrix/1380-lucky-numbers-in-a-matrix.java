class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i<n; i++){
            int rowMin = Integer.MAX_VALUE;
            int MinIndex = -1;
            for(int j = 0; j<m; j++){
                if(matrix[i][j] < rowMin){
                    rowMin = matrix[i][j];
                    MinIndex = j;
                }
            }
            boolean safe = true;
            for(int k = 0; k<n; k++){
                if(matrix[k][MinIndex] > rowMin){
                    safe = false;
                    break;
                }
            }
            if(safe){
                res.add(rowMin);
            }
        }
        return res;
    }
}