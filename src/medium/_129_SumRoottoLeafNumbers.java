package medium;


public class _129_SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int num = 0;
        int[] sum = {0};
        recursion(num, root, sum);
        return sum[0];
    }
    
    public void recursion(int num, TreeNode root, int[] sum) {
        num = num*10 + root.val;
        if (root.left == null && root.right == null) {
            sum[0] += num; 
        }
        else if (root.left != null) {
            recursion(num, root.left, sum);
        } else if (root.right != null) {
            recursion(num, root.right, sum);
        }
    }
    
    public static void main(String[] args) {
        _129_SumRoottoLeafNumbers s =new _129_SumRoottoLeafNumbers();
        System.out.println(s.sumNumbers(null));
        }
}
