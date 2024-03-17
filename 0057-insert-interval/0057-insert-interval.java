class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList();
        for(int[] meet : intervals){
            if(meet[1]<newInterval[0]){
                res.add(meet);
            } else if(newInterval[1]<meet[0]){
                res.add(newInterval);
                newInterval = meet;
            } else{
                newInterval[0] = Math.min(newInterval[0], meet[0]);
                newInterval[1] = Math.max(newInterval[1], meet[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()] []);
    }
}