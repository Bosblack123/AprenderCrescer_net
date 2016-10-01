myApp.controller('GrupoController', function GrupoController($scope, $http, GrupoFactory) {

    $scope.dados = [{"Idgrupo": 1, "tipousuario": "F", "descricaogrupo":"Faculdade"}];
    $scope.buscaGrupo = function (){
        GrupoFactory.getGrupos($scope.callbackGrupos);
    }
    
    $scope.callbackGrupos = function(resposta){
        $scope.dados = resposta.data;
    }
    
})
