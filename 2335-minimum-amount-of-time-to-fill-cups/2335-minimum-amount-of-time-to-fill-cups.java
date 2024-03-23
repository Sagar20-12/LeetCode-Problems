class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a,b)->(b-a));
        for(int element : amount){
            q.offer(element);
        }
        int count = 0;
        while(!q.isEmpty()){
            int first = q.poll();
            int second = q.poll();
            if(first<=0 && second <= 0){
                break;
            }
            first--;
            second--;
            q.offer(first);
            q.offer(second);
            count++;
        }
        return count;
    }
}