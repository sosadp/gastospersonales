var app = angular.module('gastosPerApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/gastos',
    CONCEPTS_SERVICE_API : 'http://localhost:8080/gastos/api/concepts/',
    BUDGETS_SERVICES_API : 'http://localhost:8080/gastos/api/budget/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home',{
                url:'/home',
                templateUrl:'partials/home'
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
                url: '/budgets' ,
                templateUrl: 'partials/budgets' ,
                controller: 'BudgetsController',
                controllerAs: 'Budgetctrl' ,
                resolve:{
                    budgets: function ($q, BudgetsService) {
                        console.log('load all budgets');
                        var deferred=$q.defer();
                        BudgetsService.loadAllBudget().then(deferred.resolve,deferred.resolve);
                        return deferred.promise;
                    }
                }
            })

            .state('transaction',{
                url: '/transaction',
                templateUrl:'partials/transaction'
            })


        $urlRouterProvider.otherwise('/home');
    }]);

