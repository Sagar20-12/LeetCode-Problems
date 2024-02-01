class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int res[][] = new int[n/3][3];
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 0; i<n; i+=3){
            int f = nums[i];
            int s = nums[i+1];
            int t = nums[i+2];
            if(t - f<=k){
                res[ans][0] = f;
                res[ans][1] = s;
                res[ans][2] = t;
                ans++;
            } else{
                return new int[0][0];
            }
        }
        return res;
    }
}