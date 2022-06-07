module.exports = {
    env: {
        browser: true,
        commonjs: true,
        es6: true,
        jquery: true,
    },
    extends: ['airbnb-base', 'plugin:node/recommended', 'prettier'],
    parserOptions: {
        parser: 'babel-eslint',
        sourceType: 'module',
        allowImportExportEverywhere: true,
        ecmaVersion: 11,
    },
    rules: {
        'node/no-unsupported-features/es-syntax': [
            'error',
            { ignores: ['modules'] },
        ],
        'no-console': 'off',
    },
};
