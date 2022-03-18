/**
 * Escribe una función que determine si es posible construir un string a partir de un arreglo de strings.
 *
 * Ejemplo:
 * phrase: 'probando'
 * A = [ 'p', 'ban', 'r', 'o' , 'orirra', 'do']
 * result: true .> p + r + o + ban + do
 */

const canConstruct = (phrase, words, memo = {}) => {
  if (phrase in memo) return memo[phrase];
  if (phrase == '') return true;

  for (let word of words) {
    if (phrase.startsWith(word)) {
      const newPhrase = phrase.substring(word.length);

      if (canConstruct(newPhrase, words, memo)) {
        memo[phrase] = true;
        return true;
      }
    }
  }
  memo[phrase] = false;
  return false;
};

console.log(canConstruct('probando', ['p', 'ban', 'r', 'o', 'orirra', 'do']));
console.log(canConstruct('skateboard', ['bo', 'rd', 'ate', 't', 'ska', 'sk', 'boar']));
console.log(
  canConstruct('eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef', [
    'e',
    'ee',
    'eee',
    'eeee',
    'eeeee',
    'eeeeee',
  ])
);
