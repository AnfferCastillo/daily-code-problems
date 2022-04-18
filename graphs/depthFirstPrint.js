/**
 * Depth First Traversal
 */

const graph = {
  a: ['b', 'c'],
  b: ['d'],
  c: ['e'],
  d: ['f'],
  e: [],
  f: [],
};

const depthFirstPrint = (graph, current) => {
  const stack = [];
  stack.push(current);

  while (stack.length > 0) {
    const c = stack.pop();
    console.log(c);
    for (let neighbor of graph[c]) {
      stack.push(neighbor);
    }
  }
};

const depthFirstPrintRecursive = (graph, source) => {
  console.log(source);
  for (let neighbor of graph[source]) {
    depthFirstPrintRecursive(graph, neighbor);
  }
};

//depthFirstPrint(graph, 'a');
depthFirstPrintRecursive(graph, 'a');
