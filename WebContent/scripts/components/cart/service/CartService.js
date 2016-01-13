var cartModule = angular.module("cart", []);
cartModule.factory("cartService", function(CartModel,CartItemModel) {
	var cartData = [];
	userId=345;
	return {

		addProduct : function(product) {
			var cartItem = {
					"shoppingCartId":this.cartData.cartId,
					"quantity":1,
					"productId":product.id,
					"itemPrice":product.price,
					"product":product
					}
		return CartModel.add(cartItem);
		},

		removeProduct : function(id) {
			
		},
		getProduct : function(id) {
			return CartModel.getById(id);
		},
		getAllItems:function(){
			return CartItemModel.getAll({"userId":345});
		},
		getAllItemsWithProds:function(){
			return CartModel.getProductsCart({"id":345});
		}

	}

});