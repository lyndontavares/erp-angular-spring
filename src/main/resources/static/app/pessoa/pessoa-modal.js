'use strict';
angular.module('app').controller('PessoaModalController',
    ['$http', '$scope', 'PessoaService', 'toastr', 'toastrConfig', '$uibModalInstance',
        function($http, $scope, PessoaService,  toastr, toastrConfig, $uibModalInstance) {

            $scope.tipoPessoa = [ 'FISICA' , 'JURIDICA' ];            
            $scope.tipoSituacao = [ 'ATIVA' , 'INATIVA' ,  'BLOQUEADA' ];
            $scope.tipoSexo = [ 'MASCULINO' , 'FEMININO' ];     
            $scope.tipoRole = [ {pessoaRole:'CLIENTE'} , {pessoaRole:'FORNECEDOR'},{pessoaRole:'FUNCIONARIO'},{pessoaRole:'TRANSPORTADOR'},{pessoaRole:'BANCO'} ];       
            $scope.tipoSimNao = [ 'SIM' , 'NAO' ];
 
            $scope.ok = function() {

                if ( ! $scope.pessoa.nome ) {
                    toastr.error(
                        'Informe corretamente o campo nome.','Campo Nome obrigatório.'
                    );
                }
                else if ( ! $scope.pessoa.situacao ) {
                    toastr.error(
                        'Informe corretamente o campo Situação.','Campo Situação obrigatório.'
                    );
                }
                else if ( ! $scope.pessoa.sexo ) {
                    toastr.error(
                        'Informe corretamente o campo Sexo.','Campo Sexo obrigatório.'
                    );
                }
                else {
                    $uibModalInstance.close($scope.pessoa);
                }

            };

            $scope.cancel = function() {
                $uibModalInstance.dismiss('cancel');
            };


        }]);