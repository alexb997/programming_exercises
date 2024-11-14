//Given a number N as string, find the smallest number that has same
// set of digits as N and is greater than N.
// If N is the greatest possible number with its set of digits, then print “Not Possible”.

function nextPermutation(N) {
  let arr = N.split("");
  let i = arr.length - 2;
  while (i >= 0 && arr[i] >= arr[i + 1]) {
    i--;
  }
  if (i === -1) {
    return "Not Possible";
  }
  let j = arr.length - 1;
  while (arr[j] <= arr[i]) {
    j--;
  }
  [arr[i], arr[j]] = [arr[j], arr[i]];
  let left = i + 1;
  let right = arr.length - 1;
  while (left < right) {
    [arr[left], arr[right]] = [arr[right], arr[left]];
    left++;
    right--;
  }
  return arr.join("");
}

function main() {
  const N = "534976";
  console.log(nextPermutation(N));
}

main();
