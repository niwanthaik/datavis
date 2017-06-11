/**
 * Created by asiri on 3/18/17.
 */
angular.module("datavis.services")
    .factory('fileUpload', ['$http', fileUpload]);

   function fileUpload($http) {
       this.uploadFileToUrl = function(file, uploadUrl){
           var fd = new FormData();
           fd.append('file', file);

           $http.post(uploadUrl, fd, {
               transformRequest: angular.identity,
               headers: {'Content-Type': undefined}
           })

               .success(function(){

               })

               .error(function(){
               });
       }
   }

