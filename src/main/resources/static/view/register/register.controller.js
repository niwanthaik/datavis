angular .module('datavis.controllers')
    .controller('registerCtrl', function($scope, $mdDialog,$timeout, $mdSidenav,$http,$location,DatavisServices) {

        $scope.a = false;

        $scope.register = function() {

            $scope.a = true;


            DatavisServices.registerServices( $scope.userName, $scope.password, $scope.confirmPassword, $scope.email, $scope.country, $scope.question1, $scope.question2, $scope.role)
                .then(registerPrint)
                .catch(registerError)




        };
        function registerPrint (message) {
            if(message.get("register")){
                $scope.userName='';
                $scope.password='';
                $scope.confirmPassword='';
                $scope.email='';
                $scope.country='';
                $scope.question1='';
                $scope.question2='';
                $scope.role='';

                scope.$apply(function() { $location.path("/"); });

            }else {
                alert("Registration faild");
                $scope.userName='';
                $scope.password='';
                $scope.confirmPassword='';
                $scope.email='';
                $scope.country='';
                $scope.question1='';
                $scope.question2='';
                $scope.role='';

                scope.$apply(function() { $location.path("/register"); });
            }

        }

        function registerError (errorMessage) {
            alert("Has an error");
        }

        /*$scope.submit = function () {
         console.log('test submit');
         }*/

    })


