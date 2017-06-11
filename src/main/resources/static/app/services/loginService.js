/**
 * Created by niwantha on 3/17/17.
 */
angular.module("datavis.services", [])
    .factory('DatavisServices', ['$http', '$q', DatavisServices]);
function DatavisServices($http, $q) {

    return {
        loginServices: loginServices
    };
    
        function loginServices(userName, password) {
            var deferred = $q.defer();

            var postObject = new Object();
            postObject.userName = userName,
                postObject.password = password
            var deferred = $q.defer();
            console.log(postObject);

            if(userName!=null && password!=null) {
                $http
                    .post('http://localhost:8080/apidata/login', {
                        userName: userName,
                        password: password
                    })
                    .then(function (_data) {
                        deferred.resolve(_data.data)
                    }, function (_error) {
                        deferred.reject(_error);
                    });
            }

            return deferred.promise;

        }
}