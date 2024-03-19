class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        //Counting the frequencies of the characters
        for(char ch : tasks){
            count[ch-'A']++;
        }
        Arrays.sort(count);
        int pat = count[25];
        int idle = (pat-1) * n; // Same like how many combinations possible
        for(int i = 24; i>=0; i--){
            idle -= Math.min(pat - 1, count[i]);
        }
        return tasks.length + Math.max(idle, 0);
    }
}