'use strict'

myApp.factory('ContaFactory', ['$http', function ($http) {
        return{
            getContas: function (callback) {
                $http({"method":"GET","url":"/AprenderCrescer/rest/conta/getContas"}).then
                (function (resposta){
                    callback(resposta);
                });
            },
        };
    }]);