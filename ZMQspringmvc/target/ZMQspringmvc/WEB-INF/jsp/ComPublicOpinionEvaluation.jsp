<%@ page import="com.scorpion.pojo.NewsOfCompanyWithBLOBs" %>
<%@ page import="com.scorpion.pojo.currentnewsWithBLOBs" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
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

<style type="text/css">
    .piccontainer {
        width: 400px;
        height: 300px;
    }
    .container{
        width: 1320px;
    }
</style>

<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>
    <%
        String maincom = request.getAttribute("maincom").toString();
        String selectdiscomsstr=request.getAttribute("selectdiscomsstr").toString();
        HashMap<String,Integer> wordcloud=(HashMap<String,Integer>)request.getAttribute("wordcloud");
        HashMap<String,Integer> source=(HashMap<String,Integer>)request.getAttribute("source");
        List<currentnewsWithBLOBs> hotnews=(ArrayList<currentnewsWithBLOBs>)request.getAttribute("hotnews");
        List<currentnewsWithBLOBs> sensivenews=(ArrayList<currentnewsWithBLOBs>)request.getAttribute("sensivenews");
    %>
    <div class="container">
        <div class="col-md-4 column">
	<span style="font-size:20px;">
		重点企业：
		<select name="selectcompany" id="selectcompany"  style="width:200px;">
   			"<%=selectdiscomsstr%>"
		</select>
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
            <div id="showpic" class="piccontainer"></div>
            <div id="showpic2" class="piccontainer"></div>
        </div>
        <div class="col-md-8 column">
            <div>
                <p style="text-align:center"><b><font size='4'>新闻热点变化</font></b></p>

                <table border="1">
                    <tr>
                        <th style="text-align:center;">时间</th>
                        <th style="text-align:center;">热点关键词</th>
                        <th style="text-align:center;">内容</th>
                    </tr>
                    <%
                        for(int i=0;i<hotnews.size();i++) {
                            currentnewsWithBLOBs n = hotnews.get(i);
                    %>
                    <tr>
                        <%
                            String _title = n.getTitle();
                            String _date = n.getDate();
                            String _url = n.getUrl();
                            String _source = n.getSource();
                            String _keywords=n.getKeywords();
                        %>
                        <td style="width: 80px;text-align:center"><%=_date%></td>
                        <td style="width: 600px;text-align:center"><%=_keywords%></a></td>
                        <td style="width: 70px;text-align:center"><a href="<%=_url%>" target="_blank">查看</td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>
            <br>
            <div>
                <p style="text-align:center"><b><font size='4'>敏感新闻-top10</font></b></p>
                <table border="1">
                    <tr>
                        <th style="text-align:center;">标题</th>
                        <th style="text-align:center;">时间</th>
                        <th style="text-align:center;">来源</th>
                    </tr>
                    <%
                        for(int i=0;i<sensivenews.size();i++) {
                            currentnewsWithBLOBs n = sensivenews.get(i);
                    %>
                    <tr>
                        <%
                            String _title = n.getTitle();
                            String _date = n.getDate();
                            String _url = n.getUrl();
                            String _source = n.getSource();
                        %>
                        <td style="width: 600px;text-align:center"><a href="<%=_url%>" target="_blank"><%=_title%></a></td>
                        <td style="width: 80px;text-align:center"><%=_date%></td>
                        <td style="width: 70px;text-align:center"><%=_source%></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
    data=[]
    var myChart = echarts.init(document.getElementById('showpic'));
    <%Iterator iter = wordcloud.entrySet().iterator();
    while(iter.hasNext()){
        Map.Entry entry = (Map.Entry) iter.next();
        Object key = entry.getKey();
        Object val = entry.getValue();%>
    data.push({
        name: '<%=key.toString()%>',
        value: <%=Integer.parseInt(val.toString())%>
    })
    <%}%>

    option = {
        tooltip: {},
        series: [{
            type: 'wordCloud',
            gridSize: 20,
            sizeRange: [12, 50],
            rotationRange: [0, 0],
            shape: 'circle',
            textStyle: {
                normal: {
                    color: function() {
                        return 'rgb(' + [
                                Math.round(Math.random() * 160),
                                Math.round(Math.random() * 160),
                                Math.round(Math.random() * 160)
                            ].join(',') + ')';
                    }
                },
                emphasis: {
                    shadowBlur: 10,
                    shadowColor: '#333'
                }
            },
            data: data
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>

<script>
    source=[]
    sourcenum=[]
    var myChart2 = echarts.init(document.getElementById('showpic2'));
    <%Iterator iter2 = source.entrySet().iterator();
    while(iter2.hasNext()){
        Map.Entry entry = (Map.Entry) iter2.next();
        Object key = entry.getKey();
        Object val = entry.getValue();%>
    source.push('<%=key.toString()%>')
    sourcenum.push({
        value: <%=Integer.parseInt(val.toString())%>,
        name: '<%=key.toString()%>'
    })
    <%}%>

    option2 = {
        title : {
            text: '新闻来源',
            /* subtext: '纯属虚构', */
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        /* legend: {
         orient: 'vertical',
         left: 'left',
         data: source
         }, */
        series : [
            {
                name: '访问来源',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:sourcenum,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    myChart2.setOption(option2);
</script>
</body>
</html>
