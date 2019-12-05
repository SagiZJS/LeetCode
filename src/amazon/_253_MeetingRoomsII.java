package amazon;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class _253_MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int res = 0;
        while (!list.isEmpty()) {
            int lastEnd = 0;
            Iterator<int[]> iter = list.iterator();
            for (; iter.hasNext();) {
                int[] time = iter.next();
                if (time[0] >= lastEnd) {
                    lastEnd = time[1];
                    iter.remove();
                }
            }
            res++;
        }

        return res;
    }
}
