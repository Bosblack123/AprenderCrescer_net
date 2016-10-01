myApp.controller('UsuarioController', function UsuarioController($scope, $http, UsuarioFactory) {
    
    $scope.editando = false;
    $scope.dados = [{"idUsuario": 1, "Login": "Bossblack", "Nome":"Daniel", "Ativo": "F"}];
    $scope.buscaUsuario = function (){
        UsuarioFactory.getUsuarios($scope.callbackUsuarios);
    }
    
    $scope.callbackUsuarios = function(resposta){
        $scope.dados = resposta.data;
    }
    $scope.editarusuario = function(){
        $scope.editando = !$scope.editando;
    }
    $scope.cadastroUsuario = function(usuario){
        UsuarioFactory.setUsuario($scope.callbackCadastroUsuario,usuario);
    }
    $scope.callbackCadastroUsuario = function(resposta){
        if(resposta.stauts != 200){
            alert("Erroooouuuu")
        }else{
            alert("OK");
        }
    }
    
})