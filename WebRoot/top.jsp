<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String username = (String)session.getValue("theusername");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.11.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	});
	var mydate = new Date();
	var t=mydate.toLocaleString();
	$("#currentTime").text("当前时间："+t);
})	
</script>
</head>

<body style="background:url(images/topbg.png);">

    <div class="topleft">
    	<a href="main.html" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
    </div>
    <div class="topright">    
        <ul>
        	<li id="currentTime"></li>
        	<li><a href="login.jsp" target="_parent">退出</a></li>
    	</ul>     
        <div class="user">
            <span>用户 (<%=username %>)</span>
        </div>    
    </div>

</body>
</html>
