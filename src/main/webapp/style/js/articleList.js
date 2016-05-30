define([ "common", "article" ], function(common, article) {

	function init() {

		initRunBtn();

		initDataTable();
		
	}

	function initRunBtn() {
		$("#run").on("click", function() {
			$.ajax({
				url : 'add'
			});
			setTimeout("location.reload()", 5000);
		});
	}

	function initDataTable() {
		var dataList = new Array();
		var tableList = [];
		$.ajax({
			url : 'list',
			dataType : 'json',
			success : function(data) {
				for (var i = 0; i < data.list.length; i++) {
					dataList.push(data.list[i].id);
					dataList.push(data.list[i].url);
					dataList.push(data.list[i].title);
					dataList.push(data.list[i].content);
				}
				for (var i = 0; i < dataList.length; i += 4) {
					tableList.push(dataList.slice(i, i + 4));
				}
				createTable(tableList);
			},
			error : function(data) {
				alert("服务器异常！");
			}
		});
	}

	function createTable(tableList) {
		$('#orderForm').DataTable({
			data : tableList,
			columns : [ {
				title : "ID",
				name : "id"
			}, {
				title : "网址",
				name : "url",
				render : urlHandler
			}, {
				title : "标题",
				name : "title",
				// createdCell : titleHandler
				render : titleHandler
			} ]
		});
	}

	function urlHandler(value, rowValue, tdDom) {
		return '<a href=' + value + ' target="_blank"> ' + value + '</a>';
	}

	function titleHandler(value, rowValue, tdDom) {

		var $dom = '<a href="pages/' + tdDom[0] + '">' + value + '</a>';
		
		return $dom;
	}
	
	return {
		"init" : init
	};
});
