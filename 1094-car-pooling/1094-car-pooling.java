class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1000];
        for(int[] num : trips){
            int pass = num[0];
            int left = num[1];
            int right = num[2];
            for(int i = left; i<right; i++){
                arr[i]+=pass;
            }
        }
        for(int i = 0; i<1000; i++){
            if(arr[i] > capacity)
                return false;
        }
        return true;
    }
}