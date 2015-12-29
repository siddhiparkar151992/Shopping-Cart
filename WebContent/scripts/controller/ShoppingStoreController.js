var app=angular.module("store",['ngRoute','customFilter',"cart"]);
app.controller("storeController",function ($scope,$rootScope,$http,cart,$location){
	
	$rootScope.$on("$routeChangeError",function (event, current, previous, rejection){
		console.log("Failed to change routes");
		
	})
	$scope.sendOrder=function (shippingDetails){
		var order=angular.copy(shippingDetails);
		order.products=cart.getProducts();
		$http.post("http://localhost:8080/ShoppingStoreApplication/Admin/AdminView/AdminMain.html", order)
		.success(function (data) {
		$scope.data.orderId = data.id;
		cart.getProducts().length = 0;
		})
		.error(function (error) {
		$scope.data.orderError = error;
		}).finally(function () {
		$location.path("/complete");
		});
	}
	
	
})