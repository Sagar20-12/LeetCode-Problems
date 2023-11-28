class Solution {
    public int numberOfWays(String corridor) {
        int MOD = 1000000007;
        int zero = 0;
        int one = 0;
        int two = 1;
        for(char c : corridor.toCharArray()){
            if(c == 'S'){
                zero = one;
                int temp = one;
                one = two;
                two = temp;
            }
            else{
                two = (two + zero) % MOD;
            }
        }
        return zero;
    }
}