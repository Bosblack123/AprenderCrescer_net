myApp.controller('ContaController', function ContaController($scope, $http, ContaFactory) {

    $scope.dados = [{"idConta": 1, "descricao": "Devendo", "tipoconta":"Calça", "valor":19.50}];
    $scope.buscaConta = function (){
        ContaFactory.getContas($scope.callbackContas);
    }
    
    $scope.callbackContas = function(resposta){
        $scope.dados = resposta.data;
    }
    
})



