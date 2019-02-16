                <div class="generic-container">





                <div class="panel panel-default">
                    <!-- Default panel contents -->
                    <div class="panel-heading">
                         <span class="lead text-center">List of Budget</span>

                    </div>

                    <div class="panel-body">

                        <div class="formcontainer">
                            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                                <input type="hidden" ng-model="ctrl.concept.id" />

                                    <form>
                                        <div class="form-group row">
                                        <label class="col-sm-2 col-form-label" for="uname">Budget</label>
                                        <div class="col-sm-4">
                                            <input type="text" ng-model="ctrl.concept.name" id="uname" class="username form-control input-sm" placeholder="Enter your budget" required ng-minlength="3"/>
                                        </div>
                                        </div>

                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label" for="ufechaini">Fecha Inicio</label>
                                            <div class="col-sm-4">
                                                <input type="date" ng-model="ctrl.concept.name" id="ufechaini" class="username form-control input-sm" placeholder="init date" required ng-minlength="3"/>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label" for="ufechafin">Fecha Final</label>
                                            <div class="col-sm-4">
                                                <input type="date" ng-model="ctrl.concept.name" id="ufechafin" class="username form-control input-sm" placeholder="end date" required ng-minlength="3"/>
                                            </div>
                                        </div>

                                        <div class="form-actions floatRight">

                                            <input type="submit"  value="{{!ctrl.concept.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>

                                        </div>

                                </form>



                                </div>
                            </form>

                    </div>

                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>NAME </th>
                                    <th>FECHA</th>
                                    <th width="100"></th>
                                    <th width="100"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr ng-repeat="u in Budgetctrl.getAllBudgets()">
                                    <td>{{u.id}}</td>
                                    <td>{{u.name}}</td>
                                    <td>{{u.budgetDate}}</td>




                                    <td><button type="button" ng-click="ctrl.editBudget(u.id)" class="btn btn-success custom-width">Edit</button></td>
                                    <td><button type="button" ng-click="ctrl.removeBudget(u.id)" class="btn btn-danger custom-width">Remove</button></td>
                                </tr>
                                </tbody>
                            </table>

                            <div data-pagination="" data-num-pages="numberOfPages(Budgetctrl.getAllBudgets().lenght)"
                                 data-current-page="curPage" data-max-size="maxSize"
                                 data-boundary-links="true"></div>
                        </div>
                    </div>
                </div>
                    <!-- Modal -->

                </div>