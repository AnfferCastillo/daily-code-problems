function Node(val, left, right, next) {
  this.val = val === undefined ? null : val;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
  this.next = next === undefined ? null : next;
}

const connect = function (root) {
  queue.push({ node: root, level: 0 });

  while (queue.length > 0) {
    const { node, level } = queue.shift();
    if (node) {
      const next = queue[0];
      if (next && next.level === level) {
        node.next = next.node;
      }

      if (node.left) queue.push({ node: node.left, level: level + 1 });
      if (node.right) queue.push({ node: node.right, level: level + 1 });
    }
  }
  return root;
};

const buildTree = (nodes) => {
  function setChildren(node, index) {
    let valueLeft = null;
    const indexLeft = 2 * index + 1;
    const indexRight = 2 * index + 2;
    if (indexLeft < nodes.length) valueLeft = nodes[indexLeft];

    let valueRight = null;
    if (indexRight < nodes.length) valueRight = nodes[indexRight];

    if (valueLeft) {
      node.left = new Node(valueLeft, null, null, null);
      setChildren(node.left, indexLeft);
    }
    if (valueRight) {
      node.right = new Node(valueRight, null, null, null);
      setChildren(node.right, indexRight);
    }
  }

  const root = new Node(nodes[0], null, null, null);
  setChildren(root, 0);
  return root;
};

const nodes = [1, 2, 3, 4, 5, null, 7];

const root = buildTree(nodes);
connect(root);
