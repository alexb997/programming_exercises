//Given an integer n, the task is to find the first n rows of Pascal’s triangle.
// Pascal’s triangle is a triangular array of binomial coefficients.

function generatePascalsTriangle(n) {
  let triangle = [];
  for (let i = 0; i < n; i++) {
    let row = new Array(i + 1).fill(1);
    for (let j = 1; j < i; j++) {
      row[j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
    }
    triangle.push(row);
  }
  return triangle;
}

function printPascalsTriangle(triangle) {
  for (let row of triangle) {
    console.log(row.join(" "));
  }
}

function main() {
  const n = 5;
  const triangle = generatePascalsTriangle(n);
  printPascalsTriangle(triangle);
}

main();
