/**
 * Created by niwantha on 3/12/17.
 */

angular.module('datavis.config',['ngRoute','ngMaterial','ngMessages'])
    .config(['$routeProvider','$locationProvider', function($routeProvider,$locationProvider) {

    $routeProvider
        .when('/', {
        templateUrl: 'view/main/main.html',
        controller: 'mainCtrl'

    })
        .when('/register', {
        templateUrl: 'view/register/register.html',
        controller: 'registerCtrl'

    }).when('/forgot', {
        templateUrl: 'view/forgot/forgot.html',
        controller: 'forgotCtrl'

    }) .when('/dashboard', {
        templateUrl: 'view/dashboard/dashboard.html',
        controller: 'dashboardCtrl'
    }).when('/login', {
            templateUrl: 'view/login/login.html',
            controller: 'loginCtrl'
        })
        .otherwise({
        redirectTo: '/'
    })
}]);




