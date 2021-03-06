module.exports = function(grunt) {

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        copy: {
            build: {
                files: [
                    {cwd: 'src/resources', src: '**/*', dest: 'dist/build', expand: true},
                    {cwd: 'src/webcontent', src: '**/*', dest: 'dist/build', expand: true},
                    {cwd: 'src/app', src: '**/*', dest: 'dist/mobile', expand: true},
                    {cwd: '../common.app/css', src: ['app.css', 'bootstrap.min.css', 'bootstrap-datetimepicker.min.css'],
                        dest: 'dist/mobile/css', expand: true},
                    {cwd: '../common.app/img', src: ['ajax-loader.gif', 'glyphicons-halflings.png', 'glyphicons-halflings-white.png'],
                        dest: 'dist/mobile/img', expand: true},
                    {cwd: '../common.app/js', src: ['app.js', 'deviceStrategyFactory.js', 'blackberryDeviceStrategy.js', 'nonBlackberryDeviceStrategy.js'],
                        dest: 'dist/mobile/js', expand: true},
                    {cwd: '../common.app/js/vendor', src: ['bootstrap.min.js', 'bootstrap-datetimepicker.min.js', 'jquery.jsperanto.js',
                        'json2.js', 'moment.min.js'], dest: 'dist/mobile/js/vendor', expand: true},
                    {cwd: 'dependencies/appworks-js/dist', src: 'appworks.min.js', dest: 'dist/mobile/lib/appworks-js', expand: true}
                ]
            }
        },
        compress: {
            mobile: {
                options: {
                    archive: 'dist/build/mobile.zip'
                },
                files: [{
                    expand: true,
                    cwd: 'dist/mobile/',
                    src: ['**/*'],
                    dest: ''
                }]
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-compress');

    grunt.registerTask('default', ['copy', 'compress']);
};