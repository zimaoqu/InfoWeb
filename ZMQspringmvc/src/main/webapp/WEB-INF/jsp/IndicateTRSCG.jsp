<%--
  Created by IntelliJ IDEA.
  User: Vikun
  Date: 2017/7/6
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.scorpion.pojo.bignews" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>关键指标监控</title>
    <SCRIPT language=javascript>
        function MenuDisplay(obj_id) {
            for (var i = 1; i <= 2; i++) {
                var obj = document.getElementById('table_' + i);
                if(obj){
                    document.getElementById('table_' + i).style.display = 'none';
                    document.getElementById('table_' + i + 'Span').innerText = '＋';
                }

            }
            var obj = document.getElementById(obj_id);
            if(obj){
                if (obj.style.display == 'none') {
                    obj.style.display = 'block';
                    document.getElementById(obj_id + 'Span').innerText = '－';
                } else {
                    obj.style.display = 'none';
                    document.getElementById(obj_id + 'Span').innerText = '＋';
                }
            }
        }

    </SCRIPT>


</head>
<style>
    .menu{
        height: 500px;
        /*position: absolute;*/
        width: 18%;
        margin-bottom: 20px;
        margin-left: 20px;
        margin-top: 30px;
        float: left;

    }

    .echart_container{
        display: block;
        height: 500px;
        /*position: absolute;*/
        width: 72%;
        margin-bottom: 20px;
        float: left;
    }
    .echart_container1{
        height: 400px;
        /*position: absolute;*/
        left: 5%;
        width: 50%;
        margin-bottom: 20px;

    }

    .echart_container2 {
        display: block;
        height: 400px;
        /*position: absolute;*/
        width: 50%;
        margin-top: -421px;
        margin-bottom: 20px;
        float: right;
    }
    .echart_container3 {
        height: 400px;
        /*position: absolute;*/
        left: 5%;
        width: 90%;
        margin-bottom: 20px;
    }
    .left {
        display: block;
        height: 500px;
        /*position: absolute;*/
        width: 20%;
        margin-bottom: 20px;

    }

    .mainMenu {
        FONT-WEIGHT: bold;
        FONT-SIZE: 20px;
        cursor: pointer;
        COLOR: #000000
    }
    .menuSmall{
        FONT-SIZE: 15px;
        width: 250px;

    }
    TD {
        FONT-SIZE: 11px;
        COLOR: #003366;
        FONT-FAMILY: Verdana
    }
    A.style2:link {
        PADDING-LEFT: 4px;
        COLOR: #0055bb;
        TEXT-DECORATION: none
    }

    A.style2:visited {
        PADDING-LEFT: 4px;
        COLOR: #0055bb;
        TEXT-DECORATION: none
    }

    A.style2:hover {
        PADDING-LEFT: 4px;
        COLOR: #ff0000;
        TEXT-DECORATION: none
    }
    A.active {
        PADDING-LEFT: 4px;
        COLOR: #ff0000;
        TEXT-DECORATION: none
    }
    .span {
        COLOR: #ff0000;
    }


</style>

<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>
</div>
<div  class="row-fluid">
</div>
<div class="menu">
    <table >
        <tr>
            <td class=mainMenu onClick="MenuDisplay('table_1');"><SPAN class=span id=table_1Span>＋</SPAN> 国内指标</td>
        </tr>
        <tr>
            <TD>
                <TABLE id=table_1 style="DISPLAY: block" cellSpacing=0 cellPadding=2 width=200 align=center border=0>
                    <TBODY>
                    <TR>
                        <TD class=menuSmall><A class=style2   href="${pageContext.request.contextPath}/zmq/IndicateGDP"
                        ><span>&nbsp;&nbsp;&nbsp;&nbsp;国内(GDP)&&上海(GDP)</span></A></TD>
                    </TR>
                    <TR><TD  height=1></TD></TR>
                    <TR>
                        <TD class=menuSmall><A class=style2  href="${pageContext.request.contextPath}/zmq/IndicatepcPage"
                        > &nbsp;&nbsp;&nbsp;&nbsp;PPI&&CPI</A></TD>
                    </TR>
                    <TR><TD  height=1></TD></TR>
                    <TR>
                        <TD class=menuSmall><A class=style2  href="${pageContext.request.contextPath}/zmq/IndicateExportImport"
                        >&nbsp;&nbsp;&nbsp; 进出口总额</A></TD>
                    </TR>
                    <TR><TD  height=1></TD></TR>
                    <TR>
                        <TD class=menuSmall><A class=style2  href="${pageContext.request.contextPath}/zmq/IndicateTaxCountry"
                        >&nbsp;&nbsp;&nbsp; 税务部门税收总额</A></TD>
                    </TR>
                    <TR><TD  height=1></TD></TR>
                    <TR>
                        <TD class=menuSmall><A class=style2  href="${pageContext.request.contextPath}/zmq/IndicateTRSCG"
                        > &nbsp;&nbsp;&nbsp;&nbsp;社会消费品零售总额</A></TD>
                    </TR>
                    <TR><TD  height=1></TD></TR>
                    <TR>
                        <TD class=menuSmall><A class=style2  href="${pageContext.request.contextPath}/zmq/IndicatePMI"
                        > &nbsp;&nbsp;&nbsp;&nbsp;PMI</A></TD>
                    </TR>
                    </TBODY>
                </TABLE>
            </TD>
        </tr>
        <TR>
            <TD  height=9></TD>
        </TR>

        <TR>
            <TD class=mainMenu onClick="MenuDisplay('table_2');"><SPAN class=span id=table_2Span>＋</SPAN> 国际指标</TD>
        </TR>
        <TR><TD  height=1></TD></TR>

        <TR>
            <TD>
                <TABLE id=table_2 style="DISPLAY: none" cellSpacing=0 cellPadding=2 width=200 align=center border=0>
                    <TBODY>
                    <TR>
                        <TD class=menuSmall><A class=style2 href="${pageContext.request.contextPath}/zmq/Indicatecopper"> &nbsp;&nbsp;&nbsp;&nbsp;国际铜价</A></TD>
                    </TR>
                    <TR><TD  height=1></TD></TR>

                    <TR>
                        <TD class=menuSmall><A class=style2 href="${pageContext.request.contextPath}/zmq/IndicateCrude">&nbsp;&nbsp;&nbsp;&nbsp;国际油价</A></TD>
                    </TR>
                    <TR><TD  height=1></TD></TR>
                    <TR>
                        <TD class=menuSmall><A class=style2 href="${pageContext.request.contextPath}/zmq/IndicateBDI"  >&nbsp;&nbsp;&nbsp;&nbsp;波罗的海干散货指数</A></TD>
                    </TR>
                    <TR><TD  height=1></TD></TR>
                    <TR>
                        <TD class=menuSmall><A class=style2 href="${pageContext.request.contextPath}/zmq/IndicateIMF" >&nbsp;&nbsp;&nbsp;&nbsp;IMF经济增长预期</A></TD>
                    </TR>
                    <TR><TD  height=1></TD></TR>
                    <TR>
                        <TD class=menuSmall><A class=style2 href="${pageContext.request.contextPath}/zmq/Indicatedder" >&nbsp;&nbsp;&nbsp;&nbsp;美元兑人民币汇率</A></TD>
                    </TR>
                    </tbody>
                </table>
            </TD>
        </TR>

    </table>

</div>
<div class="echart_container">
    <div id="l1" style="display: block">
        <div id="graphicTRSCG" class="echart_container3" ></div>
    </div>
    <div id="tbl">
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/zmqjs/KeyIndicatesTRSCG.js" type="text/javascript"></script>
</body>
</html>

