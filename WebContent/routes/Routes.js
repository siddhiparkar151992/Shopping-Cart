app.config(function($routeProvider) {
	$routeProvider.when('/checkout', {
		templateUrl : "http://localhost:8080/ShoppingStoreApplication/views/CheckOutSummary.html",
		resolve:
	{
		app:function($q,$timeout){
		var defer=$q.defer;
		$timeout(function (){
			
			defer.resolve();
		},2000);
		return defer.promise;
	}
	
	}
		
	}).when('/products', {
		templateUrl : 'ProductListView.html',
		
	
	}).when('/complete', {
		templateUrl : 'ThankYou.html',
		
	}).when('/placeorder', {
		templateUrl : 'PlaceOrder.html',
		
	}).otherwise({
		redirectTo : '/'
	}).when('/adminlogin', {
		templateUrl : 'AdminLogin.html',
		
	});
});