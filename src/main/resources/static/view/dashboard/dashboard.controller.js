angular .module('datavis.controllers')
    .controller('dashboardCtrl', function($scope,Upload, $mdDialog,$timeout, $mdSidenav,$http,$location,$rootScope,DatavisServices4) {

        // $scope.rol= DatavisServices.rol;

        $scope.unames = [];
        $scope.showTool = false;

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

        var canvas = document.getElementById('bardrw'),
            can2 = document.getElementById('bar'),
            can3 = document.getElementById('img123'),
            ctx3 = can3.getContext("2d"),
            ctx = canvas.getContext('2d'),
            circle = {},
            drag = false,
            circleMade = false;

        $scope.sendMessage = function () {
            getImage();
            var settings = {
                "crossDomain": true,
                "url": "http://localhost:8080/save",
                "method": "POST",
                "headers": {
                    "content-type": "application/json",
                    "cache-control": "no-cache",
                },
                "processData": false,
                "data": "  {\"senderName\":\" "+localStorage.getItem('userName')+"\",\n    \"message\": \""+$scope.topic+"\",\n    \"imageData\": \""+$scope.drwimg+"\",\n    \"receiverName\": \""+$scope.uname+"\",\n    \"discription\": \""+$scope.des+"\"\n  }"
            }

            $.ajax(settings).done(function (response) {
                console.log(response);
                $scope.des = '';
                $scope.uname = '';
                $scope.drwimg = '';
                $scope.topic = '';
            });

        }

        function drawCircle() {
            ctx.beginPath();
            ctx.arc(circle.X, circle.Y, circle.radius, 0, 2.0 * Math.PI);
            ctx.stroke();
            ctx.fillStyle = 'rgba(255, 0, 0, 0.5)';
            ctx.fill();

        }

        function mouseDown(e) {
            console.log(e.pageX);
            circle.startX = e.pageX - this.offsetLeft;
            circle.startY = e.pageY - this.offsetTop;

            circle.X = circle.startX;
            circle.Y = circle.startY;

            if (!circleMade) {
                circle.radius = 0;
            }

            drag = true;
        }

        function mouseUp() {
            drag = false;
            circleMade = true;
        }

        function mouseMove(e) {
            if (drag) {
                circle.X = e.pageX - this.offsetLeft;
                circle.Y = e.pageY - this.offsetTop;
                if (!circleMade) {
                    circle.radius = Math.sqrt(Math.pow((circle.X - circle.startX), 2) + Math.pow((circle.Y - circle.startY), 2));
                }
                ctx.clearRect(0, 0, canvas.width, canvas.height);
                drawCircle();


            }
        }

        $scope.clearRec = function () {
            circle = {};
            drag = false;
            circleMade = false;
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            ctx3.clearRect(0, 0, can3.width, can3.height);
        }

        $scope.initDrw = function () {
            canvas.addEventListener('mousedown', mouseDown, false);
            canvas.addEventListener('mouseup', mouseUp, false);
            canvas.addEventListener('mousemove', mouseMove, false);
        }

        $scope.deregDrw = function () {
            clearRec();
            canvas.removeEventListener('mousedown', mouseDown, false);
            canvas.removeEventListener('mouseup', mouseUp, false);
            canvas.removeEventListener('mousemove', mouseMove, false);
        }

        function getImage() {
            var img1 = new Image();
            img1.src = canvas.toDataURL("image/png");
            var img2 = new Image();
            img2.src = can2.toDataURL("image/png");


            ctx3.drawImage(img2, 0, 0);
            ctx3.drawImage(img1, 0, 0);

            var img = new Image();
            img.src = can3.toDataURL("image/png");
            console.log(img.src);
            $scope.drwimg = img.src;
        }



        //  if($rootScope.rol=="Role_Admin"){
        //     $scope.val=true;
        // }else {
        //      $scope.val=false;
        //  };

        $scope.toggleLeft = buildToggler('left');
        $scope.toggleRight = buildToggler('right');
        $scope.graphType={};
        $scope.chartCategory={};
        $scope.dataProcess=[];
        $scope.data = [];


        function buildToggler(componentId) {
            return function() {
                $mdSidenav(componentId).toggle();
            }
        };

        $scope.a = false;

        $scope.settings = function() {

            $scope.a = true;


            DatavisServices4.dashboardServices( $scope.dateFrom, $scope.dateTo, $scope.parameter1, $scope.parameter2, $scope.country, $scope.cabinClass, $scope.graphType)
                .then(settingsPrint)
                .catch(settingsError)
        };
        function settingsPrint (messages) {
	    $scope.showTool = true;
            $scope.labels=[];
            $scope.data1=[];
            $scope.data2=[];
            if(messages){
                console.log("message",messages);
                // $scope.dataProcess=[];
                for(var val in messages){

                    console.log(messages[val]['_id']);
                    $scope.labels.push(messages[val]['_id']);
                    console.log(messages[val]['Y']);
                    // $scope.data2.push(messages[val]['Y']);
                    $scope.data1.push(parseInt(messages[val]['Y']));
                    // $scope.data1.push(parseInt(messages[val]['']));

                }
                $scope.data1.push(0)


                //$scope.labels = ["sdas","xvxvxcvxcv"];
                $scope.series = ['Series A'];

                $scope.onClick = function (points, evt) {
                    console.log(points, evt);
                };
                $scope.datasetOverride = [{ yAxisID: 'y-axis-1' }, { yAxisID: 'y-axis-2' }];
                $scope.options = {
                    scales: {
                        yAxes: [
                            {
                                id: 'y-axis-1',
                                type: 'linear',
                                display: true,
                                position: 'left'
                            },
                            {
                                id: 'y-axis-2',
                                type: 'linear',
                                display: true,
                                position: 'right'
                            }
                        ]
                    }
                };






                $scope.selectChart($scope.dataProcess,$scope.graphType,$scope.dateFrom,$scope.dateTo,$scope.parameter1,$scope.parameter2);
                console.log(7777, $scope.dataProcess);

                //angular.forEach(messages, function(message, key){
                 //  console.log(5555,key + ': ' + value);
               // });
               //  $scope.dateFrom='';
               //  $scope.dateTo='';
               //  $scope.parameter1='';
               //  $scope.parameter2='';
               //  $scope.country='';
               //  $scope.cabinClass='';
               //  $scope.graphType='';

                $location.path("/dashboard");

            }else {
                alert("Incorrect settings");
                $scope.dateFrom='';
                $scope.dateTo='';
                $scope.parameter1='';
                $scope.parameter2='';
                $scope.country='';
                $scope.cabinClass='';
                $scope.graphType='';
                $location.path("/dashboard");
            }

        }

        function settingsError (errorMessage) {
            alert("Has an error");
        }
        $scope.uploadFiles = function(file, errFiles) {
            $scope.f = file;
            $scope.errFile = errFiles && errFiles[0];
            if (file) {
                file.upload = Upload.upload({
                    url: '/api/upload',
                    data: {file: file}
                });

                file.upload.then(function (response) {
                    $timeout(function () {
                        file.result = response.data;
                    });
                }, function (response) {
                    if (response.status > 0)
                        $scope.errorMsg = response.status + ': ' + response.data;
                }, function (evt) {
                    file.progress = Math.min(100, parseInt(100.0 *
                        evt.loaded / evt.total));
                });
            }

        }

        $scope.navigation={

        }

	$scope.chartCategory2=2;

        $scope.selectChart = function(dataProcess,type){
            if(type === 'Bar Chart'){
                $scope.chartCategory1=1;
                $scope.chartCategory2=0;
                $scope.chartCategory3=0;
                $scope.chartCategory4=0;
                $scope.chartCategory5=0;
                // $scope.data = dataProcess;
                // $scope.options = {width: 500, height: 300, 'bar': 'aaa'};
                // $scope.hovered = function(d){
                //     $scope.barValue = d;
                //     $scope.$apply();
                // };
                // $scope.barValue = 'None';
                console.log('bc',$scope.chartCategory1, $scope.data);
            }
            /*else if(type === 'Pie Chart'){
                $scope.chartCategory1=0;
                $scope.chartCategory2=2;
                $scope.chartCategory3=0;
                $scope.chartCategory4=0;
                $scope.chartCategory5=0;
                console.log('pc',$scope.chartCategory2);
            }*/
            else  if(type === 'Bubble Chart'){
                $scope.chartCategory1=0;
                $scope.chartCategory2=0;
                $scope.chartCategory3=3;
                $scope.chartCategory4=0;
                $scope.chartCategory5=0;
                console.log('buc',$scope.chartCategory3);
            }
            else  if(type === 'Line Chart'){
                $scope.chartCategory1=0;
                $scope.chartCategory2=0;
                $scope.chartCategory3=0;
                $scope.chartCategory4=4;
                $scope.chartCategory5=0;
                console.log('Lc',$scope.chartCategory4);
            }
            else  if(type === 'Donut'){
                $scope.chartCategory1=0;
                $scope.chartCategory2=0;
                $scope.chartCategory3=0;
                $scope.chartCategory4=0;
                $scope.chartCategory5=5;
                console.log('Lc',$scope.chartCategory5);
            }
            else{
                $scope.chartCategory=1;
                console.log(00000000,$scope.graphType);
            }
            $scope.chartCategory={};

        }
    });

//




