
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count = 0, n = s.length();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '1') count++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("1".repeat(count - 1)); 
        sb.append("0".repeat(n - count)); 
        sb.append("1"); 
        return sb.toString();
    }
}
