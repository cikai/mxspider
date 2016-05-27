require.config({
    paths: {
        
    }
});

require([ "top" ], function(top) {
    $(function() {
        top.init();
    });
});