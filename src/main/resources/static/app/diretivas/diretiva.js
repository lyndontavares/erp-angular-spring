'use strict';

angular.module('app').directive('autoFocus', function() {
    return {
        link: {
            pre: function preLink(scope, element, attr) {
            },
            post: function postLink(scope, element, attr) {
                console.debug('postlink called');
                element[0].focus();
            }
        }
    }
});

angular.module('app').directive('infobox', function () {

	return {
		template:
		'<div class="info-box bg-{{cor}}">' +
		'  <span class="info-box-icon"><i class="fa {{icon}}"></i></span>' +
		'  <div class="info-box-content">' +
		'    <span class="info-box-text">{{titulo}}</span>' +
		'    <span class="info-box-number">{{valor}}</span>' +
		'    <!-- The progress section is optional -->' +
		'    <div class="progress">' +
		'      <div class="progress-bar" style="width: {{progresso}}%"></div>' +
		'    </div>' +
		'    <span class="progress-description">' +
		'      {{descricao}}' +
		'    </span>' +
		'  </div>' +
		'</div>',

		replace: true,
		restrict: "A",
		scope: {
			titulo: "@",
			valor: "@",
			progresso: "@",
			descricao: "@",
			cor: "@",
			icon: "@"

		}

	}

});



angular.module('app').directive('box', function () {
	//<element ng-bind-html="expression"></element>
	//<p ng-bind-html-unsafe="data.markupData"></p>
	return {

		template: '<div class="box box-{{cor}}">' +
		'<div class="box-header with-border">' +
        '<div class="box-tools pull-right">'+
           '  <!--<button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>-->'+
           ' <!--<button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>-->'+
         ' </div>'+
		'<h3 class="box-title">{{titulo}}</h3>' +
		'</div>' +
		'<div class="box-body">' +
		'<div ng-transclude=""></div>' +
		'</div>' +
		'</div>',

		replace: true,
		restrict: "A",
		transclude: true,
		scope: {
			titulo: "@",
			cor: "@"
		}

	}
});



angular.module('app').directive('boxs', function () {
	//<element ng-bind-html="expression"></element>
	//<p ng-bind-html-unsafe="data.markupData"></p>
	return {

		template: '<div class="box box-solid box-{{cor}}">' +
		'<div class="box-header">' +
		'<h3 class="box-title">{{titulo}}</h3>' +
		'</div>' +
		'<div class="box-body">' +
		'<div ng-transclude=""></div>' +
		'</div>',

		replace: true,
		restrict: "A",
		transclude: true,
		scope: {
			titulo: "@",
			cor: "@"
		}

	}
});



angular.module('app').directive('boxx', function () {
	//<element ng-bind-html="expression"></element>
	//<p ng-bind-html-unsafe="data.markupData"></p>
	return {

		template: '<div class="box box-{{cor}}">' +
		'<div class="box-header with-border">' +
		'<h3 class="box-title">{{titulo}}</h3>' +
		'<div class="box-tools pull-right">' +
      		'<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>' +
		'</div>' +
		'</div>' +
		'<div class="box-body">' +
		'<div ng-transclude=""></div>' +
		'</div>' +
		'</div>',

		replace: true,
		restrict: "A",
		transclude: true,
		scope: {
			titulo: "@",
			cor: "@"
		}

	}
});




angular.module('app').directive('boxr', function () {
	//<element ng-bind-html="expression"></element>
	//<p ng-bind-html-unsafe="data.markupData"></p>
	return {

		template: '<div class="box box-{{cor}}">' +
		'<div class="box-header with-border">' +
		'<h3 class="box-title">{{titulo}}</h3>' +
		'<div class="box-tools pull-right">' +
      		'<button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>' +
		'</div>' +
		'</div>' +
		'<div class="box-body">' +
		'<div ng-transclude=""></div>' +
		'</div>' +
		'</div>',

		replace: true,
		restrict: "A",
		transclude: true,
		scope: {
			titulo: "@",
			cor: "@"
		}

	}
});




