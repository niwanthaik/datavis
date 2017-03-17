/**
 * Created by charith on 3/17/17.
 */
angular.module("datavis.services")
    .factory('DatavisServicesss',['$http','$q',DatavisServicesss]);
function DatavisServicesss($http,$q) {

    return {
        dashboardServices: dashboardServices
    };


    function dashboardServices(dateFrom, dateTo, parameter1, parameter2, country, cabinClass, graphType) {
        var deffer = $q.defer()

        var postObject = new Object();
        postObject.dateFrom = dateFrom;
        postObject.dateTo = dateTo;
        postObject.parameter1 = parameter1;
        postObject.parameter2 = parameter2;
        postObject.country = country;
        postObject.cabinClass = cabinClass;
        postObject.graphType = graphType;

        $http({
            url: 'http://localhost:8080/dashboard',
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
