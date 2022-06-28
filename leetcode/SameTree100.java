package leetcode;

import java.util.LinkedList;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or
 * not.
 *
 * <p>Two binary trees are considered the same if they are structurally identical, and the nodes
 * have the same value.
 */
public class SameTree100 {

  public static void main(String[] args) {
    var node1 = new TreeNode(1);
    var node2 = new TreeNode(2);
    var node3 = new TreeNode(3);

    node1.left = node2;
    node1.right = node3;

      var node12 = new TreeNode(1);
      var node22 = new TreeNode(2);
      var node32 = new TreeNode(3);

      node12.left = node22;
      node12.right = node32;

      var test = new SameTree100();
    System.out.println(
    test.isSameTree(node1, node12));
  }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q != null || p != null && q == null) return false;

        var queue  = new LinkedList<TreeNode>();
        queue.add(p);
        queue.add(q);

        while(!queue.isEmpty()) {
            var node1 = queue.poll();
            var node2 = queue.poll();
            if(node1 == null && node2 == null) continue;
            if(node1 != null && node2 == null) return false;
            if(node2 != null && node1 == null) return false;
            if(node1.val != node2.val) return false;

            if(node1 != null) queue.add(node1.left);
            if(node2 != null) queue.add(node2.left);
            if(node1 != null) queue.add(node1.right);
            if(node2 != null) queue.add(node2.right);
        }

        return true;
    }
}
