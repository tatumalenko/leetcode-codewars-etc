module.exports = {
    'env': {
        'browser': true,
        'commonjs': true,
        'es6': true
    },
    'extends': 'airbnb',
    'globals': {
        'Atomics': 'readonly',
        'SharedArrayBuffer': 'readonly'
    },
    'parserOptions': {
        'ecmaVersion': 2018
    },
    'rules': {
      'no-use-before-define': 0,
      curly: ['error', 'multi-line'],
        // 'indent': [
        //     'error',
        //     4
        // ],
        // 'linebreak-style': [
        //     'error',
        //     'unix'
        // ],
        // 'quotes': [
        //     'error',
        //     'single'
        // ],
        // 'semi': [
        //     'error',
        //     'always'
        // ],
        // 'define-with'
    }
};