class Solution {
    private int reverse(int num){
        int reverseNum = 0;
        while(num>0){
            int digit = num % 10;
            reverseNum = reverseNum * 10 + digit;
            num = num / 10;
        }
        return reverseNum;
    }
    public int countNicePairs(int[] nums) {
        int mod = 1000000007;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            int reverse = reverse(n);
            int current = map.getOrDefault(n - reverse, 0);
            map.put(n-reverse, current + 1);
            count = (count + current) % mod;

        }
        return count;
        
    }
}