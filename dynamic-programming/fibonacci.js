/**
 * Dado un numero calcular la secuencia de fibonacci hasta dicho numero. Ejemplo
 * N = 7
 * fibonacci = 1,1,2,3,5,8,13
 */

const fibonacci = (n, current, prev, sum, fibonacciSeq) => {
  if (fibonacciSeq.length == n) return;

  sum = current + prev;
  prev = current;
  current = sum;
  fibonacciSeq.push(sum);
  fibonacci(n, current, prev, sum, fibonacciSeq);
};

const stuff = (n) => {
  let fibonacciSeq = [];
  if (n == 1) {
    fibonacciSeq = [1];
    return;
  }
  fibonacciSeq = [1, 1];
  fibonacci(n, 1, 1, 0, fibonacciSeq);
  return fibonacciSeq;
};

console.log(stuff(process.argv[2]));
