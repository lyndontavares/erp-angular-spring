angular.module('app').controller('GraficoPessoaCategoriaController',[
 '$http','$scope','$timeout', 'SERVER_BASE',
 function($http,$scope,$timeout,SERVER_BASE){

	
	//grafico de linhas Doughnut
	$scope.labels = [""];
	  $scope.data = [0];


		$http(
				{
					method:'GET',
					url: SERVER_BASE+'api/grafico/1',
					headers: {'Accept':'application/json; charset=utf-8'}
				}		
		)
		.success(function(data){
	      //console.log(data);
				$scope.labels = data.series;
				//console.log('series:'+$scope.series);
				$scope.data = data.data;
				//console.log('data:'+$scope.data);
		});


		$scope.onClick = function (points, evt) {
		    console.log(points, evt);
		};
	  
	  
}]);
