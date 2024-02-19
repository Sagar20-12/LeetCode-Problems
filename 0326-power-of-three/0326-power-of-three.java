class Solution {
    public boolean isPowerOfThree(int n) {
        for(int i = 0; i<31; i++){
            long res = (long)Math.pow(3,i);
            if(res == n){
                return true;
            }
        }
        return false;
    }
}