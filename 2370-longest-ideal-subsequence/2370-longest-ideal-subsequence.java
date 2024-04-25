// TIME LIMIT EXCEEDED 
// class Solution {
//     public int longestIdealString(String s, int k) {
//         return solve(s, k, 0, -1);
//     }
    
//     public static int solve(String s, int k, int current, int prev) {
//         if (current >= s.length()) return 0;
//         int window = 0;
//         if (prev == -1 || Math.abs(prev - s.charAt(current)) <= k) {
//             window = 1 + solve(s, k, current + 1, s.charAt(current));
//         }
//         int reject = solve(s, k, current + 1, prev);
//         return Math.max(window, reject);
//     }
// }

class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] dp = new int[26];
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            int idx = curr - 'a';
            int window = 0;
            
            for (int prev = 0; prev < 26; prev++) {
                if (Math.abs(idx - prev) <= k) {
                    window = Math.max(window, dp[prev]);
                }
            }
            
            dp[idx] = window + 1;
            maxLen = Math.max(maxLen, dp[idx]);
        }
        
        return maxLen;
    }
}