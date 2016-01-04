cartModule.directive("cartSummary", function(cartService) {

	return {
		restrict : 'E',
		scope : {
			displayToatal : '@'
		},
		templateUrl : 'scripts/components/cart/templates/CartSummary.html',
		controller : function($scope) {
			var total = function() {
				var total = 0;
				for (var i = 0; i < $scope.cartData.cartItems.length; i++) {
					total += $scope.cartData.cartItems[i].quantity * $scope.cartData.cartItems[i].itemPrice;
				}
				return total;
			}
			
			var init = function(){
				var cartDefer = cartService.getAllItems().then(function(res){
					$scope.cartData = cartService.cartData =res.data;
					$scope.total =total();
				});
			}
			init();
			$scope.$on("refreshCart",function(){
				init();
			})
			

		}

	}
})