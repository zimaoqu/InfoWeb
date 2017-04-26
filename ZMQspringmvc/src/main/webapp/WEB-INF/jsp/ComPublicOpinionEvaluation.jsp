<%@ page import="com.scorpion.pojo.NewsOfCompanyWithBLOBs" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/26
  Time: 14:21
  企业舆情评价
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>

<style>
    .piccontainer {
        margin: 30px;
        width: 500px;
        height: 800px;
        border: 1px solid #000;
    }
</style>

<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>
    <%
        String maincom = request.getAttribute("maincom").toString();
        int posNum = (int) request.getAttribute("posNum");
        int neuNum = (int) request.getAttribute("neuNum");
        int negNum = (int) request.getAttribute("negNum");
        String output = request.getAttribute("output").toString();
        String selectdiscomsstr = request.getAttribute("selectdiscomsstr").toString();
        String[] othercoms = (String[]) request.getAttribute("othercoms");
        int[] poslist = (int[]) request.getAttribute("poslist");
        int[] neulist = (int[]) request.getAttribute("neulist");
        int[] neglist = (int[]) request.getAttribute("neglist");
        List<NewsOfCompanyWithBLOBs> posNews = (List<NewsOfCompanyWithBLOBs>) request.getAttribute("posNews");
        List<NewsOfCompanyWithBLOBs> negNews = (List<NewsOfCompanyWithBLOBs>) request.getAttribute("negNews");
        List<NewsOfCompanyWithBLOBs> neuNews = (List<NewsOfCompanyWithBLOBs>) request.getAttribute("neuNews");
        String showposnews = "";
        String shownegnews = "";
        String showneunews = "";
        if (!posNews.isEmpty()) {
            for (int i = 0; i < posNews.size() && i < 8; i++) {
                NewsOfCompanyWithBLOBs n = posNews.get(i);
                showposnews = showposnews + "<a href=" + "\"" + n.getUrl() + "\"" + ">" + n.getTitle() + "</a><br>";
            }
        }
        if (!negNews.isEmpty()) {
            for (int i = 0; i < posNews.size() && i < 8; i++) {
                NewsOfCompanyWithBLOBs n = negNews.get(i);
                shownegnews = shownegnews + "<a href=" + "\"" + n.getUrl() + "\"" + ">" + n.getTitle() + "</a><br>";
            }
        }
        if (!neuNews.isEmpty()) {
            for (int i = 0; i < neuNews.size() && i < 8; i++) {
                NewsOfCompanyWithBLOBs n = neuNews.get(i);
                showneunews = showneunews + "<a href=" + "\"" + n.getUrl() + "\"" + ">" + n.getTitle() + "</a><br>";
            }
        }
    %>
    <script type="text/javascript">
        window.onload = function () {
            var _posnews = "<%=showposnews.replace("\"","\\\"")%>"
            var _negnews = "<%=shownegnews.replace("\"","\\\"")%>"
            var _neunews = "<%=showneunews.replace("\"","\\\"")%>"

            document.getElementById("shownews").innerHTML = "正面新闻<br>" + "" + _posnews + "<br>中立新闻<br>" + _neunews + "<br>负面新闻<br>" + _negnews
            document.getElementById("showcount").innerHTML = "<b>" + "<%=output%>" + "<br>" + "正面新闻篇数：" + "<%=posNum%>" + "<br>" + "中立新闻篇数：" + "<%=neuNum%>" + "<br>" + "负面新闻篇数：" + "<%=negNum%>" + "</b>"

        }
    </script>

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-2 column">
                <span style="font-size:20px;"> <td>重点企业：</td>
                     <td>
                        <select name="selectcompany" id="selectcompany" style="width:200px;">
                        "<%=selectdiscomsstr%>"
                        </select>
                    </td>
			        <button id="subcom">提交</button>
			    </span>
                <script type="text/javascript">

                    $("#subcom").click(function () {
                        tmp = $("#selectcompany option:selected").text();
                        req = "${pageContext.request.contextPath}/zmq/showComPublicOpinionEvaluation?com=" + tmp
                        $.post(req,
                            {
                                //companyname:tmp
                            },
                            function () {
                                location.href = "${pageContext.request.contextPath}/zmq/showComPublicOpinionEvaluation?com=" + tmp
                            });
                    });

                </script>
            </div>

            <div class="col-md-6 column">
                <div class="row clearfix">
                    <div class="col-md-6 column">
                        <div id="showpic" class="piccontainer"></div>
                    </div>
                </div>
            </div>

            <div id="showcount">
            </div>
            <br>
            <div id="shownews" class="col-md-4 column">
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var ulItem = document.getElementById("comul");
    ulItem.onclick = function(e){
        e = e || window.event;//这一行及下一行是为兼容IE8及以下版本
        var target = e.target || e.srcElement;
        if(target.tagName.toLowerCase() === "li"){
            alert(target.innerHTML);
        }
    }
</script>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('showpic'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '重点企业舆情评价',
            subtext: '近半年统计数据'
        },
        color:['#22B14C','#00A2E8','#DC143C'],
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['正面', '中立','负面']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'value',
            boundaryGap: [0, 0.01]
        },
        yAxis: {
            type: 'category',
            data: ['<%=othercoms[3]%>','<%=othercoms[2]%>','<%=othercoms[1]%>','<%=othercoms[0]%>','<%=maincom%>']
        },
        series: [
            {
                name: '正面',
                type: 'bar',
                data: [<%=poslist[3]%>, <%=poslist[2]%>, <%=poslist[1]%>, <%=poslist[0]%>, <%=posNum%>]
            },
            {
                name: '中立',
                type: 'bar',
                data: [<%=neulist[3]%>, <%=neulist[2]%>, <%=neulist[1]%>, <%=neulist[0]%>, <%=neuNum%>]
            },
            {
                name: '负面',
                type: 'bar',
                data: [<%=neglist[3]%>, <%=neglist[2]%>, <%=neglist[1]%>, <%=neglist[0]%>, <%=negNum%>]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>
