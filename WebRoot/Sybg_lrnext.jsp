<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.*,songbiandian.middleware.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style type="text/css">
	table.main{
				text-align:center;
				width:70%;
				margin:auto;
				margin-top:-1px;
				border-collapse:collapse;
				border-spacing:0px;
				border:none;
			}
			td{
				border:solid #000 1px;
				height:40px;
			}
			table.sub{
				text-align:center;
				margin-top:-1px;
				margin-bottom:-1px;
				margin-right:0px;
				width:100%;
				border-collapse:collapse;
				border:none;
			}
			td.sub{
				width:80px;
				border:solid #000 1px;
				height:40px;
			}
			td.instrument{
				color:green;
				border:solid #000 1px;
				height:40px;
			}
			td.standard{
				color:red;
				border:solid #000 1px;
				height:40px;
			}
</style>
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
    <span style="margin-top:3px; float:right; margin-right:10px;"><a href="Sybg_gl.html" class="longblue">保存信息</a></span>
</div>
<!--/当前位置-->
<div class="mainindex" id="mainindex">
    <div class="maincon">
        <div class="fangan-detailse">
            <div class="title1 font28">
            	<span><%=session.getAttribute("testreportname") %></span> 试验报告
            </div>
        </div>
        <div class="reporttitle">
        	<table class="main">
        		<tr>
        			<td style="width:10%">试验单位</td>
        			<td style="width:40%"></td>
        			<td style="width:10%">试验日期</td>
        			<td style="width:40%"></td>
        		</tr>
        	</table>
        	<table class="main">
        		<tr>
        			<td style="width:15%">天气</td>
        			<td style="width:18%"></td>
        			<td style="width:15%">温度</td>
        			<td style="width:18%"></td>
        			<td style="width:15%">湿度</td>
        			<td style="width:18%"></td>
        		</tr>
        	</table>
        	<table class="main">
        		<tr>
        			<td style="width:15%">试验人员</td>
        			<td style="width:18%"></td>
        			<td style="width:15%">试验地点</td>
        			<td style="width:18%"></td>
        			<td style="width:15%">报告日期</td>
        			<td style="width:18%"></td>
        		</tr>
        	</table>
        	<table class="main">
        		<tr>
        			<td style="width:15%">报告人</td>
        			<td style="width:18%"></td>
        			<td style="width:15%">审核人</td>
        			<td style="width:18%"></td>
        			<td style="width:15%">批准人</td>
        			<td style="width:18%"></td>
        		</tr>
        	</table>
        	<table class="main">
        		<tr>
        			<td style="width:10%">试验型号</td>
        			<td style="width:40%"></td>
        			<td style="width:10%">运行编号</td>
        			<td style="width:40%"></td>
        		</tr>
        	</table>
        	<table class="main">
        		<tr>
        			<td style="width:10%">额定电压</td>
        			<td style="width:40%"></td>
        			<td style="width:10%">额定容量</td>
        			<td style="width:40%"></td>
        		</tr>
        	</table>
        	<table class="main">
        		<tr>
        			<td style="width:10%">额定电流</td>
        			<td style="width:40%"></td>
        			<td style="width:10%">连接组别</td>
        			<td style="width:40%"></td>
        		</tr>
        	</table>
        	<table class="main">
        		<tr>
        			<td style="width:10%">生产厂家</td>
        			<td style="width:40%"></td>
        			<td style="width:10%">生产日期</td>
        			<td style="width:40%"></td>
        		</tr>
        	</table>
        	<table class="main">
        		<tr>
        			<td style="width:10%">安装地点</td>
        			<td style="width:40%"></td>
        			<td style="width:10%">出厂编号</td>
        			<td style="width:40%"></td>
        		</tr>
        	</table>
        </div>
        <br/>
        <div class="reporttemplate">
        	<table class="title" style="width:70%; margin:auto; text-align:center; margin-bottom:1px">
        		<tr>
        			<td>试验记录</td>
        		</tr>
        	</table>
			<table class="main" cellpadding="0px">
				<tr></tr>
				<%
					String equipmentName = (String)session.getAttribute("test_equipmentname");
					List<String> projects = (List<String>)session.getAttribute("test_projectslist");
					HashMap<String, ArrayList<String>> positionListMap = (HashMap<String, ArrayList<String>>)session.getAttribute("test_positionofprojectmap");
					HashMap<String, ArrayList<String>> paramListMap = (HashMap<String, ArrayList<String>>)session.getAttribute("test_paramofpositionmap");
					HashMap<String, String> standardMap = (HashMap<String, String>)session.getAttribute("test_standardMap");
					HashMap<String, String> testInstrumentMap = (HashMap<String, String>)session.getAttribute("test_testinstrumentMap");
					HashMap<String, ArrayList<String>> paramOfFirstLineMap = (HashMap<String, ArrayList<String>>)session.getAttribute("test_paramoffirstlinemap");
					HashMap<String, HashMap<String, ArrayList<String>>> paramOfProjectMap = (HashMap<String, HashMap<String, ArrayList<String>>>)session.getAttribute("test_paramofprojectmap");
					HashMap<String, ArrayList<String>> paramOfNoPositionMap = (HashMap<String, ArrayList<String>>)session.getAttribute("test_paramofnoposition");
					for (String project : projects) {
						HashMap<String, ArrayList<String>> paramOfSingleProjectMap = paramOfProjectMap.get(project);
				 %>
				 		<tr>
				 			<td><%=project %></td>
				 			<td>
				 				<table class="sub">
				 					<%
				 						ArrayList<String> positionListOfProject = positionListMap.get(project);
				 						if (positionListOfProject == null) {
				 							ArrayList<String> paramOfNoPosition = paramOfNoPositionMap.get(project);
				 							if (paramOfNoPosition.size() == 1) {
				 					 %>
				 					 			<tr>
				 					 				<td class="sub"><input type="text"/></td>
				 					 			</tr>
				 					 <%
				 					 		}
				 					 		else {
				 					  %>
				 					  			<tr>
				 					 <%
				 					  			for (String param : paramOfNoPosition) {
				 					  %>
				 					   				<td class="sub">
				 					   					<%=param %>
				 					   				</td>
				 					   				<td class="sub"><input type="text"/></td>
				 					 <%
				 					  			}
				 					  %>
				 					  			</tr>
				 					 <%
				 					  			}
				 					  		}
				 					  	else {
				 					  %>
				 					   			<tr>
				 					   				<td>试验位置</td>
				 					 <%
				 					   		ArrayList<String> paramOfFirstLineList = paramOfFirstLineMap.get(project);
				 					   		if (paramOfFirstLineList != null) {
				 					   			if (paramOfFirstLineList.size() == 1) {
				 					  %>
				 					   				 <td class="sub">试验值</td>
				 					 <%
				 					   			}
				 					   			else {
				 					   				for (String param : paramOfFirstLineList) {
				 					  %>
				 					   				 	<td class="sub"><%=param %></td>
				 					 <%
				 					   				}
				 					   			}
				 					   		}
				 					  %>
				 					   			</tr>
				 					 <%
				 					   		for (String position : positionListOfProject) {		
				 				      %>
				 					   			<tr>
				 					   				<td style="width:120px"><%=position %></td>
				 					   				<%
				 					   				HashMap<String, ArrayList<String>> paramOfThisPositionMap = paramOfProjectMap.get(project);
				 					   				ArrayList<String> paramOfThisPositionList = paramOfThisPositionMap.get(position);
				 					   				if (paramOfThisPositionList != null) {
				 					   				if (paramOfThisPositionList.size() == paramOfFirstLineList.size()) {
				 					   					for (int j = 0 ; j < paramOfThisPositionList.size() ; j++) {
				 					   				 %>
				 					   				 		<td class="sub"><input type="text"/></td>
				 					   				<%
				 					   					}
				 					   				}
				 					   				else {
				 					   					if (paramOfThisPositionList.size() == 1) {
				 					   				 %>
				 					   				 		<td id="singleparam"><input type="text"/></td>
				 					   				<%
				 					   					}
				 					   					else {
				 					   						for (String parameter : paramOfThisPositionList) {
				 					   				 %>
				 					   				 			<td><%=parameter %></td>
				 					   				 			<td><input type="text"/></td>
				 					   				<%
				 					   						}
				 					   					}
				 					   				}
				 					   				 %>
				 					   			</tr>
				 					 <%
				 					 			}
				 					 		}
				 					 	}
				 					  %>
				 				</table>
				 			</td>
				 		</tr>
				 		<tr>
				 			<td>试验标准</td>
				 			<td class="standard"><%=standardMap.get(project) %></td>
				 		</tr>
				 		<tr>
				 			<td>试验仪器</td>
				 			<td class="instrument"><%=testInstrumentMap.get(project) %></td>
				 		</tr>
				 		<tr>
				 			<td>项目结论</td>
				 			<td>
				 				<input type="text" size="9" placeholder="合格/不合格"/>
				 			</td>
				 		</tr>
				 <%
				 	}
				  %>
				 <tr>
				 	<td>试验报告是否合格</td>
				 	<td>
				 		<input type="text" size="9" placeholder="合格/不合格"/>
				 	</td>
				 </tr>
			</table>
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
         end.start = datas;//将结束日的初始值设定为开始日
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