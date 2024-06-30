class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        // traverse via DFS and store the previous edges in the list
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> toChild = new ArrayList<>();
        for(int i = 0; i<n; i++){
            res.add(new ArrayList<>());
            toChild.add(new ArrayList<>());
        }
        for(int edge[] : edges)
            toChild.get(edge[0]).add(edge[1]);
        for(int i = 0; i<n; i++)
            dfs(i, i, res, toChild);
        return res;
    }
    void dfs(int parent, int current, List<List<Integer>> res, List<List<Integer>> toChild){
        for(int dir : toChild.get(current)){
            //If the reult list empty or doesnt conntains the parent
            if(res.get(dir).size() == 0 || res.get(dir).get(res.get(dir).size()-1)!=parent) {
                res.get(dir).add(parent);
                dfs(parent, dir, res, toChild);
            }
        }
    }
}