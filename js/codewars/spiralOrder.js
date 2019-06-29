/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
function spiralOrder(matrix) {
    const spiralOrder = [];
    const rows = matrix.length;
    const cols = matrix[0].length;

    const rowIndices = getSpiralOrderRowIndices(rows);
    const colIndices = getSpiralOrderColumnIndices(cols);

    for (let i = 0, j = 0; i < rows && j < cols; i++, j++) {
        if (i % 2 === 0) {
            spiralOrder.push(getRow(matrix, rowIndices[i]).slice(i, rows - j));
            spiralOrder.push(
                getColumn(matrix, colIndices[i]).slice(j + 1, cols - i)
            );
        } else {
            spiralOrder.push(
                getRow(matrix, rowIndices[i])
                    .reverse()
                    .slice(i, rows - j)
            );
            spiralOrder.push(
                getColumn(matrix, colIndices[i])
                    .reverse()
                    .slice(j + 1, cols - i)
            );
        }
    }

    return spiralOrder;
}

function getSpiralOrderRowIndices(length) {
    let spiralIndices = [];
    for (let i = 0, j = length - 1; i <= j; i++, j--) {
        if (i === j) spiralIndices.push(i);
        else spiralIndices.push(i, j);
    }
    return spiralIndices;
}

function getSpiralOrderColumnIndices(length) {
    let spiralIndices = [];
    for (let i = 0, j = length - 1; i <= j; i++, j--) {
        if (i === j) spiralIndices.push(i);
        else spiralIndices.push(j, i);
    }
    return spiralIndices;
}

function getRow(matrix, k) {
    return matrix[k];
}

function getColumn(matrix, k) {
    const column = [];
    for (let i = 0; i < matrix[0].length; i++) {
        column.push(matrix[i][k]);
    }
    return column;
}

let matrix1 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]];

console.log(getRow(matrix1, 1));
console.log(getColumn(matrix1, 1));
// console.log(getSpiralOrderIndices(3));
console.log(spiralOrder(matrix1));
