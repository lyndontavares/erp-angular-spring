'use strict';

angular.module('app').controller('PedidoController', 
['$http', '$rootScope', '$scope', 'toastr', 'toastrConfig', '$uibModal' ,  'SecurityService',
function ($http, $rootScope, $scope,  toastr, toastrConfig, $uibModal, SecurityService) {


/**
 * SEGURANÇA
 * 
 *  
 */
 $http.defaults.headers.common.Authorization = $rootScope.token;
 
 /**
 * PERMISSOES
 * 
 *  
 */
 $scope.checarPermissoes = function(){
    $scope.pode_add=SecurityService.getPermissao('usuario.insert');
    $scope.pode_edi=SecurityService.getPermissao('usuario.update');
    $scope.pode_del=SecurityService.getPermissao('usuario.delete');
 }
 $scope.checarPermissoes();
 
 
 
/**
 * CONFIGURAR GRID
 * 
 * 
 */
 $scope.gridOptions = {

        enableHorizontalScrollbar: 0,
		enableFiltering: false,
		enablePaginationControls: true,
		enableGridMenu: false,
		paginationPageSize: 8,
		paginationPageSizes: [8, 16, 32],
		columnDefs: [{
			name: 'id',
			field: 'id',
			displayName: 'Código',
			width: "10%",
			enableColumnMenu: false
		}, {
				field: 'login',
				displayName: 'login',
				enableColumnMenu: false
			}, 
            
            {				 
				field: 'nome',
				displayName: 'nome',
				enableColumnMenu: false
			},
            
            {				 
				field: 'situacao',
				displayName: 'situacao',
				enableColumnMenu: false
			},
            
            {  field:'id' , displayName:'Ação',
 	               cellTemplate:
					'<div class="ui-grid-cell-contents pull-right" ng-controller="PessoaController"> ' +
					'<a class="btn  btn-primary btn-xs" ng-click="grid.appScope.crud( \'con\', row.entity  )" href="#"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a> &nbsp;'+
					'<a class="btn  btn-warning btn-xs" ng-click="grid.appScope.crud( \'edi\', row.entity  )" href="#"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a> &nbsp;'+
					'<a class="btn  btn-danger  btn-xs" ng-click="grid.appScope.crud( \'del\', row.entity  )" href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>'+	
                    '</div>', width: 100, enableColumnMenu: false, enableSorting: false, enableFiltering:false
		}

		]
	};

  
/**
 * INICIAR MODELO
 * 
 *  
 */ 
 $scope.iniciarModelo = function(){
    $scope.model = {};  
 }
 
 
/**
 * LIMPAR FILTRO
 * 
 *  
 */
 $scope.limparFiltro = function() {
     if ($scope.gridOptions.data ){ $scope.gridOptions.data = [];}
 }
 
 
 /**
  * LIMPAR FILTRO - AO INICIAR
  * 
  *  
  */
 $scope.limparFiltro();

 

}]);