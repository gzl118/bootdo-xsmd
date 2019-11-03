var prefix = "/system/reportStatistics"
$(function() {
	laydateon();
});
function showReport() {
	// 获取部门和时间
	var rdepart = $('#deptid').val();
	var deptname = $('#deptname').val();
	selName = encodeURIComponent(deptname);
	var rdate = $('#renderdate').val();
	if (rdate == "") {
		layer.msg("请选择要统计的年月！");
		return;
	} else
		rdate = $('#renderdate').val() + '-01';
	var curcode = $("#dcode").val();
	var tempdate = new Date(rdate);
	var tempDateName = tempdate.getFullYear()
			+ ''
			+ ((tempdate.getMonth() + 1) < 10 ? '0' + (tempdate.getMonth() + 1)
					: (tempdate.getMonth() + 1));
	var tempIndex = arrReportCode.indexOf(curcode);
	var dDateName = tempDateName + "(" + selName + ")"
			+ arrReportName[tempIndex];
	var murl = urlrunqian + 'raq=' + curcode + '&rdate=' + rdate + '&rdepart='
			+ rdepart + '&gname=' + selName + "&departName=" + dDateName;
	tempIndex = arrReportCode.indexOf('50015');
	var dDateName = tempDateName + "(" + selName + ")"
			+ arrReportName[tempIndex];
	var surl = urlrunqian + 'raq=50015&rdate=' + rdate + '&rdepart=' + rdepart
			+ '&gname=' + selName + "&departName=" + dDateName;
	var w = $("#wrapper", parent.document).width() - 20;
	var h = $("#wrapper", parent.document).height() - 100;
	murl += "&width=" + w + "&height=" + h;
	surl += "&width=" + w + "&height=" + h;
	report5confirm(murl, surl);
}
function openReport(url) {
	// 显示报表
	var index = top.layer.open({
		type : 2,
		title : "统计报表",
		shadeClose : false, // 点击遮罩关闭层
		area : [ '1000px', '620px' ],
		fixed : false,
		// maxmin : true,
		content : url
	});
	top.layer.full(index);
}
function report5confirm(murl, surl) {
	// 主副表选择
	layer.confirm('选择要查看的表格', {
		btn : [ '主表', '附表' ],
		skin : 'layui-layer-molv'
	// 按钮
	}, function(curindex) {
		layer.close(curindex);
		openReport(murl);
	}, function(curindex) {
		layer.close(curindex);
		openReport(surl);
	});
}
function formatdate(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	m = m < 10 ? '0' + m : m;
	var d = date.getDate();
	d = d < 10 ? ('0' + d) : d;
	return y + '-' + m + '-' + d;
}
function laydateon() {
	laydate.render({
		elem : '#renderdate',
		type : 'month',
		trigger : 'click',
		format : 'yyyy-MM'
	});
};
function saveReport() {
	var rdepart = $('#deptid').val();
	var deptname = $('#deptname').val();
	selName = encodeURIComponent(deptname);
	var rdate = $("#renderdate").val();
	if (rdate == null || rdate == "") {
		layer.msg("请选择要统计的年月！");
		return;
	}
	rdate = rdate + "-01";
	var curcode = $("#dcode").val();
	layer.open({
		type : 2,
		title : '保存统计报表',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : '/system/labourreportstaticmain/add?ctype=5&rdate=' + rdate
				+ '&rdepart=' + rdepart + '&code=' + curcode+'&gname='+selName// iframe的url
	});
}