'use strict';
 
angular.module('hcApp').controller('HealthCheckController', ['$scope', 'HealthCheckService', function($scope, HealthCheckService) {
    var self = this;
    self.user={id:null,username:'',address:'',email:''};
    self.users=[];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
 
 
    fetchAllUsers();
 
    function getHealthCheck(){
    	HealthCheckService.getHealthCheck()
            .then(
            function(d) {
                self.users = d;
            },
            function(errResponse){
                console.error('Error while get health check');
            }
        );
    }
 
}]);