// Optimal Approach using HashMap
class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            if(map.get(nums[i])> max){
                max = map.get(nums[i]);
            }
        }
        int res = 0;
        for(Map.Entry<Integer, Integer> value : map.entrySet()){
            if(value.getValue() == max){
                res++;
            }
        }
        return res * max;
    }
}