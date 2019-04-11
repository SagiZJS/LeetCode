package easy;


public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {
	public TreeNode sortedArrayToBST(int[] nums) {
		
		return Insert(nums, 0, nums.length-1);
	}
	public TreeNode Insert(int[] nums, int i, int j) {
		if(i>j) return null;
		int next = (i+j)/2;
		TreeNode temp = new TreeNode(nums[next]);
		temp.left=Insert(nums, i, next-1);
		temp.right=Insert(nums, next+1, j);
		return temp;
	}
	
//		TreeNode root = null;
//		Set<Integer> s = new HashSet<Integer>();
//		int i = 0, j = 0;
//		while (i < nums.length) {
//			j = i;
//			while (j < nums.length) {
//				if (s.contains(j)) {
//					j=j-1;
//					break;
//				}
//				j++;
//			}
//			while (!s.contains((i + j) / 2)) {
//				s.add((i + j) / 2);
//				root=Insert(root, nums[(i + j) / 2]);
//				j = (i + j) / 2;
//			}
//			while(s.contains(i)) {
//				i++;
//			}
//		}
//		return root;
//	}
//	public TreeNode Insert(TreeNode root, int key) {
//		TreeNode temp = root;
//		if (temp == null) {
//			return (root = new TreeNode(key));
//		}
//		while (true) {
//			if (temp.val < key) {
//				if (temp.right == null) {
//					temp.right = new TreeNode(key);
//					return root;
//				}
//				temp = temp.right;
//			} else {
//				if (temp.left == null) {
//					temp.left = new TreeNode(key);
//					return root;
//				}
//				temp = temp.left;
//			}
//		}
//
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
