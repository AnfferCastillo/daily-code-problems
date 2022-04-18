/**
 * crear un funcion que tome por parametros un string "target" y un array de
 * strings "wordBank" y retorne todas las posibles combinaciones para formar la
 * el "target" usando los elementos del "wordBank"
 *
 * ejemplo:
 * target: abcdef
 * wordBank: [abc, def, abcd, ab, cd, ef, c]
 *
 * resultado: [[abc, def], [abcd, ef], [ab,cd,ef], [ab, c, def]]
 */

const allConstruct = (target, wordBank) => {
  const table = Array(target.length + 1)
    .fill()
    .map((el) => Array());
  table[0] = [[]];

  for (let i = 0; i <= target.length; i++) {
    for (const word of wordBank) {
      if (target.slice(i, i + word.length) === word) {
        const combinations = table[i].map((combo) => [...combo, word]);
        table[i + word.length] = [...table[i + word.length], ...combinations];
      }
    }
  }

  return table[target.length];
};

console.log(allConstruct('abcdef', ['abc', 'def', 'abcd', 'ab', 'cd', 'ef', 'c']));
