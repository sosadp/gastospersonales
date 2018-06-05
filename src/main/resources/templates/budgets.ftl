<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading"><span class="lead">List of Budget </span></div>
    <div class="panel-body">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>FECHA</th>
                    <th width="100"></th>
                    <th width="100"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in Budgetctrl.getAllBudgets()">
                    <td>{{u.id}}</td>
                    <td>{{u.name}}</td>
                    <td>{{u.budget_date}}</td>

                    <td><button type="button" ng-click="ctrl.editBudget(u.id)" class="btn btn-success custom-width">Edit</button></td>
                    <td><button type="button" ng-click="ctrl.removeBudget(u.id)" class="btn btn-danger custom-width">Remove</button></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>