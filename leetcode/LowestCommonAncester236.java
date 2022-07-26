package leetcode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * <p>According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
 * between two nodes p and q as the lowest node in T that has both p and q as descendants (where we
 * allow a node to be a descendant of itself).”
 *
 * <p>Example 1:
 *
 * <p>Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 Output: 3 Explanation: The LCA of
 * nodes 5 and 1 is 3. Example 2:
 *
 * <p>Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4 Output: 5 Explanation: The LCA of
 * nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * <p>Input: root = [1,2], p = 1, q = 2 Output: 1
 *
 * <p>Constraints:
 *
 * <p>The number of nodes in the tree is in the range [2, 105]. -109 <= Node.val <= 109 All Node.val
 * are unique. p != q p and q will exist in the tree.
 */
public class LowestCommonAncester236 {

  public static void main(String[] args) {
    var test = new LowestCommonAncester236();
    var node4 = new TreeNode(4);
    var node7 = new TreeNode(7);
    var node2 = new TreeNode(2, node7, node4);
    var node6 = new TreeNode(5);
    var node5 = new TreeNode(5, node6, node2);

    var node0 = new TreeNode(0);
    var node8 = new TreeNode(8);
    var node1 = new TreeNode(1, node0, node8);

    var root = new TreeNode(3, node5, node1);

    var path = test.lowestCommonAncestor(root, node5, node4);
    System.out.println(path);
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if (root == null) return null;

    if(root == p || root == q) return root;

    var left = lowestCommonAncestor(root.left, p, q);
    var right = lowestCommonAncestor(root.right,p,q);

    if(left != null && right != null) return root;


    return left != null ? left : right;
  }

}
