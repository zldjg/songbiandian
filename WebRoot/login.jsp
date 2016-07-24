<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0051)http://localhost:8088/TransformerInfo/jsp/login.jsp -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>系统登录</title>
<link  href="css/style_login.css"  rel="stylesheet"  type="text/css">
</head>
<body>
<div class="wrap">
    <div class="box_login">
    <form method="post" action="http://localhost:8088/TransformerInfo/UserLoginServlet">
        <ul class="logins">
            <li>
                <div class="pic"><img src="images/userbg-login.png" width="41" height="41" /></div>
                <div class="inputbox"><input  type="text" name="name" id="username" placeholder="请输入用户名" /></div>
            </li>
            <li>
                <div class="pic"><img src="images/passbg.png" width="41" height="41" /></div>
                <div class="inputbox"><input  type="password" name="password" id="password"  placeholder="请输入密码"/></div>
            </li>
            <li class="okbut">
                <input name="" type="button" value="登录" onclick="javascript:window.location.href='main.jsp'" />
            </li>
        </ul>
    </form>
    </div>
</div>
</body>
</html>