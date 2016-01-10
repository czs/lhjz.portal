var yargs = require('yargs');
var argv = yargs.argv;
var pwd = argv.pwd || ''; // remote deploy password

module.exports = {
    pwd: pwd
};
