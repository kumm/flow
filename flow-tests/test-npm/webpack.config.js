const path = require('path');
const fs = require('fs');
const CopyWebpackPlugin = require('copy-webpack-plugin');

const inputFolder = path.resolve(__dirname, './src/main/webapp/frontend');
const outputFolder = path.resolve(__dirname, './src/main/webapp/');

const statsFolder = path.resolve(__dirname, './target/classes/META-INF/resources');
fs.mkdirSync(statsFolder, { recursive: true });
const statsFile = statsFolder + '/stats.json';

module.exports = {
  mode: 'production',
  context: inputFolder,
  entry: {
    index: './main.js'
  },

  output: {
    filename: 'build/[name].js',
    path: outputFolder
  },

  plugins: [
    function (compiler) {
      compiler.plugin('after-emit', function (compilation, done) {
        console.log("Emitted " + statsFile)
        fs.writeFile(path.resolve(__dirname, statsFile),
          JSON.stringify(compilation.getStats().toJson(), null, 2), done);
      });
    },

    new CopyWebpackPlugin([{
      from: path.resolve(__dirname, 'node_modules/@webcomponents/webcomponentsjs'),
      to: 'build/webcomponentsjs/',
    }]),
  ]
};