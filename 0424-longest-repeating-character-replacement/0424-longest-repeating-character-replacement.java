class Solution {
    public int characterReplacement(String s, int k) {
        int maxlen = 0;
        int finalp = k;

        for (char i = 'A'; i <= 'Z'; i++) {
            int start = 0;
            int end = 0;
            k = finalp;

            while (end < s.length()) {
                if (s.charAt(end) != i) {
                    if (k > 0) {
                        k--;
                    } else {
                        // Move start to the right until we can make room for new character replacement
                        while (s.charAt(start) == i) {
                            start++;
                        }
                        start++;
                    }
                }
                end++;
                maxlen = Math.max(maxlen, end - start);
            }
        }

        return maxlen;
    }
}
