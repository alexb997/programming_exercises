// We have an integer array that is sorted in ascending order. We also have 3 integers A, B and C.
//  We need to apply A*x*x + B*x + C for each element x in the array and sort the modified array. 

function transformAndSort(arr, A, B, C) {
    return arr.map(x => A * x * x + B * x + C).sort((a, b) => a - b);
}

function main() {
    let arr = [-10, -5, 0, 5, 10];
    let A = 1, B = 2, C = 1;
    console.log(transformAndSort(arr, A, B, C));
}

main();
