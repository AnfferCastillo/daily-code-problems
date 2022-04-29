/**
 * escribe una funciona que busque la isla mas pequeña dentro de una matriz.
 * Los elementos dentro de la matriz tienen como valor 'L' (lando) o 'W' (water),
 * las 'L' conitugas representan una isla. Ejemplo
 *   [[L , L , W, W, W]
 *  [W , W , W, L, W]
 *  [W , W , L, L, L]
 *  [W , W , W, W, W]]
 *
 *  los conjuntos de elements [(0,0), (0,1)] y [(1,3),(2,2),(2,3),(2,4)] son considerados islas.
 *  En este caso la mas pequeña es 2.
 *
 */

const explore = (matrix, visited, row, col) => {
  if (row < 0 || row >= matrix.length) return 0;
  if (col < 0 || col >= matrix[row].length) return 0;
  if (matrix[row][col] !== 'L') return 0;
  if (visited.has(`${row}-${col}`)) return 0;

  visited.add(`${row}-${col}`);
  let count = 1;
  count += explore(matrix, visited, row + 1, col); //abajo
  count += explore(matrix, visited, row, col + 1); //derecha
  count += explore(matrix, visited, row - 1, col - 1); //arriba
  count += explore(matrix, visited, row, col - 1); //izquierda

  return count;
};

const minimumIsland = (matrix) => {
  const visited = new Set();
  let minSize = Number.MAX_SAFE_INTEGER;

  for (let row = 0; row < matrix.length; row++) {
    for (let col = 0; col < matrix[row].length; col++) {
      let size = explore(matrix, visited, row, col);
      if (size && size < minSize) minSize = size;
    }
  }

  return minSize;
};

/* const matrix = [
  ['L', 'L', 'W', 'W', 'W'],
  ['W', 'W', 'W', 'L', 'W'],
  ['W', 'W', 'L', 'L', 'L'],
  ['W', 'W', 'W', 'W', 'W'],
]; */

const matrix = [
  ['W', 'L', 'L', 'W', 'L', 'W'],
  ['W', 'W', 'L', 'L', 'L', 'L'],
  ['W', 'L', 'W', 'L', 'W', 'L'],
  ['W', 'L', 'W', 'W', 'L', 'W'],
  ['W', 'L', 'W', 'W', 'L', 'W'],
  ['W', 'L', 'W', 'W', 'L', 'L'],
];

console.log(minimumIsland(matrix));
