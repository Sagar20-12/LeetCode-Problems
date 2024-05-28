class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int i = 0;
        int j = 0;
        while (i < n) {
            maxCost -= Math.abs(s.charAt(i) - t.charAt(i++));
            if (maxCost < 0) {
                maxCost += Math.abs(s.charAt(j) - t.charAt(j));
                j++;
            }
        }
        return i - j;
    }
}