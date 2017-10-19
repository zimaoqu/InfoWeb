<%@ page import="com.scorpion.pojo.bignews" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2017/7/13
  Time: 16:14
  LSTM企业预警
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
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>
        <%
//        String maincom = request.getAttribute("maincom").toString();
//        String selectdiscomsstr=request.getAttribute("selectdiscomsstr").toString();
//        List<bignews> eventnews=(ArrayList<bignews>)request.getAttribute("eventnews");
//        int flag = 1;
          List<Double> predicted = (List<Double>)request.getAttribute("predictedData");
          List<Double> realistic = (List<Double>)request.getAttribute("realisticData");
          List<String> warningName = (List<String>)request.getAttribute("warningName");
          List<bignews> Bignewsdisplay = (List<bignews>)request.getAttribute("Bignews");
          String[] similarcount = (String[])request.getAttribute("Similarcount");
          String comName = (String)request.getAttribute("mainCom");
    %>
    <div class="row-fluid">
        <div id="left" class="col-xs-9 span9" style="background-color: #e9f0f5;">
            <span style="font-size:20px;">
                选择企业
                <select name="selectcompany" id="selectcompany" style="width:350px;">
                    <% for(int i = 0;i<warningName.size();i++)
                    {%><option><%=warningName.get(i)%></option><%}%>
                </select>

                <button id="subcom">提交</button>
            </span>
            <script type="text/javascript">
                $("#subcom").click(function () {
                    tmp = $("#selectcompany option:selected").text();
                    flag = $("#cla option:selected").text();
                    req = "${pageContext.request.contextPath}/zmq/showTopAbnormalComWarning?com=" + tmp
                    $.post(req,
                        {
                            //companyname:tmp
                        },
                        function () {
                            location.href = "${pageContext.request.contextPath}/zmq/showTopAbnormalComWarning?com=" + tmp
                        });
                });
            </script>
            <h3><%=comName%>：预警</h3>
            <h5>预测值与实际值方差大于实际值平均值，预警注意！</h5>
            <%--<script language="javascript">alert("预测值与实际值方差大于实际值平均值，企业出现异常，预警注意！");</script>--%>
            <div class="row" id ="main" style="width: 900px;height: 500px;margin-left:50px; margin-top:30px"></div>
            <script type="text/javascript">

                var namelist1=[];
                var namelist2=[];
                <%for(int i=0;i<predicted.size();i++){
                    double pre=predicted.get(i);
                %>namelist1.push(<%=pre%>)
                <%}%>
                <%for(int i=0;i<realistic.size();i++){
                    double rea=realistic.get(i);
                    %>namelist2.push(<%=rea%>)
                <%}%>
                console.log(namelist1);
                console.log(namelist2);
                var myChart = echarts.init(document.getElementById('main'));
                option = {
                    title : {
                        text: '预警变化趋势图',
                        subtext: '预测数据和实际数据'
                    },
                    tooltip : {
                        trigger: 'axis'
                    },
                    legend: {
                        data:['预测数据','实际数据']
                    },
                    calculable : true,
                    xAxis : [
                        {
                            type : 'category',
                            boundaryGap : false,
                            data : ['十三月前','十二月前','十一月前','十月前','九月前','八月前','七月前','六月前','五月前','四月前','三月前','两月前','一月前']
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value',
                            axisLabel : {
                                formatter: '{value} '
                            }
                        }
                    ],
                    series : [
                        {
                            name:'预测数据',
                            type:'line',
                            data:namelist1,
                            markLine : {
                                data : [
                                    {type : 'average', name : '平均值'}
                                ]
                            }
                        },
                        {
                            name:'实际数据',
                            type:'line',
                            data:namelist2,
                            markLine : {
                                data : [
                                    {type : 'average', name : '平均值'}
                                ]
                            }
                        }
                    ]
                };
                myChart.setOption(option);   //参数设置方法
            </script>
        </div>
        <div id="right" class="col-xs-9 span9 " style="height: 300px;background-color: #e9f0f5;" >
            <b>预警大事件</b><br><br>
            <table class="gridtable">
                <tr>
                    <th>序号</th>
                    <th>预警标题</th>
                    <th>相似新闻数</th>
                    <th>发布时间</th>
                    <th>关键字</th>
                    <th>链接</th>
                </tr>
                <%
                    for (int i = 0; i < Bignewsdisplay.size(); i++) {
                        bignews c = Bignewsdisplay.get(i);
                        Integer _id = c.getId();
                        String title = c.getTitle();
                        String Scount = similarcount[i];
                        String date = c.getDate();
                        String keywors = c.getKeywords();
                        String url = c.getUrl();
                %>
                <td><%=_id%></td>
                <td><%=title%></td>
                <td><%=Scount%></td>
                <td><%=date%></td>
                <td><%=keywors%></td>
                <td><a href=<%=url%>><%=url%></a></td>
                </tr>
                <%}%>
            </table>
        </div>
    </div>



</body>
</html>

