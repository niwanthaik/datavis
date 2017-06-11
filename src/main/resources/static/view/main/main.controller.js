/**
 * Created by charith on 3/18/17.
 */
angular .module('datavis.controllers')
.controller('mainCtrl',function($scope,$mdDialog,cookieServices){
    $scope.loginPage=function(){
        $mdDialog.show({
            templateUrl:'view/login/login.html',
            clickOutsideToClose:true
        })
    };
    $scope.isAuthenticted=function () {
        $scope.data = cookieServices.cookieService;
        console.log(44444,$scope.data)
        return $scope.data;
    }
});