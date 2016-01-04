app.controller('productListController',['$scope', '$filter', 'cartService','ProductModel','$rootScope', function($scope, $filter, cartService, ProductModel, $rootScope) {
	var selected = null;
	var init= function(){
		ProductModel.getAll().then(function(res){
			$scope.productDataset = res;
		});
		
		$scope.categoryDataSet = [ {"name" : "Chess", "categoryId" : 3 },
		                           { "name" : "Soccer", "categoryId" : 2 },
		                           {"name" : "WaterSport", "categoryId" : 1 }];
	}
	init();
	$scope.selectCategory = function(category) {
		$scope.selectedCat=category;
	}

	$scope.filterCategory = function(product) {
		return selected == null || product.category == selected;
	}

	$scope.addToCart = function(product) {
		cartService.addProduct(product).then(function(res){
			$rootScope.$broadcast("refreshCart");
		});
		
	}
}]);