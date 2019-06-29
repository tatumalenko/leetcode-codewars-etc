function solution(S, K) {
    const chars = S.split('').filter(e => e !== '-');
    const output = [];

    let ctr = 0; // Need to keep track of how many consecutive chars we used
    for (let i = chars.length - 1; i >= 0; i--) {
        // Since we don't know yet how many dangling first few chars we'll need,
        // doing it in reverse allows us to focus on the other parts.
        if (ctr != K) {
            // Time to add a dash
            output.push(chars[i].toUpperCase());
            ctr += 1;
        } else {
            output.push('-');
            ctr = 1; // About to push the current char so not zero here
            output.push(chars[i].toUpperCase());
        }
    }

    return output.reverse().join('');
}

console.log(solution('--2-4A0r7-4k--', 3));

A.reduce();
