'use strict';

angular.module('app').factory('LoginService', [
'$http','SERVER_BASE',
function($http,SERVER_BASE) {
 
    var urlBase = SERVER_BASE;  

    var dataFactory = {};
   
    dataFactory.autenticarUsuario = function (obj) {
        return $http.post(urlBase + '/autenticarUsuario', obj);
    };
    
    dataFactory.autenticarToken = function (obj) {
        return $http.post(urlBase + '/autenticarToken', obj);
    };
    
    dataFactory.autenticarUsuarioFuncionalidade = function (obj) {
        return $http.post(urlBase + '/autenticarUsuarioFuncionalidade', obj);
    };
 
    dataFactory.info = function (obj) {
        return $http.post(urlBase + '/info', obj)
    };
 
    dataFactory.info = function () {
        return $http.get(urlBase + '/whoami')
    };
    
    return dataFactory;
}]);
