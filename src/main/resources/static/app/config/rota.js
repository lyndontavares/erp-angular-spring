'use strict';

angular.module('app').config(['$stateProvider', '$urlRouterProvider', function($r, $t) {

    $t.when('/dash', '/dash/over');

    $t.otherwise('/login'),

        $r.state('base', {
            'abstract': !0,
            url: '',
            templateUrl: '/app/dash/base.html'
        }).state('login', {
            url: '/login',
            parent: 'base',
            templateUrl: '/app/login/login.html',
            controller: 'LoginController'
        }).state('dash', {
            url: '/dash',
            parent: 'base',
            templateUrl: '/app/dash/dash.html',
            controller: 'DashController'
        }).state('over', {
            url: '/over',
            parent: 'dash',
            templateUrl: '/app/dash/over.html',
            controller: 'OverController'
        }).state('pessoa', {
            url: '/pessoa',
            parent: 'dash',
            templateUrl: '/app/pessoa/pessoa.html',
            controller: 'PessoaController'
        }).state('fac-invoice', {
            url: '/fac-invoice',
            parent: 'dash',
            templateUrl: '/app/fatura/fac-invoice.html',
            controller: 'FaturaController'
        }).state('pedido', {
            url: '/pedido',
            parent: 'dash',
            templateUrl: '/app/pedido/pedido.html',
            controller: 'PedidoController'
        }).state('catalogo', {
            url: '/catalogo',
            parent: 'dash',
            templateUrl: '/app/produto/catalogo.html',
            controller: 'CatalogoController'
        }).state('usuario', {
            url: '/usuario',
            parent: 'dash',
            templateUrl: '/app/usuario/usuario.html',
            controller: 'UsuarioController'
        }).state('setup', {
            url: '/setup',
            parent: 'dash',
            templateUrl: '/app/setup/setup.html',
            controller: 'SetupController'
        }).state('financeiro', {
            url: '/financeiro',
            parent: 'dash',
            templateUrl: '/app/financeiro/financeiro.html',
            controller: 'FinanceiroController'
        }).state('fatura', {
            url: '/fatura',
            parent: 'dash',
            templateUrl: '/app/fatura/fatura.html',
            controller: 'FaturaController'
        }).state('profile', {
            url: '/profile',
            parent: 'dash',
            templateUrl: '/app/profile/profile.html',
            controller: 'ProfileController'
        })

        ;




/*

.state('wiz', {
            url: '/wiz',
            parent: 'dash',
            templateUrl: '/app/fatura/wizard.html'
        }).state('wiz0', {
            url: '/wiz0',
            parent: 'wiz',
            templateUrl: '/app/fatura/w0.fatura.html',
            controller: 'FaturaController'
        }).state('wiz1', {
            url: '/wiz1',
            parent: 'wiz',
            templateUrl: '/app/fatura/w1.fatura.html',
            controller: 'FaturaController'
        }).state('wiz2', {
            url: '/wiz2',
            parent: 'wiz',
            templateUrl: '/app/fatura/w2.fatura.html',
            controller: 'FaturaController'
        }).state('wiz3', {
            url: '/wiz3',
            parent: 'wiz',
            templateUrl: '/app/fatura/w3.fatura.html',
            controller: 'FaturaController'
        }).state('wiz4', {
            url: '/wiz4',
            parent: 'wiz',
            templateUrl: '/app/fatura/w4.fatura.html',
            controller: 'FaturaController'
        }).state('wiz5', {
            url: '/wiz5',
            parent: 'wiz',
            templateUrl: '/app/fatura/w5.fatura.html',
            controller: 'FaturaController'
        }).state('fatura', {
            url: '/fatura',
            parent: 'dash',
            templateUrl: '/app/fatura/fatura.html',
            controller: 'FaturaController'
        })

 */

}]);