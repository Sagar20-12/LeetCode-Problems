class Solution {
    public int maxDepth(String s) {
        char p = '(';
        int count = 0;
        int max = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == p){
                count++;
                max = Math.max(max, count);
            }
            else if(s.charAt(i) == ')'){
                count--;
            }
        }
        return max;
    }
}