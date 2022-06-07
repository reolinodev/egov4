const path = require('path');
const webpack = require('webpack');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');

const childProcess = require('child_process');

const removeNewLine = (buffer) => {
    return buffer.toString().replace('\n', '');
};

const env = process.env.NODE_ENV;

module.exports = {
    mode: 'development',

    entry: {
        adminConfig: '/js/admin/adminConfig.js',
        // login: '/src/main/resources/static/js/custom/login.js',
        // signUp: '/src/main/resources/static/js/custom/signUp.js',
        // pwChange: '/src/main/resources/static/js/custom/pwChange.js',
        // main: '/src/main/resources/static/js/custom/main.js',
        // gridContent: '/src/main/resources/static/js/custom/gridContent.js',
        // userMngView: '/src/main/resources/static/js/custom/user/userMngView.js',
        // authMngView: '/src/main/resources/static/js/custom/user/authMngView.js',
        // authUserMngView: '/src/main/resources/static/js/custom/user/authUserMngView.js',
        // authUserMngWrite: '/src/main/resources/static/js/custom/user/authUserMngWrite.js',
        // authUserMngWrite: '/src/main/resources/static/js/custom/user/authUserMngWrite.js',
        // codeMngView: '/src/main/resources/static/js/custom/etc/codeMngView.js',
        // menuMngView: '/src/main/resources/static/js/custom/menu/menuMngView.js',
        // index: '/src/main/resources/static/js/index/index.js',
    },
    output: {
        path: path.resolve(__dirname + '/dist'),
        filename: '[name].js',
        clean: true,
    },
    module: {
        rules: [
            {
                test: /\.s?css$/,
                use: [
                    'style-loader',
                    'css-loader',
                    'postcss-loader',
                    'sass-loader',
                ],
            },
            {
                test: /\.js$/,
                use: ['babel-loader'],
            },
            {
                test: /\.(gif|png|jpe?g|svg)$/i,
                use: [
                    {
                        loader: 'image-webpack-loader',
                        options: {
                            mozjpeg: {
                                progressive: true,
                                quality: 65,
                            },
                            optipng: {
                                enabled: false,
                            },
                            pngquant: {
                                quality: [0.65, 0.9],
                                speed: 4,
                            },
                            gifsicle: {
                                interlaced: false,
                            },
                            webp: {
                                quality: 75,
                            },
                        },
                    },
                ],
            },
        ],
    },
    plugins: [
        new CleanWebpackPlugin({
            cleanAfterEveryBuildPatterns: ['dist'],
        }),
        new webpack.BannerPlugin({
            banner: `
                Build Date :: ${new Date().toLocaleString()}
                Commit Version :: ${removeNewLine(
                    childProcess.execSync('git rev-parse --short HEAD')
                )}
                Auth.name :: ${removeNewLine(
                    childProcess.execSync('git config user.name')
                )}
                Auth.email :: ${removeNewLine(
                    childProcess.execSync('git config user.email')
                )}
            `,
        }),
        new webpack.DefinePlugin({
            VERSION: JSON.stringify('v.1.0.0'),
            MAX_COUNT: JSON.stringify(999),
            'api.domain': JSON.stringify('http://127.0.0.1'),
        }),
        new webpack.ProvidePlugin({
            $: 'jquery',
            moment: 'moment',
            _: 'lodash',
            Swal: 'sweetalert2',
        }),
    ],
};
