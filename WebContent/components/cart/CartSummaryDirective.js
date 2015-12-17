cartModule.directive("cartSummary", function(cart) {

	return {
		restrict : 'E',
		scope:{
		displayToatal:'@'
	}
		templateUrl : '../components/cart/CartSummary.html',
		controller : function($scope) {
			var cartData = cart.getProducts();
			$scope.total = function() {
				var total = 0;
				for ( var i = 0; i < cartData.length; i++) {
					total += cartData[i].count * cartData[i].price;
				}
				return total;
			}

			$scope.count = function() {
				var count = 0;
				for ( var i = 0; i < cartData.length; i++) {
					count += cartData[i].count;
				}
				return count;
			}
		}

	}
})