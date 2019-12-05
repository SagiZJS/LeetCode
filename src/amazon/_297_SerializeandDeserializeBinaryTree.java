package amazon;

public class _297_SerializeandDeserializeBinaryTree {
    public class Codec {
        int index = 1;
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            midOrder(builder, root);
            return builder.toString();
        }

        public TreeNode deserialize(String data) {
            index = 1;
            return reverseMidOrder(data.split("#"));
        }
        TreeNode reverseMidOrder(String[] data) {
            if (data[index].equals("n")) {
                index++;
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(data[index]));
            index++;
            TreeNode lNode = reverseMidOrder(data);
            TreeNode rNode = reverseMidOrder(data);
            root.left = lNode;
            root.right = rNode;
            return root;
        }
        void midOrder(StringBuilder builder, TreeNode root) {
            if (root == null) {
                builder.append("#n");
                return;
            }
            builder.append("#"+root.val);
            midOrder(builder, root.left);
            midOrder(builder, root.right);
        }
    }
    public static void main(String[] args) {
        _297_SerializeandDeserializeBinaryTree ss = new _297_SerializeandDeserializeBinaryTree();
        _297_SerializeandDeserializeBinaryTree.Codec s =  ss.new Codec();
        String data = "#1#2#n#n#3#4#n#n#5#n#n";
        s.deserialize(data);
    }
}
