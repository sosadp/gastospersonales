var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/gastos',
    CONCEPTS_SERVICE_API : 'http://localhost:8080/gastos/api/concepts/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
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
            .stage('budget',{
                url:'/budget',
                templateUrl:'partials/budget',
                controller:'BudgetController',
                controllerAs:'BudgetCtrl',
                resolve:{
                    budget: function ($q, BudgetService) {
                        console.log('load all budget');
                        var deferred=$q.defer();
                        BudgetService.loadAllBudget().then(deferred.resolve,deferred.resolve);
                        return deferred.promise;
                    }
                }

            });
        $urlRouterProvider.otherwise('/index');
    }]);

