<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<!-- saved from url=(0054)http://localhost:8088/TransformerInfo/UserLoginServlet -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<title></title>
<!--leftmenu styles-->
<link href="css/iejquery-accordion-menu.css" rel="stylesheet" type="text/css" />
<!--/leftmenu styles-->
<!--scrollbar style-->
<link href="css/perfect-scrollbar.css" rel="stylesheet"></link>
<!--/scrollbar style-->
<script src="js/jquery-1.11.2.min.js" type="text/javascript"></script>
<!--除IE外都可识别-->
<!--[if !IE 8]><!--[if !IE 7]><!--[if !IE 6]><!-->
<link href="css/jquery-accordion-menu.css" rel="stylesheet" type="text/css" />
<!--<![endif]--><!--<![endif]--><!--<![endif]-->
</head>
<body>
<div class="conmenu">	
	<div id="jquery-accordion-menu" class="jquery-accordion-menu red">
		<ul class="demo-list">
        <li class="active"><a href="Index.jsp" target="mainFrame"><img src="images/icon_01.png" alt="" width="16" height="16" />&nbsp;&nbsp;系统首页</a> </li>
		<li><a href="Fangan_mb.jsp" target="mainFrame"><img src="images/icon_tzh.png" alt="" width="16" height="16" />&nbsp;&nbsp;特调试验管理</a>
        	<ul class="submenu">           
			<li><a href="Fangan_mb.jsp"  target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;模板管理 </a></li>
            <li><a href="Fangan_gl.jsp" target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;方案管理</a></li>     
			<li><a href="Fangan_shp.jsp"  target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;方案审批 </a></li>
            <li><a href="Fangan_chx.jsp" target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;方案查询</a></li>
			</ul>
        </li>
        <li><a href="Sbtz_gl.jsp" target="mainFrame"><img src="images/menu-xc.png" alt="" width="16" height="16" />&nbsp;&nbsp;计量试验设备管理</a> 
        	<ul class="submenu">           
			<li><a href="Sbtz_gl.jsp"  target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;设备台账管理 </a></li>
            <li><a href="Sbtz_shh.jsp" target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;设备台账审核</a></li>
            <li><a href="Sbtz_tj.jsp" target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;设备台账统计</a></li>
   			</ul>
        </li>
        <li><a href="Sybg_mb.jsp" target="mainFrame"><img src="images/icon_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;试验报告管理</a> 
        	<ul class="submenu">           
			<li><a href="Sybg_mb.jsp"  target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;试验模板管理</a></li>
            <!--li><a href="Sybg_gl.jsp" target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;试验参数管理</a></li-->
			<li><a href="Sybg_gl.jsp"  target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;试验报告管理</a></li>
            <li><a href="Sybg_shh.jsp" target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;试验报告审核</a></li>
			<li><a href="Sybg_tj.jsp"  target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;试验报告统计</a></li>
			</ul>
        </li>
        <li><a href="Zhengshu_gl.jsp" target="mainFrame"><img src="images/menu-user.png" alt="" width="16" height="16" />&nbsp;&nbsp;人员资质管理</a> 
        	<ul class="submenu">           
			<li><a href="Zhengshu_gl.jsp"  target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;资质证书管理</a></li>
			</ul>
        </li>
        <li><a href="Dzqz_gl.jsp" target="mainFrame"><img src="images/menu-fa.png" alt="" width="16" height="16" />&nbsp;&nbsp;电子签章管理</a> 
        	<ul class="submenu">           
			<li><a href="Dzqz_gl.jsp"  target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;签章管理</a></li>
			</ul>
        </li>
        <li><a href="Quanxian_set.jsp" target="mainFrame"><img src="images/menu-set.png" alt="" width="16" height="16" />&nbsp;&nbsp;系统设置</a>
        	<ul class="submenu">           
			<li><a href="Quanxian_set.jsp"  target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;权限设置</a></li>
			<li><a href="User_gl.jsp"  target="mainFrame"><img src="images/menu_03.png" alt="" width="16" height="16" />&nbsp;&nbsp;用户管理</a></li>
			</ul>
        </li>   
        </ul>
	</div>
</div>

<!--scrollbar js-->
<script src="scrollbarjs/perfect-scrollbar.js"></script>
<script src="scrollbarjs/jquery.scrollbar.js"></script>
<!--/scrollbar js-->
<!--leftmenu js-->
<script src="js/jquery-accordion-menu.js" type="text/javascript"></script>
<script type="text/javascript">
//var bodyHeight = document.body.clientHeight;

jQuery(document).ready(function () {
	jQuery("#jquery-accordion-menu").jqueryAccordionMenu();
	$(".submenu li a").click(function(){
		$(".submenu li a").removeClass("active");
		$(this).addClass("active");
	});
	
});
$(function(){	
	//顶部导航切换
	$(".demo-list li").click(function(){
		$(".demo-list li.active").removeClass("active");
		$(this).addClass("active");
	});
	var bodyHeight = document.body.clientHeight;
	var bodyHeight = $(window).height();
	<!--<![endif]--><!--<![endif]--><!--<![endif]-->
	$(".conmenu").css({'height':bodyHeight});
})	

(function($) {
$.expr[":"].Contains = function(a, i, m) {
	return (a.textContent || a.innerText || "").toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
};
function filterList(header, list) {
	//@header 头部元素
	//@list 无需列表
	//创建一个搜素表单
	var form = $("<form>").attr({
		"class":"filterform",
		action:"#"
	}), input = $("<input>").attr({
		"class":"filterinput",
		type:"text"
	});
	$(form).append(input).appendTo(header);
	$(input).change(function() {
		var filter = $(this).val();
		if (filter) {
			$matches = $(list).find("a:Contains(" + filter + ")").parent();
			$("li", list).not($matches).slideUp();
			$matches.slideDown();
		} else {
			$(list).find("li").slideDown();
		}
		return false;
	}).keyup(function() {
		$(this).change();
	});
}
$(function() {
	filterList($("#form"), $(".demo-list"));
});
})(jQuery);	
</script>
<!--/leftmenu js-->

</body>
</html>