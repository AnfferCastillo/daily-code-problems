/**
 * Un grafico sin direcciones es un grafico donde la conexion o edge
 * entre dos nodos es en ambas direcciones.
 */

const edges = [
  ['i', 'j'],
  ['k', 'j'],
  ['k', 'i'],
  ['m', 'k'],
  ['k', 'l'],
  ['o', 'n'],
];

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

const hasPath = (graph, source, dest, visited = []) => {
  const stack = [source];

  while (stack.length > 0) {
    const current = stack.pop();
    visited.push(current);
    if (current === dest) return true;
    for (const neighbor of graph[current]) {
      if (visited.lastIndexOf(neighbor) < 0) {
        stack.push(neighbor);
      }
    }
  }

  return false;
};

const breadthFirstTraversal = (graph, source, visited = []) => {
  const queue = [source];

  while (queue.length > 0) {
    const current = queue.shift();
    visited.push(current);
    console.log(current);
    for (let neighbor of graph[current]) {
      if (visited.indexOf(neighbor) < 0) {
        queue.push(neighbor);
      }
    }
  }
};

const graph = buildAdjencyList(edges);

console.log(hasPath(graph, 'i', 'l'));
console.log(hasPath(graph, 'i', 'n'));
//console.log(breadthFirstTraversal(graph, 'i');
