/**
 * Escribe una función que tome un array y un target sum y devuelva si
 * es posible sumar el target sum con al menos una combinación del array. Devolver la combinación.
 *
 * ejemplo:
 * targetSum = 7;
 * Array = [1,2,3,4]
 * Resultado = [3,4]
 */

const howSum = (targetSum, numbers) => {
  if (targetSum == 0) return [];
  if (targetSum < 0) return null;

  for (const n of numbers) {
    const reminder = targetSum - n;
    const combination = howSum(reminder, numbers);
    if (combination) {
      return [...combination, n];
    }
  }

  return null;
};

const howSumTab = (targetSum, numbers) => {
  const table = Array(targetSum + 1);

  table[0] = [];

  for (let i = 0; i <= targetSum; i++) {
    if (table[i]) {
      for (let j = 0; j < numbers.length; j++) {
        if (i + numbers[j] <= targetSum) {
          table[i + numbers[j]] = [...table[i], numbers[j]];
        }
      }
    }
  }

  return table[targetSum];
};

console.log(howSum(7, [2, 3, 4]));
console.log(howSumTab(7, [2, 3, 4]));
console.log(howSumTab(7, [2, 4]));
