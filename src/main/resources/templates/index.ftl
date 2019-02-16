<!DOCTYPE html>
<html lang="en" ng-app="gastosPerApp">
<head>
    <title>${tittle}</title>
    <link href="./css/bootstrap4.min.css" rel="stylesheet"/>
    <link href="./css/app.css" rel="stylesheet"/>
    <link href="./css/all.css" rel="stylesheet"

</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-4 col-lg-12">
            <nav class="navbar navbar-light bg-light">
                <a class="navbar-brand" href="#">
                    <i class="fab fa-amazon-pay fa-3x"> </i>

                </a>
                <a class="navbar-brand" href="#/home">Inicio</a>
                <a class="navbar-brand" href="#/concepts">Lista de Conceptos</a>
                <a class="navbar-brand"  href="#/budgets">Presupuestos</a>
                <a class="navbar-brand" href="#/transaction">Transacciones</a>

            </nav>
        </div>




        <div class="col-sm-8 col-lg-12" ui-view></div>

    </div>
</div>

<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/popper.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/all.js"></script>
<script src="./js/lib/angular.min.js" ></script>
<script src="./js/lib/angular-ui-router.min.js" ></script>
<script src="./js/lib/localforage.min.js" ></script>
<script src="./js/lib/ngStorage.min.js"></script>
<script src="./js/app/app.js"></script>
<script src="./js/app/ConceptsService.js"></script>
<script src="./js/app/ConceptsController.js"></script>
<script src="./js/app/BudgetsService.js"></script>
<script src="./js/app/BudgetsController.js"></script>

</body>

</html>