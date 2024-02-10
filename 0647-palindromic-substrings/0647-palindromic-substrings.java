// This code will give time limit exceed error
/*
class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                if(palindrome(s,i,j))
                    ans++;
            }
        }
        return ans;
    }
    public boolean palindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
        }
        return true;
    }
}
*/
class Solution{
    public int countSubstrings(String s){
        int n = s.length();
        int ans = 0;
        for(int i = 0; i<n; i++){
            int even = palindrome(s, i, i+1);
            int odd = palindrome(s, i-1, i+1);
            ans = ans+even+odd+1;
        }
        return ans;

    }
    public int palindrome(String s, int left, int right){
        int count = 0;
        while(left>=0 && right<s.length() && s.charAt(left--) == s.charAt(right++)){
            count++;
        }
        return count;
    }
}