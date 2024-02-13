//Bruteforce approach 
/* We can form another string of words which is reversed then we will compare 
both the strings or array of words*/
 
// Optimised opproach
class Solution {
    public String firstPalindrome(String[] words) {
        for(String str : words){
            if(palindrome(str)){
                return str;
            }
        }
        return "";
    }
    private boolean palindrome(String s){
        int i = 0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}