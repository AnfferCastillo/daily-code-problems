package trees;

public class Tree {

	private TreeNode root;

	public static void main(String[] args) {
		int[] values = new int[] { 8, 15, 10, 20, 4, 18, 1, 14, 5, 17 };

		var tree = new Tree();

		for (int i : values) {
			tree.insert(i);
		}
		
		//tree.traverseInOrder();
		//tree.traverseLevels();
		//tree.traversePreOrder();
		tree.traversePostOrder();
	}

	public void insert(int value) {
		if (root == null) {
			root = new TreeNode(value);
		} else {
			root.insert(value);
		}
	}
	
	public void traverseInOrder() {
		if(root == null) {
			System.out.println("Empty");
			return;
		}
		root.traverseInOrder();
	}
	
	public void traverseLevels() {
		if(root == null) {
			System.out.println("Empty");
			return;
		}
		System.out.print(root.getData() + ",");
		root.traverseLevels();
	}
	
	public void traversePreOrder() {
		if(root == null) {
			System.out.println("Empty");
			return;
		}
		root.traversePreOrder();
	}
	
	public void traversePostOrder() {
		if(root == null) {
			System.out.println("Empty");
			return;
		}
		root.traversePostOrder();
	}

}
