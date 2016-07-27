'use strict';

angular.module('app').factory('FaturaService', [
'$http','SERVER_BASE',
function($http,SERVER_BASE) {

    var urlBase = SERVER_BASE +'api/fatura';  

    var dataFactory = {};

    dataFactory.getFilter = function (obj) {
        return $http.post(urlBase+'/filtro',obj);
    };

    dataFactory.getAll = function () {
        return $http.get(urlBase);
    };

    dataFactory.getId = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    dataFactory.insert = function (obj) {
        return $http.post(urlBase, obj);
    };

    dataFactory.update = function (obj) {
        return $http.put(urlBase + '/' + obj.ID, obj)
    };

    dataFactory.delete = function (id) {
        return $http.delete(urlBase + '/' + id);
    };
    
   
    //itens
    
    dataFactory.insertItem = function (obj) {
        return $http.post(urlBase+'/item', obj);
    };

    dataFactory.updateItem = function (obj) {
        return $http.put(urlBase + '/item/' + obj.ID, obj)
    };

    dataFactory.deleteItem = function (id) {
        return $http.delete(urlBase + '/item/' + id);
    };


    return dataFactory;
}]);
