// Given a binary tree, the task is to find its reverse level order traversal.
// The idea is to print the last level first, then the second last level, and so on.

class Node {
  constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

function reverseLevelOrder(root) {
  if (!root) return;
  let queue = [];
  let stack = [];
  queue.push(root);
  while (queue.length > 0) {
    let node = queue.shift();
    stack.push(node.data);
    if (node.right) queue.push(node.right);
    if (node.left) queue.push(node.left);
  }
  while (stack.length > 0) {
    console.log(stack.pop());
  }
}

function main() {
  let root = new Node(1);
  root.left = new Node(2);
  root.right = new Node(3);
  root.left.left = new Node(4);
  root.left.right = new Node(5);
  root.right.left = new Node(6);
  root.right.right = new Node(7);

  console.log("Reverse Level Order Traversal:");
  reverseLevelOrder(root);
}

main();
