const validBraces = require('./validBraces');
const uniqueInOrder = require('./uniqueInOrder');
const peopleStillOnBus = require('./peopleStillOnBus');
const assert = require('assert');

// validBraces
assert.strictEqual(validBraces('{(())}'), true);
assert.strictEqual(validBraces('{(})'), false);

// uniqueInOrder
assert.deepStrictEqual(uniqueInOrder([5, 5, 5, 5, 3, 6, 6, 2, 8]), [
  5,
  3,
  6,
  2,
  8
]);
assert.deepStrictEqual(uniqueInOrder([]), []);

// peopleStillOnBus
assert.deepStrictEquals(peopleStillOnBus([[10, 0], [3, 5], [5, 8]]), 5);
assert.deepStrictEquals(
  peopleStillOnBus([[3, 0], [9, 1], [4, 10], [12, 2], [6, 1], [7, 10]]),
  17
);
assert.deepStrictEquals(
  peopleStillOnBus([[3, 0], [9, 1], [4, 8], [12, 2], [6, 1], [7, 8]]),
  21
);
