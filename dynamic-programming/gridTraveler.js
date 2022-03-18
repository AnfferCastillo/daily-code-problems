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
