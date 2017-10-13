app.controller("myCtrl", function($scope, $http) {
    console.log('Angular OK!');
    $scope.firstName = "John";
    $scope.lastName = "Doe";

    $scope.myFunction = function() {
        console.log('Get the boards');
        $http.get('/members/1/boards')
            .then(function(response) {
                console.log(response)
            });

    }
});