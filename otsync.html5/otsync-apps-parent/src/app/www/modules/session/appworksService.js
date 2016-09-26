angular.module('appworksService', [])

    .factory('$appworksService', [
        '$q',
        '$httpParamSerializerJQLike',
        '$displayMessageService',
        function ($q, $httpParamSerializerJQLike, $displayMessageService) {

            return {

                addToCache: function (key, value, usePersistentStorage) {
                    var cache = new Appworks.AWCache({
                        usePersistentStorage: usePersistentStorage
                    });

                    cache.setItem(key, value);
                },

                authenticate: function (force) {
                    var deferred = $q.defer();
                    var auth = new Appworks.Auth(deferred.resolve, deferred.reject);
                    auth.authenticate(force);
                    return deferred.promise;
                },

                execCordovaRequest: function (namespace, func, params) {
                    var deferred = $q.defer();

                    var successFn = function (data) {
                        deferred.resolve(data)
                    };
                    var errorFn = function (error) {
                        deferred.reject(error);
                    };

                    cordova.exec(successFn, errorFn, namespace, func, params || []);

                    return deferred.promise;
                },

                getCameraOptions: function () {
                    var options = {
                        destinationType: Camera.DestinationType.DATA_URL
                    };
                    return options;
                },

                getComponentList: function () {
                    var args = ["component"];
                    return this.execCordovaRequest('AWComponent', 'list', args);
                },

                getDefaultLanguage: function () {
                    var deferred = $q.defer();
                    var _defaultLanguage = 'en';

                    this.execCordovaRequest("AWGlobalization", "getPreferredLanguage").then(
                        function (lang) {
                            if (lang != null && lang.value != null && lang.value != '')
                                deferred.resolve(lang.value);
                            else
                                deferred.resolve(_defaultLanguage);
                        }
                    ).catch(
                        function () {
                            deferred.resolve(_defaultLanguage);
                        }
                    );

                    return deferred.promise;
                },

                getFile: function (fileName) {
                    var deferred = $q.defer();

                    var storage = new Appworks.SecureStorage(success, failure);

                    // replace spaces with four underscores to avoid problems when trying to access in web view
                    fileName = fileName.replace(/ +/g, '____');
                    storage.retrieve(fileName);

                    return deferred.promise;

                    function success(file) {
                        deferred.resolve(file);
                    }

                    function failure(error) {
                        var errorMsg;
                        if (typeof error === 'object' && error.body) {
                            errorMsg = JSON.parse(error.body);
                            errorMsg = errorMsg.error || errorMsg;
                            $displayMessageService.showErrorMessage(errorMsg);
                        }
                        deferred.reject(error);
                    }
                },

                getFromCache: function (key) {
                    var cache = new Appworks.AWCache();
                    return cache.getItem(key);
                },

                getGatewayURL: function () {
                    var deferred = $q.defer();

                    this.execCordovaRequest("AWAuth", "gateway").then(
                        function (gatewayURL) {
                            deferred.resolve(gatewayURL);
                        }
                    ).catch(
                        function (error) {
                            deferred.reject(error);
                        }
                    );

                    return deferred.promise;
                },

                getSharedDocumentUrl: function () {
                    var deferred = $q.defer();
                    this.authenticate().then(function (authResponse) {
                        deferred.resolve(authResponse.authData.sharedDocumentUrl);
                    }, deferred.reject);
                    return deferred.promise;
                },

                getOTCSTICKET: function () {
                    var deferred = $q.defer();

                    this.execCordovaRequest("AWAuth", "authenticate")
                        .then(function (authResponse) {
                            if (authResponse != null &&
                                authResponse.addtl &&
                                authResponse.addtl['otsync-connector'] &&
                                authResponse.addtl['otsync-connector'].otcsticket) {

                                deferred.resolve(authResponse.addtl['otsync-connector'].otcsticket);

                            } else
                                deferred.resolve('');
                        })
                        .catch(function (error) {
                            deferred.reject(error);
                        });

                    return deferred.promise;
                },

                isNodeInStorage: function (node, key) {
                    var isNodeInCache = false;
                    var favorites = this.getFromCache(key);

                    if (favorites) {
                        favorites = JSON.parse(favorites);
                    }

                    if (favorites instanceof Array) {
                        favorites.forEach(function (favorite) {
                            if (favorite.id === node.getID() && favorite.versionNum === node.getVersionNumber()) {
                                isNodeInCache = true;
                            }
                        });
                    }
                    return isNodeInCache;
                },

                closeCurrentComponent: function () {
                    this.execCordovaRequest('AWComponent', 'close');
                },

                openFromAppworks: function (componentName, data, isComponent) {
                    var appworksType = "component";

                    if (!isComponent) {
                        appworksType = "app";
                    }

                    return this.execCordovaRequest("AWComponent", "open", [
                        componentName,
                        $httpParamSerializerJQLike(data),
                        appworksType
                    ]);
                },

                storeFile: function (downloadURL, fileName, options, share) {
                    var deferred = $q.defer();
                    var storage = new Appworks.SecureStorage(success, failure);
                    var sharedStorage = new Appworks.AWFileTransfer(success, failure);

                    if (share) {
                        storeShared();
                    } else {
                        store();
                    }

                    function success(file) {
                        deferred.resolve(file);
                    }

                    function failure(error) {
                        var errorMsg;
                        if (typeof error === 'object' && error.body) {
                            errorMsg = JSON.parse(error.body);
                            errorMsg = errorMsg.error || errorMsg;
                            $displayMessageService.showErrorMessage(errorMsg);
                        }
                        deferred.reject(error);
                    }

                    function storeShared() {
                        // replace spaces with four underscores to avoid problems when trying to access in web view
                        fileName = fileName.replace(/ +/g, '____');
                        sharedStorage.download(downloadURL, fileName, null, true);
                    }

                    function store() {
                        // replace spaces with four underscores to avoid problems when trying to access in web view
                        fileName = fileName.replace(/ +/g, '____');
                        storage.store(downloadURL, fileName);
                    }

                    return deferred.promise;
                },

                deviceIsIos: function () {
                    var device = new Appworks.AWDevice();
                    return device.platform === 'iOS';
                },

                deviceIsAndroid: function () {
                    var device = new Appworks.AWDevice();
                    return device.platform === 'Android';
                }
            }
        }
    ]);
