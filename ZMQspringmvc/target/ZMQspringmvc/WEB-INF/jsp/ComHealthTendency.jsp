<%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/25
  Time: 21:12
  企业健康态势
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
        width: 900px;
        height: 600px;
        border: 1px solid #000;
    }
</style>

<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>
    <%
        String maincom = request.getAttribute("maincompany").toString();
        String mainby = request.getAttribute("mainby").toString();
        int[] posnum = (int[]) request.getAttribute("posnum");
        int[] negnum = (int[]) request.getAttribute("negnum");
        double[] healthvalue = (double[]) request.getAttribute("healthvalue");
        String selectdiscomsstr = request.getAttribute("selectdiscomsstr").toString();
        int[] sumyearpos = new int[10];
        int[] sumyearneg = new int[10];
        int healthlen = 0;
        if (mainby.equals("quarter")) {
            healthlen = 12;
        } else if (mainby.equals("month")) {
            healthlen = 36;
        }
        int tmpyear = 0;
        for (int i = 0; i < healthlen; i++) {
            sumyearpos[tmpyear] = sumyearpos[tmpyear] + posnum[i];
            sumyearneg[tmpyear] = sumyearneg[tmpyear] + negnum[i];
            if (healthlen == 12) {
                if (i != 0 && i % 4 == 0) {
                    tmpyear++;
                }
            } else if (healthlen == 36) {
                if (i != 0 && i % 12 == 0) {
                    tmpyear++;
                }
            }
        }
    %>
    <script type="text/javascript">
        window.onload = function () {
        }
        healthposnum = []
        healthnegnum = []
        health = []
        <%
        for(int i=0;i<healthlen;i++){
            int tmphealthposnum=posnum[i];
            int tmphealthnegnum=-negnum[i];
            double tmphealth=healthvalue[i];
        %>
        healthposnum.push(<%=tmphealthposnum%>)
        healthnegnum.push(<%=tmphealthnegnum%>)
        health.push(<%=tmphealth%>)
        <%}%>

    </script>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
				<span style="font-size:20px;"> <td>重点企业：</td>
                    <td>
                        <select name="selectcompany" id="selectcompany" style="width:200px;">
                            "<%=selectdiscomsstr%>"
                        </select>
                    </td>
                    <button id="subquarter">季度</button>
                    <button id="submonth">月份</button>
                </span>
                <script type="text/javascript">
                    $("#subquarter").click(function(){
                        scom= $("#selectcompany option:selected").text();
                        req="${pageContext.request.contextPath}/zmq/showComHealthTendency?com="+scom+"&by="+"quarter"
                        $.post(req,
                            {
                                //companyname:tmp
                            },
                            function(){
                                location.href="${pageContext.request.contextPath}/zmq/showComHealthTendency?com="+scom+"&by="+"quarter"
                            });
                    });
                    $("#submonth").click(function(){
                        scom= $("#selectcompany option:selected").text();
                        req="${pageContext.request.contextPath}/zmq/showComHealthTendency?com="+scom+"&by="+"month"
                        $.post(req,
                            {
                                //companyname:tmp
                            },
                            function(){
                                location.href="${pageContext.request.contextPath}/zmq/showComHealthTendency?com="+scom+"&by="+"month"
                            });
                    });
                </script>
            </div>
            <br>
            <div class="col-md-10 column">
                <div id="showpic" class="piccontainer" style="margin-left:-50px"></div>
                <br>
            </div>
            <div id="showstate" class="col-md-3 column" style="margin-left:-80px;margin-right:-100px">
                <br>
                <font size="5" face="SimHei">分析</font><br>
                <font size="4" face="SimHei">
                    <%for (int ii = 0; ii < 3; ii++) { %>
                    <%=ii + 2014%>年
                    <br>正面新闻篇数： <%=sumyearpos[ii]%>篇
                    <br>负面新闻篇数： <%=sumyearneg[ii]%>篇<br>
                    <%}%>
                    <br>年度热词：
                    <br>大事件：
                    <br>总体趋势：
                    <br>&nbsp; 总体持平 略有下降
                </font>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        var ulItem = document.getElementById("comul");
        ulItem.onclick = function (e) {
            e = e || window.event;//这一行及下一行是为兼容IE8及以下版本
            var target = e.target || e.srcElement;
            if (target.tagName.toLowerCase() === "li") {
                alert(target.innerHTML);
            }
        }
    </script>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        byjs = "<%=mainby%>"
        var myChart = echarts.init(document.getElementById('showpic'));

        // 指定图表的配置项和数据

        var xData = function () {
            var data = [];
            xlen = 0;
            xmod = 0;
            if (byjs == "month") {
                gap = "月份"
                xlen = 36
                xmod = 12
            }
            else if (byjs == "quarter") {
                gap = "季度"
                xlen = 12
                xmod = 4
            }
            var year = 2014
            for (var i = 1; i <= xlen; i++) {
                if (i % xmod == 1) {
                    data.push(year)
                    year++
                }
                else {
                    puti = i % xmod
                    if (puti == 0) puti = xmod
                    if (puti == (xmod / 2) || puti == xmod) {
                        data.push(puti)
                    }
                    else {
                        data.push("")
                    }
                }
            }
            return data;
        }();

        option = {
            backgroundColor: "#344b58",
            "title": {
                "text": '<%=maincom%>' + " 健康态势",
                "subtext": "(按" + gap + ")",
                x: "4%",

                textStyle: {
                    color: '#fff',
                    fontSize: '22'
                },
                subtextStyle: {
                    color: '#90979c',
                    fontSize: '16',

                },
            },
            "tooltip": {
                "trigger": "axis",
                "axisPointer": {
                    "type": "shadow",
                    textStyle: {
                        color: "#fff"
                    }

                },
            },
            "grid": {
                "borderWidth": 0,
                "top": 110,
                "bottom": 95,
                textStyle: {
                    color: "#fff"
                }
            },
            "legend": {
                x: '4%',
                top: '10%',
                textStyle: {
                    color: '#90979c',
                },
                "data": ['正面', /*  '中立',  */'负面', '健康度']
            },
            "calculable": true,
            "xAxis": [{
                "type": "category",
                "axisLine": {
                    lineStyle: {
                        color: '#90979c'
                    }
                },
                "splitLine": {
                    "show": false
                },
                "axisTick": {
                    "show": false
                },
                "splitArea": {
                    "show": false
                },
                "axisLabel": {
                    "interval": 0,

                },
                "data": xData,
            }],
            "yAxis": [{
                "type": "value",
                "name": "篇数",
                "splitLine": {
                    "show": false
                },
                "axisLine": {
                    lineStyle: {
                        color: '#90979c'
                    }
                },
                "axisTick": {
                    "show": false
                },
                "axisLabel": {
                    "interval": 0,

                },
                "splitArea": {
                    "show": false
                },
            },
                {
                    "type": "value",
                    "name": "健康度",
                    "splitLine": {
                        "show": false
                    },
                    "axisLine": {
                        lineStyle: {
                            color: '#90979c'
                        }
                    },
                    "axisTick": {
                        "show": false
                    },
                    "axisLabel": {
                        "interval": 0,

                    },
                    "splitArea": {
                        "show": false
                    }
                }
            ],
            "dataZoom": [{
                "show": true,
                "height": 30,
                "xAxisIndex": [
                    0
                ],
                bottom: 30,
                "start": 0,
                "end": 100,
                handleIcon: 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
                handleSize: '110%',
                handleStyle: {
                    color: "#d3dee5",

                },
                textStyle: {
                    color: "#fff"
                },
                borderColor: "#90979c"


            }, {
                "type": "inside",
                "show": true,
                "height": 15,
                "start": 1,
                "end": 35
            }],
            "series": [
                /* {
                 "name": "中立",
                 "type": "bar",
                 "stack": "总量",
                 "barMaxWidth": 35,
                 "barGap": "10%",
                 "itemStyle": {
                 "normal": {
                 "color": "rgba(0,191,255,1)",
                 "label": {
                 "show": false,
                 "textStyle": {
                 "color": "#fff"
                 },
                 "position": "insideTop",
                 formatter: function(p) {
                 return p.value > 0 ? (p.value) : '';
                 }
                 }
                 }
                 },
                 "data": healthneunum,
                 }, */
                {
                    "name": "正面",
                    "type": "bar",
                    "stack": "总量",
                    "barMaxWidth": 35,
                    "barGap": "10%",
                    "itemStyle": {
                        "normal": {
                            "color": "rgba(0,191,183,1)",
                            "label": {
                                "show": false,
                                "textStyle": {
                                    "color": "#fff"
                                },
                                "position": "insideTop",
                                formatter: function (p) {
                                    return p.value > 0 ? (p.value) : '';
                                }
                            }
                        }
                    },
                    "data": healthposnum,
                },
                {
                    "name": "负面",
                    "type": "bar",
                    "stack": "总量",
                    "itemStyle": {
                        "normal": {
                            "color": "rgba(255,144,128,1)",
                            "barBorderRadius": 0,
                            "label": {
                                "show": false,
                                "position": "top",
                                formatter: function (p) {
                                    return p.value > 0 ? (p.value) : '';
                                }
                            }
                        }
                    },
                    "data": healthnegnum
                }, {
                    "name": "健康度",
                    "type": "line",
                    yAxisIndex: 1,
                    symbolSize: 10,
                    symbol: 'circle',
                    "itemStyle": {
                        "normal": {
                            "color": "rgba(252,230,48,1)",
                            "barBorderRadius": 0,
                            "label": {
                                "show": false,
                                "position": "top",
                                formatter: function (p) {
                                    return p.value > 0 ? (p.value) : '';
                                }
                            }
                        }
                    },
                    "data": health
                },
            ]
        }

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</div>
</body>
</html>
