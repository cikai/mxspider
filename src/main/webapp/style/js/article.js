define([""],function() {
	
	function init(tdDom) {
		
		$("#title").html(tdDom[2]);
		$("#content").html(tdDom[3]);
		
	}
	
	
	
	return {
		"init" : init
	};
});