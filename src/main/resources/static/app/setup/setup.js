'use strict';

angular.module('app').controller('SetupController', 
['$http', '$rootScope', '$scope', 'toastr', 'toastrConfig', '$uibModal' ,  'SecurityService', 'SetupService',
function ($http, $rootScope, $scope,  toastr, toastrConfig, $uibModal, SecurityService , SetupService ) {


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
    $scope.pode_add=SecurityService.getPermissao('gerenciar.configuracao');
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
 $scope.switchStatus=false;
 $scope.iniciarModelo = function(){
    $scope.config = {}; 
    $scope.moedas=['DOLAR','GUARANI','PESO','REAL'];
    $scope.horario=['6:00','7:00','8:00','9:00','10:00','11:00','12:00','13:00','14:00','15:00','16:00','17:00','18:00']
 }
 $scope.iniciarModelo();
 
 
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

 /**
  * CARREGAR MODEL
  * 
  *  
  */
  
  SetupService.getAll()
  .success( function( data){
      $scope.config=data;
  });

 /**
  * GRAVAR MODEL
  * 
  *  
  */
  $scope.gravar = function(){
      SetupService.update($scope.config)
      .success(function (data) {
             toastr.info('', 'Gravado com sucesso.');
              toastr.warning('', 'É necessário logar novamente para alterações terem efeito.');
      })
      .error(function(data, status, headers, config) {
          toastr.error('', 'Erro gravando Configuração.');         
       });
  }

}]);