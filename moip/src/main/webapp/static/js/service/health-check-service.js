'use strict';
angular.module('hcApp').factory('HealthCheckService', [ '$http', '$q', function($http, $q) {

	var REST_SERVICE_URI = 'http://localhost:8080/Spring4MVCAngularJSExample/user/';

	var factory = {
		getHealthCheck : getHealthCheck
	};

	return factory;

	function getHealthCheck() {
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI)
			.then(
				function(response) {
					deferred.resolve(response.data);
				},
				function(errResponse) {
					console.error('Error while get health check');
					deferred.reject(errResponse);
				}
		);
		return deferred.promise;
	}
} ]);