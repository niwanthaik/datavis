angular .module('MyApp', ['ngMaterial','ngMessages','ngRoute'])


.config(function ($routeProvider) {
		$routeProvider
			.when("/",{
				templateUrl:"login.html",
				controller:"loginCtrl"
			})
			.when("/register",{
				templateUrl:"register.html",
				controller:"registerCtrl"
			})
			.when("/forgot",{
				templateUrl:"forgot.html",
				controller:"forgotCtrl"
			})
			.otherwise({
				redirectTo:"/"
			});
	})

;
