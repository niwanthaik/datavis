angular .module('datavis.controllers')
    .controller('dashboardCtrl', function($scope, $mdDialog,$timeout, $mdSidenav,$http,$location,DatavisServices) {

        $scope.toggleLeft = buildToggler('left');
        $scope.toggleRight = buildToggler('right');

        function buildToggler(componentId) {
            return function() {
                $mdSidenav(componentId).toggle();
            }
        };

        $scope.a = false;

        $scope.settings = function() {

            $scope.a = true;


            DatavisServices.dashboardServices( $scope.dateFrom, $scope.dateTo, $scope.parameter1, $scope.parameter2, $scope.country, $scope.cabinClass, $scope.graphType)
                .then(settingsPrint)
                .catch(settingsError)




        };
        function settingsPrint (message) {
            if(message.get("valid")){
                $scope.dateFrom='';
                $scope.dateTo='';
                $scope.parameter1='';
                $scope.parameter2='';
                $scope.country='';
                $scope.cabinClass='';
                $scope.graphType='';
                scope.$apply(function() { $location.path("/dashboard"); });

            }else {
                alert("Incorrect user name or password");
                $scope.dateFrom='';
                $scope.dateTo='';
                $scope.parameter1='';
                $scope.parameter2='';
                $scope.country='';
                $scope.cabinClass='';
                $scope.graphType='';
                scope.$apply(function() { $location.path("/dashboard"); });
            }

        }

        function settingsError (errorMessage) {
            alert("Has an error");
        }

        /*$scope.submit = function () {
         console.log('test submit');
         }*/

    })



