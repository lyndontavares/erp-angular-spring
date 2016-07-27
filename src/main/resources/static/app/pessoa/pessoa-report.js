'use strict';

angular.module('app').controller('PessoaReportController', 
['$http', '$rootScope', '$scope', 'PessoaService', 'toastr', 'toastrConfig', '$uibModal' , 'TipoPessoaService', 'SecurityService',
function ($http, $rootScope, $scope, PessoaService,toastr, toastrConfig, $uibModal,TipoPessoaService, SecurityService) {


/**
 * SEGURANÇA
 * 
 *  
 */
 $http.defaults.headers.common.Authorization = $rootScope.token;
 
 
 $scope.report = function(){
     
   PessoaService.getFilter($scope.filtroWrapper)
         .success(function(data) {
 
           if (data.length == 0) {
                 toastr.warning(
                     'Verifique os valores informados.',
                     'Nenhum regsitro corresponde ao filtro informado');
             }
             else {
                 toastr.info(
                     '',
                     data.length + ' registro(s) encontrado(s).');
             }

         })
         .error(function(data, status, headers, config) {
             console.log(data);
             toastr.error(
                 'Erro filtrando Pessoa.',
                 'Problemas com o servidor.');

         });
	} 
    
     
 }
 
 
 
 }]);