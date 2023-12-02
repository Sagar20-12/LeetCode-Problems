class Solution {
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        for(String word : words){
            if(Formword(word,chars))
            {
                res = res + word.length();
            }
        }
        return res;
    }
    private boolean Formword(String word, String chars){
        int[] charCount = new int[26];
        for(char ch : chars.toCharArray()){
            charCount[ch - 'a']++;
        }
        for(char ch : word.toCharArray()){
            if(charCount[ch - 'a'] == 0){
                return false;
            }
            charCount[ch - 'a']--;
        }
        return true;
    }
}