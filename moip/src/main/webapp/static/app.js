angular.module('hcApp', [])
	.controller('HealthCheckController', function($scope, $http) {
		var vm = this;
	    vm.mydata = [];
	    $scope.quantity = 3;
		$scope.showData = function() {
			$http({
				method : 'GET',
				url : '/healthcheck/'
			}).then(function(response) {
				//var json = JSON.parse(response);
				console.log(response);
				vm.mydata = response;
			});
		}
		
	});