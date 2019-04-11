package jishun.utils.tree;

public class BST<E extends Comparable<E>>{
	
	private TreeNode<E> root=null;
	private int size=0;
	public BST() {
	}
	
	public E[] Traverse() {
		Object[] output = new Object[size];
		int i=0;
		return null;
	}
	
	public TreeNode<E> getRoot() {
		return root;
	}

	public boolean Insert(E key) {
		if(root==null) {
			root = new TreeNode<E>(key);
			return true;
		}
		TreeNode<E> temp = root;
		TreeNode<E> toInsert = new TreeNode<E>(key);
		while(true) {
			int comparison=-temp.getValue().compareTo(key);
			if(comparison>0) {
				if(temp.getRight()!=null) {
					temp = temp.getRight();
				} else {
					toInsert.setParent(temp);
					temp.setRight(toInsert);
					size++;
					return true;
				}
			} else if(comparison<0) {
				if(temp.getLeft()!=null) {
					temp=temp.getLeft();
				} else {
					toInsert.setParent(temp);
					temp.setLeft(toInsert);
					size++;
					return true;
				}
			} else {
				return false;
			}
		}
	}

	public boolean Delete(E key) {
		TreeNode<E> temp = Search(key);
		if(temp!=null){
			TreeNode<E> toD=temp;
			if(temp.getRight()!=null&&temp.getLeft()!=null) {
				toD = Sucessor(key);
			} 
				TreeNode<E> child=null;
				TreeNode<E> parent=null;
				if((child = toD.getRight())!=null) { //toD has right child
					child.setParent((parent = toD.getParent()));     //set right child' parent
					if(parent.getLeft()==toD) {	  // if toD is left child 
						parent.setLeft(child);
					} else {
						parent.setRight(child);
					}
				} else if((child = toD.getLeft())!=null){
					child.setParent((parent = toD.getParent()));     //set left child' parent
					if(parent.getLeft()==toD) {	  // if toD is left child 
						parent.setLeft(child);
					} else {
						parent.setRight(child);
					}
				} else {
					if(toD.getParent().getLeft()==toD) {
						System.out.println("Left");
						toD.getParent().setLeft(null);
					} else if(toD.getParent().getRight()==toD) {
						toD.getParent().setRight(null);
					}
				}
			if(toD!=temp) {
				temp.setValue(toD.getValue());
			}
			
		}
		return false;
	}

	public TreeNode<E> Search(E key) {
		TreeNode<E> temp = root;
		while(temp!=null) {
			int comparison=temp.getValue().compareTo(key);
			if(comparison<0) {
				temp = temp.getRight();
			} else if(comparison>0) {
				temp = temp.getLeft();
			} else {
				return temp;
			}
		}
		return null;
	}
	
	public TreeNode<E> Predecessor(E key){
		TreeNode<E> temp = Search(key);
		if(temp!=null) {
			if(temp.getLeft()!=null) {
				temp=temp.getLeft();
				while(temp.getRight()!=null) {
					temp=temp.getRight();
				}
			} else {
				while(temp.getParent()!=null&&temp.getParent().getLeft()==temp) {
					temp=temp.getParent();
				}
				temp = temp.getParent();
			}
			return temp;
		}
		return null;
	}
	public TreeNode<E> Sucessor(E key){
		TreeNode<E> temp = Search(key);
		if(temp!=null) {
			if(temp.getRight()!=null) {
				temp=temp.getRight();
				while(temp.getLeft()!=null) {
					temp=temp.getLeft();
				}
			} else {
				while(temp.getParent()!=null&&temp.getParent().getRight()==temp) {
					temp=temp.getParent();
				}
				temp = temp.getParent();
			}
			return temp;
		}
		return null;
	}
	public static void main(String[] args) {
		BST<String> t = new BST<String>();
		t.Insert("e");
		t.Insert("b");
		t.Insert("a");
		t.Insert("c");
		t.Insert("g");
		t.Insert("f");
		t.Insert("h");
		TreeNode<String> ptr =t.getRoot();
		System.out.println(ptr.getValue());
		System.out.println("left"+ptr.getLeft()+"\tright"+ptr.getRight());
		System.out.println("a".compareTo("b"));
		System.out.println(t.Search("c").getParent().getValue());
		String key = "c";
		System.out.println("Predecessor of "+key+":"+t.Predecessor(key).getValue());
		System.out.println("Sucessor of "+key+":"+t.Sucessor(key).getValue());
		
		t.Delete("f");
		
		
		
		
		
		
		
		
		System.out.println("exit");
	}
}


