// Given an array of positive integers arr[] and an integer x,
//  The task is to find all unique combinations in arr[] where the sum is equal to x. 
// The same repeated number may be chosen from arr[]
//  an unlimited number of times. Elements in a combination (a1, a2, …, ak)
//  must be printed in non-descending order. (ie, a1 <= a2 <= … <= ak).
//  If there is no combination possible print “Empty”.

function findCombinations(arr, x) {
    arr.sort((a, b) => a - b);
    const result = [];
    const currentCombination = [];

    function backtrack(start, target) {
        if (target === 0) {
            result.push([...currentCombination]);
            return;
        }
        
        for (let i = start; i < arr.length; i++) {
            if (arr[i] > target) break;
            currentCombination.push(arr[i]);
            backtrack(i, target - arr[i]);
            currentCombination.pop();
        }
    }

    backtrack(0, x);
    return result.length ? result : "Empty";
}

function main() {
    const arr1 = [2, 4, 6, 8];
    const x1 = 8;
    const arr2 = [1, 3, 5];
    const x2 = 10;

    console.log("Combinations for arr1 with sum", x1, ":", findCombinations(arr1, x1));
    console.log("Combinations for arr2 with sum", x2, ":", findCombinations(arr2, x2));
}

main();
