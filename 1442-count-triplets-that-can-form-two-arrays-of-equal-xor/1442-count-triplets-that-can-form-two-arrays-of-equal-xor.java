class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] prefixXor = new int[n + 1];
        
        // Compute the prefix XOR
        for (int i = 0; i < n; i++) {
            prefixXor[i + 1] = prefixXor[i] ^ arr[i];
        }
        
        int count = 0;
        
        // Find triplets (i, j, k) such that prefixXor[i] == prefixXor[k + 1]
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (prefixXor[i] == prefixXor[k + 1]) {
                    count += (k - i);
                }
            }
        }
        
        return count;
    }
}