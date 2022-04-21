/**
 * Escribir una función que devuelva la longitud del camino mas corto entre dos
 * nodos de un grafico.
 *
 */

const traverse = (graph, source, dest, visited) => {
  const stack = [source];
  let size = 0;
  while (stack.length > 0) {
    const current = stack.shift();
    visited.add(current);
    size += 1;
    if (current === dest) return size;
    for (const neighbor of graph[current]) {
      if (!visited.has(neighbor)) {
        stack.push(neighbor);
      }
    }
  }
  return false;
};

const buildAdjencyList = (edges) => {
  const adjencyList = {};
  for (const [a, b] of edges) {
    if (!adjencyList[a]) {
      adjencyList[a] = [];
    }

    if (!adjencyList[b]) {
      adjencyList[b] = [];
    }
    adjencyList[a].push(b);
    adjencyList[b].push(a);
  }
  return adjencyList;
};

const shortetsPath = (graph, source, dest) => {
  let minSize = Number.MAX_VALUE;
  for (const node of graph[source]) {
    const visited = new Set(source);
    const size = traverse(graph, node, dest, visited);
    if (size && size < minSize) {
      minSize = size;
    }
  }
  return minSize;
};

const edges = [
  ['w', 'x'],
  ['x', 'y'],
  ['z', 'y'],
  ['z', 'j'],
  ['w', 'v'],
  ['v', 'k'],
  ['k', 'j'],
];

const graph = buildAdjencyList(edges);
console.log(shortetsPath(graph, 'w', 'z'));
