class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start = 1;
        int end = (position[position.length-1]-position[0])/(m-1);
        int mid = 0;
        int ans = 0;
        while(start <= end){
            mid = (start+end)/2;
            int last = position[0];
            int count = 1;
            for(int i=1; i<position.length; i++){
                if((position[i]-last) >= mid){
                    count++;
                    last = position[i];
                }
                if(count == m) break;
            }
            if(count == m){
                ans = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return ans;
    }
}
