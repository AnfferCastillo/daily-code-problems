/**
 * Dada una lista de adyacencia buscar si existe un camino entre dos nodos dados.
 */

const graph = {
  f: ['g', 'i'],
  g: ['h'],
  h: [],
  i: ['k', 'g'],
  j: ['i'],
  k: [],
};

const hasPath = (graph, source, dest) => {
  const stack = [source];

  while (stack.length > 0) {
    const current = stack.pop();
    if (current === dest) return true;
    for (const neighbor of graph[current]) {
      stack.push(neighbor);
    }
  }

  return false;
};

const hasPathBF = (graph, source, dest) => {
  const queue = [source];

  while (queue.length > 0) {
    const current = queue.shift();
    if (current === dest) return true;
    for (const neighbor of graph[current]) {
      queue.push(neighbor);
    }
  }

  return false;
};

console.log(hasPath(graph, 'j', 'f')); //false
console.log(hasPath(graph, 'f', 'k')); //true
console.log(hasPathBF(graph, 'j', 'f')); //false
console.log(hasPathBF(graph, 'f', 'k')); //true
