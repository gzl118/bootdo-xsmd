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
