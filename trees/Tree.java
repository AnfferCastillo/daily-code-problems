package trees;

public class Tree {

	private TreeNode root;

	public static void main(String[] args) {
		int[] values = new int[] { 8, 15, 10, 20, 5, 18, 3, 14, 6, 17, 7, 25, 22, 27, 23 };

		var tree = new Tree();

		for (int i : values) {
			tree.insert(i);
		}
		
		//tree.traverseInOrder();
		//tree.traverseLevels();
		//tree.traversePreOrder();
		//tree.traversePostOrder();
		
		System.out.println("get(18): " + tree.get(18));
		System.out.println("get(58): " + tree.get(58));
		System.out.println("min: " + tree.min());
		System.out.println("max: " + tree.max());
		tree.traverseInOrder();
		tree.delete(20);
		System.out.println();
		tree.traverseInOrder();
		
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
	
	public TreeNode get(int value) {
		if(root == null) 
			return null;
		
		return root.get(value);
	}
	
	public TreeNode min() {
		if(root == null)
			return null;
		
		return root.min();
	}
	
	public TreeNode max() {
		if(root == null)
			return null;
		
		return root.max();
	}
	
	public void delete(int value) {
		root = delete(root, value);
	}


	private TreeNode delete(TreeNode subtreeRoot, int value) {
		
		if(subtreeRoot.getData() < value) {
			if(subtreeRoot.getRight() != null ) {
				subtreeRoot.setRight(delete(subtreeRoot.getRight(), value));
			}
		} else if(subtreeRoot.getData() > value) {
			if(subtreeRoot.getLeft() != null ) {
				subtreeRoot.setLeft(delete(subtreeRoot.getLeft(), value));
			}
		} else {
			if(subtreeRoot.getRight() == null) {
				return subtreeRoot.getLeft();
			} else if(subtreeRoot.getLeft() == null){
				return subtreeRoot.getRight();
			} else {
				var min = subtreeRoot.getRight().min(); 
				delete(min.getData());
				min.setLeft(subtreeRoot.getLeft());
				min.setRight(subtreeRoot.getRight());
				return min;
			}
		}
		
		return subtreeRoot;
	}

}
