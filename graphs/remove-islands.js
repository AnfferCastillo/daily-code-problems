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

const removeIslands = (land) => {
  const directions = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];
  let direction = 0;
  const iterations = land.length * 2 + (land[0].length - 2) * 2;

  const noIslandsGrid = Array(land.length)
    .fill()
    .map(() => Array(land[0].length).fill(0));

  let row = 0;
  let col = 0;

  for (let i = 0; i <= iterations; i++) {
    if (land[row][col] == 1) {
      explore(land, row, col, noIslandsGrid);
    }

    let step = directions[direction];

    // check if we need a direction change
    let rowInBound = row + step[0] < land.length && row + step[0] >= 0;
    let colInBound = col + step[1] < land[0].length && col + step[1] >= 0;

    if (!rowInBound || !colInBound) {
      //get the right direction
      direction = (direction + 1) % 4;
      step = directions[direction];
    }

    row += step[0];
    col += step[1];
  }

  return noIslandsGrid;
};

const explore = (grid, row, col, noIslandsGrid) => {
  const rowInbound = 0 <= row && row < grid.length;
  const colInbound = 0 <= col && col < grid[0].length;

  if (!rowInbound || !colInbound) return;

  if (grid[row][col] == 0) return;

  if (noIslandsGrid[row][col] == 1) return;

  noIslandsGrid[row][col] = 1;

  explore(grid, row, col + 1, noIslandsGrid); //right
  explore(grid, row + 1, col, noIslandsGrid); //down
  explore(grid, row, col - 1, noIslandsGrid); //left
  explore(grid, row - 1, col, noIslandsGrid); //up
};

const m = [
  [0, 0, 0, 0, 0, 0],
  [1, 0, 0, 1, 1, 0],
  [1, 1, 0, 0, 0, 0],
  [0, 1, 0, 0, 1, 1],
  [0, 1, 1, 1, 1, 0],
  [1, 1, 1, 0, 1, 0],
];

/* const m = [
  [1, 1, 1, 0, 1, 0],
  [0, 0, 1, 1, 0, 1],
  [1, 0, 0, 0, 0, 0],
  [0, 0, 0, 1, 1, 0],
  [0, 1, 1, 1, 0, 1],
  [1, 0, 0, 1, 0, 0],
]; */


// const m = [
//   [0, 0, 0, 1, 0],
//   [0, 0, 1, 1, 0],
//   [0, 0, 1, 1, 1],
//   [0, 1, 0, 0, 1],
//   [1, 0, 0, 1, 1],
//   [1, 0, 0, 1, 0],
// ];

const result = removeIslands(m);

result.forEach((arr) => console.log(`[${arr.join(',')}],`));
