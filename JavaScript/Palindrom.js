function isPalindrome(str) {
  const cleanStr = str.toLowerCase().replace(/[^a-z0-9]/g, "");
  return cleanStr === cleanStr.split("").reverse().join("");
}

function main() {
  const testStrings = ["racecar", "No lemon, no melon", "444"];

  testStrings.forEach((str) => {
    console.log(`"${str}" is a palindrome: ${isPalindrome(str)}`);
  });
}

main();
