package medium;


public class _450_Delete_Node_in_a_BST {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	    public TreeNode deleteNode(TreeNode root, int key) {
	        TreeNode dst = Search(root,key);
	        if(dst!=null){
	            TreeNode toD = dst;
	            if(dst.right!=null&&dst.left!=null){
	                toD = Sucessor(root,key);
	            }
	            TreeNode p =null;
	            if(root==toD){
	                if(toD.right!=null){
	                    root = toD.right;
	                    return root;
	                } else if(toD.left!=null){
	                    root = toD.left;
	                    return root;
	                } else{
	                    return null;
	                }
	            } else {
	            p = P(root,toD.val);
	            if(p==null){
	            }
	            TreeNode c =null;
	            if((c=toD.right)!=null){
	                if(toD==p.right){
	                    p.right = c;
	                } else if(toD==p.left){
	                    p.left = c;
	                }
	            } else if((c=toD.left)!=null){
	                if(toD==p.right){
	                    p.right = c;
	                } else if(toD==p.left){
	                    p.left = c;
	                }
	            } else if(toD.left==null&&toD.right==null){
	                c=null;
	                if(toD==p.right){
	                    p.right = c;
	                } else if(toD==p.left){
	                    p.left = c;
	                }
	            }
	            if(toD!=dst){
	                dst.val=toD.val;
	            }
	            }
	            return root;
	        }
	        return root;
	    }
	    public TreeNode P(TreeNode root, int key){
	        TreeNode ptr = root;
	        if(root.val==key){
	            return null;
	        }
	        if(ptr!=null){
	            while(ptr!=null){
	                if((ptr.right!=null&&ptr.right.val==key)||(ptr.left!=null&&ptr.left.val==key)){
	                    return ptr;
	                }
	                if(ptr.val<key){
	                    ptr = ptr.right;
	                } else if(ptr.val>key){
	                    ptr = ptr.left;
	                } else {
	                    break;
	                }
	            }
	        }
	        return null;
	    }
	    public TreeNode Sucessor(TreeNode root, int key){
	        TreeNode temp = Search(root, key);
	        if(temp!=null){
	            TreeNode ptr=null;
	            if(temp.right!=null){
	                ptr = temp.right;
	                while(ptr.left!=null){
	                    ptr = ptr.left;
	                }
	                return ptr;
	            } else{
	                TreeNode scr=null;
	                ptr = root;
	                while(ptr!=null){
	                    if(ptr.right.val==key)
	                    if(ptr.val<key){
	                        ptr = ptr.right;
	                    } else if(ptr.val>key){
	                        scr = ptr;
	                        ptr = ptr.left;
	                    } else{
	                        return scr;
	                    }
	                }
	            }
	        }
	        return null;
	    }
	    public TreeNode Search(TreeNode root, int key){
	        TreeNode ptr = root;
	        if(ptr!=null){
	            while(ptr!=null){
	                if(ptr.val<key){
	                    ptr = ptr.right;
	                } else if(ptr.val>key){
	                    ptr = ptr.left;
	                } else{
	                    return ptr;
	                }
	            }
	        }
	        return null;
	    }
	    class TreeNode {
	    	int val;
	    	TreeNode right, left;
	    	
	    	public TreeNode(int val) {
	    		this.val = val;
	    	}
	    	
	    }
	public static void main(String[] args) {
//		_450_Delete_Node_in_a_BST t = new _450_Delete_Node_in_a_BST();
////	    TreeNode t5 = new TreeNode(5);
//	    TreeNode t3 = new TreeNode(3);
////	    TreeNode t6 = new TreeNode(6);
////	    TreeNode t2 = new TreeNode(2);
////	    TreeNode t4 = new TreeNode(4);
////	    TreeNode t7 = new TreeNode(7);
////	    TreeNode root =t5;
////	    t5.right=t6;
////	    t5.left=t3;
////	    t3.right=t4;
////	    t3.left=t2;
////	    t6.right=t7;
////	    System.out.println(t6.left);
////	    System.out.println(t.Sucessor(root, 5).val);
//		TreeNode root = new TreeNode(2);
//		TreeNode t1 = new TreeNode(1);
//		root.left=t1;
//		root.right = t3;
//		t.deleteNode(root, 2);
		

//	    System.out.println(deleteNode(root, 0));

	}

}
