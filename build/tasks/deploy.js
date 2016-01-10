var gulp = require('gulp');
var GulpSSH = require('gulp-ssh');
var fm = require('date-format');
var runSequence = require('run-sequence');
var paths = require('../paths');
var args = require('../args');

var gulpSSH = null;

// deploy steps: pkg -> backup -> dest -> rm -> unzip -> service tomcat restart

gulp.task('deploy-precheck', function() {

    return gulpSSH
        .shell(['date'], {
            filePath: 'deploy-shell.log'
        })
        .pipe(gulp.dest(paths.logs));
});

gulp.task('deploy-backup', function() {

    var datetime = fm.asString('yyyy-MM-dd_hhmmss', new Date());

    return gulpSSH
        .shell(['cd ' + paths.dest, 'mkdir ../lhjz-backup', 'mkdir ../lhjz-backup/' + datetime, 'mv lhjz.portal-*.war ../lhjz-backup/' + datetime], {
            filePath: 'deploy-shell.log'
        })
        .pipe(gulp.dest(paths.logs));
});

gulp.task('deploy-backup-static', function() {

    var datetime = fm.asString('yyyy-MM-dd_hhmmss', new Date());

    return gulpSSH
        .shell(['cd ' + paths.dest_static, 'mkdir ../../../lhjz-backup-static', 'mkdir ../../../lhjz-backup-static/' + datetime, 'mv lhjz.static-*.zip ../../../lhjz-backup-static/' + datetime], {
            filePath: 'deploy-shell.log'
        })
        .pipe(gulp.dest(paths.logs));
});

gulp.task('deploy-dest', function() {

    return gulp
        .src(['target/lhjz.portal-*.war'])
        .pipe(gulpSSH.dest(paths.dest));

});

gulp.task('deploy-dest-static', function() {

    return gulp
        .src(['target/lhjz.static-*.zip'])
        .pipe(gulpSSH.dest(paths.dest_static));

});

gulp.task('deploy-publish', function() {

    return gulpSSH
        .shell(['cd ' + paths.dest, 'rm -rf META-INF org upload WEB-INF', 'unzip -o lhjz.portal-*.war', 'service tomcat restart'], {
            filePath: 'deploy-shell.log'
        })
        .pipe(gulp.dest(paths.logs));

});

gulp.task('deploy-publish-static', function() {

    return gulpSSH
        .shell(['cd ' + paths.dest_static, 'rm -rf static templates', 'unzip -o lhjz.static-*.zip', 'service tomcat restart'], {
            filePath: 'deploy-shell.log'
        })
        .pipe(gulp.dest(paths.logs));

});

function deployRunTask(type, callback) {

    if (!args.pwd) {
        throw new Error('ssh remote host password not set error, add --pwd=$pwd');
    }

    gulpSSH = new GulpSSH({
        ignoreErrors: false,
        sshConfig: {
            host: '120.25.70.236',
            port: 22,
            username: 'root',
            password: args.pwd
        }
    });

    if (type === 'static') {

        return runSequence(
            'pkg-static',
            'deploy-backup-static',
            'deploy-dest-static',
            'deploy-publish-static',
            callback
        );
    } else {

        return runSequence(
            'pkg',
            'deploy-backup',
            'deploy-dest',
            'deploy-publish',
            callback
        );
    }

}

gulp.task('deploy', function(callback) {

    return deployRunTask('all', callback);
});


gulp.task('deploy-static', function(callback) {

    return deployRunTask('static', callback);
});
