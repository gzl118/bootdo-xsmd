var ipurl = location.hostname;

var urlrunqian = "http://" + ipurl
		+ ":7878/jsDemo/reportJsp/showReportTJScroll.jsp?";
var urlrunqiantb = "http://" + ipurl
		+ ":7878/jsDemo/reportJsp/showReportScroll.jsp?";
var urlrunqiankbtb = "http://" + ipurl
		+ ":7878/jsDemo/reportJsp/showReportKbScroll.jsp?";
var urlrunqianadmin = "http://" + ipurl
		+ ":7878/jsDemo/reportJsp/showReportAdminScroll.jsp?";
var urlrunqianexportserver = "http://" + ipurl
		+ ":7878/jsDemo/reportJsp/exportReportServer.jsp?";

/*
 * var urlrunqian =
 * "http://localhost:7878/jsDemo/reportJsp/showReportTJScroll.jsp?"; var
 * urlrunqiantb =
 * "http://localhost:7878/jsDemo/reportJsp/showReportScroll.jsp?"; var
 * urlrunqiankbtb =
 * "http://localhost:7878/jsDemo/reportJsp/showReportKbScroll.jsp?"; var
 * urlrunqianadmin =
 * "http://localhost:7878/jsDemo/reportJsp/showReportAdminScroll.jsp?"; var
 * urlrunqianexportserver =
 * "http://localhost:7878/jsDemo/reportJsp/exportReportServer.jsp?";
 */

/**
 * 状态,0未提交，1已提交，2已审核通过，3审核未通过
 * 
 * 填报报表： 1.未提交，则一级单位可以：修改、删除、查看报表(可修改)、提交；二级单位无法查看数据；
 * 2.提交，则一级单位可以：查看报表（不能修改）、查看审批记录；二级单位可以：查看报表（可修改）、审批、查看审批记录；
 * 3.审批不通过，一级单位可以：修改、删除、查看报表(可修改)、提交、查看审批记录；二级单位可以：查看报表（不能修改）、查看审批记录；
 * 4.审批通过，一级单位可以：查看报表（不能修改）、查看审批记录；二级单位可以：查看报表（不能修改）、查看审批记录；
 * 
 * 统计报表： 1.未提交，则一级单位可以：修改、删除、查看报表、提交；二级单位无法查看数据；
 * 2.提交，则一级单位可以：查看报表、查看提交记录；二级单位可以：查看报表、查看提交记录；
 */


var arrReportCode=['10001','10002','10003','10004','10005','10006','10007','10013','10015','20001','20002','20003','20004','20005','20006','20007','20008','30001','30002','30003','30004','30005','30006','30007','30013','30015','40001'];
var arrReportName=['人员分类','人员变动','劳动效率','工时情况','工资报表','人员结构','专业技术人员','焦化效率','工资附表','人数整合快报','效率整合快报','工资整合快报','人员变动整合快报','人数本部快报','效率本部快报','工资本部快报','人员变动本部快报','人员分类合计','人员变动合计','劳动效率合计','工时情况合计','工资报表合计','人员结构合计','专业技术人员合计','焦化效率合计','工资附表合计','自定义报表'];