<%@ page pageEncoding="utf-8" %>
<%@page import="songbiandian.javabean.TestReportMetaData"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/iestyle.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<!--scrollbar style-->
<link href="css/perfect-scrollbar.css" rel="stylesheet"></link>
<!--/scrollbar style-->
<!--menu style-->
<link href="css/style-menu.css" rel="stylesheet"></link>
<!--/menu style-->
<!--分页插件style-->
<link type="text/css" rel="stylesheet" href="css/simplePagination.css"/>
<!--/分页插件style-->
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<!--menu js-->
<script type="text/javascript" src="js/jquery.menu.js"></script>
<!--/menu js-->
<script type="text/javascript" src="js/jquery.common.js"></script>
<!--除IE外都可识别-->
<!--calendar-->
<script type="text/javascript" src="calendarjs/laydate.js"></script>
<!--/calendar-->
<!--分页插件 js-->
<script type="text/javascript" src="js/jquery.simplePagination.js"></script>
<!--/分页插件 js-->
<!--[if !IE 8]><!--[if !IE 7]><!--[if !IE 6]><!-->
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!--<![endif]--><!--<![endif]--><!--<![endif]-->
<!--select options-->
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 150			  
	});
	$(".select2").uedSelect({
		width : 500  
	});
});
</script>
<script type="text/javascript">
$(function(){	
	var mydate = new Date();
	var t=mydate.toLocaleString();
	$("#end").text(t);
})	
</script>
<!--/select options-->
</head>
<body>
<!--当前位置-->
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li>首页</li>
        <li>试验报告管理</li>
        <li>试验报告审核</li>
    </ul>
</div>
<!--/当前位置-->

<div class="mainindex" id="mainindex">
    <div class="maincon">
        <!--列表信息-->
        <div class="ziliaobox">
    	<form name="del" method="post" action="#">        
          <table width="100%" class="zltab" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr0">
                <td width="4%" class="tdc"><input name="chkAll" type="checkbox" id="chkAll" onclick="CheckAll(this.form)" value="checkbox" /></td>
                <td style="text-align:center" width="26%">试验报告名称</td>
                <td style="text-align:center" width="10%">站名</td>
                <td style="text-align:center" width="12%">设备类型</td>
                <td style="text-align:center" width="8%">试验性质</td>
                <td style="text-align:center" width="8%">试验人员</td>
                <td style="text-align:center" width="7%">是否审核</td>
                <td style="text-align:center" width="10%">审核时间</td>
                <td style="text-align:center" width="15%">操作</td>
              </tr>
              <%
              ArrayList<TestReportMetaData> testReportList = (ArrayList<TestReportMetaData>)session.getAttribute("report_test_metainfolist");
              if (testReportList.size() == 0) {
               %>
              		<tr class="tr1">
              			<td><input name='ID' type='checkbox' onclick="unselectall()" value='1'></input></td>
              			<td></td>
              			<td></td>
              			<td></td>
              			<td></td>
              			<td></td>
              			<td></td>
              			<td></td>
              			<td></td>
              		</tr>
              <%
              }
              else {
              	for (TestReportMetaData testReport : testReportList) {
               %>
                	<tr class="tr1">
                		<td class="tdc"><input name='ID' type='checkbox' onclick="unselectall()" value='1'></input></td>
                		<td style="text-align:center"><%=testReport.getTestReportName() %></td>
              			<td style="text-align:center"><%=testReport.getStationName() %></td>
              			<td style="text-align:center"><%=testReport.getEquipmentType() %></td>
              			<td style="text-align:center"><%=testReport.getTestAttribute() %></td>
              			<td style="text-align:center"><%=testReport.getTestPerson() %></td>
              			<td style="text-align:center">否</td>
              			<td style="text-align:center"></td>
              			<td style="text-align:center"><a href="#">查看详细</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#">通过</a></td>
                	</tr>
              <%
              	}
              }
               %>                                   
              <tr class="tr2">
                <td colspan="9">
                	<div id="paging1" class="page" style="float:right"></div>
                </td>
              </tr>
            </table>
          </form>
          </div>
          <!--/列表信息-->
    </div> 
</div>

<!--height Resize js-->
<script type="text/javascript">
$(document).ready(function() {	
	windowResize();
	$(window).resize(function () {
    windowResize();
	});	
});
</script>
<!--/height Resize js-->
<!--scrollbar js-->
<script src="scrollbarjs/perfect-scrollbar.js"></script>
<script src="scrollbarjs/jquery.scrollbar.js"></script>
<!--/scrollbar js-->
<script type="text/javascript">
$(function(){
    $("#paging1").pagination({
        items: 100,
        itemsOnPage: 10,
        cssStyle: 'compact-theme'
    });
});
</script>
<script type="text/javascript">
!function(){
	laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
	laydate({elem: '#bianzhi'});//绑定元素
}();

//日期范围限制
var start = {
    elem: '#start',
    format: 'YYYY-MM-DD',
    min: laydate.now(), //设定最小日期为当前日期
    max: '2099-06-16', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas; //将结束日的初始值设定为开始日
    }
};

var end = {
    elem: '#end',
    format: 'YYYY-MM-DD',
    min: laydate.now(),
    max: '2099-06-16',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，充值开始日的最大日期
    }
};
laydate(start);
laydate(end);
</script>
</body>

</html>