class Solution {
    public boolean halvesAreAlike(String s) {
        if(s.length() % 2 != 0 || countVowels(s)%2!=0){
            return false;
        }
        return countVowels(s.substring(0, s.length()/2)) == countVowels(s.substring(s.length()/2, s.length()));
    }
    private int countVowels(String str){
        int count = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' || str.charAt(i) == 'U'){
                count++;
            }
        }
        return count;
    }
}