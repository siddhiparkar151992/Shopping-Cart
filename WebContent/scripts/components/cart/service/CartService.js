var cartModule = angular.module("cart", []);
cartModule.factory("cartService", function() {
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