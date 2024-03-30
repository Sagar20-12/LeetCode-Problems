class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        //Count the frequencies
        return countFreq(nums, k) - countFreq(nums, k-1);
        
    }
    private static int countFreq(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int start = 0;
        int end = 0;
        int count = 0;
        //Expansion phase
        while(end<n){
            map.put(nums[end], map.getOrDefault(nums[end], 0)+1);
            //Shrinking phase
            if(map.size()>k){
                while(map.size()>k){
                    map.put(nums[start], map.get(nums[start])-1);
                    // Agar map me kisi element ki frequency 0 ho jaye toh remove kar do 
                    // or start ko ++ kar dena
                    if(map.get(nums[start]) ==  0)
                    map.remove(nums[start]);
                    start++;
                }
            }
            count += end - start + 1;
            end++;
        }
        return count;   
    }
}