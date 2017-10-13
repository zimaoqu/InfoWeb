<%@ page import="com.scorpion.pojo.negativenewsWithBLOBs" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="com.scorpion.pojo.currentnewsWithBLOBs" %>
<%@ page import="com.scorpion.pojo.companyinformation" %>
<%@ page import="com.scorpion.pojo.ComNameNewsCount" %><%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/24
  Time: 22:14
  AbnormalWarning
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style type="text/css">
        table.gridtable {
            font-family: verdana, arial, sans-serif;
            font-size: 11px;
            color: #333333;
            border-width: 1px;
            border-color: #666666;
            border-collapse: collapse;
        }

        table.gridtable th {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #dedede;
            text-align: center;
        }

        table.gridtable td {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #ffffff;
        }
    </style>

</head>


<body>
<%
    List<currentnewsWithBLOBs> queryCurNews = (List<currentnewsWithBLOBs>) request.getAttribute("queryCurNews");
    List<companyinformation> queryComInfo = (List<companyinformation>) request.getAttribute("queryComInfo");
    List<ComNameNewsCount> warningCount = (List<ComNameNewsCount>) request.getAttribute("warningCount");
    List<Integer> beforeCount = (List<Integer>) request.getAttribute("BeforeCount");
    DecimalFormat df = new DecimalFormat("######0.000");
%>

<div class="container-fluid" style="margin-left: auto;margin-right: auto">
    <br/>
    <%@include file="title.jsp" %>
    <br/>
    <div style="margin-left: 250px">
        <%--<div id="main" style="width: 900px; height: 600px; float: left; display: inline">--%>
            <%--<a href ='javascript:GoToFirstPage();'>首页</a>--%>
            <%--<a href = 'javascript:GoToPrePage();'>上一页</a>--%>
            <%--<a href = 'javascript:GoToNextPage();'>下一页</a>--%>
            <%--<a href = 'javascript:GoToEndPage();'>最后一页</a>--%>
            <%--<table class="gridtable">--%>
                <%--<tr>--%>
                    <%--<th>序号</th>--%>
                    <%--<th>预警标题</th>--%>
                    <%--<th>发布时间</th>--%>
                    <%--<th>相关企业</th>--%>
                    <%--<th>关键词</th>--%>
                    <%--<th>通知</th>--%>
                    <%--<th>状态</th>--%>
                <%--</tr>--%>
                <%--<tbody id="tablelsw2">--%>
                <%--</tbody>--%>
            <%--</table>--%>
        <%--</div>--%>
            <div id="main1" style="width: 900px; height: 600px; float: left; display: inline">
                <a href ='javascript:GoToFirstPage();'>首页</a>
                <a href = 'javascript:GoToPrePage();'>上一页</a>
                <a href = 'javascript:GoToNextPage();'>下一页</a>
                <a href = 'javascript:GoToEndPage();'>最后一页</a>
                <table class="gridtable">
                    <tr>
                        <th>序号</th>
                        <th>预警标题</th>
                        <th>发布时间</th>
                        <th>相关企业</th>
                        <th>指数</th>
                        <th>通知</th>
                        <th>状态</th>
                    </tr>
                    <tbody id="tablelsw">
                    </tbody>
                </table>
            </div>
        <div id="main2" style="width: 400px; height: 600px;float: left; display: inline;margin-left: 10px;">
            <span id="clock"></span>
            <script src="${pageContext.request.contextPath}/resources/js/Clock.js"></script>
            <script type="text/javascript">
                var clock = new Clock();
                clock.display(document.getElementById("clock"));
            </script>
            <br><br>
            <marquee height="500px" direction=up scrollamount=2 behavior="scroll">
                <%
                    for (int i = 0; i < queryCurNews.size(); i++) {
                        currentnewsWithBLOBs curNews = queryCurNews.get(i);
                        String _curtitle = curNews.getTitle();
                        String _curdate = curNews.getDate();
                %>
                <%=_curtitle%>&nbsp;&nbsp;<%=_curdate%><br><br>
                <%
                    }
                %>
            </marquee>
        </div>




        <div id="main3" style="position:absolute; width: 400px; height: 600px; margin-left:910px; margin-top:560px">
            <b>企业情况</b><br><br>
            <table class="gridtable">
                <tr>
                    <th>企业名称</th>
                    <th>一月内新闻数</th>
                    <th>上一月新闻数</th>
                </tr>
                <%
                    int count = 0;
                    for (int i = 0; i < warningCount.size() & count < 25; i++) {
                        ComNameNewsCount c = warningCount.get(i);
                        String _companyname = c.getName();
                        Integer _curmonth = c.getCount();
                        Integer _lastmonth = beforeCount.get(i);
                %>
                <td><%=_companyname%>
                </td>
                <td><%=_curmonth%>
                </td>
                <td><%=_lastmonth%>
                </td>
                </tr>
                <%
                        count++;
                    }%>
            </table>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/paging.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/zmqjs/AbnormalWarning.js"></script>
</html>


