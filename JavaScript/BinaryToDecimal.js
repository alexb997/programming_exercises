function binaryToDecimalParse(binaryStr) {
    return parseInt(binaryStr, 2);
}

function binaryToDecimal(binaryStr) {
    let decimal = 0;
    let power = 0;
    for (let i = binaryStr.length - 1; i >= 0; i--) {
        if (binaryStr[i] === '1') {
            decimal += Math.pow(2, power);
        }
        power++;
    }
    return decimal;
}

function main() {
    const binaryStr = "1011";
    console.log(binaryToDecimal(binaryStr)); 
}

main();
