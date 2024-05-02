class Solution {
    public int findMaxK(int[] nums) {
       HashSet<Integer> set = new HashSet<>();
       int res = -1;
       for(int num : nums){
        set.add(num);
        int k = num * (-1);
        if(set.contains(k)){
            res = Math.max(res, Math.abs(num));
        }
       }
       return res;
    }
}