<%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/23
  Time: 10:38
  上海自贸区舆情评价界面
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>

<style>

    .echart_container {
        width: 660px;
        height: 600px;
        float: left;
        display: inline
    }

    .divcss {
        margin-left: auto;
        margin-right: auto;
        width: 1400px;
    }

    .piccontainer {

        width: 400px;
        height: 300px;
    }

    .container {
        width: 1320px;
    }


</style>

<body>
<br/>
<%@include file="title.jsp" %>
<br/><br/><br/>

<div class="divcss">
    <div id="main" class="echart_container"></div>
    &nbsp;
    <div id="main2" class="echart_container" style="margin-left: 50px"></div>
</div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var myChart2 = echarts.init(document.getElementById('main2'));
    // 指定图表的配置项和数据


    option = {
        "title": {
            "text": "上海自贸区舆情评价",
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        color: ['#8fc31f', '#f35833', '#00ccff', '#ffcc00'],
        legend: {
            orient: 'vertical',
            x: 'right',
            data: ['正面', '负面', '中立'],
            formatter: function (name) {
                var oa = option.series[0].data;
                var num = oa[0].value + oa[1].value + oa[2].value /*+ oa[3].value*/;
                for (var i = 0; i < option.series[0].data.length; i++) {
                    if (name == oa[i].name) {
                        return name + '     ' + oa[i].value + '     ' + (oa[i].value / num * 100).toFixed(2) + '%';
                    }
                }
            }
        },
        series: [
            {
                name: '新闻比例分析',
                type: 'pie',
                radius: '55%',
                center: ['40%', '50%'],
                data: [
                    {value: 335, name: '正面'},
                    {value: 310, name: '负面'},
                    {value: 234, name: '中立'}
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },
                itemStyle: {
                    normal: {
                        label: {
                            show: true,
//	                            position:'inside',
                            formatter: '{b} : {c} ({d}%)'
                        }
                    },
                    labelLine: {show: true}
                }
            }
        ]
    };
    option2 = {

        tooltip: {},
        series: [{
            type: 'wordCloud',
            gridSize: 20,
            sizeRange: [12, 50],
            rotationRange: [0, 0],
            shape: 'circle',
            textStyle: {
                normal: {
                    color: function () {
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
            data: [{
                name: '自贸区',
                value: 10000,
                textStyle: {
                    normal: {
                        color: 'black'
                    },
                    emphasis: {
                        color: 'red'
                    }
                }
            }, {
                name: '债券市场',
                value: 6181
            }, {
                name: '进出口',
                value: 4386
            }, {
                name: '保险',
                value: 4055
            }, {
                name: '航运',
                value: 2467
            }, {
                name: '物流运输',
                value: 2244
            }, {
                name: '手机',
                value: 1898
            }, {
                name: '自由贸易',
                value: 1484
            }, {
                name: '进出口额',
                value: 1112
            }, {
                name: '试验区',
                value: 965
            }, {
                name: '洋山港',
                value: 847
            }, {
                name: '外汇',
                value: 582
            }, {
                name: '账户',
                value: 555
            }, {
                name: '利率',
                value: 550
            }, {
                name: '市场活力',
                value: 462
            }, {
                name: '概念股',
                value: 366
            }, {
                name: '风险防控',
                value: 360
            }, {
                name: '贸易额',
                value: 282
            }, {
                name: '侵权',
                value: 273
            }, {
                name: '治理',
                value: 265
            }]
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    myChart2.setOption(option2);
</script>
</body>

</html>
