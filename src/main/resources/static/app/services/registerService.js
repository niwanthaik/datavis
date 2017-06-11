/**
 * Created by charith on 3/17/17.
 */
angular.module("datavis.services")
    .factory('DatavisServices2', ['$http', '$q', DatavisServices2]);
function DatavisServices2($http,$q) {

    return {
        registerServices: registerServices
    };


    function registerServices(userName, password, confirmPassword, email, country, question1, question2, role) {
        // var deferred = $q.defer();

        var postObject = new Object();
            postObject.userName = userName,
            postObject.password = password,
            postObject.confirmPassword = confirmPassword,
            postObject.email = email,
            postObject.country = country,
            postObject.question1 = question1,
            postObject.question2 = question2,
            postObject.role = role
        var deferred = $q.defer();
        console.log(postObject);

        if(userName!=null && password!=null && confirmPassword!=null && email!=null && country!=null && question1!=null && question2!=null) {
            if(role!=null) {
                if (password == confirmPassword) {
                    $http
                        .post('http://localhost:8080/apidata/register', {
                            userName: userName,
                            password: password,
                            email: email,
                            country: country,
                            question1: question1,
                            question2: question2,
                            rolename: role

                        })
                        .then(function (_data) {
                            deferred.resolve(_data)
                        }, function (_error) {
                            deferred.reject(_error);
                        });
                    return deferred.promise;
                } else {
                    alert("Password confirmation is invalid");
                }
            } else {
                alert("Please select your role");
            }
        }


    }
}
