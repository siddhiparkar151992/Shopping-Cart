app.controller("cartSummaryController", function($scope, cartService) {
	var init= function(){
		var cartDefer = cartService.getAllItemsWithProds().then(function(res){
			$scope.cartData = res.cartItems;
			$scope.total =total();
		});
		
	}
	
	var total = function() {
		var total = 0;
		for (var i = 0; i < $scope.cartData.length; i++) {
			total += ($scope.cartData[i].price * $scope.cartData[i].quantity);
		}
		return total;
	}
	$scope.remove = function(id) {
		cartService.removeProduct(id);
	}
	init();
})
