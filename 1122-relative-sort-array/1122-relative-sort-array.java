class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] cnt = new int[1001];

        for (int nos : arr1)
            cnt[nos]++;

        int i = 0;

        for (int nos : arr2)
            while (cnt[nos]-- > 0)
                arr1[i++] = nos;

        for (int j = 0; j < 1001; j++)
            while (cnt[j]-- > 0)
                arr1[i++] = j;

        return arr1;

    }
}