var prefix = "/system/reportconfig";
function openChild(type) {
	var targethtml = "" + type;
	var index = layer.open({
		type : 2,
		title : '报表配置',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/report?code=' + type + '&foid=gzl123456789'
	});
	layer.full(index);
}