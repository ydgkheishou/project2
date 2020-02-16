<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/2/16
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提示页面</title>
</head>
<body>
<!--setTimeout():炸弹定时函数，到达指定时间就执行函数或代码串，只会执行一次
     如果要调用的函数没有参数，可以直接用函数名调用，不用打引号-->
<h2 align="center" >${info}2秒后跳转到登录页面......</h2>
<script>
    function goToUrl(){
        //改变url
        window.location.href="${pageContext.request.contextPath}/login.jsp";
    }
    //3秒后跳转
    setTimeout(goToUrl,2000);
</script>
</body>
</html>
