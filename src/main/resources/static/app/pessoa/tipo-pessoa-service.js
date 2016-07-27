'use strict';

angular.module('app').service('TipoPessoaService',
function() {
  //this.getAll = [{descricao:'ATIVA'}, {descricao:'INATIVA'}, {descricao:'BLOQUEADA'}];
  this.getAll = [ 'ATIVA' , 'INATIVA' ,  'BLOQUEADA' ];
});