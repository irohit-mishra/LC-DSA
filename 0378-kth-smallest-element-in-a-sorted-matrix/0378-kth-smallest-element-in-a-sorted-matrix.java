/*public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] array = new int[n * n];
        int index = 0;

        // Convert matrix to array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[index++] = matrix[i][j];
            }
        }

        // Sort the array
        Arrays.sort(array);

        // Return the kth smallest element
        return array[k - 1];
    }
} */

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int countLessEqual(int[][] matrix, int val) {
        int n = matrix.length;
        int count = 0;
        int row = n - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= val) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
}
