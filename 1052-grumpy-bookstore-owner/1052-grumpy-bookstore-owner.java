class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        for(int i = 0 ; i<grumpy.length ; i++){
            if(grumpy[i] == 0){
                sum += customers[i];
            }
        }
        //creating window
        for(int i = 0; i<minutes ; i++){
            if(grumpy[i] == 1){
                sum += customers[i];
            }
        }

        int left = 0;
        int right = minutes;
        int temp = sum;
        while(right < grumpy.length){
            if(grumpy[left] == 1){
                temp -= customers[left];
            }
            if(grumpy[right] == 1){
                temp += customers[right];
            }
            left++;
            right++;
            sum = Math.max(temp,sum);
        }
        return sum;
    }
}