/**
 * Escribe una funcion que reciba un numero N y una arreglo de numeros
 * y verifique si se puede o no sumar dicho numero N usando los numeros del arreglo.
 *
 * - Se pueden usar los numeros del arreglo cuantas veces queramos.
 * - Todos los numeros del  arreglo son positivos.
 *
 * Ejemplo:
 *
 * N = 7
 * M = [5, 3, 4, 7]
 * canSum(7, [5, 3, 4, 7]) => true
 *
 * 3 + 4 = 7
 * 7 = 7
 */

const canSum = (target, numbers, memo = {}) => {
  if (target in memo) return memo[target];
  if (target == 0) return true;
  if (target < 0) return false;

  for (let n of numbers) {
    memo[target] = canSum(target - n, numbers, memo);
    if (memo[target]) {
      return true;
    }
  }

  return false;
};

const canSumTab = (target, numbers) => {
  const table = Array(target + 1).fill(false);
  table[0] = true; //siempre es posible hacer una suma 0, no se toma ningun elemento del array

  for (let i = 0; i <= target; i++) {
    for (let j = 0; j < numbers.length; j++) {
      if (i + numbers[j] < table.length && table[i]) table[i + numbers[j]] = table[i];
    }
  }

  return table[target];
};

console.log('Recursivo: ');
console.log(canSum(7, [5, 3, 4, 7]));
console.log(canSum(7, [5, 3, 25, 43]));
console.log(canSum(100, [1, 1, 1, 1, 1, 1, 1]));
console.log(canSum(300, [7, 14]));

console.log('ITerativo');
console.log(canSumTab(7, [5, 3, 4, 7])); //false
console.log(canSumTab(7, [5, 3, 25, 43])); //false
console.log(canSumTab(100, [1, 1, 1, 1, 1, 1, 1])); //true
console.log(canSumTab(300, [7, 14])); //

/**
 * Sin memoización
 * time complexity: O(M^N)
 * space complexity: O(N)
 *
 * Con memoization
 * time complexity: O(M*N)
 * space complexity: O(N)
 */
