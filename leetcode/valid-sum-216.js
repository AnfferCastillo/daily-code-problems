const combinationSum = (k, n) => {
  const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9];

  const combinations = [];
  function findCombinations(targetSum, numbers, combinations, index, currentCombination, memo = {}) {
    if (targetSum == 0 && currentCombination.length == k) {
      return currentCombination;
    }
    if (targetSum != 0 && currentCombination.length == k) return;
    if (index == numbers.length) return;

    for (let i = index; i < numbers.length; i++) {
      const reminder = targetSum - numbers[i];
      const founded = findCombinations(reminder, numbers, combinations, i + 1, [
        ...currentCombination,
        numbers[i],
      ]);
      if (founded) {
        combinations.push(founded);
      }
    }

    return;
  }

  findCombinations(n, numbers, combinations, 0, []);

  return combinations;
};

console.log(combinationSum(3, 9));
console.log(combinationSum(4, 1));
console.log(combinationSum(9, 45));
console.log(combinationSum(3, 15));
