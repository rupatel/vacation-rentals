var path = require('path');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const CleanWebpackPlugin = require('clean-webpack-plugin');
module.exports = {
	entry : './src/main/js/app.js',
	devtool : 'inline-source-map',
	devServer : {
		contentBase : path.resolve(__dirname, "src/main/resources/static"),
		publicPath : '/built/',
		hot : true,
		port : 9000,
		proxy : {
			"*" : "http://localhost:8080"
		}
	},
	plugins : [ new webpack.HotModuleReplacementPlugin() ],
	cache : true,
	output : {
		path : path.resolve(__dirname, "src/main/resources/static/built"),
		publicPath : '/built/',
		filename : 'bundle.js',
	},
	module : {
		rules : [ {
			test : /\.css$/,
			use : [ 'style-loader', 'css-loader' ]
		}, {
			test : /\.js$/,
			exclude : /(node_modules)/,
			use : {
				loader : 'babel-loader',
				options : {
					cacheDirectory : true,
					presets : [ 'es2015', 'react' ]
				}
			}
		},
		{
	         test: /.(ttf|otf|eot|svg|woff(2)?)(\?[a-z0-9]+)?$/,
	         use: [{
	           loader: 'file-loader',
	           options: {
	             name: '[name].[ext]',
	             outputPath: 'fonts/',
	             publicPath: '/built/fonts/'       
	           }
	         }]
	       },
		]
	}
};