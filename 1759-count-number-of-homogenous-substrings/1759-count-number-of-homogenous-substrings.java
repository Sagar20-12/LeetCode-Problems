class Solution {
    public int countHomogenous(String s){
        int mod = 1000000007;
        int prev = 1;
        long ans = prev;
        for(int i = 1; i < s.length(); i++){
            int curr = 1;
            if(s.charAt(i) == s.charAt(i - 1)){
                curr += prev;
            }
            prev = curr;
            ans += curr;
        }
        return (int)(ans % mod);
    }
}