'use strict';

angular.module('app').controller( 'LoginController', 
		['$rootScope','$scope','$http' , 'toastr','toastrConfig','$state', 'LoginService','$location', '$localStorage',
 function ($rootScope, $scope,  $http 	, toastr , toastrConfig,  $state, LoginService, $location, $localStorage ) {

/**
 * INICIAL MODEL
 * 
 *  
 */
$scope.user = {};
$scope.listaFilial=['MATRIZ'];
$scope.filial='MATRIZ';


/**
 * LOGIN
 * 
 *  
 */
$scope.login = function(){

    LoginService.autenticarToken( $scope.user )
    .success( function(data){
        
        $localStorage.sessao = data;
        $state.go('dash');
        toastr.success(   '', 'Bem-vindo! '+	data.user.nome );

    })
    .error(function(data){
        $localStorage.sessao = {};
        toastr.error( 'Teste novamente!','Usuário ou senha não cadastrada!');
    });
    
};
	
}]);