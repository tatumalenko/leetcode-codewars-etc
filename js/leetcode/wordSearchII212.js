/* eslint-disable prefer-const */
/* eslint-disable no-restricted-syntax */
/* eslint-disable no-undef */
/* eslint-disable no-unused-expressions */
/* eslint-disable no-param-reassign */
const assert = require('assert');

/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
function findWords(board, words) {
  if (words.length === 0) { return words; }
  const founds = [];
  const trieNode = buildTrie(words);
  for (let i = 0; i < board.length; i += 1) {
    for (let j = 0; j < board[0].length; j += 1) {
      if (trieNode.children[board[i][j]]) {
        search(board, trieNode, i, j, founds);
      }
      if (founds.length === words.length) { break; }
    }
  }
  return founds;
}

function search(board, trieNode, i, j, founds) {
  if (i < 0
    || i > board.length - 1
    || j < 0
    || j > board[0].length - 1
    || board[i][j] === '#'
    || !trieNode.children[board[i][j]]) {
    return false;
  }
  const currentChar = board[i][j];
  trieNode = trieNode.children[currentChar];
  if (trieNode.isWord) {
    founds.push(trieNode.word);
    trieNode.isWord = false;
    trieNode.word = null;
    if (Object.keys(trieNode.children).length === 0) { return true; }
  }
  board[i][j] = '#';
  search(board, trieNode, i, j - 1, founds);
  search(board, trieNode, i + 1, j, founds);
  search(board, trieNode, i, j + 1, founds);
  search(board, trieNode, i - 1, j, founds);
  board[i][j] = currentChar;
  return false;
}

function buildTrie(words) {
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

// assert.deepEqual(
//   findWords([
//     ['A', 'B', 'C', 'E'],
//     ['S', 'F', 'C', 'S'],
//     ['A', 'D', 'E', 'E']],
//   ['ABCCED', 'ABCE']),
//   ['ABCCED', 'ABCE'],
// );

assert.deepEqual(
  findWords(
    [['o', 'a', 'a', 'n'], ['e', 't', 'a', 'e'], ['i', 'h', 'k', 'r'], ['i', 'f', 'l', 'v']],
    ['oath', 'pea', 'eat', 'rain'],
  ),
  ['oath', 'eat'],
);

assert.deepEqual(
  findWords(
    [['a', 'b'], ['c', 'd']],
    ['ab', 'cb', 'ad', 'bd', 'ac', 'ca', 'da', 'bc', 'db', 'adcb', 'dabc', 'abb', 'acb'],
  ),
  ['ac', 'ab', 'bd', 'ca', 'db'],
);

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
