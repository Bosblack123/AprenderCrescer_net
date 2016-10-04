myApp.controller('UsuarioController', function UsuarioController($scope, $http, UsuarioFactory) {

    $scope.editando = false;
    $scope.dados = [{"idUsuario": 1, "Login": "Bossblack", "Nome": "Daniel", "Ativo": "F"}];
    $scope.buscaUsuario = function () {
        UsuarioFactory.getUsuarios($scope.callbackUsuarios);
    }

    $scope.callbackUsuarios = function (resposta) {
        $scope.dados = resposta.data;
    }
    $scope.editarusuario = function () {
        $scope.editando = !$scope.editando;
    }
    $scope.cadastroUsuario = function (usuario) {
        UsuarioFactory.setUsuario($scope.callbackCadastroUsuario, usuario);
    }
    $scope.callbackCadastroUsuario = function (resposta) {
        if (resposta.status != 200) {
            //alert("Erroooouuuu");
            swal("Usuario", "Erro ao cadastrar", "error");
        } else {
            swal("Usuario", "Usuario cadastrado com sucesso", "success");
            $scope.buscaUsuario();
            $scope.limpaCampos();
        }
    }
    $scope.limpaCampos = function () {
        $scope.usuario.nome = "";
        $scope.usuario.login = "";
        $scope.usuario.senha = "";
        $scope.usuario.flagnativo = "";
    }

})