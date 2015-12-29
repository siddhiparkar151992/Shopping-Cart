var endPOintMap = {
			baseUrl:'/ShoppingStoreApplication/ShoppingCart',
			productUrl:'/Products',
			cartUrl:'/Cart',
			userUrl:'/Users'
	}
	
angular.module('store').service('ConfigService', function($rootScope){
	
	this.getUrl =  function(model){
		return endPOintMap.baseUrl + '/'+model; 
	}
	
	this.getUrlById = function(model, id){
		return this.getUrl(model) + '/'+id; 
	}
})