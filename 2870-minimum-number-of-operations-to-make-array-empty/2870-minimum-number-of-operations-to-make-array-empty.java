class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        int count = 0;
        for(int num : map.values()){
            if(num == 1){
                return -1;
            }
            count += (num+2)/3;
        }
        return count;
        
    }
}