var path = require('path');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CleanWebpackPlugin = require('clean-webpack-plugin');
module.exports = {
    entry: './src/main/js/app.js',
    devtool: 'inline-source-map',
    devServer: {
    	contentBase: path.resolve(__dirname, "src/main/resources/static"),
    	publicPath: '/built/',
    	hot: true,
        port:9000,
        proxy:{
        	"*":"http://localhost:8080"
        }
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin()
    ],
    cache: true,
    output: {
        path: path.resolve(__dirname, "src/main/resources/static/built"),
        filename: 'bundle.js',
    },
    module: {
        rules: [
          {
            test: /\.css$/,
            use: ['style-loader', 'css-loader']
          },
          {
    	    test: /\.js$/,
    	    exclude: /(node_modules)/,
    	    use: {
    	      loader: 'babel-loader',
    	      options: {
    	    	  cacheDirectory: true,
                  presets: ['es2015', 'react']
    	      }
    	    }
          }
        ]
      }
};