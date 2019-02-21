package TreeAndGraph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import Stack_and_Queue.QueueUsingStack;


public class Tree<T extends Comparable<T>>
{
	Node<T> root;

	private static class Node<T extends Comparable<T>>{
		T data;

		Node<T> left;
		Node<T> right;

		public Node(final T data){
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

	public void insert(final T data){
		final Node<T> node = new Node<>(data);
		if(this.root == null){
			this.root = node;
			return;
		}
		insert(this.root, node);
	}

	private void insert(final Node<T> root, final Node<T> node)
	{
		Node<T> temp = root;
		if(node.data.compareTo(temp.data) < 0){
			if(temp.left == null) {
				temp.left = node;
				return;
			}
			insert(temp.left, node);
		}else{
			if(temp.right == null){
				temp.right = node;
				return;
			}
			insert(temp.right, node);
		}

	}

	private Node<T> search(T data){
		if(this.root != null && this.root.data == data) return this.root;
		return search(this.root, data);
	}

	private Node<T> search(final Node<T> root, final T data)
	{
		if(root.data.equals(data)) return root;
		if(data.compareTo(root.data) < 0) return search(root.left, data);
		else
			return search(root.right, data);
	}

	//level order traversal
	public void levelOrderTraversal(){
		final LinkedList<Node<T>> linkedList = new LinkedList<>();
		linkedList.push(this.root);
		while(!linkedList.isEmpty()){
			final Node<T> current = linkedList.poll();
			System.out.print(current.data+" ");
			if(current.left != null) linkedList.add(current.left);
			if(current.right != null) linkedList.add(current.right);
		}
	}

	public void preOrder(Node<T> root){
		if(root == null) return;
		System.out.print(root.data+" ");
		if(root.left != null) preOrder(root.left);
		if(root.right != null) preOrder(root.right);
	}

	public void inOrder(Node<T> root){
		if(root.left != null) inOrder(root.left);
		System.out.print(root.data+" ");
		if(root.right != null) inOrder(root.right);
	}

	public void postOrder(Node<T> root){
		if(root.left != null) postOrder(root.left);
		if(root.right != null) postOrder(root.right);
		System.out.print(root.data+" ");
	}

	public boolean checkIfBST(Node<T> root){
		if(root == null) return true;
		if(root.left != null ){
			if (isGreater(root, root.left)) return checkIfBST(root.left);
			return false;
		}
		if(root.right != null) {
			if(isSmaller(root, root.right)) return checkIfBST(root.right);
			return false;
		}
		return true;
	}

	public boolean isGreater(Node<T> current, Node<T> next){
		return current.data.compareTo(next.data) > 0;
	}

	public boolean isSmaller(Node<T> current, Node<T> next){
		return current.data.compareTo(next.data) < 0;
	}

	public static void main(final String[] args)
	{
		final Tree<Integer> tree = new Tree<>();
		tree.insert(50);
		tree.insert( 17);
		tree.insert(72);
		tree.insert(23);
		tree.insert( 12);
		tree.insert(54);
		tree.insert(76);
		tree.insert(67);
		tree.insert(9);
		tree.insert(14);
		tree.insert(19);

		System.out.println(tree.search(9).data);
		tree.levelOrderTraversal();
		System.out.println();
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
		System.out.println();
		System.out.println(tree.checkIfBST(tree.root));
	}
}
