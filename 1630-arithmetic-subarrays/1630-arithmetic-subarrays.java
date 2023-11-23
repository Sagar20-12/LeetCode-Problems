class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList();
        for(int i = 0; i<l.length; i++){
            int[] arr = new int[r[i] - l[i] + 1];
            for(int j = 0; j<arr.length ;j++){
                arr[j] = nums[l[i] + j];
            }
            list.add(check(arr));
        }
        return list;
    }
    public boolean check(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for(int i = 2; i<n; i++){
            if(arr[i] - arr[i-1]!=diff){
                return false;
            }
        }
        return true;
    }
}