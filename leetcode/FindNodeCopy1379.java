package leetcode;

import java.time.temporal.Temporal;
import java.util.LinkedList;
import java.util.Stack;

public class FindNodeCopy1379 {


    public static void main(String[] args) {
        var findCopy = new FindNodeCopy1379();
        var original = new TreeNode(10);
        var cloned = new TreeNode(10);
        var target = new TreeNode(10);

        var result = findCopy.getTargetCopy(original, cloned, target);
        System.out.println(result);
    }

    public TreeNode getTargetCopy(TreeNode original, TreeNode cloned, TreeNode target) {
        var queue = new LinkedList<TreeNode>();

        queue.push(cloned);

        while(!queue.isEmpty()) {
            var current = queue.poll();
                if(current.val == target.val) return current;
              if(current.left != null )  queue.push(current.left);
               if(current.right != null) queue.push(current.right);

        }
        return target;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}