angular.module('app').directive('boxi', function () {
	//<element ng-bind-html="expression"></element>
	//<p ng-bind-html-unsafe="data.markupData"></p>
	return {

		template: '<div class="box box-{{cor}}">' +
		'<div class="box-header with-border">' +
		'<h3 class="box-title">{{titulo}}</h3>' +
		'<div class="box-tools pull-right">' +
		'<div class="has-feedback">' +
		' <input type="text" class="form-control input-sm" placeholder="Search...">' +
		' <span class="glyphicon glyphicon-search form-control-feedback"></span>' +
      		'</div>' +
		'</div>' +
		'</div>' +
		'<div class="box-body">' +
		'<div ng-transclude=""></div>' +
		'</div>' +
		'</div>',

		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			titulo: "@",
			cor: "@"
		}

	}
});




angular.module('app').directive('dxinput', function () {
	// data-inputmask="&quot;mask&quot;: &quot;{{mask}}&quot;"
	return {

		template: 
		'<div class="form-group">' +
		'<label for="{{id}}" class="col-md-2 control-label">{{titulo}}</label>' +
		'<div class="col-md-10">' +
		'  <input type="{{tipo}}" class="form-control col-sm-10" id="{{id}}" placeholder="{{dica}}" ng-model="modelo" >' +
		'</div>' +
		'</div>',

		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			id:"@",
			titulo: "@",
			tipo:"@",
			dica:"@",
			modelo:"="
		}

	}
});

angular.module('app').directive('dxinputv', function () {

	return {

		template: 
 				'<div class="form-group">'+
                '	<label for="{{id}}">{{titulo}}</label>'+
                '	<input type="{{tipo}}" class="form-control" id="{{id}}" placeholder="{{dica}}" ng-model="modelo" ng-readonly={{readonly}}>'+
                '</div>',

		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			id:"@",
			titulo:"@",
			tipo:"@",
            readonly:"@",
			dica:"@",
			modelo:"="
		}

	}
});
 


			
			
angular.module('app').directive('dxselectx', function () {
			
/*			
			 
	<ol class="nya-bs-select" data-size="8" ng-model="deptosSelecionados" actions-box="true" multiple
		style="width: 100%">
		<li nya-bs-option="option in deptos group by option.filial.nome"><span class="dropdown-header">{{$group}}</span>
			<a>{{ option.nome }} <span class="glyphicon glyphicon-ok check-mark"></span></a></li>
	</ol>
			glyphicon glyphicon-pushpin check-mark 
			
			
			
			data-live-search="true"    
			<span>{{ option.name }}</span> <!-- this content will be search first -->
			<span class="small">{{ option.subtitle }}</span> <!-- if the name failed, this will be used --> 
			
			data-selected-text-format="count>3"
*/			
			
	return {

		template: 
				'<div class="form-group">'+   
				'<label>{{titulo}}</label>'+
				'<div class="select2 select2-container select2-container--default">'+ 
				'<ol class="nya-bs-select"'+ 
				'data-size="10" ng-model="modelo" '+ 
				'actions-box="false" data-live-search="true" multiple style="width: 100%;" data-selected-text-format="count>3">'+
				'<li nya-bs-option="op in opcoes"><a>{{ op.descricao }} <span class="glyphicon glyphicon-ok check-mark"></span></a></li>'+
				'</ol>'+
				'</div>'+
				'</div>',
 
		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			titulo: "@",
			opcoes:"=",
			modelo:"=",
			orientacao:"@"
		}

	}
});
 			
 
angular.module('app').directive('dxselectv', function () {

	return {

		template: 
				'<div class="form-group">'+   
				'<label>{{titulo}}</label>'+
				'<div class="select2 select2-container select2-container--default">'+ 
				'<ol class="nya-bs-select"'+ 
				'data-size="10" ng-model="modelo"'+ // data-live-search="true"
				'actions-box="true" style="width: 100%;">'+
				'<li nya-bs-option="op in opcoes"><a>{{ op  }}</a></li>'+
				'</ol>'+
				'</div>'+
				'</div>',
 
		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			titulo: "@",
			opcoes:"=",
			modelo:"=",
			orientacao:"@"
		}

	}
});
 
 
 
