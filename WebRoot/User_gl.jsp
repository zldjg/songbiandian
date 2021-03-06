<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.entity.*" import="java.util.*" import="com.Dao.UserDao"  import="com.Dao.GroupDao"%> 
<%@ page import="java.io.*,java.util.*,java.sql.*"%>

<%
int pageSize = 3;
int totalPage;
UserDao ud = new UserDao();
List<User> users = new ArrayList<User>();
ShowRecordByPage p = new ShowRecordByPage();
try{
	int totalResult = ud.getUser().size();
	 totalPage = (totalResult % pageSize) == 0 ?  totalResult / pageSize : totalResult / pageSize +1;
	
	int pageNow = 1;
	String pageNows = request.getParameter("pageNow");
	if(pageNows != null) {
		pageNow = Integer.parseInt(pageNows);
		if(pageNow < 1) pageNow = 1;
		if(pageNow > totalPage) pageNow = totalPage;
	}
	
	 p = ud.getUsersByPage(pageNow, pageSize);


if(p != null) {
	users = p.getDatas();}

	
}catch(Exception e){
	throw new ServletException();
}

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
		width : 150  
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
function del(){
	document.forms.form1.action="user.do?method=del";
	document.forms.form1.submit();
}
function edit(){
	document.forms.form1.action="user.do?method=edit";
	document.forms.form1.submit();
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
        <li>系统设置</li>
        <li>用户管理</li>
    </ul>
</div>
<!--/当前位置-->

<div class="mainindex" id="mainindex">
     <form name="form1"   action="" method="post" >
    <div class="maincon">
        <!--btns-->
        <ul class="btnOptions">
          <li><a href="User_new.jsp"><img src="images/btn-add.jpg" width="75" height="35" /></a></li>
          <li><input type="button" value="" style="width:75px;height:35px;border:0;background:url(images/btn-edit.jpg)" onclick="edit();"></li>
          <li><input type="button" value=""  style="width:75px;height:35px;border:0;background:url(images/btn-del.jpg)" onclick="del();"></li>

        </ul>
        <!--/btns-->
        <!--列表信息-->
        <div class="ziliaobox">
  
    	   
          <table width="100%" class="zltab" border="0" cellspacing="0" cellpadding="0">
              <tr class="tr0">
                <td width="4%" class="tdc"><input name="chkAll" type="checkbox" id="chkAll" onclick=CheckAll(this.form) value="checkbox"></td>
                <td width="4%" class="tdc">序号</td>
                <td width="20%">真实姓名</td>
                <td width="20%">登录名</td>
                <td width="13%">管理组</td>
                <td width="13%">最后登录时间</td>
                <td width="13%">最后登录IP</td>
                <td width="13%">状态</td>
              </tr>
            <%
            int state;
            String status;
            for(int i = 0; i<users.size();i++) {
         	   User user = (User)users.get(i);
         	  state = user.getState();
         	 if(state == 0){
         		 status ="启用";
         	 }else{
         		 status="禁用";
         	 }
         	   
%>
              <tr class="tr1">
                <td class="tdc"><input name='userid' id="userid" type='checkbox' value='<%=user.getUserid() %>'></td>
                <td class="tdc"><%=(i+1)%></td>
                <td><%=user.getName() %></td>
                <td><%=user.getUsername() %></td>
                <td><%=user.getGroup() %></td>
                <td></td>
                <td></td>
                <td class="tdc"><%=status %></td>
 <%}%>  
                
                <tr >
    		<td colspan="8">
    		<%if(p != null) {%>
    			<div  align="right"  class="page" style="float:right">
    			
    				当前页<%=p.getPageNow() %>
    				&nbsp;&nbsp;
    				
    				<% for(int i =0;i<totalPage;i++){ %>
    	<a href="userList?pageNow=<%=(i+1) %>" ><%=(i+1) %></a>
    	<%} %>    				
    				<%if(p.getPageNow() > 1) { %>
    				<a href="userList?pageNow=<%=p.getPageNow()-1 %>" >上一页</a>
    				
    				<% } if(p.getPageNow() <totalPage ) { %>
    				<a href="userList?pageNow=<%=p.getPageNow()+1 %>" >下一页</a>
    				<% } %>
    			</div>
    			<% } %>
    		</td>
    	</tr>              
               <tr class="tr2">
                <td colspan="12">
                	<div id="paging1" class="page" style="float:right"></div>
                </td>
              </tr>             
              </table>
          
          </div>
          <!--/列表信息-->
    </div> 
    </form>
</div>
 
 <div class="popupLayerL">
    <div id="blkh1" class="Mapdetails">
        <div class="detail-main">
            <a href="javascript:void(0)" class="closed1"></a>
            <div class="list_more">
                <img src="images/u15.png" width="680" height="455">
            </div>
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
laydate(end);
</script>
</body>

</html>
