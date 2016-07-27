'use strict';

angular.module('app').controller('PessoaController', 
['$http', '$rootScope', '$scope', 'PessoaService', 'toastr', 'toastrConfig', '$uibModal' , 'TipoPessoaService', 'SecurityService',
function ($http, $rootScope, $scope, PessoaService,toastr, toastrConfig, $uibModal,TipoPessoaService, SecurityService) {


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
    $scope.pode_add=SecurityService.getPermissao('pessoa.insert');
    $scope.pode_edi=SecurityService.getPermissao('pessoa.update');
    $scope.pode_del=SecurityService.getPermissao('pessoa.delete');
    $scope.pode_con=SecurityService.getPermissao('pessoa.select');
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
		}, 
        
        
        {
				field: 'nome',
				displayName: 'Nome',
				enableColumnMenu: false
			},
        
        {
				field: 'documento',
				displayName: 'Documento',
				enableColumnMenu: true
	     },
             
            
            
            {				 
				field: 'telefone',
				displayName: 'Telefone',
				enableColumnMenu: false
			},
            
            {				 
				field: 'email',
				displayName: 'Email',
				enableColumnMenu: false
			},
            
            {			 
				field: 'situacao',
				displayName: 'Situação',
				enableColumnMenu: false
			}, {  field:'id' , displayName:'Ação',
 	               cellTemplate:
					'<div class="ui-grid-cell-contents " ng-controller="PessoaController"> ' +
                    
                 	'<a class="btn  btn-primary btn-xs" ng-click="grid.appScope.crud( \'con\', row.entity  )" href="#"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a> &nbsp;'+
					'<a class="btn  btn-warning btn-xs" ng-click="grid.appScope.crud( \'edi\', row.entity  )" href="#"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a> &nbsp;'+
					'<a class="btn  btn-danger  btn-xs" ng-click="grid.appScope.crud( \'del\', row.entity  )" href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>'+	
   
                     
                    '</div>', width: 100, enableColumnMenu: false, enableSorting: false, enableFiltering:false
		}

		]
	};



/*
'<div class="btn-group">'+
'<button type="button" class="btn btn-default" ng-click="grid.appScope.crud( \'adi\', row.entity  )">Visualizar</button>'+
'<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">'+
    '<span class="caret"></span>'+
    '<span class="sr-only">Toggle Dropdown</span>'+
'</button>'+
'<ul class="dropdown-menu" role="menu">'+
    '<li role="menuitem" ng-click="grid.appScope.crud( \'adi\', row.entity  )">Adicionar</li>'+
    '<li role="menuitem" ng-click="grid.appScope.crud( \'edi\', row.entity  )">Editar</li>'+
    '<li role="menuitem" ng-click="grid.appScope.crud( \'del\', row.entity  )">Deletar</li>'+
    '<li class="divider"></li>'+
    '<li role="menuitem">Histórico de compras</li>'+
'</ul>'+
'</div>'+
*/

  
/**
 * INICIAR MODELO
 * 
 *  
 */ 
 $scope.iniciarModelo = function(){
        $scope.pessoa = {sexo:'MASCULINO', tipoPessoa:'FISICA',credito:'NAO',situacao:'ATIVA', 
        roles:[{pessoaRole:'CLIENTE'},{pessoaRole:'FORNECEDOR'},{pessoaRole:'FUNCIONARIO'}], cadastro: new Date().toUTCString()   }; //new Date().toLocaleDateString() 
 }
 
 
