class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[n];
        for(int i = 0; i<n; i++){
            q.add(i);
        }
        for(int i = 0; i<n; i++){
            res[q.poll()] = deck[i];
            if(!q.isEmpty()){
                q.add(q.poll());
            }
        }
        return res;
    }
}