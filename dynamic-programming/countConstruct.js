/**
 * Escribir una función que recibe un targetString y un arreglo de strings A.
 * La función debe retornar el numero total de formas en la que el targetString
 * puede ser construido usando los strings del arreglo A.
 *
 * se pueden usar los elementos de A cuantas veces necesitemos.
 *
 * Ejemplo:
 *
 * targetString = 'abdcef'
 * A = ['ab', 'abc', 'cd', 'def', 'abcd']
 * Resultado: 1 (abc + def)
 *
 */

const countConstruct = (phrase, words, memo = {}) => {
  if (phrase in memo) return memo[phrase];
  if (phrase == '') return 1;

  let count = 0;

  for (let word of words) {
    if (phrase.startsWith(word)) {
      const newPhrase = phrase.substring(word.length);
      count += countConstruct(newPhrase, words, memo);
    }
  }

  memo[phrase] = count;
  return memo[phrase];
};

console.log(countConstruct('probando', ['p', 'ban', 'r', 'o', 'orirra', 'do'])); //1
console.log(countConstruct('skateboard', ['bo', 'rd', 'ate', 't', 'ska', 'sk', 'boar'])); //0
console.log(countConstruct('abcdef', ['ab', 'abc', 'cd', 'def', 'abcd'])); //1
console.log(countConstruct('abcdef', ['ab', 'abc', 'cd', 'def', 'abcd', 'd', 'ef'])); //4
console.log(
  countConstruct('eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef', [
    'e',
    'ee',
    'eee',
    'eeee',
    'eeeee',
    'eeeeee',
  ])
); // 0

/**
 * m = A.length
 * n = targetString.length
 * space complexity: O(m)
 * time complexity: O(n*m^2)
 *
 */
