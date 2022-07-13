package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelTraversal102 {

  public static void main(String[] args) {
      var test = new BinaryTreeLevelTraversal102();

      var node4 = new TreeNode(4);
      var node3 = new TreeNode(3, null, node4);
      var node5 = new TreeNode(5);
      var node2 = new TreeNode(2, null, node5);
      var root = new TreeNode(1, node2, node3);

      test.levelOrder(root);
  }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return Collections.emptyList();

        var nodes = new ArrayList<List<Integer>>();
        var queue = new LinkedList<Object[]>();
        queue.push(new Object[]{root, 0});
        var currentLevel = 0;
        var levelNodes = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            var current = queue.poll();
            var node = (TreeNode) current[0];
            var level = (Integer) current[1];

            if(currentLevel != level) {
                nodes.add(levelNodes);
                levelNodes = new ArrayList<>();
                currentLevel = level;
            }

            levelNodes.add(node.val);

            if (node.left != null) queue.add(new Object[]{node.left, level +1});
            if (node.right != null) queue.add(new Object[]{node.right, level +1});
        }

        if(!levelNodes.isEmpty()) nodes.add(levelNodes);
        return nodes;
    }
}
