class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int win = arr[0];
        int wins = 0;
        for(int i = 1; i<n; i++){
            if(win>arr[i]){
                wins++;
            }
            else{
                wins = 1;
                win = arr[i];
            }
            if(wins == k)
                break;
        }
        return win;
    }
}