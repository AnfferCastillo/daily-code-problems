package leetcode;

import java.util.HashSet;
import java.util.Set;

public class BinaryTreeCameras958 {

  int cams = 0;

  public int minCameraCover(TreeNode root) {
    var watched = new HashSet<TreeNode>();
    watched.add(null);
    dfs(root, null, watched);
    return cams;
  }

  private void dfs(TreeNode node, TreeNode parent, Set<TreeNode> watched) {
    if (node != null) {
      dfs(node.left, node, watched);
      dfs(node.right, node, watched);

      if (parent == null && !watched.contains(node)
          || !watched.contains(node.left)
          || !watched.contains(node.right)) {
        cams++;
        watched.add(node);
        watched.add(parent);
        watched.add(node.right);
        watched.add(node.left);
      }
    }
  }

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return "TreeNode{" + "val=" + val + '}';
    }
  }
}
