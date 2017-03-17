angular .module('MyApp')
	.controller('registerCtrl', function($scope, $mdDialog,$timeout, $mdSidenav,$http,$location) {

    $scope.userRegister =[];
    $scope.a = false;

    $scope.register = function(){
        $scope.userRegister.push({ 'userName':$scope.userName,
			'password':$scope.password,
			'confirmPassword':$scope.confirmPassword,
			'email':$scope.email,
			'country':$scope.country,
			'question1':$scope.question1,
			'question2':$scope.question2,
			'role':$scope.role 
	});

        var dataObj = {
		userName : $scope.userName,
		password : $scope.password,
		confirmPassword : $scope.confirmPassword,
		email : $scope.email,
		country : $scope.country,
		question1 : $scope.question1,
		question2 : $scope.question2,
		role : $scope.role
        };

        $scope.a = true;

        console.log(JSON.stringify(dataObj));
        // console.log("tebbjabfjhl");

        var res = $http.post('/register', dataObj);
        res.success(function(data, status, headers, config) {
            console.log(JSON.stringify(data));
            $scope.message = data;
        });
        res.error(function(data, status, headers, config) {
            alert( "failure message: " + JSON.stringify({data: data}));
        });

        $scope.userName='';
        $scope.password='';
        $scope.confirmPassword='';
        $scope.email='';
        $scope.country='';
	$scope.question1='';
	$scope.question2='';
        $scope.role='';

    };

    $scope.submit = function () {
        console.log('test submit');
    }


});
