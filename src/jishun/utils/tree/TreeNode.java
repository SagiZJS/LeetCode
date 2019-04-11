package jishun.utils.tree;

public class TreeNode <E extends Comparable<E>>{

	private TreeNode<E> parent=null;
	private TreeNode<E> left=null, right=null;
	
	private E value;
	public TreeNode(E value) {
		this.value = value;
	}

	public TreeNode<E> getParent() {
		return parent;
	}

	public void setParent(TreeNode<E> parent) {
		this.parent = parent;
	}

	public TreeNode<E> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<E> left) {
		this.left = left;
	}

	public TreeNode<E> getRight() {
		return right;
	}

	public void setRight(TreeNode<E> right) {
		this.right = right;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

}
