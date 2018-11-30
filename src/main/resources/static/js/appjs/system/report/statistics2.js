var prefix = "/system/reportStatistics"
$(function() {
	selectLoad();
	loaddepts($('#dw-select').val());
});
function loaddepts(rdcId) {
	//加载已配置的单位配置
	$('#exampleTable')
		.bootstrapTreeTable(
			{
				id : 'deptId',
				code : 'deptId',
                parentCode : 'parentId',
                params:'85',
				type : "GET", // 请求数据的ajax类型
				url : '/system/reportDept/list', // 请求数据的ajax的url
				ajaxParams : {
					rdcId : rdcId,
					limit : 5000,
					offset : 0
							}, // 请求数据的ajax的data属性
				expandColumn : '1', // 在哪一列上面显示展开按钮
				striped : true, // 是否各行渐变色
				bordered : true, // 是否显示边框
				expandAll : true, // 是否全部展开								
				columns : [
					{
						title : '编号',
						field : '',
						visible : false,
						align : 'center',
						valign : 'center',
						width : '50px',
					},
					{
						field : 'sname',
						title : '单位简称',
                        valign : 'center',
						witth :20
					},
					{
						field : 'orderNum',
						title : '排序',
                        align : 'center',
                        valign : 'center'
					},
					{
						title : '操作',
						field : 'id',
						align : 'center',
                        valign : 'center',
						formatter : function(item, index) {
							var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
								+ item.rdId
								+ '\')"><i class="fa fa-edit"></i></a> ';
							var a = '<a class="btn btn-primary btn-sm ' + s_add_h + '" href="#" title="增加下級"  mce_href="#" onclick="add(\''
								+ item.deptId
								+ '\')"><i class="fa fa-plus"></i></a> ';
							var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="removeone(\''
								+ item.rdId
								+ '\')"><i class="fa fa-remove"></i></a> ';
							return e + a + d;
						}
					} ]
			});
}
function loaddeptslist() {
	//加载自定义单位配置列表
	$('#exampleTable')
	.bootstrapTreeTable(
		{
			id : 'deptId',
			code : 'deptId',
            parentCode : 'parentId',
			type : "GET", // 请求数据的ajax类型
			url : '/system/sysDept/list', // 请求数据的ajax的url
			ajaxParams : {
				limit : 5000,
				offset : 0
						}, // 请求数据的ajax的data属性
			expandColumn : '1', // 在哪一列上面显示展开按钮
			striped : true, // 是否各行渐变色
			bordered : true, // 是否显示边框
			expandAll : true, // 是否全部展开	
			columns : [
				{
					field: 'selectItem',
					checkbox : true,
					align : 'center',
					valign : 'center',
					width : '50px',
					hight : '50px'
				},
				{
					field : 'name',
					title : '单位名称',
                    valign : 'center',
					witth :20
				},
				{
					field : 'delFlag',
					title : '状态',
					align : 'center',
                    valign : 'center',
					formatter : function(item, index) {
						if (item.delFlag == '0') {
							return '<span class="label label-danger">禁用</span>';
						} else if (item.delFlag == '1') {
							return '<span class="label label-primary">正常</span>';
						}
					}
				}]
		});
}
function reLoad() {
	loaddepts($('#dw-select').val());
}
function selectLoad() {
	var html = "";
	$.ajax({
		url : '/system/reportDeptCategory/grouplist',
		data : {
			limit: 20,
			offset: 0,
			code: 12001   //不同的统计报表，选择不同的code分类,后台自己控制
		},
		success : function(data) {
			//没有数据，加载自定义的单位列表
			 if(data.length<1){
				 loaddeptslist();
				 return;
			 }
			//加载数据
			for (var i = 0; i < data.length; i++) {
				if(i==0){
					html += '<option value="' + data[i].rdcId + '" selected >' + data[i].name + '</option>';
				}
				else{
					html += '<option value="' + data[i].rdcId + '">' + data[i].name + '</option>';
				}
			}
			$(".chosen-select").append(html);
			$(".chosen-select").chosen({
				maxHeight : 200
			});
			//点击事件
			$('.chosen-select').on('change', function(e, params) {
				console.log(params.selected);
				if(params.selected==-1){//选择自定义单位配置
					alert("-1");
					loaddeptslist();
				}
				else{
					alert("222");
					loaddepts(params.selected);
				}
			});
		}
	});
}
function showReport() {
	
	
	var deptss;
	if(rdcId==-1){
		// 自定义部门的选择
	 deptss =	getSelectedDept();
	}
	else{
		rdcId=$('#dw-select').val();
	}
	
	rdate=$('#renderdate').val();
	if(rdate=="") 
	{
		var d=new Date();
		d.setDate(1);
		rdate=formatdate(d);
	}
	else rdate=$('#renderdate').val()+ '-01';	
	
//	url='http://localhost:7878/jsDemo/reportJsp/showReport.jsp?raq=11001.raq&rdate='+rdate+'&rdcId='+rdcId;
	url='www.baidu.com';  //自己根据业务添加路径
	
	var index = layer.open({
		type : 2,
		title : "统计报表明显",
		shadeClose : false, // 点击遮罩关闭层
		area : [ '1000px', '620px' ],
		fixed: false,
		maxmin : true,
		content : url
	});
	layer.full(index);
}
function formatdate(date){
    var y = date.getFullYear();  
    var m = date.getMonth() + 1;  
    m = m < 10 ? '0' + m : m;  
    var d = date.getDate();  
    d = d < 10 ? ('0' + d) : d;  
    return y + '-' + m + '-' + d;  
}
function selectDept(){
	add(0);
}
function delectDeptCategory(){
	removeDeptCategory($('#dw-select').val());
	selectLoad();
}
function removeDeptCategory(id) {
	layer.confirm('确定要删除当前的单位配置？删除后无法恢复。', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : "/system/reportDeptCategory/remove",
			type : "post",
			data : {
				'rdcId' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}
function add(pId) {
	layer.open({
		type : 2,
		title : '添加选择单位',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : '/system/reportDept/add?parentId='+pId // iframe的url
	});
}
function saveAddedDept(deptId,name,parentId) {
	$.ajax({
		cache : true,
		type : "POST",
		url :  "/system/reportDept/save",
		data : {
			rdcId: $('#dw-select').val(),
			parentId: parentId,
			deptId: deptId,
			sname: name
		},
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
			} else {
				parent.layer.alert(data.msg)
			}
			reLoad();
		}
	});
}
function batchAddedDepts(deptIds) {
	$.ajax({
		cache : true,
		type : "POST",
		url :  "/system/reportDept/batchAddToDepts",
		data : {
			rdcId: $('#dw-select').val(),
			"ids" : deptIds
		},
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				reLoad();
			} else {
				parent.layer.alert(data.msg)
			}
			
		}
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : '/system/reportDept/edit/' + id // iframe的url
	});
}
function removeone(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : "/system/reportDept/remove",
			type : "post",
			data : {
				'rdId' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}
function getSelectedDept()
{
	var rows = $('#exampleTable').bootstrapTreeTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("您没有选择统计使用的任何单位部门");
		return;
	}
	var ids = new String();
	// 遍历所有选择的行数据，取每条数据对应的ID
	$.each(rows, function(i, row) {
			console.log(row.id);
			ids += ','+row.id;
//			console.log(ids);
		});
	console.log(ids.substr(1));
	return ids.substr(1);
}
function saveDeptToCategory(){
	layer.prompt({title: '请输入保存配置的名称', formType: 1}, function(val, index){
		  layer.msg('新的配置命名为：'+val);
		  layer.close(index);
		});
}
function getDeptsStr() {
	$.ajax({
		cache : true,
		type : "GET",
		url :  "/system/reportDept/save",
		data : {
			rdcId: $('#dw-select').val(),
			parentId: parentId,
			deptId: deptId,
			sname: name
		},
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
			} else {
				parent.layer.alert(data.msg)
			}
			reLoad();
		}
	});
}
