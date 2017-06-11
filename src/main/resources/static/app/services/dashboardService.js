/**
 * Created by charith on 3/17/17.
 */
angular.module("datavis.services")
    .factory('DatavisServices4',['$http','$q',DatavisServices4]);
function DatavisServices4($http,$q) {

    return {
        dashboardServices: dashboardServices
    };


    function dashboardServices(dateFrom, dateTo, parameter1, parameter2, country, cabinClass, graphType) {
        var deferred = $q.defer();

        var postObject = new Object();
        postObject.dateFrom = dateFrom,
        postObject.dateTo = dateTo,
        postObject.parameter1 = parameter1,
        postObject.parameter2 = parameter2,
        postObject.country = country,
        postObject.cabinClass = cabinClass,
        postObject.graphType = graphType

        console.log(postObject);

        var deferred = $q.defer();

        $http
            .post('http://localhost:8080/api/setting', {
                dateFrom: dateFrom,
                dateTo: dateTo,
                parameter1: parameter1,
                parameter2: parameter2,
                country: country,
                cabinClass: cabinClass,
                graphType: graphType
            })
            .then(function (_data) {
                deferred.resolve(_data.data)
            }, function (_error) {
                deferred.reject(_error);
            });
        return deferred.promise;


    }
}
