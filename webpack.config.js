var path = require('path');

module.exports = {
    entry: './src/main/js/app.js',
    devtool: 'sourcemaps',
    cache: true,
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/bundle.js'
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