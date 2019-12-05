package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _957PrisonCellsAfterNDays {
    public static class Cells {
        int[] cells;

        public Cells(int[] cells) {
            super();
            this.cells = cells;
        }

        @Override
        public int hashCode() {
            // TODO Auto-generated method stub
            int hash = 0;
            for (int i = 0; i < 8; i++) {
                hash += cells[i];
                hash = hash << 1;
            }
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            // TODO Auto-generated method stub
            if (obj == this)
                return true;
            if (obj == null || obj.getClass() != this.getClass())
                return false;

            return ((Cells) obj).hashCode() == this.hashCode();
        }

    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        Cells nextCells = null;
        Cells lastCells = new Cells(cells);
        HashSet<Cells> set = new HashSet<>();
        List<Cells> list = new ArrayList<>();
        while (N > 0) {
            nextCells = new Cells(new int[8]);
            for (int i = 1; i < 7; i++) {

                nextCells.cells[i] = 1 - (lastCells.cells[i - 1] ^ lastCells.cells[i + 1]);
            }
            if (set.contains(nextCells)) {
                System.out.print("loop\n");
                while (!list.get(0).equals(nextCells)) {
                    list.remove(0);
                }
                break;
            }
            set.add(nextCells);
            list.add(nextCells);
            System.out.println(set.size());

            lastCells = nextCells;
            N--;
        }
        if (N > 0) {
            int remain = N % list.size();
            return list.get(remain).cells;
        } else {
            return lastCells.cells;
        }
    }

    public static void main(String[] args) {
        _957PrisonCellsAfterNDays s = new _957PrisonCellsAfterNDays();
        int[] cells = new int[8];
        cells = new int[] { 0, 1, 0, 1,0 , 0, 0, 0 };
        Cells c = new Cells(cells);
        System.out.println(Integer.toBinaryString(c.hashCode()));
        int[] c2 = s.prisonAfterNDays(cells, 100);
        System.out.print(c2);
    }
}
