
adminapp.config(
		function($routeProvider) {
			$routeProvider.when("/login", {
				templateUrl : "AdminLogin.html"
			});
			$routeProvider.when("/main", {
				templateUrl : "AdminMain.html"
			});
			$routeProvider.otherwise({
				redirectTo : "/login"
			});
		});