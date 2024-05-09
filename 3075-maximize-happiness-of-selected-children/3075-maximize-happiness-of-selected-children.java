/* class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int res = 0;
        int sum = 0;
        while(k>=0){
            for(int i = 0; i<happiness.length; i++){
            sum-=happiness[i]-1;
            k--;
            res+=happiness[i];
            }
        }
        return res;
        
    }
}
*/

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        int count = 0;
        long res = 0;
        for(int i = n-1; i>=0; i--){
            res+=Math.max(0, happiness[i]-count);
            count+=1;
            if(count>=k)
                break;
        }
        return res;
    }
}