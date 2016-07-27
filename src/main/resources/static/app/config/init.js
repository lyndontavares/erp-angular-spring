'use strict';

angular.module('app').run(['$rootScope', function ($r) {
       $r.user  = {};
       $r.permissao=[];
       $r.empresa={};
       $r.token ='';
}]);

