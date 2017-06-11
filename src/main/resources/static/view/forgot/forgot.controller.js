angular.module('datavis.controllers')
	.controller('forgotCtrl', function($scope, $mdDialog,$timeout, $mdSidenav,$http,$location,DatavisServices3) {

        $scope.a = false;

        $scope.verify = function() {
            $scope.a = true;
            DatavisServices3.forgotServices( $scope.userName, $scope.email, $scope.question1, $scope.question2)
                .then(forgotPrint)
                .catch(forgotError)
        };
        function forgotPrint (message) {
            if(message){
                console.log("message",message);

                $scope.userName='';
                $scope.email='';
                $scope.question1='';
                $scope.question2='';
                $location.path("/dashboard");
                $mdDialog.hide();

            }else {

                alert("Incorrect details");
                $scope.userName='';
                $scope.email='';
                $scope.question1='';
                $scope.question2='';

                $location.path("/");
            }

        }

        function forgotError (errorMessage) {
            alert("Has an error");
        }

        $scope.registerDialog=function (){
            $mdDialog.show({
                templateUrl:'view/register/register.html',
                clickOutsideToClose:true
            });
            $mdDialog.hide();
        };

        $scope.loginPage=function(){
            $mdDialog.show({
                templateUrl:'view/login/login.html',
                clickOutsideToClose:true
            })
        }

})
