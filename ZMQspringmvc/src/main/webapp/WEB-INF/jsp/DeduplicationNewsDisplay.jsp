<%--
  Created by IntelliJ IDEA.
  User: sunxin
  Date: 2017/10/22
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>企业新闻链</title>
    <link href="${pageContext.request.contextPath}/resources/css/deduplicationNews.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/pagination.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>
        <%
        String selectdiscomsstr=request.getAttribute("companyList").toString();
    %>
    <div class="row-fluid" >
            <span style="font-size:20px; margin-left: 200px;">
                重点企业：
                <select name="selectcompany" id="selectcompany" style="width:200px;">
                    "<%=selectdiscomsstr%>"
                </select>
                </select>
                <button id="subcom">提交</button>
            </span>
        <script>
            var key = $("#selectcompany option:selected").text();
            $("#subcom").click(function () {
                key = $("#selectcompany option:selected").text();
                queryData(1, startDate, endDate, key);
            });
        </script>
        <div class="top">
            <div class="headline">
                <h1>新闻链展示</h1>
            </div>
        </div>
        <div class="main">
            <div id="resultNews" class="news-display"></div>
            <div id="page" class="pagination"></div>
        </div>
    </div>
</body>

<script src="${pageContext.request.contextPath}/resources/js/pagination.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/zmqjs/Paging.js" type="text/javascript"></script>

</html>
