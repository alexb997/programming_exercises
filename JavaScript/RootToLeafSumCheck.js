// Given a binary tree and a sum, return true if
// the tree has a root-to-leaf path such that adding up all the values
// along the path equals the given sum.
//  Return false if no such path can be found.

class Node {
  constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

function hasPathSum(root, sum) {
  if (root === null) return false;
  if (root.left === null && root.right === null) return root.data === sum;
  return (
    hasPathSum(root.left, sum - root.data) ||
    hasPathSum(root.right, sum - root.data)
  );
}

function main() {
  let root = new Node(5);
  root.left = new Node(4);
  root.right = new Node(8);
  root.left.left = new Node(11);
  root.left.left.left = new Node(7);
  root.left.left.right = new Node(2);
  root.right.left = new Node(13);
  root.right.right = new Node(4);
  root.right.right.right = new Node(1);

  const sum = 22;
  console.log(hasPathSum(root, sum));
}

main();
