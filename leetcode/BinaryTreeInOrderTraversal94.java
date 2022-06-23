package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrderTraversal94 {

    List<Integer> values = new ArrayList<>();

  public static void main(String[] args) {
      var node4 =  new TreeNode(4, null, null);
      var node5 =  new TreeNode(5, null, null);
      var node2 =  new TreeNode(2, node4, node5);
      var node3 =  new TreeNode(3, null, null);
    var node1 =  new TreeNode(1, node2, node3);

    var test = new BinaryTreeInOrderTraversal94();
    test.inorderTraversal(node1).forEach(o -> System.out.print(o + " "));
    System.out.println();
    test.preorderTraversal(node1).forEach(o -> System.out.print(o + " "));
      System.out.println();
      test.postorderTraversal(node1).forEach(o -> System.out.print(o + " "));
  }

    private List<Integer> postorderTraversal(TreeNode root) {
        var list = new ArrayList<Integer>();
        dfsPostorder(root, list);
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        dfsInOrder(root);
        return values;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
      var list = new ArrayList<Integer>();

      dfsPreorder(root, list);

      return list;
    }

    private void dfsPreorder(TreeNode node, ArrayList<Integer> list) {
        if(node != null) {
            list.add(node.val);
            dfsPreorder(node.left, list);
            dfsPreorder(node.right, list);
        }
    }

    private void dfsPostorder(TreeNode node, ArrayList<Integer> list) {
        if(node != null) {
            dfsPostorder(node.left, list);
            dfsPostorder(node.right, list);
            list.add(node.val);
        }
    }

    public void dfsInOrder(TreeNode node){
        if(node != null) {
            dfsInOrder(node.left);
            values.add(node.val);
            dfsInOrder(node.right);
        }
    }
}
