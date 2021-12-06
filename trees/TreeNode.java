package trees;

public class TreeNode {
    
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
    
    public void insert(int value) {
    	
    	if(value == data) {
    		return;
    	}
    	
    	if(value < data) {
    		if(left != null) {
    			left.insert(value);
    		} else {
    			left = new TreeNode(value);
    		}
    	} else {
    		if(right != null) {
    			right.insert(value);
    		} else {
    			right = new TreeNode(value);
    		}
    	}
    }
    
    
    public void traverseInOrder() {
    	if(left != null) {
    		left.traverseInOrder();
    	}
    	System.out.print(data + ",");
    	if(right != null) {
    		right.traverseInOrder();
    	}
    }
    
    
    public void traverseLevels() {
    	if(left != null) {
    		System.out.print(left.data + ",");
    	}
    	
    	if(right != null ) {
    		System.out.print(right.data + ",");
    	}
    	
    	if(left != null) {
    		left.traverseLevels();
    	}
    	
    	if(right != null ) {
    		right.traverseLevels();
    	}
    }
    
    
    public void traversePreOrder() {
    	System.out.print(data + ",");
    	if(left != null) {
    		left.traversePreOrder();
    	}
    	if(right != null) {
    		right.traversePreOrder();
    	}
    }
    
    public void traversePostOrder() {
    	if(left != null) {
    		left.traversePostOrder();
    	}
    	if(right != null) {
    		right.traversePostOrder();
    	}
    	System.out.print(data + ",");
    }
   

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }


	public TreeNode getLeft() {
		return left;
	}


	public void setLeft(TreeNode left) {
		this.left = left;
	}


	public TreeNode getRight() {
		return right;
	}


	public void setRight(TreeNode right) {
		this.right = right;
	}

    

}
