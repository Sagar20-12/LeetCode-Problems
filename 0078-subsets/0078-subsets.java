class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subset(nums, 0, new ArrayList<>());
        return res;
    }
    public void subset(int[] nums, int index, List<Integer> list){
        if(index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        // pick and no pick case
        //pick case
        list.add(nums[index]);
        subset(nums, index+1, list);
        list.remove(list.size()-1);

        //not pick case
        subset(nums, index+1, list);
    }
}