angular.module('app').service('FileUpload', ['$http', function ($http) {
  this.uploadFileToUrl = function(file, uploadUrl){
 
    var fd = new  FormData();
    
    fd.append('file', file );
    
        fd.append('teste', 111 );


     console.log(fd);     
 
    $http.post(uploadUrl, fd, {
        transformRequest: angular.identity,
        headers: {'Content-Type': undefined}
    })
    .success(function(){
    })
    .error(function(){
    });
  }
}]);


/**
 * 
 * 
 * 
 * 
var formData = new FormData();
//image should be <file-input>.files[0].
formData.append('image', image);

$http.post('/api/blogposts', formData, { 
    headers: {
        'Content-Type': undefined
    },
    transformRequest: angular.identity
}).success(function (result) {}).error(function () {});

 */