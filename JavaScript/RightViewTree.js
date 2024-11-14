//Given a Binary Tree, the task is to print the Right view of it.
// The right view of a Binary Tree is a set of rightmost nodes for every level.

class Node {
  constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

function rightView(root) {
  if (root === null) return;

  let queue = [];
  queue.push(root);

  while (queue.length > 0) {
    let n = queue.length;
    for (let i = 0; i < n; i++) {
      let node = queue.shift();
      if (i === n - 1) {
        console.log(node.data);
      }
      if (node.left) queue.push(node.left);
      if (node.right) queue.push(node.right);
    }
  }
}

function main() {
  let root = new Node(1);
  root.left = new Node(2);
  root.right = new Node(3);
  root.left.left = new Node(4);
  root.left.right = new Node(5);
  root.right.right = new Node(6);
  root.left.left.left = new Node(7);

  console.log("Right View of the Binary Tree:");
  rightView(root);
}

main();
