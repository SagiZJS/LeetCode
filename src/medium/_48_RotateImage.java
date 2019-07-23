package medium;

public class _48_RotateImage {
    public void rotate(int[][] matrix) {
        rotateSize(matrix, matrix.length, 0, 0);
    }
    
    public void rotateSize(int[][] matrix, int size, int i, int j) {
        if (size<2) {
            return;
        }
        int temp = 0;
        for (int index = 0; index < size - 1; index++) {
            int rightbound = j + size - 1;
            int lowbound = i + size - 1;
//            temp = matrix[i+index][j];
//            /*up left*/ matrix[i][j + index] = matrix[i + index][rightbound];
//            /*up right*/ matrix[i + index][rightbound] = matrix[lowbound][rightbound - index];
//            /*down right*/ matrix[lowbound][rightbound - index] = matrix[lowbound - index][j];
//            /*down left*/ matrix[lowbound - index][j] = temp;
            
            temp = matrix[i][j + index];
            matrix[i][j + index] = matrix[lowbound - index][j];
            matrix[lowbound - index][j] = matrix[lowbound][rightbound - index];
            matrix[lowbound][rightbound - index] = matrix[i + index][rightbound];
            matrix[i + index][rightbound] = temp;
            
        }
        rotateSize(matrix, size - 2, i+1, j+1);
    }
    public static void main(String[] args) {
        _48_RotateImage s = new _48_RotateImage();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        
        s.rotate(matrix);
    }
}



