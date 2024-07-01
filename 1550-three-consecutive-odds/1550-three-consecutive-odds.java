class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        if(n<=3){
            if(n==1 || n==2){
                return false;
            }
            if(arr[0]%2!=0 && arr[1]%2!=0 && arr[2]%2!=0){
                return true;
            } else{
                return false;
            }
        }
        for(int i = 0; i<arr.length-2; i++){
            if(arr[i]%2!=0){
                if(arr[i+1]%2!=0){
                    if(arr[i+2]%2!=0){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}