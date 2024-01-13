class Solution {
    int show(long n){
        int ans = 0;
        if(n<=1){
            return 0;
        }
        if(n%2 == 0){
            ans = 1 + show(n/2);
        }
        else{
            ans = 1 + Math.min(show(n+1), show(n-1));
        }
        return ans;
    }
    public int integerReplacement(int n) {
        return show((long)n);
    }
}