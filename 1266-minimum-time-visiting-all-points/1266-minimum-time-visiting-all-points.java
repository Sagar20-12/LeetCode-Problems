class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int t = 0;
        for(int i = 1; i<n ;i++){
            t = t+tt(points[i-1], points[i]);
        }
        return t;
    }
    public int tt(int[] from, int[] to){
        int xD = Math.abs(from[0] - to[0]);
        int yD = Math.abs(from[1] - to[1]);
        return Math.max(xD, yD);
    }
}