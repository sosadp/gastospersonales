<!DOCTYPE html>
<html lang="en" ng-app="crudApp">
    <head>
       <title>${tittle}</title>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/app.css" rel="stylesheet"/>
    </head>
    <body>

    <div>
            <ul class="nav nav-pills">
                <li><a href="#/"> Inicio </a></li>
                <li><a href="#/concepts">Lista de Conceptos</a></li>
                <li><a href="#/budgets">Presupuestos</a></li>
                <li><a href="#/transaction">Transacciones</a></li>
            </ul>
    </div>
    <div ui-view></div>
    <script src="js/lib/angular.min.js" ></script>
    <script src="js/lib/angular-ui-router.min.js" ></script>
    <script src="js/lib/localforage.min.js" ></script>
    <script src="js/lib/ngStorage.min.js"></script>
    <script src="js/app/app.js"></script>
    <script src="js/app/ConceptsService.js"></script>
    <script src="js/app/ConceptsController.js"></script>
    </body>

</html>