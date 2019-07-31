package medium;

public class _74_Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }

        int left = 0;
        int right = m - 1;
        int middle = 0;
        while (left <= right) {
            middle = (left + right) / 2;

            if (matrix[middle][0] > target) {
                right = middle - 1;
            }
            if (matrix[middle][0] < target) {
                left = middle;
                if (left + 1 >= right) {
                    if (matrix[right][0] == target) {
                        return true;
                    }
                    if (matrix[right][0] < target) {
                        middle = right;
                    } else {
                        middle = left;
                    }
                    break;
                }
            }
            if (matrix[middle][0] == target) {
                return true;
            }
        }
        if (left > right) {
            return false;
        }
        left = 0;
        right = n - 1;
        while (left <= right) {
            int i = (left + right) / 2;
            if (matrix[middle][i] < target) {
                left = i + 1;
            }
            if (matrix[middle][i] > target) {
                right = i - 1;
            }
            if (matrix[middle][i] == target) {
                return true;
            }
        }
        return false;
    }

}
