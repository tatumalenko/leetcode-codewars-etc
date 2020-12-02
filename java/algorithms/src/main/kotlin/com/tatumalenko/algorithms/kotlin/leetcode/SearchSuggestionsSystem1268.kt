package com.tatumalenko.algorithms.kotlin.leetcode

object SearchSuggestionsSystem1268 {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        val root = TrieNode()
        products.sort()
        for (word in products) {
            root.add(word)
        }
        val results = mutableListOf<List<String>>()
        var partial = ""
        for (char in searchWord) {
            partial += char
            results.add(root[partial])
        }

        return results
    }

    data class TrieNode(
        var char: Char? = null,
        var isTerminal: Boolean = false,
        val children: MutableMap<Char, TrieNode> = mutableMapOf(),
        val words: MutableList<String> = mutableListOf()
    ) {
        operator fun get(char: Char?): TrieNode? {
            if (char == null) return null
            return children[char]
        }

        fun add(word: String) {
            var current = this
            if (current.words.size < 3) {
                current.words.add(word)
            }

            for ((i, c) in word.toCharArray().withIndex()) {
                current = current[c] ?: TrieNode(c).let {
                    current.children[c] = it
                    it
                }
                if (i == word.lastIndex) {
                    current.isTerminal = true
                }
                if (current.words.size < 3) {
                    current.words.add(word)
                }
            }
        }

        operator fun get(word: String?): List<String> {
            if (word == null) return emptyList()
            var current: TrieNode? = this
            for (c in word) {
                val temp = current?.get(c)
                if (current == null) {
                    break
                } else {
                    current = temp
                }
            }
            return current?.words ?: emptyList()
        }
    }
}
