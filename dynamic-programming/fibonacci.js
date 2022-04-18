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

//console.log(stuff(process.argv[2]));

const fiboTab = (n) => {
  if (n == 0) return 0;
  if (n == 1) return 1;

  const arr = Array(n + 1).fill(0);

  arr[1] = 1;
  let j = 0;

  while (j <= n) {
    if (j == n - 1) {
      arr[j + 1] = arr[j] + arr[j + 1];
    } else {
      arr[j + 1] = arr[j] + arr[j + 1];
      arr[j + 2] = arr[j] + arr[j + 2];
    }
    j++;
  }
  return arr[n];
};

const fiboTab2 = (n) => {
  if (n == 0) return [];
  if (n == 1) return [1];

  const fib = [1, 1];

  for (let i = fib.length; i < n; i++) {
    fib.push(fib[i - 1] + fib[i - 2]);
  }

  return fib;
};
/* 
console.log(fiboTab(6)); //8
console.log(fiboTab(2)); //1
console.log(fiboTab(15)); //1
console.log(fiboTab(0)); //1
console.log(fiboTab(1)); //1 */

console.log(fiboTab2(3));
console.log(fiboTab2(5));
console.log(fiboTab2(20));
