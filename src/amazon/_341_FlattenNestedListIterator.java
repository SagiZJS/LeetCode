package amazon;

import java.util.Iterator;
import java.util.List;

public class _341_FlattenNestedListIterator {

    // This is the interface that allows for creating nested lists. // You should
//      not implement it, or speculate about its implementation 
    public interface NestedInteger {

//       @return true if this NestedInteger holds a single integer, rather than a
//      nested list. 
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a
//      single integer // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a
//      nested list // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    class NestedIterator implements Iterator<Integer> {
        List<NestedInteger> nestedList;
        int cursor = 0;
        NestedIterator iter;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
            nextCursor();
        }

        @Override
        public Integer next() {
            NestedInteger ni = nestedList.get(cursor);
            if (ni.isInteger()) {
                cursor++;
                nextCursor();
                return ni.getInteger();
            } else {
                Integer ret = iter.next();
                if (!iter.hasNext()) {
                    cursor++;
                    nextCursor();
                }
                return ret;
            }
        }

        @Override
        public boolean hasNext() {
            return cursor < nestedList.size();
        }

        private void nextCursor() {
            while (cursor < nestedList.size()) {
                NestedInteger ni = nestedList.get(cursor);
                if (ni.isInteger()) {
                    break;
                }
                iter = new NestedIterator(ni.getList());
                if (iter.hasNext()) {
                    break;
                }
                iter = null;
                cursor++;
            }
        }
    }

}
