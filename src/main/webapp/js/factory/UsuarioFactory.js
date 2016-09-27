'use strict'

myApp.factory('UsuarioFactory', ['$http', function ($http) {
        return{
            getUsuarios: function (callback) {
                $http({"method":"GET","url":"/AprenderCrescer/rest/usuario/getusuarios"}).then
                (function (resposta){
                    callback(resposta);
                });
            },
        };
    }]);


