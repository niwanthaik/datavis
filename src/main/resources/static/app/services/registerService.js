/**
 * Created by charith on 3/17/17.
 */
angular.module("datavis.services")
    .factory('DatavisServicess', ['$http', '$q', DatavisServicess]);
function DatavisServicess($http,$q) {

    return {
        registerServices: registerServices
    };


    function registerServices(userName, password, confirmPassword, email, country, question1, question2, role) {
        var deffer = $q.defer()

        var postObject = new Object();
        postObject.userName = userName;
        postObject.password = password;
        postObject.confirmPassword = confirmPassword;
        postObject.email = email;
        postObject.country = country;
        postObject.question1 = question1;
        postObject.question2 = question2;
        postObject.role = role;

        $http({
            url: 'http://localhost:8080/register',
            dataType: 'json',
            method: 'POST',
            data: postObject,
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then(function (data) {
                console.log(JSON.stringify(data));
                deffer.resolve(data)
            }, function (error) {
                deffer.reject(error)
            });
        return deffer.promise


    }
}
