class Node {
  constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

function mirrorTree(node) {
  if (node === null) {
    return;
  }
  let temp = node.left;
  node.left = node.right;
  node.right = temp;

  mirrorTree(node.left);
  mirrorTree(node.right);
}

function printTree(node) {
  if (node === null) return;
  console.log(node.data);
  printTree(node.left);
  printTree(node.right);
}

function main() {
  let root = new Node(1);
  root.left = new Node(2);
  root.right = new Node(3);
  root.left.left = new Node(4);
  root.left.right = new Node(5);
  root.right.left = new Node(6);
  root.right.right = new Node(7);

  console.log("Tree:");
  printTree(root);

  mirrorTree(root);

  console.log("Mirror:");
  printTree(root);
}

main();
