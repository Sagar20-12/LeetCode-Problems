class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
        list.sort((a, b) -> {
            int freq = map.get(a).compareTo(map.get(b));
            if(freq == 0){
                // frequency same return in decreasing order
                return b - a; 
            }
            return freq;  // return in increasing order
        });
        int[] res = new int[n];
        for(int i = 0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}