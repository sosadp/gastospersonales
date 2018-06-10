'use strict';

angular.module('crupApp').factory('BudgetsService',[
    '$localStorage','$http','$q','urls',function ($localStorage, $http,$q,urls) {

            var factory={

                loadAllBudget: loadAllBudget,
                getAllBudget: getAllBudget,
                getBudget: getBudget,
                createBudget: createBudget,
                updateBudget: updateBudget,
                removeBudget: removeBudget
            };

            return factory;

            function loadAllBudget() {
                console.log('fetching all budgets');
                var deferred =$q.defer();
                $http.get(urls.BUDGETS_SERVICES_API)
                    .then(function (response) {
                        console.log('Fetched successfully all budget');
                        $localStorage.budgets=response.data;
                        deferred.load();
                    },
                      function (errResonse) {
                            console.log()
                      }
                        );

            }
    }
]);