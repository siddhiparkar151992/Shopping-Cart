app.controller('productListController',['$scope', '$filter', 'cartService','ProductModel','CategoryModel', function($scope, $filter, cartService, ProductModel, CategoryModel) {
	var selected = null;
	var init= function(){
		ProductModel.getAll().then(function(res){
			$scope.productDataset = res;
		});
		
		$scope.categoryDataSet = CategoryModel;
	}
	init();
	$scope.selectCategory = function(category) {
		$scope.selectedCat=category;
	}

	$scope.filterCategory = function(product) {
		return selected == null || product.category == selected;
	}

	$scope.addToCart = function(product) {

		cartService.addProduct(product);

	}
}]);