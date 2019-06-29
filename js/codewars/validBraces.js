module.exports = function validBraces(braces) {
  const map = new Map();
  map.set('{', '}');
  map.set('(', ')');
  map.set('[', ']');

  const stack = [];

  for (brace of braces) {
    if (map.has(brace)) {
      stack.push(brace);
    } else if (Array.from(map.values()).includes(brace)) {
      if (brace !== map.get(stack.pop())) return false;
    }
  }

  return stack.length == 0;
};
