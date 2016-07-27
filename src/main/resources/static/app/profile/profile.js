'use strict';

angular.module('app').controller('ProfileController', 
[ '$window', '$http', '$scope',  '$rootScope' ,'PessoaService', 'toastr', 'toastrConfig', '$uibModal' , 'TipoPessoaService', 'SecurityService', 'SERVER_BASE','FileUpload',  '$localStorage',
function ( $window, $http, $scope, $rootScope, PessoaService,toastr, toastrConfig, $uibModal, TipoPessoaService,SecurityService,SERVER_BASE,FileUpload, $localStorage) {
   
    
/**
 * SEGURANÇA
 * 
 *  
 */
 $http.defaults.headers.common.Authorization = $rootScope.token;
 
 
 
 /**
  * MODEL
  * 
  *  
  */
 $scope.profile = SecurityService.getUser();
 $scope.permissao = SecurityService.getPermissao();
 console.log($scope.permissao);
 
 

 $scope.foto = SERVER_BASE + 'api/profile/' + $scope.user.id ; //http://localhost:3000/api/profile/1
 
 
 
 
 /**
  * SELECT FOTO
  * 
  *  
  */
 $scope.selectPhoto = function(contactId) {
     /*if (!$scope.editMode || contactId <= 0) {
         return;
     }*/
     
     document.getElementById('file' + contactId).click();
 };
 
 
 
 /**
  * UPLOAD FOTO
  * 
  *  
  */
 $scope.uploadPhoto = function(fileId) {
     if (!confirm('Confirma upload desta foto?')) {
         return;
     }
 
     
     var file = document.getElementById(fileId).files[0];
    
    
     //console.log($scope.checa());
     
    /*   
    var id =  fileId.substring(4);
     FileUpload.uploadFileToUrl(file , SERVER_BASE+'api/profile/' + id ); */
   
   
    console.log(file);
     
     var formData = new $window.FormData(this);
     formData.append('file', file );
   
   
     console.log('>>>Foto');
     console.log( formData   );
 

     var id =  fileId.substring(4);
     $http.post(SERVER_BASE+'api/profile/' + id, formData, {
             headers: { 
                 'Content-Type': undefined,
             },
             transformRequest: angular.identity,
           })
           .success(function() {
               var img = document.getElementById('img' + id);
               img.src = SERVER_BASE+'api/profile/' + id + '?t=' + new Date().getTime();
          }); 
 };  


$scope.checa =  function supportAjaxUploadWithProgress() {
  return supportFileAPI() && supportAjaxUploadProgressEvents() && supportFormData();

  function supportFileAPI() {
    var fi = document.createElement('INPUT');
    fi.type = 'file';
    return 'files' in fi;
  };

  function supportAjaxUploadProgressEvents() {
    var xhr = new XMLHttpRequest();
    return !! (xhr && ('upload' in xhr) && ('onprogress' in xhr.upload));
  };

  function supportFormData() {
    return !! window.FormData;
  }
}

 
 }]);
 
 
