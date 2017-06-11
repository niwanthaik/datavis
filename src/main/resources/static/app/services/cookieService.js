/**
 * Created by charith on 3/18/17.
 */
/**
 * Created by niwantha on 3/17/17.
 */
angular.module("datavis.services")
    .factory('cookieServices', ['$cookies', cookieService]);
function cookieService($cookies) {

    return {
        cookieService: cookieService
    };

    function cookieService() {

        $scope.userData = $cookies.get('userData');
        console.log('$scope.userData', $scope.userData);

    return $scope.userData;
    }
}