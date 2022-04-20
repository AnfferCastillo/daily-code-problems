/**
 * Escribe una funcion que devuelva el tamaño del componente mas largo de un grafico.
 *
 * un componente es un grupo de nodos que se conectan entre si.
 */

const traverse = (graph, source, visited) => {
  if (visited.has(source)) return 0;
  visited.add(Number(source));

  let size = 1;
  for (let neighbor of graph[source]) {
    if (!visited.has(neighbor)) {
      size += traverse(graph, neighbor, visited);
    }
  }
  return size;
};

const sizeComponent = (graph) => {
  let maxSize = 0;
  const visited = new Set();
  for (const node in graph) {
    const size = traverse(graph, node, visited);
    if (size > maxSize) {
      maxSize = size;
    }
  }

  return maxSize;
};

const graph = {
  0: [1, 5, 8],
  1: [0],
  2: [3, 4],
  3: [2, 4],
  4: [3, 2],
  5: [0, 8],
  8: [5, 0],
};

console.log(sizeComponent(graph));
