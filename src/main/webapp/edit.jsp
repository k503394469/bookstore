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
<div id="divpagecontent" align="center">
    <table border="1px" width="50%">
        <form method="post" action="${pageContext.request.contextPath }/book/editBook" id="edit_form">
            <input type="hidden" name="id" id="id" value="${requestScope.book.id}">
            <tr align="center">
                <td style="border-color: #5CA5D6;height: 40px"><label style="font-weight:bold;">商品名称:</label>
                </td>
                <td><input type="text" name="name" id="name" value="${requestScope.book.name}"><br></td>
            </tr>
            <tr align="center">
                <td style="border-color: #5CA5D6"><label style="font-weight:bold;">商品价格</label></td>
                <td><input type="text" name="price" id="price" value="${requestScope.book.price}"></td>
            </tr>
            <tr align="center">
                <td style="border-color: #5CA5D6;height: 40px"><label style="font-weight:bold;">商品数量:</label>
                </td>
                <td><input type="text" name="pnum" id="pnum" value="${requestScope.book.pnum}"><br></td>
            </tr>
            <tr align="center">
                <td style="border-color: #5CA5D6;height: 40px"><label style="font-weight:bold;">商品类别:</label>
                </td>
                <td><input type="text" name="category" id="category" value="${requestScope.book.category}"><br></td>
            </tr>
            <tr align="center">
                <td colspan="2"><input type="submit" value="提交修改" id="edit_button"></td>
            </tr>
        </form>
    </table>
</div>
</body>
</html>
