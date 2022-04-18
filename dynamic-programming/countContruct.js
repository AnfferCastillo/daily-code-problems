/**
 * EScribe una funcion que tome por parametros un string "target" y un array
 * de strings y devuelva la cantidad total de formas en las que se puede
 * construir el string "target" usando los elementos del arreglo.
 *
 * Ejemplo:
 *
 * target: 'purple'
 * array: [purp, p, ur, le, purpl]
 * resultado: 2
 *
 * purp + le = purple
 * p + ur + p + le = purple
 */

const countContructTab = (target, wordBank) => {
  const table = Array(target.length + 1).fill(0);

  table[0] = 1;

  for (let i = 0; i <= target.length; i++) {
    if (table[i]) {
      for (const word of wordBank) {
        if (target.slice(i, i + word.length) === word) {
          table[i + word.length] += table[i];
        }
      }
    }
  }

  return table[target.length];
};

console.log(countContructTab('purple', ['purp', 'p', 'ur', 'le', 'purpl'])); //2
