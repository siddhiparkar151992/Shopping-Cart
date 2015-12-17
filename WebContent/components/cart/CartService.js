var cartModule = angular.module("cart", []);
cartModule.factory("cart", function() {
	var cartData=[];
	
	return {
		
	addProduct :function(id, name, price) {
		var repeatedProduct = false;
		for ( var i = 0; i < cartData.length; i++) {
			if (cartData[i].id == id) {
				cartData[i].count++;
				repeatedProduct = true;
				break;
			}
			}
			if (!repeatedProduct) {
				cartData.push({
					count : 1,
					id : id,
					price : price,
					name : name
				});
			}

		},

	removeProduct : function(id) {
		for ( var i = 0; i < cartData.length; i++) {
			if (cartData[i].id == id) {
				cartData.splice(i,1);
				break;
			}

		}
			},
		getProducts: function () {
			return cartData;
		}

	}
		

});