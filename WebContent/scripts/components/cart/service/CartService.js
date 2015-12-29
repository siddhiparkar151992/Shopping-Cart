var cartModule = angular.module("cartService", []);
cartModule.factory("cart", function() {
	var cartData = [];

	return {

		addProduct : function(product) {
			
			
		},

		removeProduct : function(id) {
			
		},
		getProducts : function() {
			return cartData;
		}

	}

});