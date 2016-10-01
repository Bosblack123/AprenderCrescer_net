'use strict'

myApp.factory('UsuarioFactory', ['$http', function ($http) {
        return{
            getUsuarios: function (callback) {
                $http({"method": "GET", "url": "/AprenderCrescer/rest/usuario/getusuarios"}).then
                        (function (resposta) {
                            callback(resposta);
                        });
            },
            setUsuario: function (callback) {
                $http({"method": "POST", "url": "/AprenderCrescer/rest/usuario/setusuario",
                    "headers": {"Content-Type": "application/json"},
                    "data": usuario
                }).then(function (resposta) {
                    callback(resposta);
                }, function (resposta) {
                    callback(resposta);
                });
            },
        };
    }]);