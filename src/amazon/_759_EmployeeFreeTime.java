package amazon;

import java.util.ArrayList;
import java.util.List;

public class _759_EmployeeFreeTime {
    static class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };

    class BilinkedList {
        int start;
        int end;
        BilinkedList previous;
        BilinkedList after;
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        BilinkedList head = null;
        BilinkedList tail = null;

        for (List<Interval> list : schedule) {
            for (Interval inter : list) {
                if (head == null) { //
                    head = new BilinkedList();
                    tail = head;
                    head.start = inter.start;
                    head.end = inter.end;
                } else {
                    if (inter.start > tail.end) {
                        tail.after = new BilinkedList();
                        tail.after.previous = tail;
                        tail = tail.after;

                        tail.start = inter.start;
                        tail.end = inter.end;
                    } else if (inter.end < head.start) {
                        head.previous = new BilinkedList();
                        head.previous.after = head;
                        head = head.previous;

                        head.start = inter.start;
                        head.end = inter.end;
                    } else {
                        BilinkedList prev = head;
                        while (prev.end < inter.start) {
                            prev = prev.after;
                        }
                        if (tail == prev) {
                            if (tail.start > inter.end) {
                                BilinkedList ni = new BilinkedList();
                                ni.start = inter.start;
                                ni.end = inter.end;

                                ni.previous = prev.previous;
                                ni.after = prev;

                                prev.previous.after = ni;
                                prev.previous = ni;
                            } else {
                                tail.start = Math.min(tail.start, inter.start);
                                tail.end = Math.max(tail.end, inter.end);
                            }
                        } else {
                            // prev.end >= inter.start;
                            if (inter.end < prev.start) {
                                BilinkedList newInter = new BilinkedList();
                                newInter.start = inter.start;
                                newInter.end = inter.end;
                                newInter.previous = prev.previous;
                                newInter.after = prev;

                                newInter.after.previous = newInter;
                                newInter.previous.after = newInter;
                            } else if (inter.end < prev.after.start) {
                                // not merging
                                prev.start = Math.min(prev.start, inter.start);
                                prev.end = Math.max(prev.end, inter.end);
                            } else {
                                // merging
                                prev.start = Math.min(prev.start, inter.start);
                                prev.end = inter.end;
                                BilinkedList after = prev;
                                while (after != null && after.start <= inter.end) {
                                    after = after.after;
                                }

                                if (after == null) {
                                    tail = prev;
                                    prev.after = null;
                                } else {
                                    prev.after = after;
                                    after.previous = prev;
                                }
                            }
                        }
                    }
                }
            }

        }
        List<Interval> ret = new ArrayList<>();
        BilinkedList node = head;
        int start = -1;
        int end = -1;
        while (node != null) {
            start = node.end;
            node = node.after;
            if (node == null)
                break;
            end = node.start;
            ret.add(new Interval(start, end));
        }
        return ret;
    }

    public static void main(String[] args) {
        _759_EmployeeFreeTime s = new _759_EmployeeFreeTime();
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(new ArrayList<>());
        schedule.add(new ArrayList<>());
        schedule.get(0).add(new Interval(45, 56));
        schedule.get(0).add(new Interval(89, 96));
        schedule.get(0).add(new Interval(5, 21));
        schedule.get(0).add(new Interval(57, 74));
        s.employeeFreeTime(schedule);
    }
}
