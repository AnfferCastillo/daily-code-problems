/**
 * escribe una función que reciba un numero N como argumento y devuelva
 * el N-esimo numero de la secuencia de fibonacci.
 *
 * si N = 5 entonces result = 5
 */

const fibonacci = (n, memo = {}) => {
  if (n in memo) return memo[n];
  if (n <= 2) return 1;
  memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
  return memo[n];
};

console.log(fibonacci(6)); //8
console.log(fibonacci(7)); //13
console.log(fibonacci(8)); //21
console.log(fibonacci(50)); //21
