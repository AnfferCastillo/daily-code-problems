/**
 * Escribir una funcion que reciba una matriz y cuente la cantidad de islas que tiene.
 * Los elementos dentro de la matriz tienen como valor 'L' (lando) o 'W' (water),
 * las 'L' conitugas representan una isla. Ejemplo
 *
 * [[L , L , W, W, W]
 *  [W , W , W, L, W]
 *  [W , W , L, L, L]
 *  [W , W , W, W, W]]
 *
 *  los conjuntos de elements [(0,0), (0,1)] y [(1,3),(2,2),(2,3),(2,4)] son considerados islas.
 *  En este caso tenemos dos islas.
 *
 */

const explore = (matrix, visited, row, col) => {
  if (row < 0 || row >= matrix.length) return;
  if (col < 0 || col >= matrix[row].length) return;
  if (visited.has(`${row}-${col}`)) return;

  visited.add(`${row}-${col}`);

  if (matrix[row][col] !== 'L') return;

  explore(matrix, visited, row + 1, col); //abajo
  explore(matrix, visited, row, col + 1); //derecha
  explore(matrix, visited, row - 1, col); //arriba
  explore(matrix, visited, row, col - 1); // izquierda
};

const countIslands = (matrix) => {
  const visited = new Set();
  let count = 0;
  for (let row = 0; row < matrix.length; row++) {
    for (let col = 0; col < matrix[row].length; col++) {
      const key = `${row}-${col}`;
      if (visited.has(key)) {
        continue;
      }

      if (matrix[row][col] === 'L') {
        count += 1;
        explore(matrix, visited, row, col);
      } else {
        visited.add(key);
      }
    }
  }

  return count;
};

/* const matrix = [
  ['L', 'L', 'W', 'W', 'W'],
  ['W', 'W', 'W', 'L', 'W'],
  ['W', 'W', 'L', 'L', 'L'],
  ['W', 'W', 'W', 'W', 'W'],
];
 */

const matrix = [
  ['W', 'L', 'L', 'W', 'L', 'W'],
  ['W', 'W', 'L', 'L', 'L', 'L'],
  ['W', 'L', 'W', 'L', 'W', 'L'],
  ['L', 'W', 'W', 'W', 'L', 'W'],
  ['W', 'L', 'W', 'W', 'L', 'W'],
  ['W', 'L', 'W', 'W', 'L', 'L'],
];

console.log(countIslands(matrix));
