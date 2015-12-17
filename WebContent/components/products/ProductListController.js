app.controller('productListController',function ($scope,$filter,cart
	){
	var selected=null;
	$scope.selectCategory=function (category){
		selected=category;
	}
	
	$scope.filterCategory=function (product){
		return selected==null||product.category==selected;
	}
	
	$scope.addToCart=function(product) {
		
		cart.addProduct(product.id,product.name,product.price);
	 	
	}
})