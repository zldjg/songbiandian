<%@ page language="java" import="java.util.*" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>系统登录</title>
<link  href="css/style_login.css"  rel="stylesheet"  type="text/css">
<script type="text/javascript">
String.prototype.trim = function(){  
    // 用正则表达式将前后空格  
    // 用空字符串替代。  
    return this.replace(/(^\s*)|(\s*$)/g, "");  
}

function Check()
{
	if (document.getElementById("username").value.trim() == '') {
		alert('请输入用户名');
		document.getElementById("username").focus();
		return false;
	}
	
	if (document.getElementById("password").value.trim() == ''){
		alert('请输入密码');
		document.getElementById("password").focus();
		return false;
	}
}
</script>
</head>
<body>
<div class="wrap">
    <div class="box_login">
    <form method="post" action="UserLogin" onsubmit="return Check();">
        <ul class="logins">
            <li>
                <div class="pic"><img src="images/userbg-login.png" width="41" height="41" /></div>
                <div class="inputbox"><input  type="text" name="username" id="username" placeholder="请输入用户名"/></div>
            </li>
            <li>
                <div class="pic"><img src="images/passbg.png" width="41" height="41" /></div>
                <div class="inputbox"><input  type="password" name="password"  id = "password" placeholder="请输入密码"/></div>
            </li>
            <li class="okbut">
                <input name="" type="submit" value="登录"  />
            </li>
        </ul>
        
    </form>
    </div>
</div>
</body>
</html>