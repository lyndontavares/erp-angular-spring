'use strict';

angular.module('app').controller('NotificacaoController', 
['$http', '$rootScope', '$scope', 'toastr', 'toastrConfig', '$uibModal' , 'SecurityService', 'SERVER_BASE',
function ($http, $rootScope, $scope, toastr, toastrConfig, $uibModal, SecurityService , SERVER_BASE) {

 
  $scope.msg="";

    $scope.addMsg = function(event) {
        $scope.$apply(function () {
            console.log(event.data);
            $scope.msg = event.data;            
        });
    };

    $scope.openMsg = function(event) {
        console.log('open>'+event);
    };

    $scope.stop = function(){
        if ( $scope.eventSource != undefined ){
            $scope.msg='';
            $scope.eventSource.close();
        }   
    };

    $scope.start = function(){
        $scope.eventSource = new EventSource(SERVER_BASE+'notificacao/'+SecurityService.getUser().id);
        $scope.eventSource.addEventListener("message",$scope.addMsg,false);  
        $scope.eventSource.addEventListener("open",$scope.openMsg,false);  
    };
    
    
    }]);