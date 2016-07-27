'use strict';

angular.module('app').controller('DashController', 
['$http', '$scope',  '$rootScope' ,'PessoaService', 'toastr', 'toastrConfig', '$uibModal' , 'TipoPessoaService', 'SecurityService','$state','$localStorage',
function ($http, $scope, $rootScope, PessoaService,toastr, toastrConfig, $uibModal,TipoPessoaService,SecurityService,$state, $localStorage) {
   
  
/**
 * SESSAO USUARIO VALIDA
 * 
 *  
 */
 SecurityService.sessaoValida();   


/**
 * SEGURANÇA TOKEN
 * 
 *  
 */
 $http.defaults.headers.common.Authorization = $rootScope.token;
 
 
/**
 * PERMISSOES DO USUARIO
 * 
 *  
 */
 $scope.checarPermissoes = function(){
    $scope.pode_pessoa=SecurityService.getPermissao('pessoa.select');
    $scope.pode_fatura=SecurityService.getPermissao('fatura.select');
    $scope.pode_pedido=SecurityService.getPermissao('pedido.select');
    $scope.pode_catalogo=SecurityService.getPermissao('catalogo.select');
    $scope.pode_estoque=SecurityService.getPermissao('estoque.select');
    $scope.pode_financeiro=SecurityService.getPermissao('financeiro.select');
    $scope.pode_usuario=SecurityService.getPermissao('gerenciar.usuario');
    $scope.pode_configuracao=SecurityService.getPermissao('gerenciar.configuracao');
    $scope.pode_aprovacao=SecurityService.getPermissao('gerenciar.aprovacao');
    $scope.pode_auditoria=SecurityService.getPermissao('gerenciar.auditoria');
 }
 $scope.checarPermissoes();
   
   
/**
 * INFO USUARIO
 * 
 *  
 */   
 $scope.user = SecurityService.getUser();
 
 
 /**
 * INFO EMPRESA
 * 
 *  
 */   
 $scope.empresa = SecurityService.getEmpresa();   
 
     
/**
 * INFO TOTAL CLIENTES
 * 
 *  
 */   
 $scope.getTotalClientes = function(){
     PessoaService.getTotal()
      .success(function(data, status) {
          $scope.totalClientes=data;
      })
 }
 $scope.getTotalClientes();
 
    
}]);