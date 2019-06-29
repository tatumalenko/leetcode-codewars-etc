module.exports = function uniqueInOrder(iterable) {
  out = iterable[0] ? [iterable[0]] : [];

  for (i = 1; i < iterable.length; i++) {
    if (out[out.length - 1] !== iterable[i]) {
      out.push(iterable[i]);
    }
  }

  return out;
};
