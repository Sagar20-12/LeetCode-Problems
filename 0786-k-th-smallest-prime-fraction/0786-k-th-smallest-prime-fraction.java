class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    double val1 = ((a[0] * 1.0) / (a[1] * 1.0));
                    double val2 = ((b[0] * 1.0) / (b[1] * 1.0));
                    if(val1 < val2){
                        return 1;
                    }
                    else if(val2 < val1){
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
            }
        );
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = arr.length - 1; j >= i + 1; j--){
                pq.offer(new int[]{arr[i], arr[j]});
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
        int[] res = pq.poll();
        return res;
    }
}