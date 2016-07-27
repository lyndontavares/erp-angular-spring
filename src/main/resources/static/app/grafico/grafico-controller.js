!function($, jQuery, window, document) {

'use sctrict'

app.module.controller('GraficoValorEstoqueController',[
 '$http','$scope','$timeout','SERVER_BASE',
 function($http,$scope,$timeout,SERVER_BASE){

    //grafico de linhas
	$scope.labels = ["2016"];
	$scope.series = ["",""];
	$scope.data = [0,0];

 	
/*
	$http.get( SERVER_BASE+'api/graficoLivroQuantidade' )
	.success(function(data){
      //console.log(data);
			$scope.series = data.series;
			//console.log('series:'+$scope.series);
			$scope.data = data.data;
			//console.log('data:'+$scope.data);
	});

*/
	$scope.onClick = function (points, evt) {
	    console.log(points, evt);
	};

}]);




app.module.controller('graficoController',['$http','$scope','$timeout',function($http,$scope,$timeout){
	

  $scope.labels = ["January", "February", "March", "April", "May", "June", "July"];
  $scope.series = ['Series A', 'Series B'];
  $scope.data = [
    [65, 59, 80, 81, 56, 55, 40],
    [28, 48, 40, 19, 86, 27, 90]
  ];
  $scope.onClick = function (points, evt) {
    console.log(points, evt);
  };
	
}]);


app.module.controller('GraficoLine1Controller',['$http','$scope','$timeout',function($http,$scope,$timeout){

	
	//grafico de linhas 
	$scope.labels = ["January", "February", "March", "April", "May", "June", "July"];
	$scope.series = ['Series A', 'Series B'];
	$scope.data = [
	    [65, 59, 80, 81, 56, 55, 40],
	    [28, 48, 40, 19, 86, 27, 90]
	];
	$scope.onClick = function (points, evt) {
	    console.log(points, evt);
	};
	
}]);


app.module.controller('GraficoLine2Controller',['$http','$scope','$timeout',function($http,$scope,$timeout){

	
	//grafico de linhas2 
	  $scope.labels = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
	  $scope.series = ['Series A', 'Series B'];

	  $scope.data = [
	    [65, 59, 80, 81, 56, 55, 40],
	    [28, 48, 40, 19, 86, 27, 90]
	  ];
	
}]);



app.module.controller('GraficoDoughnutController',[
 '$http','$scope','$timeout', 'SERVER_BASE',
 function($http,$scope,$timeout,SERVER_BASE){

	
	//grafico de linhas Doughnut
	$scope.labels = ["Download Sales", "In-Store Sales", "Mail-Order Sales"];
	  $scope.data = [300, 500, 100];


		$http(
				{
					method:'GET',
					url: 'http://localhost:5000/api/graficoLivroQuantidade',
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

}();