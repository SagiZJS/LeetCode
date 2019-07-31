package medium;

import java.util.ArrayList;
import java.util.List;

public class _120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] DPMatrix = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                DPMatrix[i][j] += triangle.get(i).get(j);
                if (i > 0) {
                    if (j > 0 && j < triangle.get(i).size() - 1) {
                        if (DPMatrix[i - 1][j] < DPMatrix[i - 1][j - 1]) {
                            DPMatrix[i][j] += DPMatrix[i - 1][j];
                        } else {
                            DPMatrix[i][j] += DPMatrix[i - 1][j - 1];
                        }
                    } else if (j == 0) {
                        DPMatrix[i][j] += DPMatrix[i - 1][j];
                    } else {
                        DPMatrix[i][j] += DPMatrix[i - 1][j - 1];
                    }
                }
            }
        }
        int min = DPMatrix[DPMatrix.length - 1][0];
        for (int i = 0; i < DPMatrix.length; i++) {
            if (min > DPMatrix[DPMatrix.length - 1][i]) {
                min = DPMatrix[DPMatrix.length - 1][i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<Integer> line = new ArrayList<Integer>();
        List<List<Integer>> triangle = new ArrayList<>();
        line.add(2);
        triangle.add(new ArrayList<>(line));
        line.clear();
        line.add(3);
        line.add(4);
        triangle.add(new ArrayList<>(line));
        line.clear();
        line.add(6);
        line.add(5);
        line.add(7);
        triangle.add(new ArrayList<>(line));
        line.clear();
        line.add(4);
        line.add(1);
        line.add(8);
        line.add(3);
        triangle.add(new ArrayList<>(line));
        line.clear();
        _120_Triangle s = new _120_Triangle();
        s.minimumTotal(triangle);

    }
}
