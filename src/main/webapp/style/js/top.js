define([ "articleList" ], function(articleList) {

    'use strict';

    function init() {

        var deferred = new $.Deferred();

        articleList.init();

        deferred.resolve();

        return $.when(deferred);
    }

    return({
        "init": init
    });
});
