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
    <link href="${pageContext.request.contextPath}/resources/css/historyBignews.css" rel="stylesheet">
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
    <div class="row-fluid" >
            <span style="font-size:20px;">
                重点企业：
                <select name="selectcompany" id="selectcompany" style="width:200px;">
                    "<%=selectdiscomsstr%>"
                </select>
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
        <div class="head-warp">
            <div class="head">
                <div class="nav-box">
                    <ul>
                        <li class="cur">企业热点事件链</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="main">
            <div class="history">
                <div class="history-date">
                    <ul>
                        <h2 class="first"><a href="#nogo"><%= eventnews.get(0).getDate().split("-")[0]%>年</a></h2>
                        <%  int i;
                            String dateYearFlag = eventnews.get(0).getDate().split("-")[0];
                            for (i = 0;i < eventnews.size();i++){
                            if (!dateYearFlag.equals(eventnews.get(i).getDate().split("-")[0])){break;}
                        %>
                        <li>
                            <h3><%= eventnews.get(i).getDate().split("-")[1]%>.<%= eventnews.get(i).getDate().split("-")[2]%><span><%= eventnews.get(i).getDate().split("-")[0]%></span></h3>
                            <dl>
                                <dt> <a onclick="window.open('<%= eventnews.get(i).getUrl() %> ')" > <%= eventnews.get(i).getTitle()%></a>
                                    <span>关键词：<%= eventnews.get(i).getKeywords()%></span>
                                </dt>
                            </dl>
                        </li>
                        <%}%>
                    </ul>
                </div>
                <%  while (i < eventnews.size()){
                    dateYearFlag = eventnews.get(i).getDate().split("-")[0];
                %>
                <div class="history-date">
                    <ul>
                        <h2 class="date02"><a href="#nogo"><%= dateYearFlag%>年</a></h2>
                        <% for (;i<eventnews.size();i++){
                        if (!dateYearFlag.equals(eventnews.get(i).getDate().split("-")[0])){
                            dateYearFlag = eventnews.get(i).getDate().split("-")[0];
                            break;
                        }%>
                        <li>
                            <h3><%= eventnews.get(i).getDate().split("-")[1]%>.<%= eventnews.get(i).getDate().split("-")[2]%><span><%= eventnews.get(i).getDate().split("-")[0]%></span></h3>
                            <dl>
                                <dt><a onclick="window.open('<%= eventnews.get(i).getUrl() %> ')"> <%= eventnews.get(i).getTitle()%></a>
                                    <span>关键词：<%= eventnews.get(i).getKeywords()%></span>
                                </dt>
                            </dl>
                        </li>
                        <%}%>
                    </ul>
                </div>
                <%}%>
            </div>
        </div>

        <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/HistoryBigNews.js"></script>
    </div>

</body>
</html>
