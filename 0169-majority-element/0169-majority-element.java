class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0, index = -1;
        for(int i = 0; i<n; i++){
            int count = map.get(nums[i]);
            if(count > max){
                max = count;
                index = i;
            }
        }
        if(max>n/2)
        return nums[index];
        else
        return -1;
        
    }
}