var DcsView = new function () {    var deviceStrategy = null;    this.getURLParameter = function (name) {        return decodeURIComponent(            (new RegExp(name + '=' + '(.+?)(&|$)').exec(location.search) || [, null])[1]        );    };    this.setDeviceStrategy = function () {        var deviceStrategyFactory = new DeviceStrategyFactory();        deviceStrategy = deviceStrategyFactory.getDeviceStrategy();    };    this.showDcsView = function () {        this.setDeviceStrategy();        var docId = DcsView.getURLParameter('id');        var numPages = 0;        deviceStrategy.getGatewayURL().then(function (baseUrl) {            var url = baseUrl + '/dcs/v5/nodes/' + docId + '?_nocache=' + new Date().getTime();            deviceStrategy.runRequestWithAuth({url: url})                .done(function (data) {                    var instance, options;                    var pagesArray = [];                    numPages = data;                    for (var i = 1; i <= numPages; i++) {                        pagesArray.push({                            url: baseUrl + docId + '/pages/' + i,                            caption: '' + i + ' / ' + numPages                        });                    }                    options = {                        preventHide: true,                        captionAndToolbarAutoHideDelay: 0,                        captionAndToolbarOpacity: 1,                        maxUserZoom: 0,                        getImageSource: function (obj) {                            return obj.url;                        },                        getImageCaption: function (obj) {                            return obj.caption;                        }                    };                    instance = Code.PhotoSwipe.attach(pagesArray, options);                    instance.show(0);                })                .fail(function (error) {                    alert(error);                    deviceStrategy.close();                });        });    };};function onDeviceReady() {    DcsView.showDcsView();}// Trigger dcs view when cordova is readydocument.addEventListener("deviceready", onDeviceReady, false);