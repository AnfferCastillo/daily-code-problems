/**
 * Un pedazo de tierra esta compuesto por unos (1) adyacente arriba, abajo, derecha e izquierda. 
 * Decimos que una isla es un pedazo de tierra sin conexion a los bordes.
 * Escribir un algoritmo que elimine las islas de una matriz. Ejemplo:
 * 
   [[0, 0, 0, 1, 0],
   [0, 0, 1, 1, 0],
   [0, 0, 1, 1, 1],
   [0, 1, 0, 0, 1],
   [1, 0, 0, 1, 1],
   [1, 0, 0, 1, 0]]
 *  Deberiamos eliminar el item en la posicion 3-1 porque es un item sin conexion a los bordes.
 */

const edges = [];
const visited = new Set();

const goAroundEdges = (grid) => {
  const columns = grid[0].length - 1;
  const rows = grid.length - 1;
  let row = 0;
  let col = 0;
  let next = "";
  let direction = "right";

  while (next != `0-0`) {
    if (grid[row][col] == 1) {
      explore(grid, row, col, visited);
    }
    if (direction === "right") {
      if (col < columns) col++;
      else direction = "down";
    } else if (direction == "down") {
      if (row < rows) row++;
      else direction = "left";
    } else if (direction == "left") {
      if (col > 0) col--;
      else direction = "up";
    } else if (direction == "up") {
      if (row > 0) row--;
      else direction = "right";
    }
    next = row + "-" + col;
  }

  for (let k = 0; k < grid.length; k++) {
    for (let l = 0; l < grid[k].length; l++) {
      if (!visited.has(`${k}-${l}`) && grid[k][l] != 0) {
        edges.push(`${k}-${l}`);
      }
    }
  }
};

const explore = (grid, row, col, visited) => {
  const rowInbound = 0 <= row && row < grid.length;
  const colInbound = 0 <= col && col < grid[0].length;

  if (!rowInbound || !colInbound) return false;

  if (grid[row][col] == 0) return false;

  if (visited.has(`${row}-${col}`)) return false;
  visited.add(`${row}-${col}`);

  explore(grid, row, col + 1, visited);
  explore(grid, row - 1, col, visited);
  explore(grid, row + 1, col, visited);
  explore(grid, row, col - 1, visited);
};

/* const m = [
  [0, 0, 0, 0, 0, 0],
  [1, 0, 0, 1, 1, 0],
  [1, 1, 0, 0, 0, 0],
  [0, 1, 0, 0, 1, 1],
  [0, 1, 1, 1, 1, 0],
  [1, 1, 1, 0, 1, 0],
];
 */
/* const m = [
  [1, 1, 1, 0, 1, 0],
  [0, 0, 1, 1, 0, 1],
  [1, 0, 0, 0, 0, 0],
  [0, 0, 0, 1, 1, 0],
  [0, 1, 1, 1, 0, 1],
  [1, 0, 0, 1, 0, 0],
]; */

const m = [
  [0, 0, 0, 1, 0],
  [0, 0, 1, 1, 0],
  [0, 0, 1, 1, 1],
  [0, 1, 0, 0, 1],
  [1, 0, 0, 1, 1],
  [1, 0, 0, 1, 0],
];

goAroundEdges(m);
console.log(edges);
