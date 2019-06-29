const assert = require('assert');

/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
function findWords(board, words) {
  const founds = [];
  const visited = board.map(row => row.map(e => false));
  // // eslint-disable-next-line prefer-const
  const trieNode = buildTrie(words);
  const firstLetterIdxs = words
    .map(word => findLetterIdxs(board, word[0]))
    .reduce((acc, idxPairs) => {
      idxPairs.forEach((idxPair) => {
        idxPairArrayIncludes(acc, idxPair)
          ? acc
          : acc.concat(idxPair);
      });
      return acc;
    });

  firstLetterIdxs.forEach((firstLetterIdx) => {
    // const trieNode = buildTrie(words.filter(word => !founds.includes(word)));
    search(board, words, trieNode, visited, firstLetterIdx, founds);
  });

  return founds;
}

function idxPairArrayIncludes(idxPairArray, idxPair) {
  let found = false;
  idxPairArray.forEach((ip) => {
    if (ip.i === idxPair.i && ip.j === idxPair.j) { found = true; }
  });
  return found;
}

function search(board, words, trieNode, visited, currentIdx, founds) {
  visited[currentIdx.i][currentIdx.j] = true;
  const currentChar = board[currentIdx.i][currentIdx.j];

  if (trieNode.isWord) {
    founds.push(trieNode.word);
    trieNode.isWord = false;
    trieNode.word = null;
    // if (!founds.includes(trieNode.word)) { founds.push(trieNode.word); }
    // return true;
    // removeWordFromTrie(trieNode, trieNode.word);
    // trieNode = buildTrie(words.filter(word => word !== trieNode.word));
  }

  if (Object.keys(trieNode.children).length === 0
      || !trieNode.children[currentChar]) {
    return false;
  }

  trieNode = trieNode.children[currentChar];

  const neighbours = findNeighbourIdxs(board, currentIdx);

  if (neighbours.left !== null
      && !visited[neighbours.left.i][neighbours.left.j]) {
    search(board, words, trieNode, visited, neighbours.left, founds);
    // if (search(board, words, trieNode, visited, neighbours.left, founds)) { return true; }
    visited[neighbours.left.i][neighbours.left.j] = false;
  }
  if (neighbours.up !== null
      && !visited[neighbours.up.i][neighbours.up.j]) {
    search(board, words, trieNode, visited, neighbours.up, founds);
    // if (search(board, words, trieNode, visited, neighbours.up, founds)) { return true; }
    visited[neighbours.up.i][neighbours.up.j] = false;
  }
  if (neighbours.right !== null
      && !visited[neighbours.right.i][neighbours.right.j]) {
    search(board, words, trieNode, visited, neighbours.right, founds);
    // if (search(board, words, trieNode, visited, neighbours.right, founds)) { return true; }
    visited[neighbours.right.i][neighbours.right.j] = false;
  }
  if (neighbours.down !== null
      && !visited[neighbours.down.i][neighbours.down.j]) {
    search(board, words, trieNode, visited, neighbours.down, founds);
    // if (search(board, words, trieNode, visited, neighbours.down, founds)) { return true; }
    visited[neighbours.down.i][neighbours.down.j] = false;
  }

  // return false;
}

function buildTrie(words) {
  // eslint-disable-next-line prefer-const
  let root = {
    children: {},
    isWord: false,
    word: null,
  };
  let node;
  words.forEach((word) => {
    node = root;
    word.split('').forEach((char) => {
      if (!node.children[char]) {
        node.children[char] = {
          children: {},
          isWord: false,
          word: null,
        };
      }
      node = node.children[char];
    });
    node.isWord = true;
    node.word = word;
  });
  return root;
}

function removeWordFromTrie(wordTrieNode) {
  const stack = [];
  let node = wordTrieNode;
  // for (let i = 0; i < word.length; i += 1) {
  //   if (node.children[word.charAt(i)]) {
  //     stack.push(node);
  //     node = node.children[word.charAt(i)];
  //   } else {
  //     throw new Error('no such word found!');
  //   }
  // }

  node.isWord = false;
  node.word = null;

  // Remove the first node (the leaf) unless it is a partial
  if (Object.keys(node.children).length === 0) {
    for (let i = stack.length - 1; i >= 0; i -= 1) {
      node = stack[i];
      // If the only children was the previous letter we 'removed'
      if (Object.keys(node.children) === 1) {
        // Remove the associated child so not to look down further
        node.children = {};
      }
    }
  }
}

function findLetterIdxs(board, letter) {
  const idxs = [];
  for (let i = 0; i < board.length; i += 1) {
    for (let j = 0; j < board[0].length; j += 1) {
      if (board[i][j] === letter) {
        idxs.push({
          i,
          j,
        });
      }
    }
  }
  return idxs;
}

function findNeighbourIdxs(board, current) {
  const idxs = {
    left: {},
    up: {},
    right: {},
    down: {},
  };
  const { i, j } = current;
  if (j > 0) { // left
    idxs.left = { i, j: j - 1 };
  } else {
    idxs.left = null;
  }
  if (i > 0) { // up
    idxs.up = { i: i - 1, j };
  } else {
    idxs.up = null;
  }
  if (j < board[0].length - 1) { // right
    idxs.right = { i, j: j + 1 };
  } else {
    idxs.right = null;
  }
  if (i < board.length - 1) { // down
    idxs.down = { i: i + 1, j };
  } else {
    idxs.down = null;
  }
  return idxs;
}

// const words = ['oath', 'pea', 'eat', 'rain'];
const words = ['oath', 'oaths', 'own', 'oater'];
const trie = buildTrie(words);
// assert.deepEqual(
//   findWords([
//     ['A', 'B', 'C', 'E'],
//     ['S', 'F', 'C', 'S'],
//     ['A', 'D', 'E', 'E']],
//   ['ABCCED', 'ABCE']),
//   ['ABCE', 'ABCCED'],
// );

assert.deepEqual(
  findWords(
    [['o', 'a', 'a', 'n'], ['e', 't', 'a', 'e'], ['i', 'h', 'k', 'r'], ['i', 'f', 'l', 'v']],
    ['oath', 'pea', 'eat', 'rain'],
  ),

  ['eat', 'oath'],
);
