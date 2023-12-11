class Solution {
    public int findSpecialInteger(int[] arr) {
        if(arr.length<=2) return arr[0];
        int n1= arr.length/4;
        int count=1;
        for(int i=1; i<arr.length; i++){
             if(arr[i]==arr[i-1]){
                 count++;
             }else{
                 count=1;
             }
             if(count>n1){
                 return arr[i];
             }
        }
        return -1;
    }
}