import java.util.TreeMap;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        while (!map.isEmpty()) {
            int firstCard = map.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int currentCard = firstCard + i;
                if (!map.containsKey(currentCard)) {
                    return false;
                }
                map.put(currentCard, map.get(currentCard) - 1);
                if (map.get(currentCard) == 0) {
                    map.remove(currentCard);
                }
            }
        }
        return true;
    }
}
