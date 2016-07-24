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
    </ul>
</div>
<!--/当前位置-->

<div class="mainindex" id="mainindex">
    <div class="maincon">
    	<div class="echartbox">
        	<div class="toptitle"><span class="titles">系统方案按电压等级统计</span></div>
            <div class="echartpicbox"><div class="echartpic" id="echart-2"></div></div>
        </div>  
    	<div class="echartbox">
        	<div class="toptitle borderzi"><span class="titles">试验报告按照状态统计</span></div>
            <div class="echartpicbox"><div class="echartpic" id="echart-3"></div></div>
        </div>
    	<div class="echartbox">
        	<div class="toptitle bordergreen"><span class="titles">人员资质按照状态统计</span></div>
            <div class="echartpicbox"><div class="echartpic" id="echart-4"></div></div>
        </div>   
    	<div class="echartbox">
        	<div class="toptitle borderblue"><span class="titles">当前设备台账到期统计</span></div>
            <div class="echartpicbox"><div class="echartpic" id="echart-1"></div></div>
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

<!--echart js-->
<script src="echartsjs/echarts.js"></script>
<script type="text/javascript">
	// 路径配置
	require.config({
		paths: {
			echarts: 'echartsjs/'
		}
	});
	
	// 使用
	require(
		[
			'echarts',
			'echarts/chart/line', 				
            'echarts/chart/bar', 
			'echarts/chart/pie',		
            'echarts/chart/funnel'
		],
		function (ec) {
			// 基于准备好的dom，初始化echarts图表
			var myChart1 = ec.init(document.getElementById('echart-1')); 
			
			var option1 = {
					tooltip : {
						show: true,
						formatter: "{a} <br/>{b} : {c} ({d}%)"
					},
					legend: {
						orient : 'vertical',
						x : 'left',
						data:['已到期','距10天到期','距20天到期','距30天到期']
					},
					calculable : true,
					series : [
						
						{
							name:'到期台账汇总',
							type:'pie',
							center : ['50%', 150],
							radius : [70, 100],
							data:[
								{value:335, name:'已到期'},
								{
									value:1048,
									name:'距10天到期',
									itemStyle : {
										normal : {
											color : (function (){
												var zrColor = require('zrender/tool/color');
												return zrColor.getRadialGradient(
													300, 200, 110, 300, 200, 140,
													[[0, 'rgba(255,255,0,1)'],[1, 'rgba(30,144,250,1)']]
												);
											})(),
											label : {
												textStyle : {
													color : 'rgba(30,144,255,0.8)',
													align : 'center',
													baseline : 'middle',
													fontFamily : '微软雅黑',
													fontSize : 30,
													fontWeight : 'bolder'
												}
											},
											labelLine : {
												length : 40,
												lineStyle : {
													color : '#f0f',
													width : 3,
													type : 'dotted'
												}
											}
										}
									}
								},
								{value:251, name:'距20天到期'},
								{
									value:102,
									name:'距30天到期',
									itemStyle : {
										normal : {
											label : {
												show : false
											},
											labelLine : {
												show : false
											}
										},
										emphasis : {
											label : {
												show : true
											},
											labelLine : {
												show : true,
												length : 50
											}
										}
									}
								}
							]
						}
					]
				};
	
			//天津分公司设备台账.echart初始化数据
			var myChart2 = ec.init(document.getElementById('echart-2')); 			
			var option2 = {
					tooltip : {
						trigger: 'axis'
					},
					legend: {
						data:[
							'已完成','未完成'
						]
					},
					toolbox: {
						show : false,
						feature : {
							mark : {show: true},
							dataView : {show: true, readOnly: false},
							magicType : {show: true, type: ['line', 'bar']},
							restore : {show: true},
							saveAsImage : {show: true}
						}
					},
					calculable : true,
					grid: {y: 70, y2:30, x2:20},
					xAxis : [
						{
							type : 'category',
							data : ['35kV','110kV','220kV','500kV']
						},
						{
							type : 'category',
							axisLine: {show:false},
							axisTick: {show:false},
							axisLabel: {show:false},
							splitArea: {show:false},
							splitLine: {show:false},
							data : ['35kV','110kV','220kV','500kV']
						}
					],
					yAxis : [
						{
							type : 'value',
							axisLabel:{formatter:'{value}'}
						}
					],
					series : [
						{
							name:'已完成',
							type:'bar',
							itemStyle: {normal: {color:'#2ec7c9', label:{show:true}}},
							data:[80,60,55,40]
						},
						{
							name:'未完成',
							type:'bar',
							itemStyle: {normal: {color:'#b6a2de', label:{show:true}}},
							data:[32,69,55,60]
						}
					]
				};
				
			var myChart3 = ec.init(document.getElementById('echart-3')); 
			var option3 = {
				//title : {
				//	text: '漏斗图',
				//	subtext: '纯属虚构'
				//},
				tooltip : {
					trigger: 'item',
					formatter: "{a} <br/>{b} : {c}"
				},
				legend: {
					data : ['编制','审核中','已完成']
				},
				calculable : true,
				series : [
					{
						name:'状态统计图',
						type:'funnel',
						width: '60%',
						data:[
							{
								value:60, 
								itemStyle: {normal: {color:'#d87a80', label:{show:true}}},
								name:'编制'},
							{
								value:80, 
								itemStyle: {normal: {color:'#5ab1ef', label:{show:true}}},
								name:'审核中'},
							{
								value:100, 
								itemStyle: {normal: {color:'#57d2d3', label:{show:true}}},
								name:'已完成'}
						]
					}
				]
			};
			
			var myChart4 = ec.init(document.getElementById('echart-4')); 
			var option4 = {
				color : [
					'rgba(255, 69, 0, 0.5)',
					'rgba(255, 150, 0, 0.5)',
					'rgba(255, 200, 0, 0.5)',
					'rgba(155, 200, 50, 0.5)',
					'rgba(55, 200, 100, 0.5)'
				],
				tooltip : {
					trigger: 'item',
					formatter: "{a} <br/>{b} : {c}%"
				},
				legend: {
					data : ['编制','审核中','已完成']
				},
				calculable : true,
				series : [
					{
						name:'预期',
						type:'funnel',
						x: '10%',
						width: '80%',
						itemStyle: {
							normal: {
								label: {
									formatter: '{b}预期'
								},
								labelLine: {
									show : false
								}
							},
							emphasis: {
								label: {
									position:'inside',
									formatter: '{b}预期 : {c}%'
								}
							}
						},
						data:[
							{value:20, name:'编制'},
							{value:60, name:'审核中'},
							{value:100, name:'已完成'}
						]
					},
					{
						name:'实际',
						type:'funnel',
						x: '10%',
						width: '80%',
						maxSize: '80%',
						itemStyle: {
							normal: {
								borderColor: '#fff',
								borderWidth: 2,
								label: {
									position: 'inside',
									formatter: '{c}%',
									textStyle: {
										color: '#fff'
									}
								}
							},
							emphasis: {
								label: {
									position:'inside',
									formatter: '{b}实际 : {c}%'
								}
							}
						},
						data:[
							{value:30, name:'编制'},
							{value:10, name:'审核中'},
							{value:80, name:'已完成'}
						]
					}
				]
			};

			// 为echarts对象加载数据 
			myChart1.setOption(option1); 
			myChart2.setOption(option2); 
			myChart3.setOption(option3); 
			myChart4.setOption(option4); 
			window.onresize = function () {
				myChart1.resize();
				myChart2.resize();
				myChart3.resize();
				myChart4.resize();
			};
		}
	);
</script>
<!--/echart js-->
</body>

</html>