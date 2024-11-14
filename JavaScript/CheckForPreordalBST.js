// Check if a given array can represent Preorder Traversal of Binary Search Tree

function canRepresentBST(preorder) {
  let stack = [];
  let root = -Infinity;

  for (let i = 0; i < preorder.length; i++) {
    if (preorder[i] < root) return false;

    while (stack.length > 0 && preorder[i] > stack[stack.length - 1]) {
      root = stack.pop();
    }

    stack.push(preorder[i]);
  }
  return true;
}

function main() {
  const preorder1 = [10, 5, 1, 7, 40, 50];
  const preorder2 = [10, 5, 1, 40, 7, 50];

  console.log("Can preorder1 represent a BST?", canRepresentBST(preorder1));
  console.log("Can preorder2 represent a BST?", canRepresentBST(preorder2));
}

main();
