/*import java.util.*;

 class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0, m = matrix.length, n = matrix[0].length;
        for (int rowStart = 0; rowStart < m; rowStart++) {
            for (int rowSize = 1; rowStart + rowSize <= m; rowSize++) {
                for (int colStart = 0; colStart < n; colStart++) {
                    for (int colSize = 1; colStart + colSize <= n; colSize++) {
                        if (sumOfSubMatrix(matrix, rowStart, rowSize, colStart, colSize) == target) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public int sumOfSubMatrix(int[][] matrix, int rStart, int rSize, int cStart, int cSize) {
        int subMatrixSum = 0;
        for (int i = rStart; i < rStart + rSize; i++) {
            for (int j = cStart; j < cStart + cSize; j++) {
                subMatrixSum += matrix[i][j];
            }
        }
        return subMatrixSum;
    }
}
*/
import java.util.*;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 1; col < n; col++) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }
        for (int col1 = 0; col1 < n; col1++) {
            for (int col2 = col1; col2 < n; col2++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1); 

                int sum = 0;
                for (int row = 0; row < m; row++) {
                    int prefixSum = matrix[row][col2] - (col1 > 0 ? matrix[row][col1 - 1] : 0);
                    sum += prefixSum;
                    if (map.containsKey(sum - target)) {
                        count += map.get(sum - target);
                    }

                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return count;
    }
}

