/**
 * Escribe una funcion que devuelva todas las combinaciones de 4
 * numeros dentro de un array dado que sumen una cantidad N.
 *
 * Ejemplo:
 * N = 16
 * A = [7,6,1,-1,2,4]
 *
 * [7,6,1,2]
 * [7,6,-1,4]
 */

const subSetSum = (targetSum, numbers, combinations, currentCombination = []) => {
  if (targetSum == 0 && currentCombination.length == 4) {
    return currentCombination;
  }
  if (targetSum != 0 && currentCombination.length == 4) return;

  for (const n of numbers) {
    const reminder = targetSum - n;
    const numbersLeft = numbers.filter((a) => a != n);
    const founded = subSetSum(reminder, numbersLeft, combinations, [...currentCombination, n]);
    if (founded) {
      combinations.push(founded);
    }
  }

  return;
};

const uniqueSubsetSum = (targetSum, numbers, combinations, index, currentCombination = []) => {
  if (targetSum == 0 && currentCombination.length == 4) {
    return currentCombination;
  }
  if (targetSum != 0 && currentCombination.length == 4) return;
  if (index == numbers.length) return;

  for (let i = index; i < numbers.length; i++) {
    const reminder = targetSum - numbers[i];
    const founded = uniqueSubsetSum(reminder, numbers, combinations, i + 1, [
      ...currentCombination,
      numbers[i],
    ]);
    if (founded) {
      combinations.push(founded);
    }
  }

  return;
};

const findSubset = (targetSum, numbers) => {
  const combinations = [];
  uniqueSubsetSum(
    targetSum,
    numbers.sort((a, b) => b - a),
    combinations,
    0
  );
  return combinations;
};

const globalCombinatinos = [];
/* subSetSum(16, [7, 6, 1, -1, 2, 4].sort(), globalCombinatinos);
console.log(globalCombinatinos);
 */

/* uniqueSubsetSum(
  16,
  [7, 6, 1, -1, 2, 4].sort((a, b) => b - a),
  globalCombinatinos,
  0
); */

console.log(findSubset(10, [1, 2, 3, 4, 5, 6, 7]));

console.log(findSubset(0, [5, -5, -2, 2, 3, -3]));
console.log(findSubset(4, [-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9]));
