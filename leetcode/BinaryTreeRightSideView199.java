package leetcode;

import java.util.*;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the
 * values of the nodes you can see ordered from top to bottom.
 *
 * <p>Example 1: Input: root = [1,2,3,null,5,null,4] Output: [1,3,4]
 *
 * <p>Example 2:
 *
 * <p>Input: root = [1,null,3] Output: [1,3] Example 3:
 *
 * <p>Input: root = [] Output: []
 */
public class BinaryTreeRightSideView199 {

  public static void main(String[] args) {
    var test = new BinaryTreeRightSideView199();

    var node4 = new TreeNode(4);
    var node3 = new TreeNode(3, null, node4);
    var node5 = new TreeNode(5);
    var node2 = new TreeNode(2, null, node5);
    var root = new TreeNode(1, node2, node3);

    test.rightSideView(root);
  }

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return Collections.emptyList();

        var nodes = new ArrayList<Integer>();
        var queue = new LinkedList<Object[]>();
        queue.push(new Object[]{root, 0});

        while(!queue.isEmpty()) {
            var current = queue.poll();
            var node = (TreeNode) current[0];
            var level = (Integer) current[1];

            var next = queue.isEmpty() ? null : queue.getFirst();

            if(next == null) {
                nodes.add(node.val);
            }else if(next[1] != level) {
                nodes.add(node.val);
            }

            if (node.left != null) queue.add(new Object[]{node.left, level +1});
            if (node.right != null) queue.add(new Object[]{node.right, level +1});
        }
        return nodes;
    }

    public void dfs(TreeNode node, List<Integer> rightSideView){
        if(node != null) {
            rightSideView.add(node.val);
            if(node.right != null) {
                dfs(node.right, rightSideView);
            } else {
                dfs(node.left, rightSideView);
            }
        }
    }

}
