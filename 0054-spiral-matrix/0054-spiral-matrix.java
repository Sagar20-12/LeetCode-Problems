class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> mat = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return mat;
        }
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = col-1, top = 0, bottom = row-1;
        while(left<=right && top<=bottom){
            for(int i = left; i<=right; i++){
                mat.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i<=bottom;i++){
                mat.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i = right; i>=left; i--){
                    mat.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i = bottom; i>=top; i--){
                    mat.add(matrix[i][left]);
                }
                left++;
            }
        }
        return mat;
    }
}