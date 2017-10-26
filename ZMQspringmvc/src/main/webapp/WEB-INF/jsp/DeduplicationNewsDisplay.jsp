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
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/js/zmqjs/DeduplicationNews.js" type="text/javascript"></script>

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
            queryData(key,1);
            $("#subcom").click(function () {
                key = $("#selectcompany option:selected").text();
                $("#news section").remove();
                queryData(key,1);
            });
        </script>
    </div>
    <div class="titleName">
        <p style="margin: 30px auto; font-size: 40px; text-align: center;">企业新闻链</p>
    </div>
    <div  class="content">
        <article id="news">
        </article>
    </div>
</div>
</body>
</html>
