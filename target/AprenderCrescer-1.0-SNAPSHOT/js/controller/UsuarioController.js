myApp.controller('UsuarioController', function UsuarioController($scope, $http, UsuarioFactory) {

    $scope.editando = false;
    $scope.dados = [{"idUsuario": 1, "Login": "Bossblack", "Nome": "Daniel", "Ativo": "F"}];
    $scope.buscaUsuario = function () {
        UsuarioFactory.getUsuarios($scope.callbackUsuarios);
    }

    $scope.callbackUsuarios = function (resposta) {
        $scope.dados = resposta.data;
    }
    $scope.editarusuario = function (item) {
        $scope.editando = true;
        $scope.usuario = angular.copy(item);
    }
    $scope.cadastroUsuario = function (usuario) {
        if (usuario.idUsuario && usuario.idUsuario != 0) {
            UsuarioFactory.updateUsuario($scope.callbackCadastroUsuario, usuario);
        } else {
            UsuarioFactory.setUsuario($scope.callbackCadastroUsuario, usuario)
        }
    }
    $scope.callbackCadastroUsuario = function (resposta) {
        if (resposta.status != 200) {
            swal("Usuario", "Erro ao cadastrar", "error");
        }
        if ($scope.editando == true) {
            swal("Usuario", "Usuario editado com sucesso", "success");
        } else if ($scope.editando == false) {
            swal("Usuario", "Erro ao editar", "error");
        } else {
            swal("Usuario", "Usuario cadastrado com sucesso", "success");
            $scope.buscaUsuario();
            $scope.limpaCampos();
        }
    }
    $scope.limpaCampos = function () {
        $scope.usuario.idUsuario = "";
        $scope.usuario.nome = "";
        $scope.usuario.login = "";
        $scope.usuario.senha = "";
        $scope.usuario.flagnativo = "";
        $scope.editando = false;
    }
    $scope.deleteUsuario = function (id) {
        UsuarioFactory.deleteUsuario($scope.callbackDeleteUsuario, id)
    };
    $scope.callbackDeleteUsuario = function (resposta) {
        if (resposta.status != 200) {
            swal("Usuario", "Usuario deletado com sucesso", "success");
        } else {
            swal("Usuario", "Erro ao deletar usuario", "error");
        }
    }
})