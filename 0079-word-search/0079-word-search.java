class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int r = 0; r<n; r++){
            for(int c = 0; c<m; c++){
                if(word.charAt(0)==board[r][c]){
                    boolean found = dfs(board, r,  c,  word, 0);
                    if(found) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int r, int c, String word, int wi){
        if(wi == word.length()){
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        if(r<0 || c<0 || r>=row || c>=col){
            return false;
        }
        if(board[r][c] == ' ' || board[r][c] !=word.charAt(wi)){
            return false;
        }
        char ch = board[r][c];
        board[r][c] = ' ';
        //dfs calls
        
        if(dfs(board,  r-1,  c, word,  wi+1)||
         dfs(board,  r,  c+1, word,  wi+1)||
         dfs(board,  r+1,  c, word,  wi+1) ||
         dfs(board,  r,  c-1, word,  wi+1)){
            return true;
        }
        board[r][c] = ch;
        return  false;
    }
}