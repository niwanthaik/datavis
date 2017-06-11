angular .module('datavis.controllers')
	.controller('messageCtrl', function($scope, $mdDialog,$timeout, $mdSidenav,$http,$location,DatavisServices,$cookies) {

       $scope.topics = [];
        $scope.unames = [];
        $scope.msgs = [];

        $http
            .get('http://localhost:8080/getall')
            .then(function (data) {
                for( var i = 0, len = data.data.length; i < len; i++){
                    if(data.data[i].userName !=  localStorage.getItem('userName')){
                        $scope.unames.push(data.data[i].userName);

                    }
                }
            }, function (_error) {
                console.log(_error);
            });

        $http
            .get('http://localhost:8080/allmessage')
            .then(function (data) {
                for( var i = 0, len = data.data.length; i < len; i++){
                    var a = data.data[i];
                    $scope.topics.push(a);
                }
                console.log($scope.topics);
            }, function (_error) {
                console.log(_error);
            });
        
        $scope.loadThread = function (a) {
           // console.log("dsad");
            $scope.msgs = [];
            for( var i = 0, len = a.length; i < len; i++){
                $scope.msgs.push(a[i]);
            }
            console.log( $scope.msgs);
            //$scope.apply();
           
        }

        $scope.addMessage = function (topic, img) {
          //  console.log(topic);
          //  console.log(img);

            var settings = {
                "crossDomain": true,
                "url": "http://localhost:8080/save",
                "method": "POST",
                "headers": {
                    "content-type": "application/json",
                    "cache-control": "no-cache",
                },
                "processData": false,
                "data": "  {\"senderName\":\" "+localStorage.getItem('userName')+"\",\n    \"message\": \""+topic+"\",\n    \"imageData\": \""+img+"\",\n    \"receiverName\": \""+$scope.uname+"\",\n    \"discription\": \""+$scope.des+"\"\n  }"
            }

            $.ajax(settings).done(function (response) {
                console.log(response);
                $scope.des = "";
                $scope.apply();
            });
        }
})
