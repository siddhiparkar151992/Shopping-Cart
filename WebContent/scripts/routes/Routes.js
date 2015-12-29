app.config(function($routeProvider) {
			$routeProvider
					.when('/checkout',{
								templateUrl : "scripts/views/CheckOutSummary.html",
								resolve : {
									app : function($q, $timeout) {
										var defer = $q.defer;
										$timeout(function() {

											defer.resolve();
										}, 2000);
										return defer.promise;
									}

								}

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