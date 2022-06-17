const path = require('path');
// eslint-disable-next-line node/no-unpublished-require
const webpack = require('webpack');
// eslint-disable-next-line node/no-unpublished-require
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
        adminLogin: '/js/admin/login/adminLogin.js',
        adminSignUp: '/js/admin/login/adminSignUp.js',
        adminPwChange: '/js/admin/login/adminPwChange.js',
        adminMain: '/js/admin/main/adminMain.js',
        adminGridContent: '/js/admin/main/adminGridContent.js',
        adminUser: '/js/admin/user/adminUser.js',
        adminAuth: '/js/admin/user/adminAuth.js',
        adminUserAuth: '/js/admin/user/adminUserAuth.js',
        adminUserAuthWrite: '/js/admin/user/adminUserAuthWrite.js',
        adminCode: '/js/admin/mng/adminCode.js',
        adminMenu: '/js/admin/menu/adminMenu.js',
        adminAuthMenu: '/js/admin/menu/adminAuthMenu.js',
        adminHead: '/js/admin/main/adminHead.js',
    },
    output: {
        path: path.resolve(`${__dirname  }/dist`),
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
