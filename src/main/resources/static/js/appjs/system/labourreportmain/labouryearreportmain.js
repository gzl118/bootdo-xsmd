var prefix = "/system/labourreportstaticmain"
$(function() {
	laydate.render({
		elem : '#renderdate',
		type : 'month',
		trigger : 'click',
		format : 'yyyy-MM'
	});
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
						// showRefresh : true,
						// showToggle : true,
						// showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						bordered : true,
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						pageList : [ 10, 25, 50, 100, 'All' ],
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						// search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
						// "server"
						sortable : true,
						sortOrder : "desc",
						queryParams : function(params) {
							return {
								// 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit : params.limit,
								offset : params.offset,
								sort : params.sort,
								order : params.order,
								renderdate : ($('#renderdate').val() == null || $(
										'#renderdate').val() == '') ? $(
										'#renderdate').val() : $('#renderdate')
										.val()
										+ '-01',
								renderdepart : $('#renderdepart').val(),
								code : $("#code").val(),
								// status : $("#status").val(),
								ctype : $("#ctype").val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								// {
								// checkbox : false
								// },
								{
									field : 'oid',
									title : '主键',
									visible : false
								},
								{
									field : 'code',
									title : '编号',
									visible : false
								},
								{
									field : 'renderdate',
									title : '统计年月',
									align : 'center',
									width : '180px',
									formatter : function(value, row, index) {
										var val = value;
										if (val != null) {
											var date = new Date(val);
											return date.getFullYear() + '年'
													+ (date.getMonth() + 1)
													+ '月';
										}
									}
								},
								{
									field : 'ext1',
									align : 'center',
									title : '统计单位'
								},
								{
									field : 'ctype',
									title : '分类，1表示统计报表，2表示快报',
									visible : false
								},
								{
									field : 'deptids',
									title : '统计的单位编号,多个以逗号隔开',
									visible : false
								},
								{
									field : 'status',
									title : '状态',
									align : 'center',
									width : '80px',
									formatter : function(value, row, index) { // 单元格格式化函数
										// 0未提交，1已提交，2已审核通过，3审核未通过
										var text = '-';
										if (value == 1) {
											text = "已提交";
										} else if (value == 2) {
											text = "已审核通过";
										} else if (value == 3) {
											text = "审核未通过";
										} else if (value == 0) {
											text = "未提交";
										} else {
											text = "未提交";
										}
										return text;
									}

								},
								{
									field : 'remark',
									title : '说明',
									width : '250px'
								},
								{
									field : 'renderdepart',
									title : '填报单位',
									visible : false
								},
								{
									field : 'mineleader',
									title : '矿负责人',
									visible : false
								},
								{
									field : 'businessleader',
									title : '业务部门负责人',
									visible : false
								},
								{
									field : 'edituser',
									title : '制表人',
									visible : false
								},
								{
									field : 'edittime',
									title : '制表时间',
									visible : false
								},
								{
									field : 'upttime',
									title : '更新时间',
									visible : false
								},
								{
									field : 'uptuser',
									title : '操作人',
									visible : false
								},
								{
									field : 'ext2',
									title : '备用2',
									visible : false
								},
								{
									field : 'ext3',
									title : '备用3',
									visible : false
								},
								{
									title : '操作',
									field : 'id',
									align : 'left',
									halign : 'center',
									width : '240px',
									formatter : function(value, row, index) {
										s_edit_h = '';
										s_remove_h = '';
										var rol = $("#status").val();
										var checksubmit = ''; // 提交按钮控制
										var isWrite = 1;
										if (row.status == 1) {
											checksubmit = 'hidden';
											s_edit_h = 'hidden';
											s_remove_h = 'hidden';
											isWrite = 0;
										}
										var approverecord = ''; // 审批记录按钮控制
										if (row.status == 0 || row.status == ''
												|| row.status == null)
											approverecord = 'hidden';
										var selName = row.ext2;
										if (row.ctype == 4) {
											selName = "西山煤电集团公司(" + selName
													+ ")(合计)";
										}
										selName = encodeURIComponent(selName);
										var curCode = row.code;
										var tempdate = new Date(row.renderdate);
										var tempDateName = tempdate
												.getFullYear()
												+ ''
												+ ((tempdate.getMonth() + 1) < 10 ? '0'
														+ (tempdate.getMonth() + 1)
														: (tempdate.getMonth() + 1));
										var tempIndex = arrReportCode
												.indexOf(curCode);
										var dDateName = tempDateName + "("
												+ encodeURIComponent(selName)
												+ ")"
												+ arrReportName[tempIndex];
										// dDateName =
										// encodeURIComponent(encodeURIComponent(dDateName));
										var curUrl = urlrunqian + "raq="
												+ curCode + "&rdate="
												+ row.renderdate + "&rdepart="
												+ row.deptids + "&gname="
												+ selName + "&departName="
												+ dDateName + "&IsWrite="
												+ isWrite + "&roid=" + row.oid;

										var g = '<a class="btn btn-warning btn-sm '
												+ s_detail_h
												+ '" href="#" title="报表"  mce_href="#" onclick="reportfunc(\''
												+ curUrl
												+ '\')"><i class="fa fa fa-tasks"></i></a> ';

										if (curCode == '50005') {
											tempIndex = arrReportCode
													.indexOf('50015');
											dDateName = tempDateName
													+ "("
													+ encodeURIComponent(selName)
													+ ")"
													+ arrReportName[tempIndex];
											// dDateName =
											// encodeURIComponent(encodeURIComponent(dDateName));
											var suburl = urlrunqian
													+ "raq=50015&rdate="
													+ row.renderdate
													+ "&rdepart=" + row.deptids
													+ "&gname=" + selName
													+ "&departName="
													+ dDateName + "&IsWrite="
													+ isWrite + "&roid="
													+ row.oid;
											g = '<a class="btn btn-warning btn-sm '
													+ s_detail_h
													+ '" href="#" title="报表"  mce_href="#" onclick="report5confirm(\''
													+ curUrl
													+ '\',\''
													+ suburl
													+ '\')"><i class="fa fa fa-tasks"></i></a> ';
										}
										var e = '<a class="btn btn-primary btn-sm '
												+ s_edit_h
												+ '" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.oid
												+ '\',\''
												+ row.ext1
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '
												+ s_remove_h
												+ '" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.oid
												+ '\')"><i class="fa fa-remove"></i></a> ';
										return e + d + g;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function reportfunc(url) {
	// var w = $(".gray-bg").width() - 30;
	// var h = $(".gray-bg").height() - 85;
	var w = $("#wrapper", parent.document).width() - 20;
	var h = $("#wrapper", parent.document).height() - 100;
	url += "&width=" + w + "&height=" + h;
	console.log(url);
	var index = top.layer.open({
		type : 2,
		title : '报表明细',
		// maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : url,
		cancel : function() {
			reLoad();
		}
	});
	top.layer.full(index);
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function remove(id, code) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix + "/remove",
			type : "post",
			data : {
				'oid' : id,
				'Code' : code
			},
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	})
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['oid'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}
function report5confirm(murl, surl) {
	// var w = $(".gray-bg").width() - 30;
	// var h = $(".gray-bg").height() - 85;
	var w = $("#wrapper", parent.document).width() - 20;
	var h = $("#wrapper", parent.document).height() - 100;
	murl += "&width=" + w + "&height=" + h;
	surl += "&width=" + w + "&height=" + h;
	console.log(murl);
	layer.confirm('选择要查看的表格', {
		btn : [ '主表', '附表' ],
		skin : 'layui-layer-molv'
	// 按钮
	}, function(curindex) {
		layer.close(curindex);
		var index = top.layer.open({
			type : 2,
			title : '报表明细',
			// maxmin : true,
			shadeClose : false, // 点击遮罩关闭层
			area : [ '800px', '520px' ],
			content : murl,
			cancel : function() {
				reLoad();
			}
		});
		top.layer.full(index);

	}, function() {
		var index = top.layer.open({
			type : 2,
			title : '报表明细',
			// maxmin : true,
			shadeClose : false, // 点击遮罩关闭层
			area : [ '800px', '520px' ],
			content : surl,
			cancel : function() {
				reLoad();
			}
		});
		top.layer.full(index);
	});
}