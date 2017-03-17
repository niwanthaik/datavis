angular .module('datavis.controllers')
	.controller('loginCtrl', function($scope, $mdDialog,$timeout, $mdSidenav,$http,$location,DatavisServices) {
        
    $scope.a = false;

    $scope.login = function() {

        $scope.a = true;


        DatavisServices.loginServices( $scope.userName, $scope.password)
            .then(loginPrint)
            .catch(loginError)




    };
        function loginPrint (message) {
            if(message){
                $scope.userName='';
                $scope.password='';
                 $location.path("/forgot");

            }else {
                alert("Incorrect user name or password");
                $scope.userName='';
                $scope.password='';
               $location.path("/register");
            }

        }

        function loginError (errorMessage) {
            alert("Has an error");
        }

    /*$scope.submit = function () {
        console.log('test submit');
    }*/

})
