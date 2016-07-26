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
<!--åé¡µæä»¶style-->
<link type="text/css" rel="stylesheet" href="css/simplePagination.css"/>
<!--/åé¡µæä»¶style-->
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<!--menu js-->
<script type="text/javascript" src="js/jquery.menu.js"></script>
<!--/menu js-->
<script type="text/javascript" src="js/jquery.common.js"></script>
<!--é¤IEå¤é½å¯è¯å«-->
<!--calendar-->
<script type="text/javascript" src="calendarjs/laydate.js"></script>
<!--/calendar-->
<!--åé¡µæä»¶ js-->
<script type="text/javascript" src="js/jquery.simplePagination.js"></script>
<!--/åé¡µæä»¶ js-->
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
<!--å½åä½ç½®-->
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li>首页</li>
        <li>试验报告管理</li>
        <li>试验模板管理</li>
        <li>模板添加</li>
    </ul>
</div>
<!--/å½åä½ç½®-->
<div class="mainindex" id="mainindex">
    <div class="maincon">
        <!--åè¡¨ä¿¡æ¯-->
        <div class="ziliaobox">
           <form action="generateTestReportTemplate" method="post">
            <table width="100%"  class="zltab" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr0">
                <td colspan="6" class="tdc">模板添加 </td>
              </tr>
              <tr class="tr1">
                <td width="10%" class="tdc2">模板名称：</td>
                <td width="40%">
                    <input name="templatename" type="text" class="dfinput" style=" width:85%;" autofocus="autofocus" placeholder="利民道-220kV避雷器-电气-交接试验-20160126" />
                </td>
                <td width="10%" class="tdc2">设备类型</td>
                <td width="40%">
                    <select class="select1" name="equipmenttype"   style=" width:55%">
                        <option value="电力变压器及电抗器">电力变压器及电抗器</option>
                        <option value="互感器">互感器</option>
                        <option value="开关设备">开关设备</option>
                        <option value="电容器">电容器</option>
                    </select>
                </td>
              </tr>
              <tr class="tr1">
              	<td width="10%" class="tdc2">设备名称</td>
                <td>
                	<select class="select1" name="equipment" style="width:15%">
                		<option value="10kv干式变">10kV干式变</option>
						<option value="35kv干式变">35kV干式变</option>
						<option value="35kv油变">35kV油变</option>
						<option value="66kv站用变">66kV站用变</option>
						<option value="110kv二绕组">110kV二绕组</option>
						<option value="110kv三绕组">110kV三绕组</option>
						<option value="220kv二绕组">220kV二绕组</option>
						<option value="220kv三绕组">220kV三绕组</option>
                	</select>
                </td>
              </tr>
              <tr class="tr1">
                <td width="15%">选择试验项目：</td>
                <td width="85%" colspan="4">
                    <input type="checkbox" name="project" value="绝缘电阻" />绝缘电阻(MΩ)
					<input type="checkbox" name="project" value="直流电阻" />直流电阻
					<input type="checkbox" name="project" value="电压比" />电压比
					<input type="checkbox" name="project" value="交流耐压" />交流耐压
					<input type="checkbox" name="project" value="短路阻抗" />短路阻抗
					<input type="checkbox" name="project" value="负载损耗" />负载损耗
                </td>
              </tr>
              <tr class="tr1">
                <td width="10%"></td>
                <td width="90%" colspan="4">
                    <input type="submit" value="生成模板""/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="reset" value="取消"/>
                </td>
              </tr>
            </table>
          </form>
        </div>
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
	laydate.skin('molv');//åæ¢ç®è¤ï¼è¯·æ¥çskinsä¸é¢ç®è¤åº
	laydate({elem: '#bianzhi'});//ç»å®åç´ 
}();

//æ¥æèå´éå¶
var start = {
    elem: '#start',
    format: 'YYYY-MM-DD',
    min: laydate.now(), //è®¾å®æå°æ¥æä¸ºå½åæ¥æ
    max: '2099-06-16', //æå¤§æ¥æ
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //å¼å§æ¥éå¥½åï¼éç½®ç»ææ¥çæå°æ¥æ
         end.start = datas; //å°ç»ææ¥çåå§å¼è®¾å®ä¸ºå¼å§æ¥
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
        start.max = datas; //ç»ææ¥éå¥½åï¼åå¼å¼å§æ¥çæå¤§æ¥æ
    }
};
laydate(start);
laydate(end);
</script>
</body>

</html>
