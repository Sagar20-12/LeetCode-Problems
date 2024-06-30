class Solution {
    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int components;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            components--;
            return true;
        }

        public int getComponents() {
            return components;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int edgesUsed = 0;

        // Process type 3 edges
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean usedByAlice = alice.union(edge[1] - 1, edge[2] - 1);
                boolean usedByBob = bob.union(edge[1] - 1, edge[2] - 1);
                if (usedByAlice || usedByBob) {
                    edgesUsed++;
                }
            }
        }

        // Process type 1 and 2 edges
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (alice.union(edge[1] - 1, edge[2] - 1)) {
                    edgesUsed++;
                }
            } else if (edge[0] == 2) {
                if (bob.union(edge[1] - 1, edge[2] - 1)) {
                    edgesUsed++;
                }
            }
        }

        // Check if the graph is fully connected for both Alice and Bob
        if (alice.getComponents() != 1 || bob.getComponents() != 1) {
            return -1;
        }

        return edges.length - edgesUsed;
    }
}