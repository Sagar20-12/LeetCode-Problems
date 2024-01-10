class Solution {
    // we are starting top down approach after seeing the topic tags. 
   public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> wordSet = new HashSet<>(wordDict);
    Map<String, Boolean> map = new HashMap<>();
    return wordbreak(s, wordSet, map);
}
    boolean wordbreak(String prefix, Set<String> dict, Map<String, Boolean> dp){
        if(prefix.isEmpty())
            return true;
        if(!dp.containsKey(prefix)){
            boolean wordbreak = false;
            for(String word: dict){
                if(prefix.startsWith(word)){
                    if(prefix.length() == word.length()){
                        return true; 
                    } else{
                        wordbreak = wordbreak(prefix.substring(word.length()), dict, dp);
                        if(wordbreak){
                            break;
                        }
                    }
                }
            }
            dp.put(prefix, wordbreak);

        }
        return dp.get(prefix);
    }
}