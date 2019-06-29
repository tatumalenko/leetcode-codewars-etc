function possibleToDeleteChars(S, T) {
    let indices = [];
    const dupMap = new Map();

    for (let i = 0; i < T.length; i++) {
        const idxs = indicesOf(S, T[i]);

        let idx;

        if (idxs.length === 1) idx = idxs[0];
        else {
            if (dupMap.has(T[i])) {
                idx = idxs[dupMap.get(T[i])];
                dupMap.set(T[i], dupMap.get(T[i]) + 1);

                if (!idx) return 0;
            } else {
                idx = idxs[0];
                dupMap.set(T[i], 1);
            }
        }

        indices.push(idx);
    }

    // let stringFromIndices = indices.map(i => S[i]).join('');
    // if (T !== stringFromIndices) return 0;

    // Check that indices length is same as T
    if (indices.length !== T.length) return false;

    // Check that indices are ordered (chars preserve order)
    if (!sorted(indices)) return 0;

    // Deal with repeated letters

    return 1;
}

function sorted(entries) {
    for (let i = 1; i < entries.length; i++) {
        if (entries[i - 1] > entries[i]) return false;
    }

    return true;
}

function indicesOf(str, char) {
    let indices = [];

    for (let i = 0; i < str.length; i++) {
        if (str[i] === char) indices.push(i);
    }

    return indices;
}

console.log(possibleToDeleteChars('abcd', 'abd')); // 1
console.log(possibleToDeleteChars('ab', 'ba')); // 0
console.log(possibleToDeleteChars('aabcd', 'abd')); // 1
console.log(possibleToDeleteChars('aabcd', 'aabd')); // 1
console.log(possibleToDeleteChars('aabcbd', 'abbd')); // 1
console.log(possibleToDeleteChars('aabcbd', 'aaabbd')); // 0
console.log(possibleToDeleteChars('aeeabcbd', 'aabbd')); // 1
