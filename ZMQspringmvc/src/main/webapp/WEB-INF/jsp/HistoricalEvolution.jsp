<%@ page import="com.scorpion.pojo.bignews" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/6/5
  Time: 9:44
  企业历史演变
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

</head>


<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>
        <%
        String maincom = request.getAttribute("maincom").toString();
        String selectdiscomsstr=request.getAttribute("selectdiscomsstr").toString();
        List<bignews> eventnews=(ArrayList<bignews>)request.getAttribute("eventnews");
        int flag = 1;
    %>
    <div class="row-fluid" style="background-color: #e9f0f5;">
            <span style="font-size:20px;">
                重点企业：
                <select name="selectcompany" id="selectcompany" style="width:200px;">
                    "<%=selectdiscomsstr%>"
                </select>

                <button id="subcom">提交</button>
            </span>
        <script type="text/javascript">
            $("#subcom").click(function () {
                tmp = $("#selectcompany option:selected").text();
                flag = $("#cla option:selected").text();
                req = "${pageContext.request.contextPath}/zmq/showHistoricalEvolution?com=" + tmp
                $.post(req,
                    {
                        //companyname:tmp
                    },
                    function () {
                        location.href = "${pageContext.request.contextPath}/zmq/showHistoricalEvolution?com=" + tmp
                    });
            });
        </script>
        <section id="cd-timeline" class="cd-container">
        <% for (int i = 0; i < eventnews.size(); i++) {%>
        <div class="cd-timeline-block" >
            <% if (flag == 1) {%>
            <div class="cd-timeline-img cd-picture">
                <img src="${pageContext.request.contextPath}/resources/images/cd-icon-location.svg" alt="Picture">
            </div>
            <% flag = 0; %>
            <%} else {%>
            <div class="cd-timeline-img cd-movie">
                <img src="${pageContext.request.contextPath}/resources/images/cd-icon-location.svg" alt="Movie">
            </div>
            <% flag = 1; %>
            <% }%>
            <div class="cd-timeline-content" >
                <h2>
                    <a href='<%= eventnews.get(i).getUrl() %>' target="_blank">
                        <strong style="font-size: 20px"><%= eventnews.get(i).getTitle()%></strong>
                    </a>
                </h2>
                <p style="font-size: 15px">关键词：<%= eventnews.get(i).getKeywords()%>
                </p>
                <span class="cd-date" style="font-size: 15px"><%= eventnews.get(i).getDate()%></span>
            </div>
        </div>
        <%}%>
        </section>
    </div>


</body>
</html>
