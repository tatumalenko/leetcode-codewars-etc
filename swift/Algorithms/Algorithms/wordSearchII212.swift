//
//  wordSearchII212.swift
//  Algorithms
//
//  Created by Tatum Alenko on 2019-07-01.
//  Copyright © 2019 Tatum Alenko. All rights reserved.
//

class WordSearchII212 {
    static func findWords(_ board: [[Character]], _ words: [String]) -> [String] {
        if words.count == 0 { return words }
        var board = board
        var foundWords: [String] = []
        let trieNode = TrieNode.build(from: words)
        for i in 0..<board.count {
            for j in 0..<board[0].count {
                let char = board[i][j]
                if trieNode?.children[char] != nil {
                    search(&board, trieNode, i, j, &foundWords)
                }
                if foundWords.count == words.count { break }
            }
        }
        return foundWords
    }
    
    private static func search(_ board: inout [[Character]], _ trieNode: TrieNode?, _ i: Int, _ j: Int, _ foundWords: inout [String]) {
        if i < 0 || i > board.count - 1 || j < 0 || j > board[0].count - 1 || board[i][j] == "#" || trieNode?.children[board[i][j]] == nil {
            return
        }
        let currentChar = board[i][j]
        let trieNode = trieNode?.children[currentChar] ?? nil
        if trieNode?.isWord ?? false {
            foundWords.append(trieNode!.word)
            trieNode?.isWord = false
            if trieNode?.children.keys.count == 0 { return }
        }
        board[i][j] = "#"
        search(&board, trieNode, i, j - 1, &foundWords)
        search(&board, trieNode, i + 1, j, &foundWords)
        search(&board, trieNode, i, j + 1, &foundWords)
        search(&board, trieNode, i - 1, j, &foundWords)
        board[i][j] = currentChar
        return
    }
    
    class TrieNode {
        var children: [Character: TrieNode?] = [:]
        var isWord: Bool = false
        var word: String = ""
        init() {
        }
        static func build(from words: [String]) -> TrieNode? {
            let root = TrieNode()
            var node: TrieNode?
            for word in words {
                node = root
                for char in Array(word) {
                    if node?.children[char] == nil {
                        node?.children[char] = TrieNode()
                    }
                    node = node?.children[char] ?? nil
                }
                node?.isWord = true
                node?.word = word
            }
            return root
        }
    }
}

func wordSearchII212() {
    let board: [[Character]] = [
        ["o","a","a","n"],
        ["e","t","a","e"],
        ["i","h","k","r"],
        ["i","f","l","v"]
    ]
    let words = ["oath", "pea", "eat", "rain"]
    //    findWords(&board, words)
    assert(Set(WordSearchII212.findWords(board, words)) == Set((["eat","oath"])))
}
