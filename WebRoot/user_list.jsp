<%@ page language="java" import="java.util.*" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ page import="com.entity.*" import="com.Dao.UserDao" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<base href="<%=basePath%>">
	<title>用户列表</title>
	
	<script language="javascript">
    function del(){
		var c = "你确认要删除记录吗？";
		if(confirm(c)){
			window.event.returnValue = true;
		} else {
			window.event.returnValue = false;
		}
	}
	</script> 
</head>
<body>
	<table align="center" width="60%">
  	<tr>
  		<td>
  			<h1 align="center">用户列表</h1>
  		</td>
  	</tr>  	
  </table>
  
<div>    
    <%
    	if(users != null && users.size() > 0) {
    %>
    <table cellspacing="0" align="center"  border="1">
    	<tr>
    		<td><b>序号</b></td>
    		<td><b>ID</b></td>
    		<td><b>用户名</b></td>
    		<td><b>登入名</b></td>
    		<td><b>密码</b></td>
    		<td><b>管理组</b></td>
    		<td><b>职责</b></td>    		
    	</tr>
    <%		
    		for(int i = 0; i < users.size(); i++) {
    			User user = (User)users.get(i);
    %>
    	<tr>
    		<td><%=(i+1) %></td>
    		<td><%=user.getUserid() %></td>
    		<td><%=user.getName() %></td>
    		<td><%=user.getUsername()%></td>
    		<td><%=user.getPassword() %></td>
    		<td><%=user.getGroup() %></td>
    		<td><%=user.getRank() %></td>
    		</tr>
    <% } %>
    </table>
    <table cellspacing="0" align="center">
    	<tr >
    		<td>
    		<%if(p != null) {%>
    			<div align="right"  class="page" style="float:right">
    			
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
    </table>
   
    <% } else { %>
    	<div align="center">书籍列表为空</div>
    <%} %>
    
</div>
</body>
</html>