<%@ page import="com.scorpion.pojo.negativenewsWithBLOBs" %>
<%@ page import="java.util.List" %>
<%@ page import="com.scorpion.pojo.currentnewsWithBLOBs" %>
<%@ page import="com.scorpion.pojo.companyinformation" %><%--
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


<body onload="startTime()">
<%
    String[] columnName = (String[]) request.getAttribute("columnName");
    List<negativenewsWithBLOBs> queryNegNews = (List<negativenewsWithBLOBs>) request.getAttribute("queryNegNews");
    List<currentnewsWithBLOBs> queryCurNews = (List<currentnewsWithBLOBs>) request.getAttribute("queryCurNews");
    List<companyinformation> queryComInfo = (List<companyinformation>) request.getAttribute("queryComInfo");
%>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>
    <div style="margin-left: 50px">
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
                <tbody id="tablesw">
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
                    <td><%=_date%>
                    </td>
                    <td><%=_relcompany%>
                    </td>
                    <td><%=_oreitationvalue%>
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

        <div id="main2" style="width: 400px; height: 600px;float: left; display: inline">
            <span id="nowDateTimeSpan"></span>
            <%--<script type="text/javascript">--%>
                <%--var clock = new Clock();--%>
                <%--clock.display(document.getElementById("clock"));--%>
            <%--</script>--%>
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
                    <th>上月新闻数</th>
                    <th>本月新闻数</th>
                    <th>本月负面数</th>
                </tr>
                <%
                    int count = 0;
                    for (int i = 0; i < queryComInfo.size() & count < 25; i++) {
                        companyinformation comInfo = queryComInfo.get(i);
                        String _companyname = comInfo.getName();
                        Integer _lastmonthsum = comInfo.getLastmonthsum();
                        Integer _curmonthsum = comInfo.getCurmonthsum();
                        Integer _curmonthneg = comInfo.getCurmonthneg();
                        double a = _curmonthneg * 1.0;
                        double b = _curmonthsum * 1.0;
                        double tmp = 0.0;
                        if (a != 0.0 && b != 0.0) {
                            tmp = a / b;
                        }
                        if (tmp > 0.3) {
                %>
                <td><font color="red"><%=_companyname%>
                </font></td>
                <%} else {%>
                <td><%=_companyname%>
                </td>
                <%}%>
                <td><%=_lastmonthsum%>
                </td>
                <td><%=_curmonthsum%>
                </td>
                <td><%=_curmonthneg%>
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
<script src="${pageContext.request.contextPath}/resources/js/Clock.js"></script>
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
<script language="JavaScript">
    function startTime()
    {
        var today=new Date();//定义日期对象
        var yyyy = today.getFullYear();//通过日期对象的getFullYear()方法返回年
        var MM = today.getMonth()+1;//通过日期对象的getMonth()方法返回年
        var dd = today.getDate();//通过日期对象的getDate()方法返回年
        var hh=today.getHours();//通过日期对象的getHours方法返回小时
        var mm=today.getMinutes();//通过日期对象的getMinutes方法返回分钟
        var ss=today.getSeconds();//通过日期对象的getSeconds方法返回秒
        // 如果分钟或小时的值小于10，则在其值前加0，比如如果时间是下午3点20分9秒的话，则显示15：20：09
        MM=checkTime(MM);
        dd=checkTime(dd);
        mm=checkTime(mm);
        ss=checkTime(ss);
        var day; //用于保存星期（getDay()方法得到星期编号）
        if(today.getDay()==0)   day   =   "星期日 "
        if(today.getDay()==1)   day   =   "星期一 "
        if(today.getDay()==2)   day   =   "星期二 "
        if(today.getDay()==3)   day   =   "星期三 "
        if(today.getDay()==4)   day   =   "星期四 "
        if(today.getDay()==5)   day   =   "星期五 "
        if(today.getDay()==6)   day   =   "星期六 "
        document.getElementById('nowDateTimeSpan').innerHTML=yyyy+"-"+MM +"-"+ dd +" " + hh+":"+mm+":"+ss+"   " + day;
        setTimeout('startTime()',1000);//每一秒中重新加载startTime()方法
    }

    function checkTime(i)
    {
        if (i<10){
            i="0" + i;
        }
        return i;
    }
</script>

