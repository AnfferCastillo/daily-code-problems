package leetcode;

import trees.Tree;

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
  }

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return values;
    }

    public void dfs(TreeNode node){
        if(node != null) {
            dfs(node.left);
            values.add(node.val);
            dfs(node.right);
        }
    }
}
