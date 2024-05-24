class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        // base case
        if(words == null || words.length == 0 || letters == null || letters.length == 0 || score == null || score.length == 0){
            return 0;
        }
        int[] count = new int[score.length];
        for(char ch : letters){
            count[ch - 'a']++;
        }
        return solve(words, count, score, 0);
    }
    public static int solve(String[] words, int[] count, int[] score, int index){
        int max = 0;
        for(int i = index; i<words.length; i++){
            int res = 0;
            boolean isVisited = true;
            for(char ch : words[i].toCharArray()){
                count[ch - 'a']--;
                res += score[ch - 'a'];
                if(count[ch - 'a']<0){
                    isVisited = false;
                }
            }
            if(isVisited){
                res += solve(words, count, score, i+1);
                max = Math.max(max, res);
            }
            for(char ch : words[i].toCharArray()){
                count[ch - 'a']++;
                res = 0;
            }
        }
        return max;
    }
}