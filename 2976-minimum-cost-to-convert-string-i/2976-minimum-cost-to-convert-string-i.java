class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dist = new int[26][26];
        for(int i = 0; i<26; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for(int i = 0; i<cost.length; i++){
            dist[original[i] - 'a'][changed[i] - 'a'] = Math.min(dist[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }
        for(int via = 0; via < 26; via++){
            for(int i = 0; i<26; i++){
                for(int j = 0; j<26; j++){
                    if(dist[i][via] == Integer.MAX_VALUE || dist[via][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }
        long res = 0;
        for(int i = 0; i<source.length(); i++){
            int start = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if(dist[start][to] == Integer.MAX_VALUE){
                return -1;
            } else{
                res += (long) dist[start][to];
            }
        }
        return res;
    }
}