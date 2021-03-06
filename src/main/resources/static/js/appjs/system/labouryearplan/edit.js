$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/system/labouryearplan/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			nyear : {
				required : true
			},
			deptid : {
				required : true
			},
			a1 : {
				number : true
			},
			a2 : {
				number : true
			},
			a3 : {
				number : true
			},
			a4 : {
				number : true
			}
		},
		messages : {
			nyear : {
				required : icon + "请选择汇报年份"
			},
			deptid : {
				required : icon + "请选择单位"
			}
		}
	})
}