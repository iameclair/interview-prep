public class BinaryTree
{
	//create a node structure
	class Node{
		int value;
		Node left;
		Node right;

		public Node(int value)
		{
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	//create a node root

	Node root;

	//add node starting with the root

	public Node add(int value){
		root = insertNode(root, value);
		return root;
	}

	public boolean find(int value){
		return findNode(root, value);
	}

	//operation 1 insert node
	private Node insertNode(Node current, int value){
		if(current == null){
			return new Node(value);
		}
		//if value is less than the current value
		if(value < current.value) current.left = insertNode(current.left, value);
		if(value > current.value) current.right = insertNode(current.right, value);

		return current;
	}

	//find operation
	private boolean findNode(Node current, int value){
		if(current == null) return false;
		if(current.value == value) return true;
		return current.value < value ? findNode(current.left, value):
				findNode(current.right, value);
	}

	public BinaryTree buildBinaryTree(){
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.add(6);
		binaryTree.add(8);
		binaryTree.add(5);

		return binaryTree;
	}

	public static void main(String[] args)
	{
		new BinaryTree().buildBinaryTree();
		System.out.println(new BinaryTree().find(5));
	}
}
