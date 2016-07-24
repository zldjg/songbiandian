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
        <li>方案模板</li>
        <li>新华路220kV组合电器交流耐压试验方案</li>
    </ul>
</div>
<!--/当前位置-->
<div class="mainindex" id="mainindex">
    <div class="maincon">
        <!--列表信息-->
        <div class="fangan-detailse">
            <div class="title1 font28">
            	<span>（变电站名称）</span><span> 220kV </span><span>组合电器</span><br /><span>交流耐压</span>试验方案
            </div>
            <div class="title2 font20">
            	<span class="btname">方案批准：</span><span class="line1"></span><br />
            	<span class="btname">方案审核：</span><span class="line1"></span><br />
            	<span class="btname">方案编写：</span><span class="line1"></span><br />
            	<span class="btmemo">会签：</span><br />
            	<span class="btname">监理单位：</span><span class="line1"></span><br />
            	<span class="btname">施工单位：</span><span class="line1"></span><br />
            	<span class="btname">设备制造厂：</span><span class="line1"></span><br />
            	<span class="btname">建设单位：</span><span class="line1"></span>
            </div>
            <div class="title2 font20">
            	<span>天津送变电工程公司技术调试分公司</span><br />
            	<span class="margin20">年</span><span class="margin20">月</span><span class="margin20">日</span>
            </div>
        </div>
        <div class="fangan-detailse">
            <div class="title1 font28">
            	<span>（变电站名称）</span><span> 220kV </span><span>组合电器</span><span>交流耐压</span>试验方案
            </div>
            <div class="title3 font18">一、试验内容：</div>
            <div class="title4 font18">新华路220kV新装GIS进行交流耐压试验</div>
            <div class="title3 font18">二、试验分工：</div>
            <div class="title4 font18">1.送变电工程公司调试分公司负责耐压试验的指挥协调工作。<br />
2.施工单位与设备制造厂负责GIS的方式操作；接地操作；互感器等设备二次封地等。<br />
3.调试分公司负责GIS交流耐压试验设备的界限和试验设备的操作。</div>
            <div class="title3 font18">三、试验步骤：</div>
            <div class="title4 font18">1.按方案要求进行方式转换及倒接线。<br />
2.设备厂家及施工单位按方案要求倒方式及互感器等二次设备封地，并进行复核。<br />
3.有挑食分公司现场负责人进行方式及接线复核。<br />
4.调试分公司试验人员进行耐压试验操作。<br />
第一步：145kV（Vm/√3）耐压5分钟<br />
第二步：252kV（Vm）    耐压3分钟<br />
第三步：368kV           耐压1分钟<br />
5.	整体试验未完成则重复1-4步<br />
注：试验过程中的转换操作接线组合电压充分静置时间，满足生产单位和建设单位要求后方可进行耐压试验。</div>
            <div class="title3 font18">四、组合电器操作及试验详细步骤：</div>
            <div class="title4 font18">1.参照示意图，从A相加压。<br />
2.一相加压其他两相接地。<br />
3.以A相加压为例<br />
如图将PT投入加压至220/√3kV时核对二次电压是否正确。校准后将PT退出并用传感器监视加压相是否正确，加压时将传感器短接避免损坏传感器。<br />
4.按图分别对母线断路器（包括断口）及隔离开关加压。<br />
5.加压后退至160kV，测量局部放电。<br />
说明：PT、避雷器退出。
</div>
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