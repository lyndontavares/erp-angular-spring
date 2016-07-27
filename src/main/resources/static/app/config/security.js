'use strict';

angular.module('app').factory('SecurityService', [
    '$http', '$rootScope', '$localStorage', '$state',
    function($http, $rootScope, $localStorage, $state) {

        var dataFactory = {};

        var sessaoExiste = function() {
            //console.log($localStorage.sessao);
            //console.log(  $localStorage.sessao.token !== undefined);
            return $localStorage.sessao.token !== undefined;
        };

        dataFactory.sessaoValida = function() {
            if ($localStorage.sessao.token == undefined) { $state.go('login'); }
        };

        dataFactory.getPermissao = function(funcionalidade) {
            if (sessaoExiste()) {
                return $localStorage.sessao.permissao;
            } else {
                return '';
            }
        };

        dataFactory.getToken = function() {
            if (sessaoExiste()) {
                return $localStorage.sessao.token;
            } else {
                return '';
            }
        };

        dataFactory.getUser = function() {
            if (sessaoExiste()) {
                return $localStorage.sessao.user;
            } else {
                return '';
            }
        };

        dataFactory.getPessoa = function() {
            if (sessaoExiste()) {
                return $localStorage.sessao.user.pessoa;
            } else {
                return '';
            }
        };

        dataFactory.getConfig = function() {
            if (sessaoExiste()) {
                return $localStorage.sessao.configuracao;
            } else {
                return '';
            }
        };

        dataFactory.getEmpresa = function() {
            if (sessaoExiste()) {
                return $localStorage.sessao.configuracao.empresa;
            } else {
                return '';
            }
        };
        
 

        return dataFactory;
    }]);
