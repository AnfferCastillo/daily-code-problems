/**
 * Escribir un algoritmo que reciba una lista de adjacencia y cuente los componentes conectados.
 */

const traverseNodes = (graph, source, visited) => {
  if (visited.has(source)) return 0;
  visited.add(source);

  for (let neighbor of graph[source]) {
    if (!visited.has(neighbor)) {
      traverseNodes(graph, neighbor, visited);
    }
  }
  return 1;
};

const countingConnectedComponents = (graph) => {
  let count = 0;

  const visited = new Set();
  for (let node in graph) {
    count += traverseNodes(graph, node, visited);
  }

  return count;
};

const graph = {
  a: ['b'],
  b: ['a'],
  c: [],
  d: ['f'],
  e: ['f'],
  f: ['e', 'd', 'g', 'h'],
  g: ['f'],
  h: ['f'],
};

console.log(countingConnectedComponents(graph));
