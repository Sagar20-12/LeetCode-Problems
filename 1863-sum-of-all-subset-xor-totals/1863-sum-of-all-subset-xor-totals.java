class Solution {
    public int subsetXORSum(int[] nums) {
        return solveXOR(nums, 0, 0);
    }
    public static int solveXOR(int[] nums, int index, int xor){
        if(index == nums.length) return xor;
        int pick = solveXOR(nums, index+1, xor ^ nums[index]);
        int npick = solveXOR(nums, index+1, xor);
        return pick + npick;
    }
}