<%@ page import="com.scorpion.pojo.CompanyInfo" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/26
  Time: 16:06
  企业声誉分析
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>

<style>
    .piccontainer {
        margin: 10px;
        width: 1100px;
        height: 700px;
        border: 1px solid #000;
    }
</style>

<body>
<div class="container-fluid">
    <br/>
    <%@include file="title.jsp" %>
    <br/>

    <%
        ArrayList<CompanyInfo> res = (ArrayList<CompanyInfo>) request.getAttribute("comInfo");
    %>
    <script type="text/javascript">
        window.onload = function () {
        }
        data = []
        <%
        for(int i=0;i<res.size();i++){
            CompanyInfo c = res.get(i);
            String name=c.getName();
            double h=c.getHealth();
            double r=c.getReputation();
        %>

        item = []
        item.push(<%=h%>)
        item.push(<%=r%>)
        item.push('<%=name%>')
        data.push(item)

        <%}%>
    </script>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div id="showpic" class="piccontainer" style="margin-left:0px"></div>
                <br>
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
        var schema = [
            {name: 'health', index: 0, text: '健康度'},
            {name: 'reputation', index: 1, text: '声誉度'},
            {name: 'companyname', index: 2, text: '企业名称'},
        ];

        var itemStyle = {
            normal: {
                opacity: 0.8,
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowOffsetY: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        };
        var myChart = echarts.init(document.getElementById('showpic'));
        option = {
            "title": {
                "text": "重点企业声誉分析",
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
            backgroundColor: '#404a59',
            color: [
                '#dd4444', '#fec42c', '#80F1BE'
            ],
            grid: {
                x: '10%',
                x2: 150,
                y: '18%',
                y2: '10%'
            },
            tooltip: {
                padding: 10,
                backgroundColor: '#222',
                borderColor: '#777',
                borderWidth: 1,
                formatter: function (obj) {
                    var value = obj.value;
                    return '<div style="border-bottom: 1px solid rgba(255,255,255,.3); font-size: 18px;padding-bottom: 7px;margin-bottom: 7px">'
                        + ' ' + value[2]
                        + '</div>'
                        + schema[0].text + '：' + value[0] + '<br>'
                        + schema[1].text + '：' + value[1] + '<br>';
                }
            },
            xAxis: {
                type: 'value',
                name: '健康度',
                nameGap: 16,
                nameTextStyle: {
                    color: '#fff',
                    fontSize: 14
                },
                splitLine: {
                    show: false
                },
                axisLine: {
                    lineStyle: {
                        color: '#eee'
                    }
                }
            },
            yAxis: {
                type: 'value',
                name: '声誉度',
                nameLocation: 'end',
                nameGap: 20,
                nameTextStyle: {
                    color: '#fff',
                    fontSize: 16
                },
                axisLine: {
                    lineStyle: {
                        color: '#eee'
                    }
                },
                splitLine: {
                    show: false
                }
            },
            visualMap: [
                {
                    left: 'right',
                    top: '10%',
                    dimension: 1,
                    min: -3,
                    max: 5,
                    itemWidth: 30,
                    itemHeight: 120,
                    calculable: true,
                    precision: 0.1,
                    text: ['圆形大小：声誉度'],
                    textGap: 30,
                    textStyle: {
                        color: '#fff'
                    },
                    inRange: {
                        symbolSize: [10, 70]
                    },
                    outOfRange: {
                        symbolSize: [10, 70],
                        color: ['rgba(255,255,255,.2)']
                    },
                    controller: {
                        inRange: {
                            color: ['#c23531']
                        },
                        outOfRange: {
                            color: ['#444']
                        }
                    }
                },
                {
                    left: 'right',
                    bottom: '5%',
                    dimension: 0,
                    min: -10,
                    max: 10,
                    itemHeight: 120,
                    calculable: true,
                    precision: 0.1,
                    text: ['明暗：健康度'],
                    textGap: 30,
                    textStyle: {
                        color: '#fff'
                    },
                    inRange: {
                        colorLightness: [1, 0.5]
                    },
                    outOfRange: {
                        color: ['rgba(255,255,255,.2)']
                    },
                    controller: {
                        inRange: {
                            color: ['#c23531']
                        },
                        outOfRange: {
                            color: ['#444']
                        }
                    }
                }
            ],
            series: [
                {
                    type: 'scatter',
                    itemStyle: itemStyle,
                    data: data,
                    animationDelay: function (idx) {
                        return idx * 100;
                    }
                }
            ]
        };
        myChart.setOption(option);
    </script>
</div>
</body>
</html>
