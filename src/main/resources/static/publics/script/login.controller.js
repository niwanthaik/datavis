angular .module('MyApp')
	.controller('loginCtrl', function($scope, $mdDialog,$timeout, $mdSidenav,$http,$location) {

    $scope.userLogin =[];
    $scope.a = false;

    $scope.login = function(){
        $scope.userLogin.push({ 'userName':$scope.userName, 'password':$scope.password});

        var dataObj = {
            userName : $scope.userName,
            password : $scope.password
        };

        $scope.a = true;

        console.log(JSON.stringify(dataObj));
        // console.log("tebbjabfjhl");

        var res = $http.post('/login', dataObj);
        res.success(function(data, status, headers, config) {
            console.log(JSON.stringify(data));
            $scope.message = data;
        });
        res.error(function(data, status, headers, config) {
            alert( "failure message: " + JSON.stringify({data: data}));
        });

        $scope.userName='';
        $scope.password='';   

    };

    $scope.submit = function () {
        console.log('test submit');
    }

})