/**
 * LIMPAR FILTRO
 * 
 *  
 */
 $scope.limparFiltro = function() {
     $scope.listaSituacao =[ 'ATIVA', 'INATIVA' ,  'BLOQUEADA', 'TODOS' ];
     $scope.listaTipo =[ 'FISICA', 'JURIDICA',  'TODOS' ];
     $scope.listaRole = [ 'CLIENTE', 'FORNECEDOR', 'FUNCIONARIO', 'TRANSPORTADOR', 'BANCO', 'TODOS' ];     
	 $scope.filtro = { nome: '', codigo: '', situacao: 'ATIVA', role:'CLIENTE', tipo:'FISICA' };
     if ($scope.gridOptions.data ){ $scope.gridOptions.data = [];}
 }
 
 
 /**
  * LIMPAR FILTRO - AO INICIAR
  * 
  *  
  */
 $scope.limparFiltro();


 /**
  * FILTRAR
  * 
  *  
  */
 $scope.filtrar = function() {

     $scope.filtroWrapper = { filtros: [] };
     
      if ($scope.filtro.documento ){ $scope.filtroWrapper.filtros.push({ 'parametro': 'documento', 'valor': $scope.filtro.documento, 'operador': 'igual' }); }
      if ($scope.filtro.nome) { $scope.filtroWrapper.filtros.push({ 'parametro': 'nome', 'valor': $scope.filtro.nome + '%', 'operador': 'like' }); }
      if ($scope.filtro.role !== 'TODOS') { $scope.filtroWrapper.filtros.push({ 'parametro': 'roles.pessoaRole', 'valor': $scope.filtro.role , 'operador': 'innerJoin',join:'roles' }); }
      if ($scope.filtro.tipo !== 'TODOS') { $scope.filtroWrapper.filtros.push({ 'parametro': 'tipoPessoa', 'valor': $scope.filtro.tipo , 'operador': 'igual' }); }
      if ($scope.filtro.situacao !== 'TODOS' ) { $scope.filtroWrapper.filtros.push({ 'parametro': 'situacao', 'valor': $scope.filtro.situacao, 'operador': 'igual' }); }

     PessoaService.getFilter($scope.filtroWrapper)
         .success(function(data) {

             $scope.gridOptions.data = data;

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
	};
    
    
 /**
 * CRUD
 * 
 *  
 */
 $scope.crud = function(modoEdicao, registro) {
    
     if (modoEdicao == "add") {
         $scope.modoEdicao = 'add';
         $scope.iniciarModelo();
     } else if (modoEdicao == "edi") {
         $scope.modoEdicao = 'edi';
         $scope.pessoa= angular.copy(registro); //_.clone(registro);
     } else if (modoEdicao == "del") {
         $scope.modoEdicao = 'del';
         $scope.pessoa={};
         angular.copy(registro, $scope.pessoa);  
     } else {
         $scope.modoEdicao = 'con';
          $scope.pessoa={};
         angular.copy(registro, $scope.pessoa); 
     }

     var modalInstance = $uibModal.open({
         keyboard :false,
         backdrop :false,
         animation: true,
         templateUrl: '/app/pessoa/pessoa-modal.html',
         controller: 'PessoaModalController',
         scope: $scope,
         size: 'lg'
     });

     modalInstance.result.then(function(pessoa) {
         
         $scope.pessoa = pessoa;
         $scope.modoEdicao
         if ($scope.modoEdicao == "del"){
              PessoaService.delete(pessoa.id)
              .success(function(data, status) {
                        $scope.atualizarGrid(registro,registro);
              })
              .error(function(data, status, headers, config) {
                        $scope.mensagemErroCrud(data, status);
              });
             
         }else if ( $scope.modoEdicao == "add" )  {
              PessoaService.insert(pessoa)
              .success(function(data, status) {
                        $scope.atualizarGrid(registro,data);
              })
              .error(function(data, status, headers, config) {
                        $scope.mensagemErroCrud(data, status);
              });
         }else if ( $scope.modoEdicao == "edi" )  {
              PessoaService.insert(pessoa)
              .success(function(data, status) {
                        $scope.atualizarGrid(registro,data);
              })
              .error(function(data, status, headers, config) {
                        $scope.mensagemErroCrud(data, status);
              });
         }
        

     }, function() {
         //console.info('Modal fechado: ' + new Date());
     });
 }; 

    
/**
 * ATUALIZAR GRID APOS CRUD
 * 
 *  
 */     
 $scope.atualizarGrid = function(anterior, novo){       
    if ( $scope.modoEdicao == 'add' ){
        toastr.info('', 'Adicionado com sucesso!');
        $scope.gridOptions.data.push(novo);        
    }if ( $scope.modoEdicao == 'edi' ){         
        var i = $scope.gridOptions.data.indexOf(anterior);
        if ( i >=0 ){  $scope.gridOptions.data[i]= novo; 
            toastr.info('', 'Editado com sucesso!'); }
    }if ( $scope.modoEdicao == 'del' ){
        var i = $scope.gridOptions.data.indexOf(anterior);
        if ( i >=0 ){ $scope.gridOptions.data.splice( i, 1); 
            toastr.info('', 'Deletado com sucesso!');}
    } 

};  


/**
 * MENSAGEM ERRO CRUD
 * 
 *  
 */     
 $scope.mensagemErroCrud = function(data, status){
        
    if ( $scope.modoEdicao === 'add' ){        
        toastr.error('Erro ao adicionar Pessoa.', 'Problemas com o servidor.');
    }if ( $scope.modoEdicao === 'edi' ){
         toastr.error('Erro ao Editar Pessoa.', 'Problemas com o servidor.');  
    }if ( $scope.modoEdicao === 'del' ){
         toastr.error('Erro ao Deletar Pessoa.', 'Problemas com o servidor.'); 
    } 

};  

/**
 * MOSTRAR MODO DE EDICAO
 * 
 *  
 */ 
$scope.viewModoEdicao = function(){
    
    if ( $scope.modoEdicao == "add") { return "Adicionar"; }
    else if ( $scope.modoEdicao == "edi") { return "Editar"; }
    else if ( $scope.modoEdicao == "del") { return "Deletar"; }
    else {return "Consultar"; }
} 


/**
 * LISTAR GRID
 * 
 *  
 */ 



}]);