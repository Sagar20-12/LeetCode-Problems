class Meet{
    int person, time;
    Meet(int person, int time){
        this.person = person;
        this.time = time;
    }
}
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<Meet>> graph = new ArrayList<>();
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<Meet>());
        }
        // Getting the list of the persons who has meetings after sorting 
        for(int meeting[]: meetings){
            int pone = meeting[0];
            int ptwo = meeting[1];
            int time = meeting[2];
            graph.get(pone).add(new Meet(ptwo, time));
            graph.get(ptwo).add(new Meet(pone, time));
        }
        Queue<Meet> mq = new LinkedList<Meet>();
        mq.offer(new Meet(0,0));
        mq.offer(new Meet(firstPerson, 0));
        
        //Getting the record for past meeting
        int pastMeet[] = new int[n];
        Arrays.fill(pastMeet, Integer.MAX_VALUE);
        pastMeet[0] = 0;
        pastMeet[firstPerson] = 0;
        while(!mq.isEmpty()){
            Meet meet = mq.poll();
            int currPerson = meet.person;
            int currTime = meet.time;
            for(Meet nextMeet: graph.get(currPerson)){
                int nextPerson = nextMeet.person;
                int nextTime = nextMeet.time;
                if(nextTime>=currTime && pastMeet[nextPerson]>nextTime){
                    pastMeet[nextPerson] = nextTime;
                    mq.offer(new Meet(nextPerson, nextTime));
                }
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i<n; i++){
            if(pastMeet[i]!=Integer.MAX_VALUE){
                res.add(i);
            }
        }
        return res;
    }
}