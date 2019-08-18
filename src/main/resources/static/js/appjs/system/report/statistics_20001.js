var prefix = "/system/reportStatistics"
$(function() {
	$("#dw-select").chosen({
		maxHeight : 200
	});
	// 点击事件
	$('#dw-select').on('change', function(e, params) {
		load(params.selected);
	});
	laydateon();
	selectLoad();
});

function load(rdcId) {
	$('#exampleTable').bootstrapTreeTable({
		id : 'deptId',
		code : 'deptId',
		parentCode : 'parentId',
		params : '85',
		type : "GET", // 请求数据的ajax类型
		url : '/system/reportDept/list', // 请求数据的ajax的url
		ajaxParams : {
			rdcId : rdcId,
			limit : 2000,
			offset : 0
		}, // 请求数据的ajax的data属性
		expandColumn : '1', // 在哪一列上面显示展开按钮
		striped : true, // 是否各行渐变色
		bordered : true, // 是否显示边框
		expandAll : true, // 是否全部展开
		columns : [ {
			title : '编号',
			field : '',
			visible : false,
			align : 'center',
			valign : 'center',
			width : '50px',
		}, {
			field : 'sname',
			title : '单位简称',
			valign : 'center',
			witth : 20
		}, {
			field : 'orderNum',
			title : '排序',
			align : 'center',
			valign : 'center'
		} ]
	});
}
function selectLoad() {
	var html = "";
	$.ajax({
		url : '/system/reportDeptCategory/grouplist',
		data : {
			limit : 20,
			offset : 0,
			code : $('#dcode').val()
		},
		success : function(data) {
			// 没有数据，不加载
			if (data.length < 1) {
				$("#dw-select").empty();
				$("#dw-select").append(html);
				$("#dw-select").trigger("chosen:updated");
				return;
			}
			// 加载数据
			$("#dw-select").empty();
			for (var i = 0; i < data.length; i++) {
				if (i == 0) {
					html += '<option value="' + data[i].rdcId + '" selected >'
							+ data[i].name + '</option>';
				} else {
					html += '<option value="' + data[i].rdcId + '">'
							+ data[i].name + '</option>';
				}
			}
			$("#dw-select").append(html);
			$("#dw-select").trigger("chosen:updated");
			load($('#dw-select').val());
		}
	});
}
function showReport() {
	// 获取部门和时间
	var rdepart = new String();
	var rdcId = $('#dw-select').val();
	if (rdcId == -1) {
		layer.msg("请先到配置界面添加单位配置！");
		return;
	}

	var rdate = $('#renderdate').val();
	if (rdate == "") {
		layer.msg("请选择要统计的年月！");
		return;
	} else
		rdate = $('#renderdate').val() + '-01';

	var curcode = $("#dcode").val();
	var tempdate = new Date(rdate);
	var tempDateName=tempdate.getFullYear()+''+ ((tempdate.getMonth() + 1)<10?'0'+(tempdate.getMonth() + 1):(tempdate.getMonth() + 1));
	var tempIndex=arrReportCode.indexOf(curcode);
	var dDateName=tempDateName+arrReportName[tempIndex];

	url = urlrunqian + 'raq=' + curcode + '&rdate=' + rdate + '&rfoid='
			+ rdcId+ "&departName="+dDateName;
//	var w = $(".gray-bg").width() - 30;
//	var h = $(".gray-bg").height() - 85;
	var w = $("#wrapper", parent.document).width() - 20;
	var h = $("#wrapper", parent.document).height() - 100;
	url += "&width=" + w + "&height=" + h;
	console.log(url);
	var index = top.layer.open({
		type : 2,
		title : "统计报表",
		shadeClose : false, // 点击遮罩关闭层
		area : [ '1000px', '620px' ],
		fixed : false,
		//maxmin : true,
		content : url
	});
	top.layer.full(index);
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
	var rdcId = $('#dw-select').val();
	if (rdcId == -1) {
		layer.msg("请先到配置界面添加单位配置！");
		return;
	}
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
		content : '/system/labourreportstaticmain/add?ctype=2&rdate=' + rdate
				+ '&rdepart=' + rdcId + '&code=' + curcode// iframe的url
	});
}
