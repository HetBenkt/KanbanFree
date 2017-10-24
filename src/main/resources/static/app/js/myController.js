app.controller("myCtrl", function($scope, $http) {
    console.log('Angular OK!');
    $scope.firstName = "John";
    $scope.lastName = "Doe";

    $scope.myFunction = function(id) {
        console.log('Get the boards for id: ' + id);
        $http.get('/members/'+id+'/boards')
            .then(function(response) {
                console.log(response)
            });

    }
});