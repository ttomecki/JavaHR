var app = angular.module('Application', [ 'ngRoute' ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'pages/lists.html',
		controller : 'PersonListControler'
	}).when('/NewPerson', {
		templateUrl : 'pages/new.html',
		controller : 'PersonAddControler'
	}).when('/UpdatePerson/:id', {
		templateUrl : 'pages/edit.html',
		controller : 'PersonEditControler'
	}).otherwise({
		redirectTo : '/'
	});
} ]);

app.controller('PersonListControler', [ '$scope', '$http',
		function($scope, $http) {
			$http.get('/persons/').success(function(data) {
				$scope.persons = data;
			});
		} ]), 
app.controller('PersonAddControler', [ '$scope', '$http',
		'$location', function($scope, $http, $location) {

			$scope.master = {};
			$scope.activePath = null;
			$http.get('/depart/').success(function(data) {
				$scope.departments = data;
			});
			$scope.genders = ["MALE", "FEMALE"];

			$scope.New_Person = function(person, AddNewForm) {
				$http.post('/persons/add', person).success(function() {
					$scope.reset();
					$scope.activePath = $location.path('/');
				});
				$scope.reset = function() {
					$scope.person = angular.copy($scope.master);
				};
				$scope.reset();
			};
			
		} ]),

app.controller('PersonEditControler',[
        '$scope','$http','$location','$routeParams',
        function ($scope, $http, $location, $routeParams) {
            var id = $routeParams.id;
            $scope.activePath = null;

            $http.get('/persons/'+id).success(function(data) {
    			$http.get('/depart/').success(function(data) {
    				$scope.departments = data;
    			});
    			$scope.genders = ["MALE", "FEMALE"];
    			$scope.person = data;
            });

            $scope.Update_Person = function(person, AddNewForm) {
				$http.post('/persons/update', person).then(function() {
					$scope.activePath = $location.path('/');

				});
			};
            
            $scope.Delete_Person = function(person) {
                console.log(person);
                var deletePerson = confirm('Are you absolutely sure you want to delete?');
                if (deletePerson) {
                    $http.delete('/persons/'+person.id);
                    $scope.activePath = $location.path('/');
                }        
            };
        }
  ]);
