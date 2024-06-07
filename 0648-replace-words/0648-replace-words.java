class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        int min = Integer.MAX_VALUE;
        for(int k = 0;  k<dictionary.size(); k++){
            min = Math.min(min, dictionary.get(k).length());
        }
        for(int i=0;i<words.length;i++){
            for(int j=0;j<dictionary.size();j++){
                if(words[i].startsWith(dictionary.get(j))){
                    words[i]=dictionary.get(j);
                    if(dictionary.get(j).length() == min){
                        break;
                    }
                }
            }
        }
        String out = String.join(" ",words);
        return out;
    }
}