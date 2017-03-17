angular.module('datavis.controllers')
	.controller('forgotCtrl', function($scope, $mdDialog,$timeout, $mdSidenav,$http,$location) {

    $scope.verifyLogin =[];
    $scope.a = false;

    $scope.verify = function(){
        $scope.userRegister.push({ 'userName':$scope.userName,
			'email':$scope.email,
			'question1':$scope.question1,
			'question2':$scope.question2 
	});

        var dataObj = {
		userName : $scope.userName,
		email : $scope.email,
		question1 : $scope.question1,
		question2 : $scope.question2
        };

        $scope.a = true;

        console.log(JSON.stringify(dataObj));
        // console.log("tebbjabfjhl");

        var res = $http.post('/forgot', dataObj);
        res.success(function(data, status, headers, config) {
            console.log(JSON.stringify(data));
            $scope.message = data;
        });
        res.error(function(data, status, headers, config) {
            alert( "failure message: " + JSON.stringify({data: data}));
        });

        $scope.userName='';
        $scope.email='';
	$scope.question1='';
	$scope.question2='';

    };

    $scope.submit = function () {
        console.log('test submit');
    }

})
