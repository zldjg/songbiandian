<%@ page language="java" import="java.util.*" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ϵͳ��¼</title>
<link  href="css/style_login.css"  rel="stylesheet"  type="text/css">
<script type="text/javascript">
String.prototype.trim = function(){  
    // ��������ʽ��ǰ��ո�  
    // �ÿ��ַ��������  
    return this.replace(/(^\s*)|(\s*$)/g, "");  
}

function Check()
{
	if (document.getElementById("username").value.trim() == '') {
		alert('�������û���');
		document.getElementById("username").focus();
		return false;
	}
	
	if (document.getElementById("password").value.trim() == ''){
		alert('����������');
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
                <div class="inputbox"><input  type="text" name="username" id="username" placeholder="�������û���"/></div>
            </li>
            <li>
                <div class="pic"><img src="images/passbg.png" width="41" height="41" /></div>
                <div class="inputbox"><input  type="password" name="password"  id = "password" placeholder="����������"/></div>
            </li>
            <li class="okbut">
                <input name="" type="submit" value="��¼"  />
            </li>
        </ul>
        
    </form>
    </div>
</div>
</body>
</html>