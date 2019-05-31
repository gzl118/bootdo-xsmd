$().ready(function() {
	validateRule();

	var ndate=new Date().AddTime("M",-1).Format("yyyy-MM");
	
	laydate.render({
		elem : '#renderdate',
		type : 'month',
		trigger : 'click',
		format:'yyyy-MM',
		value:ndate
	});
});
Date.prototype.AddTime = function (fmt, nvalue) {
    var year = this.getFullYear();
    var month = this.getMonth();
    var day = this.getDate();
    var hour = this.getHours();
    var min = this.getMinutes();
    var sec = this.getSeconds();
    switch (fmt) {
        case "y":
            year += nvalue;
            break;
        case "M":
            month += nvalue;
            break;
        case "d":
            day += nvalue;
            break;
        case "h":
            hour += nvalue;
            break;
        case "m":
            min += nvalue;
            break;
        case "s":
            sec += nvalue;
            break;
    }
    d = new Date(year, month, day, hour, min, sec);
    return d;
};
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth(),
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S": this.getMilliseconds()
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};
$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/system/labourreportmain/save",
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
			renderdepart : {
				required : true
			},
			renderdate : {
				required : true
			}
		},
		messages : {
			renderdepart : {
				required : icon + "请输入单位名称"
			},
			renderdate : {
				required : icon + "请输入汇报年月"
			}
		}
	})
}

var openDept = function() {
	layer.open({
		type : 2,
		title : "选择部门",
		area : [ '300px', '450px' ],
		content : "/system/sysDept/treeView"
	})
}
function loadDept(deptId, deptName) {
	$("#ext1").val(deptId);
	$("#renderdepart").val(deptName);
}