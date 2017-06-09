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
    String[] columnName = (String[]) request.getAttribute("columnName");
    List<negativenewsWithBLOBs> queryNegNews = (List<negativenewsWithBLOBs>) request.getAttribute("queryNegNews");
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
        <div id="main" style="width: 900px; height: 600px; float: left; display: inline">
            <span id="spanFirstt">第一页</span> <span id="spanPret">上一页</span> <span
                id="spanNextt">下一页</span> <span id="spanLastt">最后一页</span> 第<span
                id="spanPageNumt"></span>页/共<span id="spanTotalPaget"></span>页

            <table class="gridtable">
                <tr>
                    <%
                        for (int i = 0; i < columnName.length; i++) {
                    %>
                    <th><%=columnName[i]%>
                    </th>
                    <%
                        }
                    %>
                </tr>
                <tbody id="tablelsw">
                <%
                    for (int i = 0; i < queryNegNews.size(); i++) {
                        negativenewsWithBLOBs negNews = queryNegNews.get(i);
                        Integer _id = negNews.getId();
                        String _title = negNews.getTitle();
                        String _url = negNews.getUrl();
                        String _date = negNews.getDate();
                        String _relcompany = negNews.getRelcompany();
                        double _oreitationvalue = negNews.getOreitationvalue();
                %>
                <tr>
                    <td><%=_id%>
                    </td>
                    <td style="width: 320px"><a href="<%=_url%>" target="_blank"><%=_title%>
                    </a></td>
                    <td style="width: 91px;height: 34px"><%=_date%>
                    </td>
                    <td><%=_relcompany%>
                    </td>
                    <td><%=df.format(_oreitationvalue)%>
                    </td>
                    <td><input type="submit" value="发送"/></td>
                    <td><input type="button" value="未读"/></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
            </table>
            <span id="spanFirst">第一页</span> <span id="spanPre">上一页</span> <span
                id="spanNext">下一页</span> <span id="spanLast">最后一页</span> 第<span
                id="spanPageNum"></span>页/共<span id="spanTotalPage"></span>页
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
<script src="${pageContext.request.contextPath}/resources/js/buttonClick.js"></script>

<script type="text/javascript">
    window.onload = function () {
        IniButtonEvent();
    }
</script>
</html>
<script>
    var theTable = document.getElementById("tablelsw");
    var totalPage = document.getElementById("spanTotalPage");
    var pageNum = document.getElementById("spanPageNum");

    var spanPre = document.getElementById("spanPre");
    var spanNext = document.getElementById("spanNext");
    var spanFirst = document.getElementById("spanFirst");
    var spanLast = document.getElementById("spanLast");

    var totalPaget = document.getElementById("spanTotalPaget");
    var pageNumt = document.getElementById("spanPageNumt");

    var spanPret = document.getElementById("spanPret");
    var spanNextt = document.getElementById("spanNextt");
    var spanFirstt = document.getElementById("spanFirstt");
    var spanLastt = document.getElementById("spanLastt");

    var numberRowsInTable = theTable.rows.length;
    var pageSize = 30;
    var page = 1;
    hide();
</script>

