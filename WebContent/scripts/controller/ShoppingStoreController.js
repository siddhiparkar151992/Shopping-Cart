var app=angular.module("store",['ngRoute','customFilter',"cart"]);
app.controller("storeController",function ($scope,$rootScope,$http,cartService,$location){
	
	$rootScope.$on("$routeChangeError",function (event, current, previous, rejection){
		console.log("Failed to change routes");
		
	})
	$scope.sendOrder=function (shippingDetails){
		
	}
	
	
})