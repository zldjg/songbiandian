<%@ page pageEncoding="utf-8" %>
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
});	
</script>
<!--/select options-->
</head>
<body>
<!--当前位置-->
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li>首页</li>
        <li>特调试验管理</li>
        <li>方案管理</li>
        <li>方案录入</li>
    </ul>
</div>
<!--/当前位置-->
<div class="mainindex" id="mainindex">
    <div class="maincon">
        <!--列表信息-->
        <div class="ziliaobox">
            <table width="100%"  class="zltab" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr0">
                <td colspan="4" class="tdc">方案录入</td>
              </tr>
              <tr class="tr1">
                <td width="10%" class="tdc2">变电站：</td>
                <td width="40%">
                    <select class="select1"   style=" width:85%">
                        <option>请选择变电站</option>
                        <option>利民道</option>
                        <option selected="selected">新华路</option>
                        <option>白庙</option>
                    </select>
                </td>
                <td width="10%" class="tdc2">电压等级：</td>
                <td width="40%">
                    <select class="select1"  style=" width:85%">
                        <option>请选择电压等级</option>
                        <option>35kV</option>
                        <option>110kV</option>
                        <option selected="selected">220kV</option>
                        <option>500kV</option>
                    </select>
                </td>
              </tr>
              <tr class="tr1">
                <td width="10%" class="tdc2">设备类型：</td>
                <td width="40%">
                    <select class="select1"   style=" width:85%">
                        <option>请选择设备类型</option>
                        <option>电力变压器及电抗器</option>
                        <option>互感器</option>
                        <option>开关设备</option>
                        <option>电容器</option>
                        <option selected="selected">组合电器</option>
                    </select>
                </td>
                
                <td width="10%" class="tdc2">试验项目：</td>
                <td width="40%">
                    <select class="select1" >
                        <option>请选择试验项目</option>
                        <option selected="selected">交流耐压</option>
                        <option>绝缘电阻</option>
                        <option>GIS局部放电测量</option>
                        <option>断路器的机械特性试验</option>
                        <option>导电回路电阻</option>
                    </select>
                </td>
              </tr>
              <tr class="tr1">
                <td width="10%" class="tdc2">选择方案模板：</td>
                <td width="90%" colspan="5"> <input name="muban" type="radio" value="" /> 新华路试验模板（MB-001）<br />
                 <input name="muban" type="radio" value="" /> 新华路试验模板（MB-002）<br /></td>
              </tr>
              <tr class="tr1">
                <td width="10%" class="tdc2">上传附图：</td>
                <td width="90%" colspan="5"><input name="" type="text" class="dfinput" style="width:80%; float:left" />  <a href="#" class="longgrey">上传</a></td>
              </tr>
              <tr class="tr1">
                <td width="10%"></td>
                <td width="90%" colspan="3">
                    <a href="Fangan_details.jsp" class="longblue">生成方案</a> <a href="#" class="longgrey">取消</a>
                </td>
              </tr>
            </table>
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