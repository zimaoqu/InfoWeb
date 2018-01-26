<%--
  Created by IntelliJ IDEA.
  User: Scorpion
  Date: 2017/4/23
  Time: 14:56
  自贸区对比
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>

<style>
    .echart_container1 {
        height: 600px;
        position: absolute;
        left: 10%;
        width: 80%;
        margin-bottom: 20px;
    }

    .echart_container2 {
        height: 600px;
        position: absolute;
        left: 10%;
        width: 80%;
        margin-top: 700px;
        margin-bottom: 20px;
    }
</style>

<body>
<br/>
<%@include file="title.jsp" %>
<br/><br/><br/>

<div id="graph" class="echart_container1"></div>
&nbsp;
<div id="map" class="echart_container2"></div>

<script type="text/javascript">
    var myChart1 = echarts.init(document.getElementById("graph"));
    var myChart2 = echarts.init(document.getElementById("map"));
    option1 = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data: ['税收总额', '海关税收', '吸引投资总额', '进出口总额', '经营总收入']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'value'
        },
        yAxis: {
            type: 'category',
            data: ['中国（陕西）自由贸易试验区',
                '中国（广东）自由贸易试验区',
                '中国（天津）自由贸易试验区',
                '中国（福建）自由贸易试验区',
                '中国（辽宁）自由贸易试验区',
                '中国（浙江）自由贸易试验区',
                '中国（河南）自由贸易试验区',
                '中国（湖北）自由贸易试验区',
                '中国（重庆）自由贸易试验区',
                '中国（四川）自由贸易试验区',
                '中国（上海）自由贸易试验区']
        },
        series: [
            {
                name: '税收总额',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [320, 302, 301, 334, 390, 330, 320, 301, 334, 390, 330]
            },
            {
                name: '海关税收',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [120, 132, 101, 134, 90, 230, 210, 132, 101, 134, 90]
            },
            {
                name: '吸引投资总额',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [220, 182, 191, 234, 290, 330, 310, 234, 290, 330, 310]
            },
            {
                name: '进出口总额',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [150, 212, 201, 154, 190, 330, 410, 212, 201, 154, 190]
            },
            {
                name: '经营总收入',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: [820, 832, 901, 934, 1290, 1330, 1320, 832, 901, 934, 1290]
            }
        ]
    };

    function randomData() {
        return Math.round(Math.random() * 1000);
    }

    option2 = {
        title: {
            text: '各自贸区发展情况对比',
            subtext: '纯属虚构',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['沿海', '成立较早', '税收较高']
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'],           // 文本，默认为数值文本
            calculable: true
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                dataView: {readOnly: false},
                restore: {},
                saveAsImage: {}
            }
        },
        series: [
            {
                name: '沿海',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: [
                    {name: '天津', value: randomData()},
                    {name: '上海', value: randomData()},
                    {name: '辽宁', value: randomData()},
                    {name: '浙江', value: randomData()},
                    {name: '广东', value: randomData()},
                    {name: '福建', value: randomData()}
                ]
            },
            {
                name: '成立较早',
                type: 'map',
                mapType: 'china',
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: [
                    {name: '天津', value: randomData()},
                    {name: '上海', value: randomData()},
                    {name: '广东', value: randomData()},
                    {name: '福建', value: randomData()}
                ]
            },
            {
                name: '税收较高',
                type: 'map',
                mapType: 'china',
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: [
                    {name: '天津', value: randomData()},
                    {name: '上海', value: randomData()},
                    {name: '重庆', value: randomData()},
                    {name: '河南', value: randomData()},
                    {name: '辽宁', value: randomData()},
                    {name: '浙江', value: randomData()},
                    {name: '湖北', value: randomData()},
                    {name: '广东', value: randomData()},
                    {name: '四川', value: randomData()},
                    {name: '陕西', value: randomData()},
                    {name: '福建', value: randomData()}
                ]
            }
        ]
    };

    myChart1.setOption(option1);
    myChart2.setOption(option2);
</script>
</body>

</html>

