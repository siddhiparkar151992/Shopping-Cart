cartModule.directive("cartSummary", function(cartService) {

	return {
		restrict : 'E',
		scope : {
			displayToatal : '@'
		},
		templateUrl : 'scripts/components/cart/templates/CartSummary.html',
		controller : function($scope) {
			var cartData = cartService.getProducts();
			$scope.total = function() {
				var total = 0;
				for (var i = 0; i < cartData.length; i++) {
					total += cartData[i].count * cartData[i].price;
				}
				return total;
			}

			$scope.count = function() {
				var count = 0;
				for (var i = 0; i < cartData.length; i++) {
					count += cartData[i].count;
				}
				return count;
			}

		}

	}
})