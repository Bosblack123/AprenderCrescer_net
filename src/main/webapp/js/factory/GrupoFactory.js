'use strict'

myApp.factory('GrupoFactory', ['$http', function ($http) {
        return{
            getGrupos: function (callback) {
                $http({"method":"GET","url":"/AprenderCrescer/rest/grupo/getgrupos"}).then
                (function (resposta){
                    callback(resposta);
                });
            },
        };
    }]);