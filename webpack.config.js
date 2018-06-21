const HtmlWebPackPlugin = require("html-webpack-plugin");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const path = require('path');

const pathToGatewaysFrontEnd = './frequency_gateway/src/main/front-end';
const pathToGatewaysStaticFolder = './frequency_gateway/src/main/resources/static';

module.exports = {
    mode: 'development',
    entry: pathToGatewaysFrontEnd+'/index.js',
    output: {
        path: path.resolve(pathToGatewaysStaticFolder),
        filename: 'index.js'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: "babel-loader"
                }
            },
            {
                test: /\.html$/,
                use: [
                    {
                        loader: "html-loader",
                        options: { minimize: true }
                    }
                ]
            },
            {
                test: /\.css$/,
                use: [MiniCssExtractPlugin.loader, "css-loader"]
            }
        ]
    },
    plugins: [
        new HtmlWebPackPlugin({
            template: pathToGatewaysFrontEnd+"/index.html",
            filename: "/index.html"
        }),
        new MiniCssExtractPlugin({
            filename: "[name].css",
            chunkFilename: "[id].css"
        })
    ]
};