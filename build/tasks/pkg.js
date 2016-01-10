var gulp = require('gulp');
var zip = require('gulp-zip');
var fm = require('date-format');
var del = require('del');
var vinylPaths = require('vinyl-paths');

gulp.task('clean-static-pkg', function() {
    return gulp.src('target/lhjz.static-*.zip')
        .pipe(vinylPaths(del));
});

gulp.task('pkg', ['build']);

gulp.task('pkg-static', ['clean-static-pkg'], copyRes);


function copyRes() {

    // 打包压缩生成的文件名
    var zipFileName = 'lhjz.static' + '-v' + fm.asString('yyyyMMdd_hhmmss.SSS', new Date()) + '.zip';

    // 复制资源
    var resources = ['src/main/resources/static/**', 'src/main/resources/templates/**'];

    // 复制文件
    return gulp.src(resources, {
            base: 'src/main/resources/'
        })
        .pipe(zip(zipFileName)) // 压缩文件
        .pipe(gulp.dest('target'));
}
