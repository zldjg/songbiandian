<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
 <%@ page import="com.entity.*" %>
 <%
 Managroup managroup = (Managroup)request.getAttribute("managroup");
 


%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/iestyle.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<!--scrollbar style-->
<link href="css/perfect-scrollbar.css" rel="stylesheet">
<!--/scrollbar style-->
<!--menu style-->
<link href="css/style-menu.css" rel="stylesheet">
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
		width : 300			  
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
        <li>系统设置</li>
        <li>权限设置</li>
        <li>添加组</li>
    </ul>
</div>
<!--/当前位置-->
<div class="mainindex" id="mainindex">
<form action="group.do?method=modify" method="post" >
    <div class="maincon">
        <!--列表信息-->
        <div class="ziliaobox">
            <table width="100%"  class="zltab" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr0">
                <td colspan="2" class="tdc">修改管理组信息</td>
                 <td><input type="hidden" name="groupid" value="<%= managroup.getGroup_id()%>"></td></tr>
              <tr class="tr1">
                <td width="20%" style="text-align:right">组名称：</td>
                <td width="80%">
                    <input name="groupname" type="text" value="<%=managroup.getGroupname()%>" class="dfinput" style=" width:85%;" />
                </td>
              </tr>
              <tr class="tr1">
                <td width="20%"  style="text-align:right">组描述：</td>
                <td width="80%"><input name="descriptor" type="text"  value="<%=managroup.getDescriptor()%>" class="dfinput" style=" width:85%;"  /></td>
              </tr>
             <tr  class="tr1">
                <td width="20%"  style="text-align:right">权限：</td>
                <td width="80%">
                    <select class="select1" name="authority" value="<%=managroup.getAuthority()%>" style=" width:85%">
                        <option>9999</option>
                        <option>999</option>
                        <option>99</option>
                        <option>9</option>
                    </select>
                </td>
              </tr> 
              <tr class="tr1">
                <td width="20%"  style="text-align:right">特调试验管理：</td>
                <td width="80%"><input name='ID' type='checkbox' onClick="unselectall()" value='1'> 模板管理  <input name='ID' type='checkbox' onClick="unselectall()" value='2'> 方案管理 <input name='ID' type='checkbox' onClick="unselectall()" value='3'> 方案审批 <input name='ID' type='checkbox' onClick="unselectall()" value='4'>  方案查询</td>
              </tr>
              <tr class="tr1">
                <td width="20%"  style="text-align:right">计量试验设备管理：</td>
                <td width="80%"><input name='ID' type='checkbox' onClick="unselectall()" value='5'> 设备台账管理  <input name='ID' type='checkbox' onClick="unselectall()" value='6'> 设备台账审核 <input name='ID' type='checkbox' onClick="unselectall()" value='7'> 设备台账统计</td>
              </tr>
              <tr class="tr1">
                <td width="20%"  style="text-align:right">试验报告管理：</td>
                <td width="80%"><input name='ID' type='checkbox' onClick="unselectall()" value='8'> 试验模板管理  <input name='ID' type='checkbox' onClick="unselectall()" value='9'> 试验报告管理 <input name='ID' type='checkbox' onClick="unselectall()" value='10'> 试验报告审核 <input name='ID' type='checkbox' onClick="unselectall()" value='11'>  试验报告统计</td>
              </tr>
              <tr class="tr1">
                <td width="20%"  style="text-align:right">人员资质管理：</td>
                <td width="80%"><input name='ID' type='checkbox' onClick="unselectall()" value='12'> 资质证书管理</td>
              </tr>
              <tr class="tr1">
                <td width="20%"  style="text-align:right">电子签章管理：</td>
                <td width="80%"><input name='ID' type='checkbox' onClick="unselectall()" value='13'> 签章管理</td>
              </tr>
              <tr class="tr1">
                <td width="20%"  style="text-align:right">系统设置：</td>
                <td width="80%"><input name='ID' type='checkbox' onClick="unselectall()" value='14'> 权限设置 <input name='ID' type='checkbox' onClick="unselectall()" value='15'> 用户管理</td>
              </tr>
              <tr class="tr1">
                <td width="20%"  style="text-align:right">状态：</td>
                <td width="80%">
                    <select class="select1"  name="state" style=" width:85%">
                        <option>启用</option>
                        <option>禁用</option>
                    </select>
                </td>
              </tr>
              <tr class="tr1">
                <td width="20%"></td>
                <td width="80%" colspan="3">
                    <input type="submit" class="longblue" value="保存"> <a onclick="history.go(-1)" class="longgrey">取消</a>
                </td>
              </tr>
            </table>
        </div>
          <!--/列表信息-->
    </div> 
    </form>
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
         end.start = datas //将结束日的初始值设定为开始日
    }
};

var start2 = {
    elem: '#start2',
    format: 'YYYY-MM-DD',
    min: laydate.now(), //设定最小日期为当前日期
    max: '2099-06-16', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
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
laydate(start2);
laydate(end);
</script>
</body>

</html>
