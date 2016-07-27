'use strict';

angular.module('app').factory('PessoaService', [
'$http','SERVER_BASE',
function($http,SERVER_BASE) {

    //expect(MOVIE_TITLE).toEqual('http://localhost:5000/');//http://localhost:3000/#/dash/pessoa

    var urlBase = SERVER_BASE +'api/pessoa'; //SERVER_BASE

    var dataFactory = {};

    dataFactory.getFilter = function (obj) {
        return $http.post(urlBase+'/filtro',obj);
    };

    dataFactory.getAll = function () {
        return $http.get(urlBase);
    };
    
     dataFactory.getTotal = function () {
        return $http.get(urlBase+'/total');
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

    return dataFactory;
}]);