angular.module('app').directive('dxselectvSimples', function () {

	return {

		template: 
				'<div class="form-group">'+   
				'<label>{{titulo}}</label>'+
				'<div class="select2 select2-container select2-container--default">'+ 
				'<ol class="nya-bs-select"'+ 
				'data-size="10" ng-model="modelo" data-live-search="true"'+ 
				'actions-box="true" style="width: 100%;">'+
				'<li nya-bs-option="op in opcoes"><a>{{ op }}</a></li>'+
				'</ol>'+
				'</div>'+
				'</div>',
 
		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			titulo: "@",
			opcoes:"=",
			modelo:"=",
			orientacao:"@"
		}

	}
}); 


angular.module('app').directive('dxselect', function () {

	return {

		template: 
				'<div class="form-group">'+   
				'<label class="col-md-2 col-sm-2 control-label">{{titulo}}</label>'+
				'<div class="col-md-10 col-sm-10 form-control select2 select2-container select2-container--default">'+
				'<ol class="nya-bs-select"'+ 
				'data-size="10" ng-model="modelo" data-live-search="true"'+ 
				'actions-box="true" style="width: 100%;">'+
				'<li nya-bs-option="op in opcoes"><a>{{ op.descricao }}</a></li>'+
				'</ol>'+
				'</div>'+
				'</div>',
 
		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			titulo: "@",
			opcoes:"=",
			modelo:"=",
			orientacao:"@"
		}

	}
});
 


angular.module('app').directive('dxdate', function () {

	return {

		template: 
				'<div class="form-group">'+
				'<label>{{titulo}}</label>'+
				'<div class="input-group">'+
				'	<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span></span>'+
				'	<input date-range-picker class="form-control date-picker" type="text" ng-model="modelo" options="opcoes" required>'+
				'</div>'+
				'</div>',				
 
		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			titulo: "@",
			opcoes: "=",
			modelo: "="
			
		}

	}
});
 


angular.module('app').directive('dxmaskmoney', function () {

	return {

		template: 
				'<div class="form-group">'+
				'<label>{{titulo}}</label>'+				 
				'	<input mask-money type="text" class="form-control" ng-model="modelo" mm-options="opcoes" >'+	 
				'</div>',				
 
		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			titulo: "@",
			opcoes:"=",
			modelo:"="
			
		}

	}
});


angular.module('app').directive('dxmaskmoneyh', function () {

	return {

		template: 
				'<div class="form-group">'+   
				'<label class="col-md-2 col-sm-2 control-label">{{titulo}}</label>'+
				'<div class="form-control">'+
				'	<input mask-money type="text" class="form-control" ng-model="modelo" mm-options="opcoes" >'+	 
				'</div>'+
				'</div>',
 
		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			titulo: "@",
			opcoes:"=",
			modelo:"=",
			orientacao:"@"
		}

	}
});
 


angular.module('app').directive('dxmaskmoney2', function () {

	return {

		template: 
				'<div class="form-group">'+
				'	<input mask-money type="text" class="form-control" ng-model="modelo" mm-options="opcoes" >'+				 
				'</div>',				
 
		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			titulo: "@",
			opcoes:"=",
			modelo:"="
			
		}

	}
});
 


angular.module('app').directive('dxbutton', function () {

	return {

		template: 
				'<div class="form-group">'+
					'<button type="button" ng-click="modelo" class="form-control btn bg-{{cor}}" style="margin: 24px 0px 24px;"><i class="fa {{icon}}"></i> {{titulo}}</button>'+
				'</div>', 
		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			icon:"@",
			cor:"@",
			titulo:"@",
			modelo:"="
	
		}

	}
});
 
