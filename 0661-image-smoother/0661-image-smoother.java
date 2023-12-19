class Solution {
    public int[][] imageSmoother(int[][] img) {
        int ima[][] = new int[img.length][img[0].length];
        for(int i = 0; i<img.length; i++){
            for(int j = 0; j<img[0].length; j++){
                ima[i][j] = filter(img, i, j);
            }
        }
        return ima;
    }
    int filter(int[][] img, int x, int y){
        int m = img.length;
        int n = img[0].length;
        int sum = 0;
        int count = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                int ax = x + i;
                int by = y + j;
                //checking the edge case condition of the matrix
                if(ax < 0 || ax >= m || by < 0 || by >= n) continue;
                sum += img[ax][by];
                count++;
            }
        }
        return sum/count;
    }
}