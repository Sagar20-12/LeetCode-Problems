import java.util.*;


// Create a stack for storing elements
// Create a hashmap for mapping the Characters count
    //--> Create another hashmap if you find any other starting brackets 
// Create a treeMap for giving the sorted order of elements
class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<HashMap<String, Integer>> s1 = new Stack<>();
        s1.push(new HashMap<String, Integer>());

        int i = 0;
        while (i < n) {
            if (formula.charAt(i) == '(') {
                s1.push(new HashMap<String, Integer>());
                i++;
            } else if (formula.charAt(i) == ')') {
                HashMap<String, Integer> curr = s1.pop();
                i++;

                StringBuilder mult = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    mult.append(formula.charAt(i));
                    i++;
                }

                int multInteger = mult.length() == 0 ? 1 : Integer.parseInt(mult.toString());

                for (Map.Entry<String, Integer> entry : curr.entrySet()) {
                    curr.put(entry.getKey(), entry.getValue() * multInteger);
                }

                for (Map.Entry<String, Integer> entry : curr.entrySet()) {
                    String key = entry.getKey();
                    int value = entry.getValue();
                    s1.peek().merge(key, value, Integer::sum);
                }

            } else {
                StringBuilder currelement = new StringBuilder();
                currelement.append(formula.charAt(i));
                i++;

                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    currelement.append(formula.charAt(i));
                    i++;
                }

                StringBuilder currcount = new StringBuilder();
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    currcount.append(formula.charAt(i));
                    i++;
                }

                int integercount = currcount.length() == 0 ? 1 : Integer.parseInt(currcount.toString());

                s1.peek().merge(currelement.toString(), integercount, Integer::sum);
            }
        }

        TreeMap<String, Integer> t1 = new TreeMap<>(s1.peek());

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : t1.entrySet()) {
            String key = entry.getKey();
            result.append(key);
            int value = entry.getValue();
            if (value > 1) {
                result.append(value);
            }
        }

        return result.toString();
    }
}