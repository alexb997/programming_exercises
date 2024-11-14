// Given a binary tree, the task is to connect the nodes that are at the same level.
//  Given an addition nextRight pointer for the same.
// Initially, all the next right pointers point to garbage values,
//  set these pointers to the point next right for each node.

class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
    this.nextRight = null;
  }
}

function connectNodesAtSameLevel(root) {
  if (!root) return;
  const queue = [root];
  while (queue.length > 0) {
    let levelSize = queue.length;
    let prevNode = null;

    for (let i = 0; i < levelSize; i++) {
      let node = queue.shift();

      if (prevNode) {
        prevNode.nextRight = node;
      }
      prevNode = node;

      if (node.left) {
        queue.push(node.left);
      }
      if (node.right) {
        queue.push(node.right);
      }
    }

    prevNode.nextRight = null;
  }
}

function main() {
  const root = new TreeNode(1);
  root.left = new TreeNode(2);
  root.right = new TreeNode(3);
  root.left.left = new TreeNode(4);
  root.left.right = new TreeNode(5);
  root.right.right = new TreeNode(6);

  connectNodesAtSameLevel(root);

  console.log(root.left.nextRight === root.right);
  console.log(root.left.left.nextRight === root.left.right);
  console.log(root.left.right.nextRight === root.right.right);
}

main();
