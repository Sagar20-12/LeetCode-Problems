import java.util.*;

class Solution {
    Map<Integer, List<Integer>> prime2index = new HashMap<>();
    Map<Integer, List<Integer>> index2prime = new HashMap<>();

    public void dfs(int index, boolean[] visitedIndex, Map<Integer, Boolean> visitedPrime) {
        if (visitedIndex[index])
            return;
        visitedIndex[index] = true;

        for (int prime : index2prime.getOrDefault(index, new ArrayList<>())) {
            if (visitedPrime.getOrDefault(prime, false))
                continue;
            visitedPrime.put(prime, true);
            for (int index1 : prime2index.getOrDefault(prime, new ArrayList<>())) {
                if (visitedIndex[index1])
                    continue;
                dfs(index1, visitedIndex, visitedPrime);
            }
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = 2; j * j <= nums[i]; j++) {
                if (temp % j == 0) {
                    prime2index.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                    index2prime.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    while (temp % j == 0)
                        temp /= j;
                }
            }
            if (temp > 1) {
                prime2index.computeIfAbsent(temp, k -> new ArrayList<>()).add(i);
                index2prime.computeIfAbsent(i, k -> new ArrayList<>()).add(temp);
            }
        }

        boolean[] visitedIndex = new boolean[nums.length];
        Map<Integer, Boolean> visitedPrime = new HashMap<>();
        dfs(0, visitedIndex, visitedPrime);

        for (boolean b : visitedIndex)
            if (!b)
                return false;
        return true;
    }
}
