var cartModule = angular.module("cart", []);
cartModule.factory("cartService", function() {
	var cartData = [];

	return {

		addProduct : function(product, cart,quantity) {
			var cartItem = {
					"shoppingCartId":cart.cartId,
					"quantity":quantity,
					"productId":itemPrice.productId,
					"itemPrice":itemPrice.price,
					
					
			}
		},

		removeProduct : function(id) {
			
		},
		getProducts : function() {
			return cartData;
		}

	}

});