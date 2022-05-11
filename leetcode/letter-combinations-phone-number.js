/**
 * Get all letter combinations of a phone number
 */

const keyboard = [
  [],
  [],
  ['a', 'b', 'c'],
  ['d', 'e', 'f'],
  ['g', 'h', 'i'],
  ['j', 'k', 'l'],
  ['m', 'n', 'o'],
  ['p', 'q', 'r', 's'],
  ['t', 'u', 'v'],
  ['w', 'x', 'y', 'z'],
];

const letterCombinationsHelper = (digits, index, combinations, currentCombination) => {
  if (digits == '') return;
  if (index >= digits.length) {
    combinations.push(currentCombination);
    return;
  }

  const digitLetters = keyboard[Number(digits[index])];
  for (letter of digitLetters) {
    letterCombinationsHelper(digits, index + 1, combinations, currentCombination + letter);
  }
};

var letterCombinations = function (digits) {
  const combinations = [];
  letterCombinationsHelper(digits, 0, combinations, '');
  return combinations;
};

console.log(letterCombinations('23'));
console.log(letterCombinations(''));
