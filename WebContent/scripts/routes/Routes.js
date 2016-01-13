app.config(function($routeProvider) {
			$routeProvider
					.when('/checkout',{
								templateUrl : "scripts/views/CheckOutSummary.html",
								

							}).when('/', {
						templateUrl : 'scripts/components/products/templates/ProductListView.html',
						controller : 'productListController'

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