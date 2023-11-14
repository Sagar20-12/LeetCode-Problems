class Solution {
    public int countPalindromicSubsequence(String s) {
        int result = 0;
        HashSet<Character> unique = new HashSet<>();
        for(char c: s.toCharArray()){
            unique.add(c);
        }
        for(char c: unique){
            int start = s.indexOf(c);
            int end = s.lastIndexOf(c);
            if(start<end){
                HashSet<Character> charSet = new HashSet<>();
                for(int i = start + 1; i<end; i++){
                    charSet.add(s.charAt(i));
                }
                result += charSet.size();
            }
        }
        return result;
    }
}