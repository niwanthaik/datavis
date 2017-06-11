/**
 * Created by charith on 3/19/17.
 */
angular.module("datavis.services")
    .factory('DatavisServices3', ['$http', '$q', DatavisServices3]);
function DatavisServices3($http,$q) {

    return {
        forgotServices: forgotServices
    };


    function forgotServices(userName, email, question1, question2) {
        var deferred = $q.defer();

        var postObject = new Object();
            postObject.userName = userName,
            postObject.email = email,
            postObject.question1 = question1,
            postObject.question2 = question2
        var deferred = $q.defer();
        console.log(postObject);

        $http
            .post('http://localhost:8080/forgot', {
                userName: userName,
                email: email,
                question1: question1,
                question2: question2
            })
            .then(function (_data) {
                deferred.resolve(_data.data.validation)
            }, function (_error) {
                deferred.reject(_error);
            });
        return deferred.promise;


    }
}

