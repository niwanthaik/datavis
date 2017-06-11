angular .module('datavis.controllers')
	.controller('loginCtrl', function($scope, $mdDialog,$timeout,$rootScope, $mdSidenav,$http,$location,DatavisServices,$cookies) {

    $scope.a = false;

    $scope.login = function() {
        $scope.a = true;
        DatavisServices.loginServices( $scope.userName, $scope.password)
            .then(loginPrint)
            .catch(loginError)
    };
        function loginPrint (message) {
            if(message){
                // $cookies.put('userData', 'Authenticated');
                // $scope.userData = $cookies.get('userData');
                // console.log( $scope.userData);
                console.log("message",message);
                if(message.rol=="Role_Admin"){
                    $rootScope.val=true;
                }else {
                    $rootScope.val=false;
                }


                $scope.userName='';
                $scope.password='';
                $location.path("/dashboard");
                $mdDialog.hide();

            }else {

                alert("Incorrect user name or password");
                $scope.userName='';
                $scope.password='';
                $location.path("/");
            }

        }

        function loginError (errorMessage) {
            alert("Has an error");
        }
        
        $scope.registerDialog=function (){
            $mdDialog.show({
                templateUrl:'view/register/register.html',
                clickOutsideToClose:true
            });
            $mdDialog.hide();
        };

        $scope.forgotDialog=function (){
            $mdDialog.show({
                templateUrl:'view/forgot/forgot.html',
                clickOutsideToClose:true
            });
            $mdDialog.hide();
        };


    /*$scope.submit = function () {
        console.log('test submit');
    }*/
$scope.logout= function(){
    // console.log(44444444444444444);
    // $cookies.remove("userData'");
    // $scope.userData = $cookies.get('userData');
    // console.log(1111111,$scope.userData );
}
})
