var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/gastos',
    CONCEPTS_SERVICE_API : 'http://localhost:8080/gastos/api/concepts/',
    BUDGETS_SERVICES_API : 'http://localhost:8080/gastos/api/budgets/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
    


        $stateProvider
            .state('home',{
                url:'/'
            })
            .state('concepts', {
                url: '/concepts',
                templateUrl: 'partials/concepts',
                controller:'ConceptsController',
                controllerAs:'ctrl',
                resolve: {
                    concepts: function ($q, ConceptsService) {
                        console.log('Load all concepts');
                        var deferred = $q.defer();
                        ConceptsService.loadAllConcepts().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            })
            .state('budgets',{
                url: '/budgets'
            });
        $urlRouterProvider.otherwise('/index');
    }]);

