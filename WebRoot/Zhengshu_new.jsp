<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript">
String.prototype.trim = function(){  
    // 用正则表达式将前后空格  
    // 用空字符串替代。  
    return this.replace(/(^\s*)|(\s*$)/g, "");  
}

function Check()
{
	if (document.getElementById('name').value.trim() == '') {
		alert('请输入姓名');
		document.getElementById('name').focus();
		return false;
	}
 
	if (document.getElementById("age").value.trim() == ''){
		alert('请输入年龄');
		document.getElementById("age").focus();
		return false;
	}

	
}
</script>
<!--/select options-->
</head>
<body>
<!--当前位置-->
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li>首页</li>
        <li>人员资质管理</li>
        <li>资质证书管理</li>
        <li>添加</li>
    </ul>
</div>
<!--/当前位置-->
<div class="mainindex" id="mainindex">
    <div class="maincon">
        <!--列表信息-->
        <div class="ziliaobox">
        <form action="zhengshuAdd" method="post" onsubmit="return Check();">
            <table width="100%"  class="zltab" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr0">
                <td colspan="4" class="tdc">添加资质证书信息</td>
              <tr class="tr1">
                <td width="10%" class="tdc2">姓名：</td>
                <td width="40%">
                    <input name="name" id="name" type="text" class="dfinput" style=" width:85%;" placeholder="" />
                </td>
                <td width="10%" class="tdc2">性别：</td>
                <td width="40%">
                    <select  name="sex" class="select1"  style=" width:85%">
                        <option>男</option>
                        <option>女</option>
                    </select>
                </td>
              </tr>
              <tr class="tr1">
                <td width="10%" class="tdc2">年龄：</td>
                <td width="40%"><input name="age" id="age" type="text" class="dfinput" style=" width:85%;" placeholder="" />
                </td>
             
                <td width="10%" class="tdc2">出生日期：</td>
                <td width="40%">
                    <input class="inline laydate-icon" name="birthdate"  id="start" style=" width:80%">
                </td>
              </tr>
              <tr class="tr1">
                <td width="10%" class="tdc2">证书类型：</td>
                <td width="40%">
                    <select class="select1"  name="cer_type" style=" width:85%">
                        <option>请选择</option>
                    </select>
                </td>
                <td width="10%" class="tdc2">颁发机关：</td>
                <td width="40%">
                    <input type="text"  name="issue_office" class="dfinput" style=" width:82%;" placeholder="">
                </td>
              </tr>
              <tr class="tr1">
               <td width="10%" class="tdc2">颁发日期：</td>
                <td width="40%">
                    <input class="inline laydate-icon" name="issue_date" id="end" style=" width:80%">
                </td>
                <td width="10%" class="tdc2">有效期：</td>
                <td width="40%">
                    <input class="inline laydate-icon" name="validity" id="start2" style=" width:80%">
                </td>                             
              </tr>
              <tr class="tr1">
                <td width="10%" class="tdc2">附件上传：</td>
                <td width="90%" colspan="3"><input name="" type="text" class="dfinput" style="width:80%; float:left" />  <a href="#" class="longgrey">上传</a></td>
              </tr>
              <tr class="tr1">
                <td width="10%"></td>
                <td width="90%" colspan="3">
                    <input type="submit" value="保存" class="longgrey"> <a onclick="history.go(-1)" class="longgrey">取消</a>
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
