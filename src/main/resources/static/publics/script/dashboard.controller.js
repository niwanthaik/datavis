angular .module('MyApp')
	.controller('dashboardCtrl', function($scope, $mdDialog,$timeout, $mdSidenav,$http,$location) {

    $scope.chartSettings =[];
    $scope.a = false;

    $scope.register = function(){
        $scope.chartSettings.push({ 'dateFrom':$scope.dateFrom,
			'dateTo':$scope.dateTo,
			'parameter1':$scope.parameter1,
			'parameter2':$scope.parameter2,
			'country':$scope.country,
			'cabinClass':$scope.cabinClass,
			'graphType':$scope.graphType 
	});

        var dataObj = {
		dateFrom : $scope.dateFrom,
		dateTo : $scope.dateTo,
		parameter1 : $scope.parameter1,
		parameter2 : $scope.parameter2,
		country  :$scope.country,
		cabinClass : $scope.cabinClass,
		graphType : $scope.graphType
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

        $scope.dateFrom='';
        $scope.dateTo='';
        $scope.parameter1='';
        $scope.parameter2='';
        $scope.country='';
	$scope.cabinClass='';
	$scope.graphType='';

    };

    $scope.submit = function () {
        console.log('test submit');
    }

  $scope.toggleLeft = buildToggler('left');
    $scope.toggleRight = buildToggler('right');

    function buildToggler(componentId) {
      return function() {
        $mdSidenav(componentId).toggle();
      }
    }

});
