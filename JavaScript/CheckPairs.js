function countPairs(N) {
    let count = 0;
    for (let a = 0; a * a * a <= N; a++) {
        let bCubed = N - a * a * a;
        let b = Math.cbrt(bCubed);
        if (Number.isInteger(b)) count++;
    }
    return count;
}

function main() {
    const N = 75;
    console.log(countPairs(N)); 
}

main();
