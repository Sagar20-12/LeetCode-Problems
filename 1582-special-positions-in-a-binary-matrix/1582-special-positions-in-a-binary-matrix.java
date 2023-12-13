class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int special = 0;
        for(int i = 0; i<n; i++){
            int index = checkrow(mat, i);
            if(index >=0 && checkcol(mat, i, index))
                special++;
        }
        return special;
        
    }
    private int checkrow(int[][] mat, int i){
        int index = -1;
        for(int j = 0; j<mat[0].length; j++){
            if(mat[i][j] == 1){
                if(index >= 0)
                    return -1;
                else
                    index = j;
            }
        }
        return index;
    }
    private boolean checkcol(int[][] mat, int i, int index){
        for(int j = 0; j<mat.length; j++){
            if(mat[j][index] == 1 && j!=i)
                return false;
        }
        return true;
    }
}