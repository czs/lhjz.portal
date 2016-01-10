var gulp = require('gulp');
var exec = require('child_process').exec;

gulp.task('mvn', function(cb) {
    exec('mvn clean package -Dmaven.test.skip=true', function(err, stdout, stderr) {
        console.log(stdout);
        console.log(stderr);
        cb(err);
    });
});