// the main AppWorks object defines the callback handling, without it we cannot do much
if (!window.AppWorks) {
	throw new Error('Cannot use the AppWorksStorage without the base AppWorks object in scope,' + 
			' please include appworks.js above this file in your page');
}

/**
 * General light-weight JSON data storage solution. This client creates user defined "dataTypes"
 * within an apps dedicated storage area on the device. A more persistent version of HTML5 local
 * storage essentially. 
 * 
 * It is assumed that we are persisting String data only, dates should there be represented using 
 * millisecond Strings, a utility function (see millisToDate) is provided for convenience.
 */
var AppWorksStorage = {
	requestPrefix : 'storage.',
	callbackIdPrefix : 'storageReq.',
	invalidRequestMessage : 'Invalid request object passed to function.',
	
	/**
	 * Add some JSON to the device store, this operation will automatically overwrite 
	 * the value identified in the request with the new data supplied (hence 'put' not
	 * 'add'). Generate a basic request object via the getBaseStorageRequest function, and 
	 * add any other properties to the data as you see fit, they will all be persisted.
	 *
	 * @return 	response { 
	 * 				"callbackID" : "val",
	 *				"success" : "true|false"
	 * 			}
	 *
	 * @param requestObj 	the request, the contents of which will be validated  
	 * @param callback 		callback
	 */
	put : function(requestObj, callback) {
		// these fields are mandatory when adding data
		if (!requestObj.app || !requestObj.dataType || !requestObj.id) 
			throw new Error(this.invalidRequestMessage);

		var json = 
			'{'+
				'"action" : "'+this.requestPrefix+'put"'+
				', "callbackID" : "'+AppWorks.getNewCallbackId()+'"'+
				', "data" : '+JSON.stringify(requestObj)+
			'}';

		AppWorks.blackberryCommunication(json, callback);
	},

	/**
	 * Lookup a single item (by id) in the persistent JSON store.
	 *
	 * @return 	response { 
 	 * 				"callbackID" : "val",
 	 *				"app" : "val",
	 *				"dataType" : "some.type",
	 *				"id" : "val",
	 *				"data" : {
	 *					"prop1" : "val1",
	 *					"prop2" : "val2",
	 *					...
	 *				}
	 * 			} 
     *
     * @param app 		the app the data belongs to
     * @param dataType	the data type
     * @param id 		unique identifier 
	 * @param callback 	callback
	 */
	getItemFromStore : function(app, dataType, id, callback) {
		if (!app || !dataType || !id) 
			throw new Error(this.invalidRequestMessage);

		var json = 
			'{'+
				'"action" : "'+this.requestPrefix+'getItem"'+
				', "callbackID" : "'+AppWorks.getNewCallbackId()+'"'+
				', "app" : "'+app+'"'+
				', "dataType" : "'+dataType+'"'+
				', "id" : "'+id+'"'+
			'}';

		AppWorks.blackberryCommunication(json, callback);
	},

	/**
	 * Lookup all data stored under a type. Returns a (potentially empty) list of items.
	 *
	 * @return 	response { 
 	 * 				"callbackID" : "val",
	 *				"data" : [
	 *					{
	 * 						"app" : "val",
	 *						"dataType" : "some.type",
	 *						"id" : "val",
	 *						"data" : {
	 *							"prop1" : "val1",
	 *							"prop2" : "val2",
	 *							...
	 *						}
	 *					},
	 *					{
	 *						"app" : "val",
	 *						...
	 *					},
	 *					...]	
	 * 			} 
     * 
     * @param requestObj 	the request, will be validated for "app" and "dataType" 
	 * @param callback 		callback
	 */
	getByTypeFromStore : function(app, dataType, callback) {
		// this time "id" must nit
		if (!app || !dataType) 
			throw new Error(this.invalidRequestMessage);

		var json = 
			'{'+
				'"action" : "'+this.requestPrefix+'getByType"'+
				', "callbackID" : "'+AppWorks.getNewCallbackId()+'"'+
				', "app" : "'+app+'"'+
				', "dataType" : "'+dataType+'"'+
			'}';
		AppWorks.blackberryCommunication(json, callback);
	},

	/**
	 * Build the basic JSON storage request. All fields are mandatory.
	 *
     * @param dataType 	data type name 
     * @param app 		the app the data should be stored for (use a unique key your
     *       			app knows about)  
     * @param id 		the identifier for the data item (optional)
     * @param dataObj	extra properties to add to the request (optional)
	 */
	getStorageRequest : function(dataType, app, id, dataObj) {
		if (app == null) 
			throw new Error("app cannot be null");

		if (dataType == null) 
			throw new Error("dataType cannot be null");
		
		var baseReq = {
			"app" : app,
			"dataType" : dataType
		};

		if (id != null)
			baseReq.id = id;

		if (dataObj)
			baseReq.data = dataObj;
		
		return baseReq;
	},
	
	/**
	 * Constructs a JavaScript Date from a millisecond String. This is the format
	 * used by this cache to represent time values (modified, expires). 
	 */			
	millisToDate : function (millisString) {
		return new Date(parseInt(millisString, 10));
	}
	
};