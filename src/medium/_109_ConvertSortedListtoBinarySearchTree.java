package medium;

import java.util.Arrays;

public class _109_ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        int[] vals = new int[200];
        int len = 0;
        while (head != null) {
            vals[len++] = head.val;
            head = head.next;
            if (len == vals.length) {
                int[] temp = new int[vals.length * 2];
                System.arraycopy(vals, 0, temp, 0, vals.length);
                vals = temp;
            }
        }
        if (vals.length != len) {
            vals = Arrays.copyOf(vals, len);
        }

        return recursionBuildTree(vals, 0, vals.length - 1);
    }

    public TreeNode recursionBuildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = recursionBuildTree(nums, start, middle - 1);
        root.right = recursionBuildTree(nums, middle + 1, end);
        return root;
    }
}
