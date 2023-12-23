class Solution {
    public boolean isPathCrossing(String mp) {
        HashSet<String> vp = new HashSet<>();
        int X = 0;
        int Y = 0;
        vp.add(X + "," + Y);

        for (char path : mp.toCharArray()) {
            if (path == 'N') Y++;
            else if (path == 'S') Y--;
            else if (path == 'E') X++;
            else X--;

            String trace = X + "," + Y;
            if (vp.contains(trace)) {
                return true;  
            }
            vp.add(trace);  
        }
        return false;
    }
}
