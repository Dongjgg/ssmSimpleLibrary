<%@ page import="com.dj.service.BookServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Dj
  Date: 2023/1/9
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表 —— 显示所有书籍</small>
                    <div style="float: right">
                        <a href="${pageContext.request.contextPath}/user/goOut"><input type="button" value="注销" class="btn btn-primary" style="color: #ff0000"></a>
                    </div>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <!--toAddBook-->
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增</a>
        </div>
        <div class="col-md-4 column"></div>
        <div class="col-md-4 column">
            <!--查询书籍-->
            <form action="${pageContext.request.contextPath}/book/queryBook" method="post" style="float: right" class="form-inline">
                <input type="text" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍名称">
                <input type="submit" value="查询" class="btn btn-primary">
            </form>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名字</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </tr>
                </thead>

                <%--书籍从数据库中查询出来,从这个list中遍历出来 : foreach--%>
                <tbody>
                <c:forEach var="book" items="${requestScope.get('list')}">
                    <tr>
                        <td>${book.getBookID()}</td>
                        <td>${book.getBookName()}</td>
                        <td>${book.getBookCounts()}</td>
                        <td>${book.getDetail()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/book/toUpdate?id=${book.getBookID()}">更改</a> |
                            <a href="${pageContext.request.contextPath}/book/del/${book.getBookID()}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <%--这个标签自动减1我也不明白，唉，错在这搞得我无语--%>
        <nav aria-label="Page navigation" style="text-align: center" id="pageB">
            <ul class="pagination">

                <c:if test="${nowPage>=1}">
                    <li style="display: inline">
                        <a href="${pageContext.request.contextPath}/book/limitPage?startIndex=${nowPage}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
                    </li>
                </c:if>
                <c:if test="${nowPage==0}">
                    <li style="display: none;">
                        <a href="${pageContext.request.contextPath}/book/limitPage?startIndex=${nowPage-1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
                    </li>
                </c:if>


                <%
                    for (int i=0;i<(int)session.getAttribute("pageNum");i++){
                %>
                        <li><a href="${pageContext.request.contextPath}/book/limitPage?startIndex=<%=i+1%>"><%=i+1%></a></li>
                <%
                    }
                %>

                <li style="display: inline">
                    <a href="${pageContext.request.contextPath}/book/limitPage?startIndex=${nowPage+2}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
                </li>


            </ul>
        </nav>

    </div>



</div>