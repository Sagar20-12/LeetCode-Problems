class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        for(char ch = 'a'; ch<='z';ch++){
            int min =  Integer.MAX_VALUE;
            for(String word : words){
                int cnt = 0;
                for(char c : word.toCharArray()){
                    if(c == ch){
                        cnt++;
                    }
                }
                min = Math.min(min, cnt);
            }
            for(int i = 0; i < min; i++){
                result.add(String.valueOf(ch));
            }
        }
        return result;
    }
}