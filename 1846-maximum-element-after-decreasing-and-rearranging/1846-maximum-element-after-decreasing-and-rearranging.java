class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int max = 1;
        for(int i = 1; i<n; i++){
            if(arr[i]>max){
                max+=1;
            }
        }
        return max;
    }
}