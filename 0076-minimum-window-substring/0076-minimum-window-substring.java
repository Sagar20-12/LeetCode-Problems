class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> freqCount = new HashMap<Character, Integer>();
            for (int i = 0; i < t.length(); i++) {
            freqCount.put(t.charAt(i), freqCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        //Keeping the count of characters 
        // Aryan Mittal Approach
        int left = 0, right = 0, minWindow = Integer.MAX_VALUE;
        int leftStart = -1, required = t.length();

        while (right < s.length()) {
            char cur = s.charAt(right);

            if (freqCount.containsKey(cur)) {
                if (freqCount.get(cur) > 0) {
                    required--;
                }
                freqCount.put(cur, freqCount.get(cur) - 1);
            }

            while (required == 0) {
                char leftCur = s.charAt(left);
                int curWindow = right - left + 1;
                    if (curWindow < minWindow) {
                    minWindow = curWindow;
                    leftStart = left;
                }

                if (freqCount.containsKey(leftCur)) {
                    freqCount.put(leftCur, freqCount.get(leftCur) + 1);

                    if (freqCount.get(leftCur) > 0) {
                        required++;
                    }
                }
                left++;
            }
            right++;

        }
         return minWindow == Integer.MAX_VALUE ? "" : s.substring(leftStart, leftStart + minWindow);
    }
}