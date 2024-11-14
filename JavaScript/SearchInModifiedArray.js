// Given a sorted and rotated array arr[] of n distinct elements,
//  the task is to find the index of given key in the array.
//  If the key is not present in the array, return -1.

function search(arr, key) {
  let low = 0;
  let high = arr.length - 1;

  while (low <= high) {
    let mid = Math.floor((low + high) / 2);

    if (arr[mid] === key) return mid;

    if (arr[low] <= arr[mid]) {
      if (arr[low] <= key && key < arr[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    } else {
      if (arr[mid] < key && key <= arr[high]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
  }
  return -1;
}

function main() {
  let arr = [6, 7, 9, 15, 19, 2, 3];
  let key = 15;
  console.log(search(arr, key));
}

main();
