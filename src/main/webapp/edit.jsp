<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>edit</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css"/>
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/my.js"></script>
    <script src="js/getParameter.js"></script>

</head>
<body class="main">

<jsp:include page="head.jsp"/>
<jsp:include page="menu_search.jsp"/>
<div id="divpagecontent">
    <table border="1px" width="50%">
        <form method="post" action="" id="login_form">
            <tr align="center">
                <td style="border-color: #5CA5D6;height: 40px"><label style="font-weight:bold;">用户名:</label>
                </td>
                <td><input type="text" name="username" id="username"><span id="checkName"></span><br></td>
            </tr>
            <tr align="center">
                <td style="border-color: #5CA5D6"><label style="font-weight:bold;">密码</label></td>
                <td><input type="password" name="password" id="password"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="button" value="提交查询" id="login_btn"></td>
            </tr>
        </form>
    </table>
</div>
</body>
</html>
