(function(){
    var app = angular.module('store', ['store-products']);

    app.controller('StoreController', [ '$http', '$scope', function($http, $scope){
        var store = this;
        store.fromCurrency = '';
        store.toCurrencies = '';
        store.products = [ ];
        store.loadCurrencyPairs = function() {
            $http.get('http://localhost:8080/fxrates/' + store.fromCurrency + '/' + store.toCurrencies).then(function(promise){
                store.products = promise.data.fxrates;

            });
        };
    } ]);
})();