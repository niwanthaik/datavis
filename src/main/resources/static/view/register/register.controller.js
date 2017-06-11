angular .module('datavis.controllers')
    .controller('registerCtrl', function($scope, $mdDialog,$timeout, $mdSidenav,$http,$location,DatavisServices2) {

        $scope.a = false;

        $scope.register = function() {

            $scope.a = true;


            DatavisServices2.registerServices( $scope.userName, $scope.password, $scope.confirmPassword, $scope.email, $scope.country, $scope.question1, $scope.question2, $scope.role)
                .then(registerPrint)
                .catch(registerError)


        };

        function registerPrint (message) {
            if(message){
                console.log("message",message);

                $scope.userName='';
                $scope.password='';
                $scope.confirmPassword='';
                $scope.email='';
                $scope.country='';
                $scope.question1='';
                $scope.question2='';
                $scope.role='';

                $location.path("/");
                $mdDialog.hide();


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

                $location.path("/");
            }

        }

        function registerError (errorMessage) {
            alert("Has an error");
        }

        $scope.loginPage=function(){
            $mdDialog.show({
                templateUrl:'view/login/login.html',
                clickOutsideToClose:true
            })
        }

        /*$scope.submit = function () {
         console.log('test submit');
         }*/

    })


