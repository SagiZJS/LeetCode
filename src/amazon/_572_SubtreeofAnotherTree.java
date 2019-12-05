package amazon;


public class _572_SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder st = new StringBuilder();
        recursiveToString(st, s);
        StringBuilder bt = new StringBuilder();
        recursiveToString(bt, t);
        System.out.println(bt.toString());
        return bt.toString().indexOf(st.toString()) >=0;
    }


    void recursiveToString(StringBuilder builder, TreeNode node) {
        if (node == null) {
            builder.append("n");
            return;
        }
        builder.append("m");
        builder.append(node.val);
        
        builder.append("l");
        recursiveToString(builder, node.left);
        builder.append(" ");
        
        builder.append("r");
        recursiveToString(builder, node.right);
        builder.append(" ");
    }
}
