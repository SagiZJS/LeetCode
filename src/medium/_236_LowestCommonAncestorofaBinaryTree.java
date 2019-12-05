package medium;

public class _236_LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] res = new TreeNode[1];
        if (p == q) {
            return recFind(root, p);
        } else {
            recFind(root, p, q, res);
        }
        return res[0];
    }
    public TreeNode recFind(TreeNode root, TreeNode p) {
        if (root == p || root == null) {
            return root;
        } else {
            TreeNode temp = recFind(root.left, p);
            if (temp != null) {
                return temp;
            } else {
                return recFind(root.right, p);
            }
        }
    }
    public int recFind(TreeNode root, TreeNode p, TreeNode q, TreeNode[] res) {
        if (res[0] != null) {
            return 2;
        }
        if (root == null) {
            return 0;
        }
        int rightSignal = 0;
        int leftSignal = 0;
        leftSignal = recFind(root.left, p, q, res);
        if (leftSignal == 2) {
            return 2;
        } 
        rightSignal = recFind(root.right, p, q, res);
        if (rightSignal == 2) {
            return 2;
        }
        if (leftSignal == 0) {
            if (root == q) {
                if (rightSignal == -1) {
                    res[0] = root;
                    return 2;
                } else {
                    return 1;
                }
            } else if (root == p) { 
                if (rightSignal == 1) {
                    res[0] = root;
                    return 2;
                } else {
                    return -1;
                }
            } else {
                return rightSignal;
            }
        } else if (leftSignal == -1){
            if (rightSignal == 1 || root == q) {
                res[0] = root;
                return 2;
            } else {
                return -1;
            }
        } else {
            if (rightSignal == -1 || root == p) {
                res[0] = root;
                return 2;
            } else {
                return 1;
            }
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);

        root.left = p;
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = q;
        _236_LowestCommonAncestorofaBinaryTree s = new _236_LowestCommonAncestorofaBinaryTree();
        root = s.lowestCommonAncestor(root, p, q);
        System.out.println(root.val);
    }
}
