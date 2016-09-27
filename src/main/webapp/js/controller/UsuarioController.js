myApp.controller('UsuarioController', function UsuarioController($scope, $http, UsuarioFactory) {

    $scope.dados = [{"idUsuario": 1, "Login": "Bossblack", "Nome":"Daniel", "Ativo": "F"}];
    $scope.buscaUsuario = function (){
        UsuarioFactory.getUsuarios($scope.callbackUsuarios);
    }
    
    $scope.callbackUsuarios = function(resposta){
        $scope.dados = resposta.data;
    }
    
})