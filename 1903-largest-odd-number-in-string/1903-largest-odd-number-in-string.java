public class Solution {
    public String largestOddNumber(String num) {
        String result = "";
        int a = num.length() - 1;
        for (int i = a; i >= 0; i--) {
            char ch = num.charAt(i);
            if (Character.getNumericValue(ch) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return result;
    }
}