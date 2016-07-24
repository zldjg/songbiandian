<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/iestyle.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<!--scrollbar style-->
<link href="css/perfect-scrollbar.css" rel="stylesheet" />
<!--/scrollbar style-->
<!--menu style-->
<link href="css/style-menu.css" rel="stylesheet" />
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
		width : 100			  
	});
	$(".select2").uedSelect({
		width : 500  
	});
	$(".select3").uedSelect({
		width :150  
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
        <li>试验报告管理</li>
        <li>试验模板管理</li>
        <li>实验报告录入</li>
    </ul>   
    <span style="margin-top:3px; float:right; margin-right:10px;"><a href="saveTestReport" class="longblue">保存信息</a></span>
</div>
<!--/当前位置-->
<div class="mainindex" id="mainindex">
    <div class="maincon">
        <!--列表信息-->
        
        <div class="fangan-detailse">
            <div class="title1 font28">
            	<span>避雷器电气</span> 试验报告
            </div>
        </div>
        <div class="sybgtab-style" >
            <table width="100%"  class="sybgtab" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr1">
                <td width="16%" class="tdc2">站名</td>
                <td width="16%">黄花店新</td>
                <td width="16%" class="tdc2">运行编号</td>
                <td width="16%">2063-3避雷器</td>
                <td width="16%" class="tdc2">委托单位</td>
                <td width="17%"><select class="select3">
                        <option>请选择委托单位</option>
                    </select></td>
              </tr>
              <tr class="tr1">
                <td width="16%" class="tdc2">试验单位</td>
                <td width="16%"><select class="select3">
                        <option>请选择试验单位</option>
                    </select></td>
                <td width="16%" class="tdc2">试验性质</td>
                <td width="16%">交接</td>
                <td width="16%" class="tdc2">试验日期</td>
                <td width="17%"><input name="" type="text" class="dfinput" style="width:150px;" value="2016-01-25" /></td>
              </tr>
              <tr class="tr1">
                <td width="16%" class="tdc2">试验人员</td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;" value="孙大康" /></td>
                <td width="16%" class="tdc2">试验地点</td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;" value="黄花店新" /></td>
                <td width="16%" class="tdc2">报告日期</td>
                <td width="17%">2016-01-26</td>
              </tr>
              <tr class="tr1">
                <td width="16%" class="tdc2">报告人</td>
                <td width="16%">高嵩</td>
                <td width="16%" class="tdc2">审核人</td>
                <td width="16%"></td>
                <td width="16%" class="tdc2">批准人</td>
                <td width="17%"></td>
              </tr>
              <tr class="tr1">
                <td width="16%" class="tdc2">试验天气</td>
                <td width="16%">晴</td>
                <td width="16%" class="tdc2">温度</td>
                <td width="16%">20°C</td>
                <td width="16%" class="tdc2">湿度</td>
                <td width="17%">20%</td>
              </tr>
            </table>
            <table width="100%"  class="sybgtab" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr1">
                <td width="25%" class="tdc2">相别</td>
                <td width="25%" class="tdc1">A</td>
                <td width="25%" class="tdc1">B</td>
                <td width="25%" class="tdc1">C</td>
              </tr>
              <tr class="tr1">
                <td width="25%" class="tdc2">厂名</td>
                <td width="25%" class="tdc1">西安西电高压电器厂</td>
                <td width="25%" class="tdc1">西安西电高压电器厂</td>
                <td width="25%" class="tdc1">西安西电高压电器厂</td>
              </tr>
              <tr class="tr1">
                <td width="25%" class="tdc2">节数</td>
                <td width="25%" class="tdc1"></td>
                <td width="25%" class="tdc1"></td>
                <td width="25%" class="tdc1"></td>
              </tr>
              <tr class="tr1">
                <td width="25%" class="tdc2">出厂日期</td>
                <td width="25%" class="tdc1">2015-03-01</td>
                <td width="25%" class="tdc1">2015-03-01</td>
                <td width="25%" class="tdc1">2015-03-01</td>
              </tr>
              <tr class="tr1">
                <td width="25%" class="tdc2">出厂编号</td>
                <td width="25%" class="tdc1">150607908</td>
                <td width="25%" class="tdc1">150607909</td>
                <td width="25%" class="tdc1">150607907</td>
              </tr>
              <tr class="tr1">
                <td width="25%" class="tdc2">额定电压(kV)</td>
                <td width="25%" class="tdc1">17</td>
                <td width="25%" class="tdc1">17</td>
                <td width="25%" class="tdc1">17</td>
              </tr>
              <tr class="tr1">
                <td width="25%" class="tdc2">相位</td>
                <td width="25%" class="tdc1">1</td>
                <td width="25%" class="tdc1">2</td>
                <td width="25%" class="tdc1">3</td>
              </tr>
              <tr class="tr1">
                <td width="25%" class="tdc2">型号</td>
                <td width="25%" class="tdc1">HY5WR-17/45 G600A</td>
                <td width="25%" class="tdc1">HY5WR-17/45 G600A</td>
                <td width="25%" class="tdc1">HY5WR-17/45 G600A</td>
              </tr>
              <tr class="tr1">
                <td width="25%" class="tdc2">直流参考电压（kV）</td>
                <td width="25%" class="tdc1"></td>
                <td width="25%" class="tdc1"></td>
                <td width="25%" class="tdc1"></td>
              </tr>
              <tr class="tr2">
                <td width="25%" colspan="4" >温度：20.0℃  湿度：20.0%</td>
              </tr>
            </table>
            
            <table width="100%"  class="sybgtab" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr1">
                <td width="25%" class="tdc" colspan="2">绝缘电阻(不分节)</td>
                <td width="25%">耐压前绝缘电阻(MΩ)</td>
                <td width="25%">耐压后绝缘电阻(MΩ)</td>
              </tr>
              <tr class="tr1">
                <td width="25%" class="tdc1" rowspan="2">A</td>
                <td width="25%">本体</td>
                <td width="25%"><input name="" type="text" class="dfinput" style="width:150px;" value="100000"/></td>
                <td width="25%"><input name="" type="text" class="dfinput" style="width:150px;" /></td>
              </tr>
              <tr class="tr1">
                <td width="25%">底座</td>
                <td width="25%"><input name="" type="text" class="dfinput" style="width:150px;"  value="1000"/></td>
                <td width="25%"><input name="" type="text" class="dfinput" style="width:150px;" /></td>
              </tr>
              <tr class="tr1">
                <td width="25%" class="tdc1" rowspan="2">B</td>
                <td width="25%">本体</td>
                <td width="25%"><input name="" type="text" class="dfinput" style="width:150px;" value="100000"/></td>
                <td width="25%"><input name="" type="text" class="dfinput" style="width:150px;" /></td>
              </tr>
              <tr class="tr1">
                <td width="25%">底座</td>
                <td width="25%"><input name="" type="text" class="dfinput" style="width:150px;"  value="1000"/></td>
                <td width="25%"><input name="" type="text" class="dfinput" style="width:150px;" /></td>
              </tr>
              <tr class="tr1">
                <td width="25%" class="tdc1" rowspan="2">C</td>
                <td width="25%">本体</td>
                <td width="25%"><input name="" type="text" class="dfinput" style="width:150px;" value="100000"/></td>
                <td width="25%"><input name="" type="text" class="dfinput" style="width:150px;" /></td>
              </tr>
              <tr class="tr1">
                <td width="25%">底座</td>
                <td width="25%"><input name="" type="text" class="dfinput" style="width:150px;"  value="1000"/></td>
                <td width="25%"><input name="" type="text" class="dfinput" style="width:150px;" /></td>
              </tr>
              <tr class="tr1">
                <td colspan="4"> 试验仪器:<input name="" type="text" class="dfinput" style="width:150px;" value="绝缘电阻表"/> <span style="padding-left:300px;">仪器编号:<input name="" type="text" class="dfinput" style="width:150px;" value="1" /></span></td>
              </tr>
              <tr class="tr1">
                <td colspan="4">项目结论:合格</td>
              </tr>
              <tr class="tr2">
                <td colspan="4" >温度：20.0℃  湿度：20.0%</td>
              </tr>
            </table>
            <table width="100%"  class="sybgtab" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr1">
                <td width="20%" class="tdc" colspan="2">直流试验</td>
                <td width="16%" class="tdc1">U1mA (kV)</td>
                <td width="16%" class="tdc1">U1mA 初值(kV)</td>
                <td width="16%" class="tdc1">U1mA 初值差(%)</td>
                <td width="16%" class="tdc1">75%U1mA 下的电流(uA)</td>
                <td width="16%" class="tdc1">75%U1mA 初值差(%)</td>
              </tr>
              <tr class="tr1">
                <td width="10%" class="tdc1" rowspan="4">A</td>
                <td width="10%" class="tdc1">第一节</td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;" value="25.2" /></td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;" value="0" /></td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;" value="2" /></td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;" value="2" /></td>
              </tr>
              <tr class="tr1">
                <td class="tdc1">第二节</td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
              </tr>
              <tr class="tr1">
                <td class="tdc1">第三节</td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
              </tr>
              <tr class="tr1">
                <td class="tdc1">第四节</td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
              </tr>
              <tr class="tr1">
                <td width="10%" class="tdc1" rowspan="4">B</td>
                <td width="10%" class="tdc1">第一节</td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;"  value="25.7"/></td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;" value="0" /></td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;" value="3" /></td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;" value="0" /></td>
              </tr>
              <tr class="tr1">
                <td class="tdc1">第二节</td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
              </tr>
              <tr class="tr1">
                <td class="tdc1">第三节</td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
              </tr>
              <tr class="tr1">
                <td class="tdc1">第四节</td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
              </tr>
              <tr class="tr1">
                <td width="10%" class="tdc1" rowspan="4">C</td>
                <td width="10%" class="tdc1">第一节</td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;"  value="25.5" /></td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;" value="0"/></td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;" value="3" /></td>
                <td width="16%"><input name="" type="text" class="dfinput" style="width:150px;" value="0" /></td>
              </tr>
              <tr class="tr1">
                <td class="tdc1">第二节</td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
              </tr>
              <tr class="tr1">
                <td class="tdc1">第三节</td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
              </tr>
              <tr class="tr1">
                <td class="tdc1">第四节</td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
                <td><input name="" type="text" class="dfinput" style="width:150px;" /></td>
              </tr>
              <tr class="tr1">
                <td colspan="7"> 试验仪器:<input name="" type="text" class="dfinput" style="width:150px;" value="绝缘电阻表"/> <span style="padding-left:300px;">仪器编号:<input name="" type="text" class="dfinput" style="width:150px;" value="1" /></span></td>
              </tr>
              <tr class="tr1">
                <td colspan="7">项目结论:合格</td>
              </tr>
              <tr class="tr2">
                <td colspan="7" >温度：20.0℃  湿度：20.0%</td>
              </tr>
            </table>
            
            
            <table width="100%"  class="sybgtab" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr1">
                <td width="33%" class="tdc1">外观和计数器动作检查</td>
                <td width="33%" class="tdc1">计数器动作检查</td>
                <td width="34%" class="tdc1">外观检查</td>
              </tr>
              <tr class="tr1">
                <td class="tdc1">A</td>
                <td class="tdc1" ><input name="" type="text" class="dfinput" style="width:150px;" value="正常" /></td>
                <td class="tdc1" ><input name="" type="text" class="dfinput" style="width:150px;" value="正常" /></td>
              </tr>
              <tr class="tr1">
                <td class="tdc1">B</td>
                <td class="tdc1" ><input name="" type="text" class="dfinput" style="width:150px;" value="正常" /></td>
                <td class="tdc1" ><input name="" type="text" class="dfinput" style="width:150px;" value="正常" /></td>
              </tr>
              <tr class="tr1">
                <td class="tdc1">C</td>
                <td class="tdc1" ><input name="" type="text" class="dfinput" style="width:150px;" value="正常" /></td>
                <td class="tdc1" ><input name="" type="text" class="dfinput" style="width:150px;" value="正常" /></td>
              </tr>
              <tr class="tr1">
                <td colspan="3"> 试验仪器:<input name="" type="text" class="dfinput" style="width:150px;" value="绝缘电阻表"/> <span style="padding-left:300px;">仪器编号:<input name="" type="text" class="dfinput" style="width:150px;" value="1" /></span></td>
              </tr>
              <tr class="tr1">
                <td colspan="3">项目结论:合格</td>
              </tr>
            </table>
            <table width="100%"  class="sybgtab" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr1">
                <td width="15%" class="tdc2">试验结论</td>
                <td width="60%" >合规</td>
                <td width="25%" class="tdc1" rowspan="2" height="100">单位盖章处</td>
              </tr>
              <tr class="tr1">
                <td class="tdc2">备注</td>
                <td ><input name="" type="text" class="dfinput" style="width:450px;" /></td>
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
