class Solution {
    public int numTrees(int n) {
        int tree[] = new int[n+1];
        tree[0] = tree[1] = 1;
        for(int i =2; i<n+1; i++){
            for(int j =0; j<i; j++){
                int left = tree[j];
                int right= tree[i-j-1];
                tree[i] += left * right;
            }
        }
        return tree[n];
    }
}