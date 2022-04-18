<<<<<<< HEAD
/**
 * Escribe una función que encuentra la cantidad de recorridos posibles en una matriz MxN
 * comenzando en la esquina superior izquierda y terminando en la esquina inferior derecha. Con
 * la condición de que solo se puede dar un paso hacia la derecha o hacia abajo a la vez
 *
 * Argumentos: M numeros de filas, N numero de Columnas
 * gridTraveler(M,N)
 *
 * ejemplo:
 * gridTraveler(2,3) -> 3
 *
 * [[1, 2, 3],
 *  [4, 5, 6]]
 *
 * rutas: 1,2,3,6
 *        1,2,5,6
 *        1,4,5,6
 */

const gridTraveler = (m, n, memo = {}) => {
  if (`${m},${n}` in memo) return memo[`${m},${n}`];

  if (n == 0 || m == 0) return 0;
  if (m == 1 && n == 1) return 1;

  memo[`${m},${n}`] = gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo);

  return memo[`${m},${n}`];
};

const gridTravelerTab = (m, n) => {
  if (n == 0 || m == 0) return 0;

  const table = Array(m + 1)
    .fill()
    .map(() => Array(n + 1).fill(0));

  // De la implementacion recursiva llegamos a esta conclusión
  table[1][1] = 1;

  for (let i = 0; i <= m; i++) {
    for (let j = 0; j <= n; j++) {
      if (i != m && j != n) {
        table[i + 1][j] += table[i][j];
        table[i][j + 1] += table[i][j];
      } else if (i == m) {
        table[i][j + 1] += table[i][j];
      } else if (j == n) {
        table[i + 1][j] += table[i][j];
      }
    }
  }

  return table[m][n];
};

//console.log(gridTraveler(2, 3));
//console.log(gridTraveler(18, 18));

console.log(gridTravelerTab(3, 2)); //3
console.log(gridTravelerTab(0, 0)); //0
console.log(gridTravelerTab(3, 3)); //6
console.log(gridTravelerTab(1, 1)); //1
console.log(gridTravelerTab(18, 18)); //2333606220
=======
/**
 * Escribe una función que encuentra la cantidad de recorridos posibles en una matriz MxN
 * comenzando en la esquina superior izquierda y terminando en la esquina inferior derecha. Con
 * la condición de que solo se puede dar un paso hacia la derecha o hacia abajo a la vez
 *
 * Argumentos: M numeros de filas, N numero de Columnas
 * gridTraveler(M,N)
 *
 * ejemplo:
 * gridTraveler(2,3) -> 3
 *
 * [[1, 2, 3],
 *  [4, 5, 6]]
 *
 * rutas: 1,2,3,6
 *        1,2,5,6
 *        1,4,5,6
 */

const gridTraveler = (m, n, memo = {}) => {
  if (`${m},${n}` in memo) return memo[`${m},${n}`];

  if (n == 0 || m == 0) return 0;
  if (m == 1 && n == 1) return 1;

  memo[`${m},${n}`] =
    gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo);

  return memo[`${m},${n}`];
};

console.log(gridTraveler(2, 3));
console.log(gridTraveler(18, 18));
>>>>>>> 29759f4c2cd5b6ac60a52dd0402a71839b8d5fcc
