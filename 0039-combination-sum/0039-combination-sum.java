class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        combination(candidates, target, new ArrayList<>(), 0);
        return result;
    }
    public void combination(int[] arr, int target, List<Integer> list,  int i){
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(i>=arr.length || arr[i]>target){
            return;
        }
        list.add(arr[i]);
        combination(arr, target - arr[i], list, i);
        list.remove(list.size()-1);
        combination(arr, target, list, i+1);

    }
}